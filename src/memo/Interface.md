# 인터페이스(interface)
  ╰추상 메서드의 집합(+상수)
  - 높은 추상화. 껍데기(구현x)
  - 선언(껍데기)과 구현(알맹이)의 분리
  - static메서드(JDK 8), 디폴트 메서드(JDK 8), private메서드(JDK 9)

# 인터페이스의 작성
  ╰`추상 메서드(public abstract)` + 상수(public static)
    
    interface 인터페이스 이름 {
        public static final 타입 상수이름 = 값;        // 상수
        public abstract 메서드이름(매개변수목록);       // 추상메서드
    }


# 인터페이스의 상속 - 다중 상속 OK
  ╰Object와 같은 최고 조상은 없음.

interface Movable {
    /** 지정된 위치(x, y)로 이동하는 기능의 메서드 */
    void move(int x, int y);
    // public abstract가 생략되있음
}

interface Attackable {
    /** 지정된 대상(u)을 공격하는 기능의 메서드 */
    void attack(Unit u);
    // public abstract가 생략되있음
}

interface Fightable extends Movable, Attackable { }


# 인터페이스의 구현, 완성 - implements
  ╰구현하는 인터페이스의 `추상 메서드 몸통 만들기`
  
interface Fightable {
    void move(int x, int y);
    void attack(Unit u);
}

class 클래스이름 `implements` 인터페이스이름 {
    // 인터페이스에 정의된 추상 메서드를 구현해야 한다.
}

class Fighter `implements` Fightable {
    public void move(int x, int y)  { /* 내용 생략 */ }
    public void attak(Unit u)  { /* 내용 생략 */ }
}

`abstract` class Fighter implements Fightable {
    public void move(int x, int y) { /* 내용 생략 */ }     
}


# 인터페이스 vs 추상클래스
  ╰껍데기(완전 미완성) vs 템플릿(일부 미완성)

・인터페이스
  → iv(인스턴스 변수)를 가질 수 없음.

`interface` Fightable {
    void move(int x, int y);
    void attack(Unit u);
}

class Fighter `implements` Fightable {
    public void move(int x, int y)  { /* ... */ }
    public void attack(Unit u)      { /* ... */ }
}

・추상클래스

`abstract` class Unit {
    int x, y;       // iv
    `abstract` void move(int x, int y);      // 추상메서드
    void stop()  { /* 현재 위치에 정지 */ }    // 인스턴스 메서드
}

class Marine extends Unit { // 보병
    void move(int x, int y)  { /* 지정된 위치로 이동 */ }
    void stimPack()          { /* 스팀팩을 사용함   */ } 
}


# 인터페이스를 이용한 다형성
  ╰구현 클래스는 인터페이스 타입으로 형변환, instanceof 가능

interface Fightable {
    void move(int x, int y);
    void attack(Unit u);
}


class Fighter `extends` Unit `implements` Fightable {   // 구현과 상속 동시에 가능
    public void move(int x, int y) { /* 내용 생략 */ }
    public void attack(Unit u)     { /* 내용 생략 */ }
}

Fightable f = (Fightable) new Fighter();

if (f instanceof Fightable) // true. 참조변수 f가 가리키는 객체가 Fightable구현했는가??
    System.out.println("f는 Fightable인터페이스를 구현했습니다.");


# 인터페이스 타입의 매개변수와 반환타입
  ╰인터페이스를 구현한 클래스의 객체를 대입, 반환
  
// 매개변수 f에 Fightable을 구현한 클래스의 객체만 가능 
void attack(`Fightable f`) {
    //...
}

`Fightable` method() {    // Fightable을 구현한 클래스의 객체를 반환
    ...
    Fighter f = new Fighter();      // Fighter는 Fightable을 구현
    return `f`;
}

# 인터페이스의 장점
 - 개발 시간의 단축. 구현과 사용을 동시에
 - 서로 관계 없는 클래스들을 관계 맺어주기 가능
 - 공통 표준을 만드는 것이 가능

■서로 관계없는 클래스들을 관계 맺어주기

void repair(Tank k) {
    // Tank를 수리한다.
}

void repair(Dropship d) {
    // Dropship를 수리한다.
}

void repair(GroundUnit gu) {
    // 지상유닛(GroundUnit)을 수리한다.
}

공통 조상 만들기
interface Repairable {}

class SCV   extends GroundUnit implements Repairable { ... }
class Tank  extends GroundUnit implements Repairable { ... }
class Dropship extends AirUnit implements Repairable { ... }

// Repairable을 구현한 클래스의 객체만 가능
void repair(Repairable r) {
    // 매개변수로 넘겨받은 유닛을 수리한다.
}

# 인터페이스(interface)의 이해
  ╰두 대상(face) 사이의 중간(inter) 역할, 껍데기, 표준

* 메서드 호출은 선언부만 알면 된다. 구현 내용은 몰라도 OK

예제1

class A {           // User
    public void methodA(B b) {
        b.method();
    }
}

↓

class A {
    public void methodA(I i) {
        i.method();
    }
}


class B {           // Provider
    public void method() {
        System.out.println("method() in B);
    }
}

↓  

interface I {
    public abstract void method();
}

class B implements I {      // 구현
    public void method() {
        System.out.println("method() in B);
    }
}


# 디폴트 메서드 - JDK 8
  ╰인터페이스에 추상 메서드를 추가할 때, 기본 구현(몸통)을 제공

interface MyInterface {
    void method();
    void newMethod();   // 추상메서드
}

↓

interface MyInterface {
    void method();
    default void newMethod() {}
}

1. 여러 인터페이스의 디폴트 메서드 간의 충돌
 - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩 해야한다.

2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
 - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.