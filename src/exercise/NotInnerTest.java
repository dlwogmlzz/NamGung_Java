package exercise;

class AAA {
    int i = 100;
    // BBB클래스에 접근하려고 하면 객체 생성을 해줘야 함.
    BBB b = new BBB();
}
class BBB {
    void method() {
        AAA a = new AAA();
        System.out.println(a.i);
    }
}
class CCC {
    // BBB클래스에 접근하려고 하면 객체 생성을 해줘야 함.
    BBB b = new BBB();
}


public class NotInnerTest {
    public static void main(String[] args) {
        BBB b = new BBB();
        b.method();
    }
}
