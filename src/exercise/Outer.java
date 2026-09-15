package exercise;

// 내부 클래스와 외부 클래스
class Outer {
    private int outerIv = 0;
    static  int outerCv = 0;

    class InstanceInner {
        int iiv  = outerIv;  // 외부 클래스의 private 멤버도 접근가능하다.
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // static 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        // int siv = outerIv;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0; // 값이 바뀌지 않는 변수는 상수로 간주!! 원래는 (final)을 붙여야 되지만 값만 안바꾸면 되기 때문에 안붙여도 된다.
        final int LV = 0;   // JDK1.8부터 final 생략 가능

        class LocalInner {  // 지역 내부 클래스를 감싸고 있는 메서드의 상수만 가능.
            int liv  = outerIv;
            int liv2 = outerIv;
            // 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능하다.
            // int liv3 = lv;  // 에러!!!(JDK1.8부터 에러 아님)
            int liv4 = LV;     //OK
        }
    }
}
