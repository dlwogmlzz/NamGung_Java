public class ArrayEx {
    public static void main(String[] args) {
        int[] score = new int[5]; // 길이가 5인 int배열
        // long[] score2 = new int[2_000_000_0000]; // 배열의 타입은 int만 허용, long은 안됨.
        score[0] = 100;
        score[1] = 200;

        System.out.println("score.length = " + score.length);

        // for (int i = 0; i < 5; i++) {
        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }
    }
}
