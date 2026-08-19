package exercise;

import java.util.Arrays;

public class ArrayEx2 {
    public static void main(String[] args) {
         // int[] score;
         // score = {51,60,70,80,90}; // 반드시 한줄로만 가능. 에러발생함. Array initializer is not allowed here

        // 두줄로 하고 싶을때 생략가능한 new int[]를 붙여 줘야함.
        int[] score;
        score = new int[] {51,60,70,80,90};
        int[] newArr = new int[score.length * 2]; // 2배 길이의 새로운 배열을 생성

        // int[] score = {51,60,70,80,90};

        // Arrays.toString(score) - score배열에 들어있는 모든 값을 한눈에 문자열로 변환하여 출력
        // for (int i = 0; i < score.length; i++) {
        //    newArr[i] = score[i];
        // }

        System.arraycopy(score, 0, newArr, 5, score.length);
        System.out.println(Arrays.toString(score));
        System.out.println(Arrays.toString(newArr));

        System.out.println("score.length = " + score.length);

        // for (int i = 0; i < score.length; i++) {
         for (int element : score) { // 향상된 for문
             System.out.println(element);
         }
    }
}
