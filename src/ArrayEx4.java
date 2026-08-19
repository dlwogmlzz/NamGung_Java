// 배열의 최대값과 최소값
public class ArrayEx4 {
    public static void main(String[] args) {
        int[] score = { 77, 70, 89, 92, 100 };

        int max = score[0];    // 배열의 첫번째 값으로 최대값을 초기화
        int min = score[0];    // 배열의 첫번째 값으로 최소값을 초기화

        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            } else if (score[i] < min) {
                min = score[i];
            }
        } // end of for

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
    }
}
