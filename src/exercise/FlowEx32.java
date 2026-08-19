package exercise;

public class FlowEx32 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i % 3 == 0) { // 3의 배수일때 출력안함.
                continue; // 조건식이 참이 되어 continue문이 실행되면 블럭의 끝으로 이동한다. break문과 달리 반복문을 벗어나지 않고 다시 조건문으로 간다.
            }
            System.out.println(i);
        }
    }
}
