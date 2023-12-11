스키마 생성
-  CREATE USER SPRING6 IDENTIFIED BY "_aA123456";

권한 부여
- GRANT RESOURCE, CONNECT TO SPRING6;

오라클은 대소문자 구분x, 비번만 구분


# JDBC로 데이터베이스 연동
_aA123456

JDBC(Java DataBase Connectivity) API(Application Programming Interface)

1. 순서
    1) java.sql.* 패키지 임포트
    2) JDBC 드라이버 로딩
       ojdbc11.jar

        - 동적 로딩 : Class.forName("패키지명을 포함한 클래스명");
          - 클래스 파일 소스 -> 데이터 영역 메모리

    3) 데이터베이스 접속을 위한 Connection객체 생성
       String url = "jdbc:oracle:thin:@localhost:1521:orcl

       참고)<br>
       localhost : 같은 서버 위치<br>
       127.0.0.1
        
        포트(1521) : 데이터가 이동하는 통로

       DriverManager
       - .getConnection(String url)
       - .getConnection(String url, String user, String password)
       - .getConnection(String url, Properties prop)

    4) 쿼리문을 실행하기 위한  Statement/PreparedStatement/CallableStatement 객체 생성 쿼리 실행
       Statement : 정적 쿼리

        ResultSet executeQuery(String sql)	: 조회용 쿼리(SELECT ... )
       		
        int executeUpdate(String sql) : 데이터 변경용 쿼리(INSERT, UPDATE, DELETE)
       											: 반환값 - 반영된 레코드 갯수 


	5) 쿼리 실행 결과 값(int, ResultSet) 사용
		ResultSet 
			boolean next() : 다음 커서(레코드)로 이동 
			
            자료형(...) : 데이터 조회용 메서드 
						(int ...) : 컬럼 순서 번호(1, 2, ...)
						(String .. ) : 컬럼명
						
			java.sql.Date getDate(...) : 날짜
			java.sql.Time getTime(..) : 시간
			java.sql.Timestamp getTimestamp(..) : 날짜와 시간 
			
	6) 사용된 객체(ResultSet, Statement/PreparedStatement/CallableStatement, Connection) 종료

데이터베이스 쿼리 실행
1. Statement
   Connection
    - createStatement()

1) 정적인 쿼리에 사용
2) 하나의 쿼리를 사용하고 나면 더는 사용할 수 없습니다.
3) Statement 객체의 메서드 종류
   ResultSet **executeQuery**(String sql) :  SELECT  문
   반환값 : ResultSet - 레코드를 조회할 수 있는 커서

		참고) 날짜, 시간 
   			날짜만 조회 
   			getDate(...)
   			
   			시간만 조회
   			getTime(...)
   			
   			날짜 + 시간 
   			getTimestamp(...)

   int **executeUpdate**(String sql) : INSERT, UPDATE, DELETE 문
   반환값 : 반영된 레코드 갯수

2. PreparedStatement
   Connection
   .prepareStatement(String sql);
1) 동적인 쿼리에 사용
2) PreparedStatement 객체는 하나의 객체로 여러 번의 쿼리를 실행할 수 있으며, 동일한 쿼리문을 특정 값만 바꾸어서 여러 번 실행해야 할 때, 매개변수가 많아서 쿼리문을 정리해야 할 때 유용합니다.

3) setXxx() 메서드
4) PreparedStatement 객체의 메서드
   ResultSet rs executeQuery();
   int executeUpdate();

쿼리문 실행 결과 값 가져오기
1. ResultSet
- getDate(...) : 날짜 java.sql.Date
- getTime(...) : 시간 java.sql.Time
- getTimestamp(...) : 날짜,시간 java.sql

.toLocalDateTime()

참고) 자원해제를 자동으로 해주는 try ~ catch
    try with Resources 구문
try(해제할 자원 객체; 해제할 자원 객체...) {
    
} catch (예외 객체 ...) {

}

해제할 자원이 AutoCloseable 인터페이스의 구현체만 가능

집합 (Set, Tuple) : 중복 x


# JdbcTemplate
1. 설치 및 설정
1) spring-jdbc : JDBC API 개선 + 커넥션 풀 <br>
     ex) DriverManager -> 커넥션 x<br>
         DataSource -> 커넥션 풀 o
2) tomcat-jdbc / HikariCP
    - 커넥션 풀
        - 미리 연결 객체를 여러개 생성해서 필요할때마다 빌려주고, 회수하는 방식
        - 반응성, 성능 향상의 효과
        - 오랜시간 연결이 x -> DB와 연결 객체의 연결 x -> 오류
        - 연결 상태 체크
            - setTestWhileIdle(boolean) : 커넥션이 풀에 유휴 상태로 있는 동안 검사할지 여부를 지정한다.
            - setMinEvictableIdleTimeMillis(int) : 커넥션 풀에 유효 상태를 유지할 최초 시간을 밀리초 단위로 지정한다.
+ spring*-context
+ lombok
+ spring-test
+ servlet-api
+ servlet.j*sp-api
+ bcrypt
2. DataSource 설정
    - 초기화 단계 initioalizedBean
    - 초기화 때 desposolBean
    - 외부 소스, tomcat jdbc에서 제공하는 datasource인경우 인터페이스 추가 X
    - 소멸직전의 호출할수 있는 distroy 메서드나 초기화 단계에 실행하는 init 메서드로 대신 설정가능
    - @Bean(destroyMethod = "close")


3. JdbcTemplate을 이용한 쿼리실행
1) query() : 목록 데이터 조회
- List query(String sql, RowMapper rowMapper)
- List query(String sql, Object[] args, RowMapper rowMapper)
- List query(String sql, RowMapper rowMapper, Object... args)

List 형태 : 완성된 데이터 형태로 반환

Mapper : 변환 작업, 검색
- DB에서 가져온 데이터를 가지고 원하는 데이터 객체로 변환

2) queryForObject() : 단일 데이터 조회

3) update() : 추가, 수정, 삭제
- int update(String sql)
- int update(String sql, Object... args)

4. PreparedStatementCreator를 이용한 쿼리 실행
5. INSERT 쿼리 실행 시 **KeyHolder**를 이용해서 자동 생성 키값 구하기
6. 스프링의 익셉션 변환 처리
    - 각 연동 기술에 따라 발생하는 익셉션을 스프링이 제공하는 익셉션으로 변환함으로써 다음과 같이 구현 기술에 상관없이 동일한 코드로 익셉션을 처리할 수 있게 된다.
      SQLExcpetion, HibernateException, PersistenceException ->  DataAccessException
      (RuntimeException)

7. 트랜잭션 처리
- @Transactional : 연속된 쿼리, 클래스에 넣으면 모든 메서드가 트랜젝션 수동 관리, 특정 메서드의 연속된 쿼리가 있으면 메서드가 하나의 트렌젝션 단위가 된다.

트랜젝션 : SQL 실행 단위(COMMIT 할때 까지)<br>
COMMIT -> DB 영구 반영
- autocommit -> true : 1개 SQL 실행시 자동 COMMIT

트랜젝션을 수동 관리? @Transactional <br>
conn.setAutocommit(false); // 공통 기능

//핵심기능
<br>SQL1<br>
SQL2<br>
SQL3<br>
...

conn.commit() // 공통기능

8. 로거 연동 
- slf4j-api
- logback-classic : 구현체

로그 레벨
- FATAL
- ERROR 
- WARN : 경고, 기능 문제 X, 향후 문제 가능성이 있는 경우

정보성 로그
- INFO
- DEBUG
- TRACE

%d -> 날짜, 시간 <br>
%5p -> 5자 내에서 로그 레벨을 출력<br>
%c{2} -> 패키지를 요약(한글자로 요략) + 클래스명<br>
%m -> 출력 메세지

JDBC API
- 조회 (SELECT)
  - ResultSet executeQuery(..)
- 변경(INSERT, UPDATE, DELETE)
  - int executeUpdate(..) : 반영된 레크드 갯수가 반환값

내부 클래스 : 클래스 내부에 정의된 클래스
1) 인스턴스 내부 클래스
2) 정적 내부 클래스
3) 지역 내부 클래스(중요!)
 - 메서드 지역 안에 정의된 클래스
 - 인터페이스, 추상 클래스가 객체가 되는 조건
    1) 환경 조건
       - 지역 내부
       - 맴버 변수
    2) 미 구현된 추상 메서드의 구현 내용을 추가함으로써
4) 익명 내부 클래스

함수(메서드) 내에 정의된 지역 변수 <br>
-> 호출되서 실행할때 변수의 자원 할당<br>
-> 연산 종료(return) : 자원 해제

int num3<br>
-> 지역 변수로써 스택에서 할당 -> 임시 메모리(제거)<br>
-> 지역 내부에서 정의된 클래스의 메서드에서 사용 중? -> 제거 x -> 상수화(fical) -> 데이터 영역 메모리 생성(제거x)