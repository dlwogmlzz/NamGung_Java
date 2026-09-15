package exercise;

public class Inner {
    // 인스턴스 내부 클래스
    class InstanceInner {
        int iv = 100;
        // static int cv = 200;                // 에러! static변수를 선언할 수 없다.
        final static int CONST = 100;       // final static은 상수이므로 허용
    }

    // static 내부 클래스
    static class StaticInner {
        int iv = 200;
        static int cv = 200;                // static클래스만 static멤버를 정의할 수 있다.
    }

    void myMethod() {
        // 지역 내부 클래스
        class LocalInner {
            int iv = 300;
            // static int cv = 300;            // 에러! static변수를 선언할 수 없다.
            final static int CONST = 300;   // final static은 상수이므로 허용
        }
        int i = LocalInner.CONST;   // OK
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
        // System.out.println(LocalInner.CONST); // LocalInner는 메서드 안에 있는 로컬 클래스기 때문에 메서드안 + LocalInner클래스 안에서만 사용할 수 있음.
    }
}
