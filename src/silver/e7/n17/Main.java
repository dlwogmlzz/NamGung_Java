package silver.e7.n17;

public class Main {
    public static void main(String[] args) {
        A a = new A();  // 생성하고 있는 인스턴스가 A(부모)이기 때문에
        B b = (B) a;    // 예외 발생.
        b.hello();
    }
}
