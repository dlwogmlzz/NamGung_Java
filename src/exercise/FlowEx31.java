package exercise;

public class FlowEx31 {
    public static void main(String[] args) {
        int sum = 0;
        int i   = 0;

        while(true) { // true면 무한 반복인데,
            if(sum > 100) // 여기의 조건문과 break문으로 무한반복을 멋어난다.
                break;
            // break문이 실행되면 밑의 코드는 실행되지 않고 while문을 완전히 벗어난다.
            ++i;
            sum += i;
        }   // end of while

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }
}
