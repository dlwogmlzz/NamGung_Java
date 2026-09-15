package exercise;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);      // 실행되지 않는다.
        } catch (ArithmeticException ae) {
            if (ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException");
        } catch (Exception e) { // 위의 ArithmeticException이외의 예외처리함, 이것만 있을때는 모든 예외 처리 가능, 모든 예외의 최고 조상 Exception
            System.out.println("Exception");
        }   // try-catch의 끝
        System.out.println(6);
    }   // main메서드의 끝
}
