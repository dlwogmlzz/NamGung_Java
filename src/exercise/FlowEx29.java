package exercise;

import java.util.Scanner;

public class FlowEx29 {
    public static void main(String[] args) {
        int input = 0, answer = 0, attempt = 0;

        answer = (int)(Math.random() * 100) + 1; // 1~100사이의 임의의 수를 저장
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("1과 100사이의 정수를 입력하세요.>");
            input = sc.nextInt();
            attempt++;

            if (input > answer) {
                System.out.println("더 작은 수로 다시 시도해보세요..");
            } else if(input < answer) {
                System.out.println("더 큰 수로 다시 시도해보세요..");
            } else {
                System.out.println("정답입니다!!");
                System.out.println("시도 횟수 : " + attempt + "회");
            }
        } while (input != answer);
    }
}
