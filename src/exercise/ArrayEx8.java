package exercise;

// 배열 - 빈도수 구하기, 랜덤으로 10개의 수를 받아서 그수가 몇개 인지 세는 코드
public class ArrayEx8 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int)(Math.random() * 10); // 0~9의 임의의 수를 배열에 저장
            System.out.print(numArr[i]); // 출력
        }
        System.out.println();

        for (int i = 0; i < numArr.length; i++) {
            counter[numArr[i]]++;
        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.println(i + "의 개수 : " + counter[i]);
        }
    } // main의 끝
}
