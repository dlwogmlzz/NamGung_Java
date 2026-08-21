# 오버라이딩(overriding) - 조상의 메서드 자식에서 덮어쓰기(변경)

 - 오버라이딩은 선언부는 같아야 되고, 내용은 달라야 된다.
   ╰오버라이딩(overriding)의 조건 3가지
    1. 선언부가 일치해야 한다.
    2. 접근 제어자를 좁게 할 수 없다.
    3. 조상 메서드보다 많은 예외를 선언 할 수 없다. 

class Point {
    int x;
    int y;

    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}

class Point3D extends Point {
    int z;

    String getLocation() {  // 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
    }
}

* 오버로딩 vs 오버라이딩
  - `오버로딩`(overloading) : 기존에 없는 `새로운 메서드를 정의`하는 것(`new`), 메서드 이름 일치, 매개변수 갯수 or 타입이 달라야함.
  - `오버라이딩`(overriding) : 상속받은 메서드의 `내용을 변경`하는 것(`change, modify`), 선언부가 일치해야 함.

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    void parentMethod() {}           // 오버라이딩
    void parentMethod(int i) {}      // 오버로딩

    void childMethod() {}
    void childMethod(int i) {}       // 오버로딩
    void childMethod() {}            // 에러. 중복정의 되었음(already defined in Child)
}


* super(this와 비슷) - 참조변수(객체 자신의 주소가 담긴..), `조상 멤버 구별`에 사용

class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;

    void method() {
        System.out.println("x=" + x);               // 제일 가까운 x 니까 20
        System.out.println("this.x=" + this.x);     // 자기 자신의 멤버x니까 20
        System.out.println("super.x=" + super.x);   // 조상의 멤버x니까 10
    }
}

class SuperEx {
    public static void main(String args[]) {
        Child c = new Child();
        c.method();
    }
}

* this vs super
 - this  : 자기 멤버인 lv와 iv 구별.
 - super : 조상 멤버 구별.

class Point {
    int x;
    int y;

    // super.getLocation()
    String getLocation() {
        return "x :" + x + ", y :" + y;
    }
}


class Point3D extends Point {
    int z;
    // this.getLocation()
    String getLocation() {      // 오버라이딩
        // return "x :" + x + ", y :" + y + ", z :" + z; // 이렇게 하면 조상과 똑같은 코드가 중복된다.
        return super.getLocation() + ", z:" + z;    // 조상의 메서드를 호출하고 추가.
    }
}

* super() - 조상의 생성자, 조상 멤버는 super()로 초기화
╰왜? 조상의 멤버를 먼저 초기화하는가? 자손이 조상 멤버를 사용할 수도 있어서!
 - 생성자 첫 줄에 생성자 this() 또는 super()를 호출해야 한다.
 - 아니면 컴파일러가 'super();'를 생성자의 첫 줄에 삽입(Object제외)


class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
                        // 👈　여기 빈칸 첫줄에서 다른 생성자를 호출 안해서 컴파일러가 'super();'를 자동으로 삽입해줌.
        // this.x = x;
        // this.y = y;
        // ↑ 위의 this.x와 y를 자식이 초기화 하는 것이 아니라, 부모에게 초기화를 시킴.
        // this.z = z;  <-- 여기에 쓰면 에러! (super보다 위에 올 수 없음)
        super(x, y);    // 조상의 생성자 Point(int x, int y)를 호출.
        this.z = z;
    }

    String getLocation() {      // 오버라이딩
        return "x :" + x + ", y :" + y + ", z :" + z;
    }
}


⭐Remind⭐
생성자의 조건
1. 클래스의 이름과 일치해야 함.
2. void 붙일수 없음, 붙이면 메서드임.
3. this()로 다른 생성자 호출
4. 생성자 첫줄에 반드시 생성자 호출!!(그렇지 않으면 super()가 자동으로 삽입됨.)