package sliver2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// try블록과 finally블록 양쪽에서 똑같은 리소스에 엑세스하기 위해서는,
// try-catch-finally의 바깥쪽에서 변수를 선언하지 않으면 안된다.
public class Sample {
    public static void main(String[] args) {
        try (FileInputStream is = new FileInputStream("sample.txt")) {  // {}중괄호 안에 선언된 is는 지역변수, try블록 내부에서만 사용할 수 있는 전용 변수가 된다.
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.out.println("A");
        } finally {
//            if (is != null) {
//                is.close();
//            }
            System.out.println("B");
        }
    }
}
