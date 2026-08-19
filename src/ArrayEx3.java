// 배열의 총합과 평균
public class ArrayEx3 {
    public static void main(String[] args) {
        int sum = 0;        // 총점을 저장하기 위한 변수
        float avg = 0f;     // 평균을 저장하기 위한 변수

        int[] score = { 100, 60, 92, 85, 74 };

        for (int i = 0; i < score.length; i++) {
            sum += score[i];   // 반복문으로 배열에 저장되어 있는 값을 모두 더함.
        }
        avg = sum / (float)score.length;    // 계산결과를 float로 얻기 위해서 형변환

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
