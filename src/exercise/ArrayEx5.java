package exercise;

// 섞기(shuffle)
public class ArrayEx5 {
    public static void main(String[] args) {
        int[] numArr = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;  // 배열을 0~9의 숫자로 초기화
            System.out.print(numArr[i]);
        }
        System.out.println();
        // suffle
        // for (int i = 0; i < 20; i++) { // 20번 섞기
        for (int i = 0; i < numArr.length; i++) { // 배열의 길이(10)만큼 섞기
            int n = (int)(Math.random() * 10);  // 0~9중의 한 값을 임의로 얻는다.
            // numArr[0]과 numArr[n]의 값을 서로 바꿈.
            // int tmp = numArr[0];
            int tmp = numArr[i];
            numArr[0] = numArr[n];
            numArr[n] = tmp;
        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i]);
        }
    } // main의 끝
}
