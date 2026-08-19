package silver;

public class e6n17 {
    public static void main(String[] args) {
        e6n17 m = new e6n17();
        System.out.println(m.calc(2,3));
    }
    // index와 출력할때의 값(int면 int로)이 맞아야 됨. 아니면 에러발생
    private double calc(int a, int b) {
        return (a+b) / 2;
    }
    private double calc(double a, int b) {
        return (a+b) / 2;
    }
    private double calc(int a, double b) {
        return (a+b) / 2;
    }
}
