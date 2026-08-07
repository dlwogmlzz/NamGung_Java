import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {
        // Scanner를 생성해서 화면(System.in)으로 부터 입력받기
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        int input = sc.nextInt();

        System.out.println("input = " + input);

    }
}
