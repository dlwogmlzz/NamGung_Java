# 다형성 - 참조변수 하나로 여러 종류 객체를 다루기
　╰조상타입 참조변수로 자손객체를 참조 가능(그 반대는 불가능)

Tv t = new Caption();       // OK
CaptionTv c = new Tv();     // 컴파일 에러. 자손 참조 변수로 조상 객체 참조 불가

class Tv {          // 부모클래스
    boolean power;
    int channel;

    void power()        { power = !power; }
    void channelUp()    { ++channel;      }
    void channelDown()  { --channel;      }
}

class CaptionTv extends Tv {        // 자손클래스
    String text;        // 캡션을 보여 주기 위한 문자열
    void caption()      { /* 내용생략 */ }
}

* 참조변수의 형변환
　╰`조상과 자손 관계만` 형변환 가능

    - 자손타입 → 조상타입(Up-casting) : 형변환 생략가능 
    - 자손타입 ← 조상타입(Down-casting) : 형변환 생략불가

Car car = null;
FireEngine fe = new FireEngine();

Car = fe;               // Car = (Car)fe; 에서 형변환 생략됨.
fe = (FireEngine)car;   // 형변환을 생략불가.


* instanceof연산자 - **객체의 타입 확인에 사용 / 형변환 해도 되는지 확인**
  ╰instanceof연산의 결과가 `true면`, `형변환 OK`

   void doWork(Car c) {     // Car 또는 Car의 자손만 가능
        if (c `instanceof` FireEngine) {          // c가 FireEngine인지 타입 확인
            FireEngine fe = (FireEngine)c;
            fe.water();
                ...
        } else if (c `instanceof` Ambulance) {    // c가 Ambulance인지 타입 확인
            Ambulance a = (Ambulance)c;
            a.siren();
                ...
        }
     }

* instanceof를 위한 패턴 매칭 - JDK 16
  ╰instanceof연산 이후의 `형변환 생략`가능

if(c instanceof FireEngine) {
    FireEngine fe = (FireEngine)c;
    fe.water();
        ...
}

            ↓

if(c instanceof FireEngine fe) {
    fe.water();
        ...
}

if(obj instanceof Point) {
    Point p = (Point)obj;
    if(x==p.x && y==p.y) {
        ...
}

        ↓

if(obj instanceof Point p &&
x==p.x && y==p.y){
        ...

if(obj instanceof Point p || x==p.x) {  // 에러. `&&만 가능`


* switch문을 위한 패턴 매칭 - 주의 사항
  ╰case의 순서에 주의. 조상 타입의 case를 `자손타입의 case보다 아래에`

  void buy(Product p) {
        bonus += switch(p) {
            case CaptionTv c -> 120;     // OK
            case `Tv` t -> 100;            // Tv와 Tv의 모든 자손을 처리
            case `SmartTv` t -> 200;       // `에러`. 절대 실행 되지 않음
                ...            
            default -> 0;
        };




* case-when - case에 중첩된 if문을 처리

String getStringType(`String` str) {
    return switch(str) {
        case null -> "null";
        case `String` s -> {
            if(s.isEmpty()) {
                yield "empty";
            }
            if(s.isBlank()) {
                yield "blank";
            }
            yield "String";
        }
    }
}

                ↓

String getStringType(`String` str) {
    String type = switch(str) {
        case null -> "null";
        // str이 String타입이고, str.isEmpty()가 true인 경우
        case String s `when` s.isEmpty() -> "empty String";
        case String s `when` s.isBlank() -> "blank String";

        // 위의 두 경우를 제외한 나머지를 여기서 모두 처리
        case String s -> "String";
    }:


* 참조변수와 인스턴스의 연결(1)
  ╰`메서드`는 항상 객체의 타입에 정의된 것이 호출됨(`참조변수 타입과 관계x`)

  class Parent {
    int x = 100;
    
    void method() {
        System.out.println("Parent Method");
    }
  }

  class Child extends Parent {
    int x = 200;
    
    void method() {
        System.out.println("Child Method");
    }
  }

  public static void main(String[] args) {
        Parent p = new Child();
        Child  c = new Child();     // 메서드는 마지막에 생성한 것, 자식것만 호출됨.

        System.out.println("p.x = " + p.x);
        p.method();
        System.out.println("c.x = " + c.x);
        c.method();
  }

결과
p.x = 100;
Child method
p.x = 200;
Child method

* 참조변수와 인스턴스의 연결(2)
  ╰`메서드`는 항상 객체의 타입에 정의된 것이 호출됨(`참조변수 타입과 관계x`)

  class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
  }

  class Child extends Parent {  }

public static void main(String[] args) {
    Parent p = new Chlid();
    Child  p = new Chlid();

    System.out.println("p.x = " + p.x);
    p.method();

    System.out.println("c.x = " + c.x);
    c.method();
}


결과
p.x = 100;
Parent method
c.x = 100;
Parent method




* 참조변수와 인스턴스의 연결(3)
class Parent {
  int x = 100;

  void method() {
    System.out.println("Parent Method");
  }
}

class Child extends Parent {
  int x = 200;
  
  void method() {
    System.out.println("x=" + x);       // this.x와 같다.
    System.out.println("super.x=" + super.x);
    System.out.println("this.x=" + this.x);
  }
}


★★다형성의 장점1★★

* 매개변수의 다형성
  ╰`참조형 매개변수`에 `자신 or 자손 타입`의 객체 대입 가능

class Product {         // 모든 제품의 조상
    int price;          // 제품의 가격
    int bonusPoint;     // 보너스 점수
}

class Tv       extends Product {}
class Computer extends Product {}
class Audio    extends Product {}

class Buyer {           // 고객, 물건을 사는 사람
    int money = 1000;   // 소유금액
    int bonusPoint = 0; // 보너스 점수
}

~~void buy(Tv t) {        // 여기서 Tv만 해당되고 나머지 Computer, Audio는 또 메서드를 만들어 줘야함
    money = money - t.price;
    bonusPoint = bonusPoint + t.bonusPoint;
}~~

        ↓

// 그래서 다형성을 이용해서 부모를 매개변수로 하면 다 사용가능.
void buy(Product p) {
    money = money - p.price;
    bonusPoint = bonusPoint + p.bonusPoint;
}


★★다형성의 장점2★★

*  `하나의 배열`에 `여러 종류`의 객체를 저장
  ╰`참조형 매개변수`에 `자신 or 자손 타입`의 객체 대입가능

* 원래 배열은 같은 타입만 되는데 다른 타입도 됨.
  Product p1 = new Tv();
  Product p2 = new Computer();
  Product p3 = new Audio();

  Product p[] = new Product[3];   // 객체 배열(참조변수 배열)
  p[0] = new Tv();
  p[1] = new Computer();
  p[2] = new Audio();


class Buyer {               // 고객, 물건을 사는 사람
    int money = 1000;       // 소유금액
    int bonusPoint = 0;     // 보너스점수
    Product[] cart = new Product[10];
    int i = 0;

    void buy(Product p) {
            ...

        money -= p.price;               // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint;     // 제품의 보너스 점수를 추가한다.
        cart[i++] = p;                  // 제품을 Product[] item에 저장한다.
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}