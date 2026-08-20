package exercise;
// 기본형 매개변수(Call by Value)
class Data { int x; }

public class PrimitiveParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);      // 1. main() : x = 10 출력

        change(d.x);                                    // 2. 여기서 change메서드로 감.
        System.out.println("After change(d.x)");        // 4. After change(d.x) 출력
        System.out.println("main() : x = " + d.x);      // 5. main() : x = 10 출력

    }

    static void change(int x) {  // 기본형 매개변수
        x = 1000;
        System.out.println("change() : x = " + x);      // 3. x에 1000을 넣고, change() : x = 1000 출력
    }
}
