package exercise;

public class ExceptionTest2 {
    public static void main(String[] args) {
        // Exception과 그 자손은 checked예외라서 try-catch가 필요함 아니면 컴파일에러발생!
        try {   // Exception과 그 자손은 반드시 예외 처리를 필수로 해줘야 한다.
            throw new Exception();  // Exception을 고의로 발생시킨다.
        } catch (Exception e) {}

        // RuntimeException는 try-catch문은 선택사항이며, 컴파일은 되지만 런타임에러 발생함.
        throw new RuntimeException();
    }
}
