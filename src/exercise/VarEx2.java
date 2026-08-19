package exercise;

public class VarEx2 {
    // x, y 값 변경하기.
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int tmp; // 빈 컵 역할

        tmp = x;
        x = y;
        y = tmp;

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("tmp = " + tmp);
    }
}
