// 이름 붙인 반복문(labeled for)
public class FlowEx34 {
    public static void main(String[] args) {
        // for문에 Loop1이라는 이름을 붙임.
        Loop1 :
        for(int i=2; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if(j==5)
                    break Loop1; // 2개이상을 뚫고 나가고 싶을때 label에 붙인 이름을 지정해주면 나갈 수 있음.
                // break;    // 그냥 break는 하나만 뚫고 나감
                // continue Loop1;
                // continue;

                System.out.println(i+"*"+j+"="+i*j);
            }
            System.out.println();
        } // end of Loop1
    }
}
