package exam01;

@MyAnno("값") // @MyAnno(value = "값")과 동일
// 애너테이션 요소가 오직 하나뿐이고 이름이 value인 경우, 애너테이션을 적용할 때 요소의 이름을 생략하고 값만 적어도 된다.
public class Ex01 {
    int num;

    void method(){}
}
