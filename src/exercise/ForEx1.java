package exercise;

public class ForEx1 {
    public static void main(String[] args) {
        /*
        * 1 1 <= 5 → true 참
        * 2 2 <= 5 → true 참
        * 3 3 <= 5 → true 참
        * 4 4 <= 5 → true 참
        * 5 5 <= 5 → true 참
        * 6 6 <= 5 → false 거짓, 반복종료
        * */
        for (int i = 1; i <= 5; i++) {
            System.out.println("I can do it.");
        }
    }
}
