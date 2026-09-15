package silver.e7.n18;

public class Sample2 {
    int num = 10;   // 멤버 변수(필드)
    void test() {   // 메서드 내부에 클래스 필드와 같은 이름의 지역 변수를 선언하는 것을 허용한다.
        int num = 20;   // 지역 변수, 메서드 안에서는 지역 변수가 우선권을 가진다.
        System.out.println(num);
    }
}
