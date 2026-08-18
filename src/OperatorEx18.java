public class OperatorEx18 {
    public static void main(String[] args) {
        // 반올림, Math.round() - 소숫점 첫째자리 반올림.
        double pi = 3.141592;
        double shortPi = Math.round(pi * 1000) / 1000.0; // 3.1415에서 5로 인해 반올림이 되고 3.142가 됨.
        System.out.println(shortPi);
    }
}
