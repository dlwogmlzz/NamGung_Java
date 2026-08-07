public class VarEx3 {
    public static void main(String[] args) {
        final int MAX_VALUE = 100; // 상수, 값이 바뀌지 않는다.
        // MAX_VALUE = 200; // 에러. 값을 바꿀 수 없음. 상수는 값을 한번만 저장가능.

        char ch = 'a';
        // ch = ''; // 에러
        String str = "java"; // 참조형. 그룹(집합) 공집합(0개 문자 허용)
        str = ""; // 0개 문자 저장 가능.
        ch = ' '; // 빈문자 저장 가능.

        System.out.println(7+""); // "7"
        System.out.println(7+7+""); // "14"
        System.out.println(7+""); // "7"
        System.out.println(7+""); // "7"

        // 텍스트 블락은 닫는 """ 따옴표 위치가 어디냐에 따라서 처음부터 끝의 범위까지가 공백으로 들어감
        // 처음 """이후에 개행을 해야 됨, 안하면 에러.
        String block = """
                Hello
                world
                zzzz
        """;
        System.out.println(block);
    }
}
