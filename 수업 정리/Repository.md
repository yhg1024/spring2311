# Repository 설계하기
- DAO 클래스 대체

CrudRepository 인터페이스

1. JpaRepository 인터페이스  : 상속

2. JpaRepository에서 지원하는 메서드
- S save(S entity) : persist(...) : 영속성 상태로 추가
- S saveAndFlush(S entity) : persist() + flush()

- List`<S>` saveAll(Collection`<S>` ...)
- List`<S>` saveAllAndFlush(....)
- void flush()


- void delete(T entity) : remove(...)
- count()
- Iterable findAll()
- S findOne(..)
- S findById(기본키)


참고) find로 시작하는 메서드 : 영속 상태<br>
get로 시작하는 메서드 : 비영속 상태 - 상태변화 감지 X

- flush() : 상태 변화 감지 -> DB 에 반영

Pageable 인터페이스 : 페이징 관련 기능, 설정
- PageRequest

반환값 Page<T>


# 쿼리 메서드

@Query 애노테이션
- JPQL 

JPQL(Java Persistence Query Language)
- 엔티티 기준의  SQL, 조회 결과 영속성 상태

Querydsl
- 비표준
- 엔티티 클래스 -> 쿼리 빌딩 기능 추가된 Q엔티티 클래스 자동 생성
  - 의존성
    - javaee8 버전 기준 : javax.
    - jakarta ee 10 : jakarta 

QuerydslPredicateExecutor
  : 기존 JpaRepository에 정의된 메서드에 매개변수가 Predicate인 형태가 추가

- 예)
  - findAll(Predicate ..)
  - findAll(Predicate .., Sort ..)
  - findAll(Predicate .., Pageable ..)
  - findOne(...)
- BooleanBuilder : 논리조건 (and(...), or(...), not(...))

```java
        QBoardData boardData = QBoardData.boardData;
        BooleanBuilder orBuilder = new BooleanBuilder();
        orBuilder.or(boardData.subject.contains("목"))
        .or(boardData.subject.contains("용"));
        List<BoardData> items = (List<BoardData>) repository.findAll(orBuilder);
        items.forEach(System.out::println);
```

build.gradle 파일 하단에 다음 추가
```
def querydslDir = "$buildDir/generated/querydsl"  // def 지역변수

sourceSets {
main.java.srcDirs += [ querydslDir ]
}

tasks.withType(JavaCompile) {
options.getGeneratedSourceOutputDirectory().set(file(querydslDir))
}

clean.doLast {
file(querydslDir).deleteDir()
}
```

### 연관 관계 매핑
1. 일대일(1:1) : @OneToOne
    - 회원 - 주소
    - 값이 중복될수없다. 하나만 존재하므로 unique가 추가된다.
2. 일대다(1:N) : @OneToMany
  - 일 : 회원
  - 다 : 게시글
  - 연관관계 주인을 명시 : 필수 (mappedBy)
    1) Many 쪽이 주인
    2) 외래키가 있는 쪽
  - 연관관계 주인
    1) 데이터 수정, 삭제 가능
  - mappedby 관계의 주인을 정해준다.
  - (fetch = FetchType.LAZY)가 기본값

3. 다대일(N:1) : @ManyToOne
  - 다 : 게시글
  - 일 : 회원
  - @JoinColumn : 외래키로 설정되는 필드명을 직접 설정
    - @JoinColumn(name = "userNo")
  - 외래키 : Many쪽 생성
4. 다대다(N:M) : @ManyToMany
   - 게시글 - 해시태그

### StackOverflowError 메모리 부족 오류
왜냐하면 Lombok : toString() : 내부의 항목을 getter를 통해서 출력<br>
예)
```java
class Member {
    private String email;
    
    public  String getEmail() {
        return email;
    }
    
    public String toString() {
        return "... email = " + getEmail()...
    }
}
```
참조 변수를 출력 -> toString()....<br>
member -> getItems() -> toString() -> getMember() -> toString() -> getItems() -> toString() ...<br>
계속 반복 되서, 순환 참조가 발생해서 메모리 부족 오류가 난다.

해결방법 :
1. 참조를 설정
2. lombok에서 toString 값을 설정
    - 둘중에 하나만 참조가 되지 않게 끊으면 된다. @OneToMany 쪽을 끊었다.
    - @ToString
        - .Exclude // 출력이 안되게 막아준다.
        - .Include

manyToOne이 있어야 oneToMany를 쓸수 있다


1. 지연로딩
   1) FetchType.EAGER : 즉시 로딩 - 처음부터 join형태로 SQL 실행
       - 너무 많은 테이블을 처음부터 조인 : 성능저하
         - 모든 테이블이 로직에서 필요한건 아니므로
   2) FetchType.LAZY : 지연 로딩 - 메인 엔티티 쿼리만 수행, 필요할 때만 2차 쿼리 형태로 실행
       - 글로벌 전략 : 기본 선택
         - 필요할땐 부분적인 즉시 로딩 전략 - Fetch 조인이 답이다.
         - 반복문에서는 문제가 된다.
           - 목록되어있는 만큼 매핑되어있어 n
           - N + 1
           - 해결 방안
             1. JPQL - FETCH 
                - LEFT JOIN FETCH
             2. @EntityGraph : 즉시 로딩할 엔티티 명시 
                - @EntityGraph(attributePaths = {"member"})
             3. QueryDsl 쿼리 빌딩(.fetchJoin())
```java
QBoardData boardData = QBoardData.boardData;
JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        List<BoardData> items = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(boardData.subject.contains("목"))
                .fetch(); // fetch로 데이터를 가져온다.
```

함수형 프로그래밍

일등 함수
- 함수 == 값

1) 매개 변수로 함수
2) 반환값으로 함수

- 인터페이스의 지역 내부에서 객체가 되는 조건 : 함수형 프로그래밍을 구현

2. 영속성 전이