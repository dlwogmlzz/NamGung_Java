# 제어자(modifier)
  ╰대상에 `부가적인 의미`를 부여
  
접근 제어자  public, protected, default, private
그      외  static, final, abstract, native, transient, synchronized, volatile, strictfp

* static - 클래스의, 공통적인
  ╰적용 대상 : 멤버변수, 메서드, 초기화 블럭

class StaticTest {
    static int width  = 200;            // 클래스 변수(static변수)
    static int height = 120;            // 클래스 변수(static변수)

    static {                            // 클래스 초기화 블럭
        // static변수의 복잡한 초기화 수행
    }

    {                                   // 인스턴스 초기화 블럭, 객체(인스턴스)가 생성될 때마다 생성자보다 먼저 실행되며, 모든 생성자에서 공통으로 수행해야 하는 작업이 있을 때 사용함.
        ...
    }

    static int max(int a, int b) {      // 클래스 메서드(static메서드), 안붙이면 인스턴스 메서드
        return a > b ? a : b;
    }
}

* final - 마지막의, 변경될 수 없는
  ╰적용 대상 : 클래스, 변수, 메서드

   final class FinalTest {              // 조상이 될 수 없는(final이라서) 클래스!!
        final int MAX_SIZE = 10;        // 값을 변경할 수 없는 멤버변수(상수)
        
        final void getMaxSize() {       // 오버라이딩할 수 없는 메서드(변경불가)
            final int LV = MAX_SIZE;    // 값을 변경할 수 없는 지역변수(상수)
            return LV;
        }
     }

예제

생성자로 상수를 초기화

class Card {
    // iv, 객체마다 다른 상수값을 가지게 할때 final만 씀. `final static도 있음`
    final int NUMBER;                   // 상수지만 선언과 함께 초기화 하지 않고
    final String KIND;                  // 생성자에서 단 한번만 초기화할 수 있다.
    static int width  = 100;
    static int height = 200;
    // 상수의 초기화(여기서 한번 밖에 못함. 나중에 바꿀 수 없음)
    Card(String kind, int num) {
        // 매개변수로 넘겨받은 값으로 KIND와 NUMBER를 초기화한다.
        KIND = kind;
        NUMBER = num;
    }
}

public static void main(String args[]) {
    Card c = new Card("HEART", 10); // 상수는 객체 생성할 때, 한번만 값을 지정할 수 있음.
    // c.NUMBER = 5;    // 에러. cannot assign a value to final variable NUMBER
    System.out.println(c.KIND);
    System.out.println(c.NUMBER);
}

* abastract - 추상의(구체적이지 않다.), 미완성의
  ╰적용 대상 : 클래스, 메서드

   `abstract` class AbstractTest {        // 추상 클래스(추상 메서드를 포함한 클래스)
        `abstract` void move();           // 추상 메서드(구현부가 없는 메서드)
   }

* 접근 제어자(access modifier)
  ╰적용 대상 : 클래스, 멤버 변수, 메서드, 생성자

================================================================================
[ 자바 접근 제어자 허용 범위 표 ]
-----------------------------------------------------------------------------------
제어자         │ 같은 클래스   │ 같은 패키지   │ 자손 클래스(다른 패키지의)   │ 전 체 (모든곳)
──────────────┼─────────────┼─────────────┼──────────────────────────┼────────────┼
public        │      ●      │      ●      │             ●            │       ●    │
protected     │      ●      │      ●      │             ●            │       X    │
(default)     │      ●      │      ●      │             X            │       X    │
private       │      ●      │      X      │             X            │       X    │
===================================================================================


public(접근 제한 없음)　> protected(같은패키지 + 다른 패키지의 자손 클래스) > (default), 같은 패키지 > private(같은 클래스)


================================================================================
[ 대상별 사용 가능한 접근 제어자 ]
--------------------------------------------------------------------------------
대상           │ 사용 가능한 접근 제어자
──────────────┼───────────────────────────────────────────────────────────────
클래스         │ public, (default)
메서드         │ public, protected, (default), private
멤버변수       │ public, protected, (default), private
지역변수       │ 없음
================================================================================


* 접근 제어자를 이용한 캡슐화
  ╰적용 대상 : 클래스, 멤버 변수, 메서드, 생성자

   접근 제어자를 사용하는 이유
    - 외부로부터 `데이터를 보호(캡슐화)`하기 위해서
    - 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서

예제
    * 인스턴스 변수는 private, 메서드(getter, setter)는 public
    💡 한 줄 요약: "중요한 데이터(private)를 외부로부터 숨기고, 메서드(Getter/Setter)를 통해서만 안전하게 읽고 쓸 수 있게 통제하는 기법"
    public class Time {
        // 접근 제어자를 private로 하여 외부에서 직접 접근하지 못하게 한다. private 클래스 안에서만 접근가능.
        // 1. 데이터 숨기기(정보 은닉)
        private int hour;
        private int minute;
        private int second;

        // ↑ 위에서 인스턴스 변수를 private로 접근 못하게 막아 두고, public인 메서드를 통해서만 접근할 수 있도록 함. 
        public int getHour() {  return hour;  }     // 2. 값 읽기(Getter)
        // 외부에서 hour값을 변경(수정)하고 싶을 때 호출하는 메서드(setHour)
        public void setHour(int hour) {             // 3. 값 쓰기(Setter + 데이터 유효성 검사)
            if (hour < 0 || hour > 23) return;
            this.hour = hour;
        }
        ...
    }

    public static void main(String[] args) {
        Time t = new Time(12, 35, 40);
        // t.hour = 13; // 에러. 변수 hour의 접근제어자가 private이므로 접근할 수 없다.
        t.setHour(t.getHour() + 1); // 1시간 후로 변경.
    }


* 생성자의 접근 제어자
  ╰`private 생성자`는 외부에서 객체 생성 불가

    class Singleton {       // default class
        ...
        // getInstance()에서 사용할 수 있게 인스턴스가 미리 생성되어야 하므로 static이어야 한다.
        private static Singleton s = new Singleton(); // 싱글톤 패턴, 객체 1개만 생성하고 재사용함!!!!
        private Sington() {     // 클래스 내에서만 객체 생성 가능!!!!
            ...
        }
        // 인스턴스를 생성하지 않고도 호출할 수 있어야 하므로 static이어야 한다.
        public static Singleton getInstance() { // getInstance()는 객체를 반환, factory method
            return s;
        }
      }

    public static void main(String args[]) {
        // Singleton s = new Singleton();       // 에러
        Singleton s = Singleton.getInstance();  // static메서드
    }