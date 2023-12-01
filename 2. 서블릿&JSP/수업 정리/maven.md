# 설치

   C:\dev\language\java-17
   JAVA_HOME 환경 변수

D:\yhg1024\apache-maven-3.9.5\bin


API(Application Programming Interface)

maven 싱크버튼(reload): 의존성 추가했을때 반영하는 버튼

# 버전
1        .18    .30
(Major) (Minor) (patch)
Major - 기존 버전과 호환이 안될때
Minor - 기존 버전과 호환에는 문제X
patch - 오류가 난거 기능개선

에노테이션 : 주석

# getter/setter 
정보은닉, 통제불가능한 값을 통제하기위해
private 변수에 접근하기 위해 만든다. 값을 통제하기위해

# 객체 object 
사물, 사물(객체)간의 의사소통이 중요하다.
의존성, 다형성,대체가능,유연성
의사소통 - 함수, 메서드로 발생한다.

class : 객체를 만들기위한 설계도
변수 : 공간, 메모리,
변수는 통제불가능해서 변수에 직접 값을 넣는건 지양한다.

toString() : 변수의 값, 데이터 확인

settings - editor - general - auto import > add unambiguous imports on the fly 
: 애매한것들 자동 import

싱글톤 : 객체를 한개만 만든다.

view - active editor - soft wrap :  화면에서 줄이 길면 다음줄로 넘김

함수는 스텍이랑 메모리 영역에서 실행된다.

참조변수 : 주소만 가지고 객체에 접근

인스턴스 : 생성된 객체, 실체

생성자 : 객체를 만드는 역할

this. : 모든 메서드에 존재하는 지역변수, 생성되는 객체의 주소값, 객체의 자원을 내부에서 접근하기 위한 주소
인스턴스자원인지 지역변수인지 뭐를 가르키는지 애매할때는 정의를 해줘야한다.

== : 주소
equals : 논리적으로 동일한 값인지

C-> B -> A->
C() -> super() : B() -> super() : A()

참조 변수 instanceof 클래스 : 객체의 출처를 체크, 내용물을 확인