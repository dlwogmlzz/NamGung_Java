# 클래스 메서드와 인스턴스 메서드

* 객체사 필요한가 안한가로 구별
- 인스턴스 메서드 : 인스턴스(iv의 집합)가 필요한 메서드
- 클래스 메서드 : 인스턴스(iv의 집합)가 필요없는 메서드

====================================================

- 인스턴스 변수 : 인스턴스마다 개별적인 변수
- 클래스 변수 : 모든 인스턴스가 공유하는 변수

* 클래스 멤버와 인스턴스 멤버 간의 참조와 호출(1)

class TestClass {
void instanceMethod() {}        // 인스턴스 메서드, 객체 생성후에 호출가능
static void staticMethod() {}   // static메서드, 항상 호출가능

    void instanceMethod2() {        // 인스턴스 메서드
        instanceMethod();           // 다른 인스턴스 메서드를 호출한다.
        staticMethod();             // static메서드를 호출한다.
    }

    static void staticMethod2() {   // static메서드
        intanceMethod();            // 에러. static메서드에 인스턴스 메서드를 호출할 수 없다. 
        staticMethod();             // static메서드는 호츨할 수 있다.
    }
}   // end of class


* 클래스 멤버와 인스턴스 멤버 간의 참조와 호출(2)

class TestClass2 {
int iv;             // 인스턴스 변수
static int cv;      // 클래스 변수

    void instanceMethod() {        // 인스턴스 메서드
        System.out.println(iv);    // 인스턴스 변수를 사용할 수 있다.
        System.out.println(cv);    // 클래스 변수를 사용할 수 있다. 
    }

    static void staticMethod() {   // static메서드
        System.out.println(iv);    // 에러. 인스턴스 변수를 사용할 수 없다.
        System.out.println(cv);    // 클래스 변수는 사용할 수 있다.
    }
}   // end of class

* 오버로딩(overloading, 과적하다)
  ╰ 같은 이름의 메서드를 여러 개 작성 하는것.

★오버로드 성립조건
1. 메서드 이름이 같아야 한다.
2. 매개변수의 개수 또는 타입이 달라야 한다.
3. 반환타입은 뭐든지 상관없다. 이건 아님

- 매개변수 타입 or 갯수로 구별가능.
void println()
void println(boolean x)
void println(char x)
void println(char[] x)
void println(double x)
void println(float x)
void println(float x)
void println(int x)
void println(long x)
void println(Object x)
void println(String x)

아닌 예1. 변수명이 다른 경우, 오버로딩이 아님. 같은 메서드임.
int add(int a, int b) { return a + b; }
int add(int x, int y) { return x + y; }

아닌 예2. 반환타입이 다른 경우, 반환타입이 뭐든 상관없다. 오버로딩이 아님.
int add(int a, int b) { return a + b; }
long add(int a, int b) { return (long)(a + b); }

아닌 예3. 개수는 같은데 타입이 다른경우, 오버로딩이 맞음.
long add(int a, long b) { return a + b; }
long add(long a, int b) { return a + b; }


* 가변인자와 오버로딩
  ╰ 매개변수의 개수를 가변적으로 할 수 있다.
String concatenate(String s1, String s2) { ... }    // () 괄호안에 매개변수를 무제한으로 기입할 수 있음. but
String concatenate(String s1, String s2, String s3) { ... }
String concatenate(String s1, String s2, String s3, String s4) { ... }

★★매개변수가 너무 많아지면 문제가 있기 때문에 `가변인자`를 사용함.
String concatenate(`String... str`) { ... }

System.out.println(concatenate());                              // 인자가 없음
System.out.println(concatenate("a"));                           // 인자가 하나
System.out.println(concatenate("a", "b"));                      // 인자가 둘
System.out.println(concatenate(new String[]{"A", "B"}));        // 배열도 가능


💡가변인자와 오버로딩 - 주의 사항
  ╰ `가변인자`는 매개변수 목록의 `마지막`에 기재해야함.

public PrintStream printf(String format, `Object... args`) { ... }

// 매개변수 목록의 마지막이 아니면 컴파일 에러가 발생
public PrintStream printf(`Object... args`, String format) { ... }