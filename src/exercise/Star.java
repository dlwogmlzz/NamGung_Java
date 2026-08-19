package exercise;

public class Star {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 ; j++) {
//                System.out.print("*");
//                if (i == j)
                if (i == j || i + j == 6)
                    System.out.printf("[%d, %d]", i, j);
                else
                    System.out.print("       ");
            }
            System.out.println();
        }
    }
}
