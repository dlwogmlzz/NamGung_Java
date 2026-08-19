package exercise;

public class OperatorEx13 {
    public static void main(String[] args) {
        char c1 = 'a';

//        char c2 = c1 + 1; // 컴파일 에러 발생!!
        char c2 = 'a' + 1;
        System.out.println(c2); // 컴파일러 최적화 때문에 컴파일 에러 없음
    }
}
