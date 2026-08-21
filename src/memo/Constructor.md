# 생성자(constructor)
  ╰ 객체 `초기화` 메서드
   1. 생성자의 이름은 `클래스 이름과 같아야` 한다.
   2. 생성자는 `리턴 값이 없다`(void 붙이지 않음.)

class Card {
    // 매개변수가 없는 생성자
    Card() { ... }

    // 매개변수가 있는 생성자
    Card(String k, int num) { ... }
}

* 객체 생성은 new연산자가, 객체 초기화는 생성자가
    
    Card c = new Card();
    1. new로 생성.
    2. Card()객체로 초기화.
    3. =(대입연산자)를 이용해서 생성된 객체의 주소가 참조변수c에 들어간다.

    0x100 (참조값/주소)
    ┌───────┐
    │ 0x100 │─────┐
    └───────┘     │
    (참조 변수 c)   │
                  ▼
              ┌───────┐
              │ null  │ <── kind (필드)
              ├───────┤
              │   0   │ <── num. (필드)
              └───────┘
              (Heap 메모리의 객체)

    1. 연산자 new에 의해서 메모리(heap)에 Card클래스의 인스턴스가 생성된다.
    2. 생성자 Card()가 호출되어 수행된다.
    3. 생성된 Card인스턴스의 주소가 참조변수 c에 저장된다.

* 기본생성자(default constructor) - 매개변수 없는 생성자
  ╰생성자가 하나도 없으면 `기본 생성자를 자동 추가` by 컴파일러

★클래스에는 생성자가 반드시 1개 이상 필요하다!!
클래스 이름() { }
Card () { }

* 매개변수 있는 생성자
class Car {
    // iv
    String color;           // 색상
    String gearType;        // 변속기 종류 - auto(자동), manual(수동)
    int door;               // 문의 개수

    Car() {}                            // 기본 생성자
    Car(String c, String g, int d) {    // 매개변수가 있는 생성자
        color = c;
        gearType = g;
        door = d;
    }
}

Car c = new Car();
c.color = "white";
c.gearType = "auto";
c.door = 4;

↓

위의 코드를 한번에 초기화 가능
Car c = new Car("white", "auto", 4);


* 생성자가 다른 생성자를 호출할 때 - this()
 - 생성자의 이름으로 `클래스 이름 대신 참조변수인 this`를 사용, but`this()는 생성자`임.
 - 다른 생성자를 호출할 때 `반드시 첫 줄에서만 호출`이 가능

Car(String color) {
    door = 5;                   // 첫 번째 줄
    Car(color, "auto", 4);      // 에러1. 생성자의 두 번째 줄에서 다른 생성자 호출하고 있음.
}                               // 에러2. `this(color, "auto", 4);`로 해야함.

💡예시
Car() { this("white", "auto", 4); }
Car(String color) { this(color, "auto", 4); }

↓

Car(String color, String gearType, int door) { // 여기서는 this가 생략되있음
    this.color = color;
    this.gearType = gearType;
    this.door = door;
    // 여기도 원래 `return this;`가 있는데 생략됨. 
}

* 객체 자신을 가리키는 `참조변수` - `this` / this는 인스턴스 메서드 내에서 따로 선언 없이 사용가능

this 인스턴스 `자신을 가리키는 참조 변수`, 인스턴스의 주소가 저장되어 있으며
     모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재.

this(), this(매개변수) 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용.