# 내부 클래스(inner class)

 - 클래스 안의 클래스

class A {   // 외부 클래스
    ...
    class B {   // 내부 클래스
        ... // `A객체 생성 없이도` A의 멤버 접근가능
    }
}

클래스가 나누어져 있을 경우

class A {
    ...
}

class B {
    ... // 이 경우는 `A의 객체를 생성해야` A의 멤버 접근가능
}

▶ 내부 클래스의 장점
 - 내부 클래스에서 외부 클래스에 멤버들을 쉽게 접근할 수 있다.
 - 코드의 복잡성을 줄일 수 있다.(캡슐화)


# 내부 클래스의 종류와 특징
 - 내부 클래스의 종류와 유효범위(scope)는 변수와 동일

class Outer {
    int iv = 0;
    static int cv = 0;

    void myMethod() {
        int lv = 0;
    }
}

↓

class Outer {
    class InstanceInner() {}
    static class StaticInner {}

    void myMethod() {
        class LocalInner {} // 내부 클래스
    }
}

# 내부 클래스의 제어자와 접근성
 - 내부 클래스의 제어자는 변수에 사용 가능한 제어자와 동일

class Outer {
    private int iv = 0;
    protected static int cv = 0;

    void myMethod() {
        int lv = 0;
    }
}

↓

class Outer {   // 외부클래스는 public default만 가능
    // 내부 클래스는 public default private protected 다 가능
    private class InstanceInner {}
    protected static class StaticInner {}

    void myMethod() {
        class LocalInner {}
    }
}