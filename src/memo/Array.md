* 배열이란?
    같은 타입의 여러 변수를 하나로 묶은것.

    int score1, score2, score3, score4, score5;
    →　int[] score = new int[5]; // 5개의 int값을 저장할 수 있는 배열을 생성.

배열의 선언과 생성

타입[] 변수이름;              // 배열을 선언(배열을 다루기 위한 참조 변수 선언)
변수이름 = new 타입[길이];     // 배열을 생성(실제 저장 공간을 생성)

1. 선언
int[] score;            // int타입의 배열을 다루기 위한 참조 변수 score선언

2. 생성
score = new int[5];     // int타입의 값 5개를 저장할 수 있는 배열

* 배열의 길이와 인덱스[index]
배열의 요소에 자동으로 붙는 번호(0~배열길이-1)
int[] score = new int[5]; // 길이가 5인 int배열

* 배열의 길이 - 배열이름.length
  배열의 길이는 생성 후 실행도중에 변경불가

int[] score = new int[5]; // 배열의 길이를 6에서 5로 변경하고싶을때...
for (int i=0; i<6; i++) {} → for (int i=0; i<score.length; i++) {}

* 배열의 초기화
①int[] score = new int[] { 50, 60, 70, 80, 90 };
②int[] score = { 50, 60, 70, 80, 90 };   // new int[]를 생략 가능.

int[] score = new int[5];
score[0] = 50;
score[1] = 60;
score[2] = 70;
score[3] = 80;
score[4] = 90;

* 배열의 출력
int[] iArr = { 100, 95, 82, 77, 61 };

// 배열의 요소를 순서대로 하나씩 출력
for (int i=0; i<iArr.length; i++) {
    System.out.println(iArr[i]);
}

// 배열　iArr의 모든 요소를 출력함. [ 100, 95, 82, 77, 61 ]이 출력된다.
System.out.println(Arrays.toString(iArr));

// 향상된 for문
for (int element : iArr) {  // 배열의 요소를 하나씩 element에 담음.
    System.out.println(element);
}

* 배열의 복사
int[] arr = {1,2,3,4,5}; // arr.length는 5
int[] tmp = new int[arr.length*2]; // 1. arr보다 길이가 2배인 배열 생성

for(int i = 0; i < arr.length; i++) // 2. arr의 내용을 tmp에 복사
    tmp[i] = arr[i];    // arr[i]의 값을 tmp[i]에 저장
arr = tmp;  // 3. 참조변수 arr가 새로운 배열을 가리키게 한다.

★사용하지 않는 배열은 GC(가비지 컬렉터)가 자동으로 제거 해준다.

System.arraycopy() - 배열을 하나씩이 아니고 한번에 복사 가능

for(int i=0; i<num.length; i++) { newNum[i = num[i]; }    // 배열을 하나씩 담는다...
→　System.arraycopy(num, 0, newNum, 0, num.length);       // num[0]에서 newNum[0]으로 num.length개의 데이터를 복사

* 배열의 활용
* String 배열
String[] name = new String[3];
  name[0] = "Kim";
  name[1] = "Lee";
  name[2] = "Yi";

* String 클래스
 - char배열에 기능(메서드)을 추가한 것

1. charAt() - 문자 하나 꺼내기, substring() - 문자열 일부분 자르기

String str = "ABCDE";       // A0 B1 C2 D3 E4
char ch = str.charAt(3);    // 문자열 str의 4번째 문자 'D'를 ch에 저장, charAt() - 문자를 하나 꺼내는 메서드

String str2 = "012345";
String tmp = str.substring(1,4);    // str에서 index범위 1~4의 문자들을 반환, 1에서 4의 전까지
System.out.println(tmp);            // "123"이 출력됨

2. char배열로 변환

char[] chArr = { 'A', 'B', 'C' };
String str = new String(chArr);     // char배열 → String
char[] tmp = str.toCharArray();     // String → char배열

* 다차원 배열
int[][] score = new int[4][3]; // 4행 3열의 2차원 배열을 생성

* 다차원 배열 - 초기화
int[][] score = { 
    { 100, 100, 100 }
   ,{ 200, 200, 200 }
   ,{ 300, 300, 300 }
   ,{ 400, 400, 400 }
   ,{ 500, 500, 500 }
};

// 2차원 배열 score의 모든 요소를 10으로 초기화한다.

for (int i = 0; i < score.length; i++) {
    for (int j = 0; j < score[i].length; j++) {
        score[i][j] = 10;
    }
}

* 다차원 배열 - 가변 배열, 열길이가 다름.
int[][] score = new int[5][];
  score[0] = new int[4];    // 열이 4칸인
  score[1] = new int[3];    // 열이 3칸인
  score[2] = new int[2];    // 열이 2칸인
  score[3] = new int[2];    // 열이 2칸인
  score[4] = new int[3];    // 열이 3칸인
