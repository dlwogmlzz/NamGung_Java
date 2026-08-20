package exercise;
// 참조형 매개변수
class Data2 { int x; }

public class ReferenceParamEx {
    public static void main(String[] args) {
        Data2 d = new Data2();
        d.x = 10;
        System.out.println("main() : x = " + d.x);      // 1. main() : x = 10 출력

        change(d);                                      // 2. 여기서 change메서드로 감.
        System.out.println("After change(d.x)");        // 4. After change(d.x) 출력
        System.out.println("main() : x = " + d.x);      // 5. main() : x = 1000 출력
    }

    static void change(Data2 d) {  // 참조형 매개변수, 여기의 d는 change의 지역변수
        d.x = 1000;
        System.out.println("change() : x = " + d.x);    // 3. x에 1000을 넣고, change() : x = 1000 출력
    }
}
