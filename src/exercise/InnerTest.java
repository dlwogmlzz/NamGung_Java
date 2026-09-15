package exercise;

class AAA2 {    // AAA는 BBB의 외부 클래스가 됨.
    int i = 200;
    // BBB클래스에 접근하려고 하면 객체 생성을 해줘야 함.
    BBB2 b = new BBB2();

    class BBB2 {    // BBB는 AAA의 내부 클래스가 됨.
        void method() {
            // 내부 클래스가 되면 객체 생성 필요없어짐.
            // AAA2 a = new AAA2();
            // System.out.println(a.i);
            System.out.println(i);  // 객체 생성 없이 외부 클래스의 멤버에 접근 가능함.
        }
    }
}
//class CCC2 {
//    BBB2 b = new BBB2();
//}


public class InnerTest {
    public static void main(String[] args) {
//        BBB2 b = new BBB2();
//        b.method();
    }
}
