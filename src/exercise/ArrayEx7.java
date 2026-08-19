package exercise;

import java.util.Arrays;

// 배열 정렬하기, 버블정렬
public class ArrayEx7 {
    public static void main(String[] args) {
        int[] numArr = { 10, 1, 4, 7, 8, 9, 3, 2 };

        for (int i = 0; i < numArr.length - 1; i++) {
            for (int j = 0; j < numArr.length - 1 - i; j++) {
                if (numArr[j] > numArr[j+1]) {
                    int tmp = numArr[j];
                    numArr[j] = numArr[j+1];
                    numArr[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(numArr));
    }
}
