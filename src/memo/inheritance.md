# 상속(inheritance)
  ╰기존 클래스를 `확장(재사용)`해서 새로운 클래스 작성
   class Parent { }
   class Child `extends` Parent { } // Parent를 상속받는 Child를 정의


1. 상속 관계도 (Class Diagram)      2. 포함 관계 (Venn Diagram)
   ┌────────┐                     ┌───────────────────────────┐
   │ Parent │                     │ Child                     │
   └────────┘                     │   ┌───────────────────┐   │
       ▲                          │   │ Parent            │   │
       │                          │   └───────────────────┘   │
   ┌────────┐                     └───────────────────────────┘
   │ Child  │
   └────────┘


 - 자손(Child)은 조상(Parent)의 모든 멤버를 상속받는다.(생성자와 초기화 블록은 예외, 상속 받지 않는다!!)
 - 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

class Parent {
    int age;
}

class Child extends parent {
    `void play() {
        System.out.println("놀자~~");
    }`
}

1. 개념도 (포함/상속 관계)
   ┌─────────────────────────────────────────┐
   │ Child (자식 클래스)                       │
   │   ┌───────────────┐     ┌───────────┐   │
   │   │ Parent (상속)  │     │  play()   │   │
   │   │   ┌───────┐   │     │ (추가된    │   │
   │   │   │  age  │   │     │  메서드)   │   │
   │   │   └───────┘   │     └───────────┘   │
   │   └───────────────┘                     │
   └─────────────────────────────────────────┘

2. 클래스별 멤버 요약표
   ┌──────────┬────────────────────────┐
   │ 클래스    │ 클래스의 멤버            │
   ├──────────┼────────────────────────┤
   │ Parent   │ age (1개)              │
   ├──────────┼────────────────────────┤
   │ Child    │ age, play() (2개)      │
   └──────────┴────────────────────────┘


예제

class Tv {
    boolean power;      // 전원 상태(on/off)
    int channel;        // 채널

    void power()        {  power = !power; }
    void channelUp()    {  ++channel;      }
    void channelDown()  {  --channel;      }
}

class CaptionTv extends Tv {
    boolean caption;     // 캡션(자막)상태(on/off)
    void displayCaption(String text) {
        if (caption)     // 캡션(자막)상태가 on(true)일 때만 text를 보여줌.
            System.out.println(text);
    }
}


1. 상속 관계도 (Class Diagram)
   ┌──────┐
   │  Tv  │ (부모 클래스)
   └──────┘
      ▲
      │ (상속)
   ┌───────────┐
   │ CaptionTv │ (자식 클래스)
   └───────────┘

2. 멤버 확장 구조 (Venn Diagram)
   ┌──────────────────────────────────────────────────────────────┐
   │ CaptionTv (자식 클래스)                                        │
   │   ┌─────────────────────────────┐       ┌─────────────────┐  │
   │   │ Tv (부모로부터 상속받음)       │       │ 자식 고유 멤버     │  │
   │   │   - power()                 │       │   - caption     │  │
   │   │   - channelUp()             │       │   - displayCap..│  │
   │   │   - channelDown()           │       └─────────────────┘  │
   │   │   - power (변수)             │                            │
   │   │   - channel (변수)           │                            │
   │   │ ─────────────────────────── │                            │
   │   └─────────────────────────────┘                            │
   └──────────────────────────────────────────────────────────────┘


class Circle {
    int x;      // 원점의 x좌표
    int y;      // 원점의 y좌료
    int r;      // 반지름(radius)
}

==========================================================================-

* 포함 관계 - 클래스 안에 참조형 변수 선언
  ╰composite(구성), aggregation(집합)

class Point {
    int x;      // x좌표
    int y;      // y좌표
}

        ↓

class Circle {
    Point c = new Point();      // 원점
    int r;
}

* 클래스 간의 관계 결정하기 - 상속인가? 포함인가?

class Point {
    int x;      // x좌표
    int y;      // y좌표
}

1. 포함

class Circle {
    `Point c = new Point();`
    int r;
}

 - 포함 관계 : '~은 ~을 가지고 있다.(has-a)'

2. 상속

class Circle `extends Point` {
    int r;
}

- 상속 관계 : '~은 ~이다.(is-a)'

★메서드는 하나의 값만 반환가능, 여러 값을 반환하려면 객체로 묶고 객체의 주소(참조형 반환타입)를 반환해야 한다.


* 단일 상속(single inheritance) - 하나의 조상만 허용

class TvDVD extends Tv, DVD {   // 에러. 조상은 Tv냐 DVD냐 하나만 허용된다.
    // ...
}

그래서...

class TvDVD extneds Tv {        // 하나는 상속으로
    DVD dvd = new DVD();        // 다른 하나는 포함으로

    // DVD의 기능을 사용
    void play() {
        dvd.play();
    }

    void stop() {
        dvd.stop();
    }
}

* Object클래스 - 모든 클래스의 조상

class Tv {  // extends Object가 생략됨.
    ...
}

class CaptionTv `extends Tv` {
    ...
}


* 상속 계층도

┌──────────┐
│  Object  │ (모든 클래스의 최고 조상)
└──────────┘
     ▲
     │ (상속)
┌──────────┐
│    Tv    │ (부모 클래스)
└──────────┘
     ▲
     │ (상속)
┌──────────┐
│CaptionTv │ (자식 클래스)
└──────────┘


★OOP 설계
①그룹화(집합), 서로관련이 있는가??
②그룹간의 관계(상속이냐 포함이냐), 관계가 있으면 줄긋기로 그룹을 맺어주고, 아니면 안맺어주고
