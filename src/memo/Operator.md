* 증감 연산자 - 값을 1증가(++), 감소(--)

전위형 - 값이 참조되기 전에 증가 j = ++i;
후위형 - 값이 참조된 후에 증가 j = i++;

j = ++i; // 전위형
++i; // 1. 증가 후에
j = i; // 2. 참조하여 대입


j = i++; // 후위형
j = i; // 1. 참조하여 대입
i++; // 2. 증가

* 사칙연산자(+ - * / ...)

int형
10 / 4 -> 2 // 소수점 이하는 버려진다.

int형 / float형 -> int가 float되서 계산됨.
10 / 4.0f -> 10.0f / 4.0f -> 2.5f

산술변환(자동형변환)
1. 작은 타입과 큰 타입이 연산되면 큰타입으로 변환되서 연산됨.
   →　10(int 小) == 10.0f(float 大)　→　float == float
   →　'0'(문자) == 0(숫자) → 48(char보다 큰 int로 바뀌면서 계산됨) == 0 -> false

2. int보다 작으면 -> int로 바꾼다.

int 범위 : +-20억, 2x10의 9승

System.out.println(3/0);    // 오류 발생(ArithmeticException, 산술예외).
System.out.println(3/0.0);  // Infinity가 출력됨.



* 비교연산자 - float와 double의 비교
double을 float로 변환후 비교.

* 비교연산자 - 문자열의 비교, equals(), equalsignoreCase()
String str = new String("abc");
// equals()는 두 문자열의 내용이 같으면 true, 다르면 false
// equalsignoreCase()는 대소문자 구별없이 비교 
boolean result = str.equals("abc");

* 논리연산자
!!b
→ !!true 
→ !false
→ true

* 비트연산자(2진수 연산) - &, |, ^
* 비트전환 연산자 - ~

x ~x
1 0
0 1

10 → 11
-x → ~x + 1

* 쉬프트 연산자(2진수 연산) - <<(왼쪽으로 이동),>>(오른쪽으로 이동)
  x << n은 x * 2의 n승의 결과와 같다.(8<<1(2의1승) → 16 / 8<<2(2의2승) → 32)
  x >> n은 x / 2의 n승의 결과와 같다.


* 조건연산자(삼항연산자) - ?:


조건식 ? 식1(참일때) : 식2(거짓일때)

* 중첩 if문 - 주의사항

if (num >= 0)
   if (num != 0)
      sign = '+';
else
      sign = '-'

위의 괄호가 없는 조건문에서 else는 가장 가까운 if문과 엮여서 실행됨

위의 코드와 같음.
if (num >= 0) {
   if (num != 0) {
     sign = '+';
   } else {
     sign = '-';
   }
}

switch문 - 여러 조건 처리에 유리

①조건식을 계산한다. 
②조건식의 결과와 일치하는 case문으로 이동한다.
③이후의 문장들을 실행한다.
④break문이나 switch문의 끝을 만나면 switch문 전체를 빠져나간다.

switch문 - 제약조건
1. switch문의 조건식 결과는 정수 값(long타입 제외) 또는 참조형(객체 주소)만 허용
2. case문에는 정수 값, 문자열 리터럴 또는 참조형만 가능(중복 불가)

switch(result) {
    case '1':           // OK. 문자 리터럴(49와 동일)
    case ONE:           // OK. 정수 상수
    case "YES":         // OK. 문자열 리터럴. JDK7부터 허용
    case Double d:      // OK. 참조형. JDK14부터 허용
    case num:           // 에러. 변수는 불가
    case 1.0:           // 에러. 실수도 불가
         ...


switch식 - 결과 값을 반환, yield JDK14

char grade = switch(score/10) {
    case 9, 10 -> 'A'; // 콤마(,)로 여러 case를 합칠 수 있다.
    case 8     -> 'B'; // break;가 없어도 다음 case로 넘어가지 않는다.
    case 7     -> 'C';
    default    -> 'F';
}; 끝에 세미콜론을 붙이는것을 잊지말 것.

* 반복문 - while, for, do-while

while (조건식) { ①
    // ②조건식의 연산결과가 참(true)인 동안, 반복될 문장들을 작성.
}

do {
    // ①조건식의 연산결과가 참(true)인 동안, 실행될 문장들을 작성.
} while (조건식); ② ← 끝에 ';'을 잊지 않도록 주의

for (초기화; 조건식; 증감식) {   // 반복횟수가 정해졌을때
    // ①조건식의 연산결과가 참(true)인 동안, 실행될 문장들을 작성.
}

반복문 - 주의 사항
★★★　
 반복문이 잘 안돈다고 했을때 조건식을 확인할 것!
 반복문이 아니었을 때, 다른 부분을 확인!
★★★

* 반복문 - 향상된 for문

for (타입변수명 : 배열 또는 컬렉션) {
    // 반복할 문장
}

