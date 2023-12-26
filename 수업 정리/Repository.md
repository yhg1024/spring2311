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