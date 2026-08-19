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
