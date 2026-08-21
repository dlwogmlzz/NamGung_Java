package exercise.Super;

class Parent {
    int x = 1110;
}

public class Child extends Parent {
//    int x = 20;

    void method() {
        System.out.println("여기x는 가장가까운 x의 값 = " + x);
        System.out.println("this.x는 나의 x의 값 = " + this.x);
        System.out.println("super.x는 부모 x의 값 =" + super.x);
    }
}
