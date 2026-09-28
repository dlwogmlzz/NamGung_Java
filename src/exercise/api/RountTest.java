package exercise.api;

public class RountTest {
    public static void main(String[] args) {
        System.out.println("i="+Integer.parseInt("100"));            // 100, 원래는 10이 생략되있음.
        System.out.println("i="+Integer.parseInt("100",10));    // 100 (위와 동일)
        System.out.println("i="+Integer.parseInt("100",2));     // 4 (2진수)
        // System.out.println("i="+Integer.parseInt("FF"));              // 255 (16진수), NumberFormatException
        System.out.println("i="+Integer.parseInt("FF",16));     // 255 (16진수)
    }
}