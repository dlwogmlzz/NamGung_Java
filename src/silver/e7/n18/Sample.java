package silver.e7.n18;

public class Sample {
    public static void main(String[] args) {
        int num = 10;
        if (num < 11) {
            // 변수의 스코프는 그 변수가 속한 가까운 블록이 끝낼때까지
            // 이 룰은 로컬 변수끼리(인수포함)일때 적용된다.
            // int num = 20;
            int value = 100;
        }
        int value = 200;
    }

}
