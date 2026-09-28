# StringBuilder(동기화 X)

- StringBuffer는 동기화(데이터 보호)되어 있다. 멀티 쓰레드에 안전(thread-safe) 

싱글 쓰레드 : 한번에 1개의 작업
멀티 쓰레드 : 동시에 n개의 작업

- 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하
  이럴 땐 StringBuffer대신 StrinBuilder를 사용하면 성능 향상


// `StringBuffer` 사용 예시
StringBuffer sb1 = new StringBuffer();
sb1.append("abc");

// `StringBuilder` 사용 예시
StringBuilder sb2 = new StringBuilder();
sb2.append("abc");



# Math클래스

[자바 Math 클래스 및 소수점 반올림 처리 정리]

* 수학 관련 static 상수 및 메서드 집합
    - public static final double E = 2.718281828459045234; (자연로그의 밑)
    - public static final double PI = 3.14159265358979323846; (원주율)

* round()를 활용한 소수점 아래 특정 자리 반올림 처리 방법
    - 1단계: 원래 값에 10의 거듭제곱(예: 소수점 세 번째 자리에서 반올림하려면 100)을 곱한다.
    - 2단계: 위의 결과에 Math.round()를 적용하여 정수형으로 반올림한다.
    - 3단계: 결과를 다시 실수형(예: 100.0)으로 나누어 원래 소수점 자리로 돌려놓는다. (정수 100으로 나누면 소수점이 잘려나가는 것을 주의).


// Math 클래스 상수 및 반올림 연산 코드 예시
double eConstant = Math.E;
double piConstant = Math.PI;

double targetValue = 90.7552;
long roundedValue = Math.round(targetValue * 100); // 9075.52 -> 9076
double finalResult = roundedValue / 100.0; // 90.76


[자바 Math 클래스 주요 메서드 (abs, ceil, floor, max) 정리]

* static double abs(double a) / float / int / long
    - 설명: 주어진 값의 절대값을 반환한다.
    - 예제 및 결과: int i = Math.abs(-10); -> i = 10, double d = Math.abs(-10.0); -> d = 10.0

* static double ceil(double a)
    - 설명: 주어진 값을 올림하여 반환한다.
    - 예제 및 결과: double d = Math.ceil(10.1); -> d = 11.0, double d2 = Math.ceil(-10.1); -> d2 = -10.0, double d3 = Math.ceil(10.000015); -> d3 = 11.0

* static double floor(double a)
    - 설명: 주어진 값을 버림하여 반환한다.
    - 예제 및 결과: double d = Math.floor(10.8); -> d = 10.0, double d2 = Math.floor(-10.8); -> d2 = -11.0

* static double max(double a, double b) / float / int / long
    - 설명: 주어진 두 값을 비교하여 큰 쪽을 반환한다.
    - 예제 및 결과: double d = Math.max(9.5, 9.50001); -> d = 9.50001, int i = Math.max(0, -1); -> i = 0


// Math 클래스 abs, ceil, floor, max 메서드 활용 예시 코드
int iVal = Math.`abs`(-10); // 10
double dVal = Math.`abs`(-10.0); // 10.0

double ceilVal = Math.`ceil`(10.1); // 11.0
double ceilVal2 = Math.`ceil`(-10.1); // -10.0
double ceilVal3 = Math.`ceil`(10.000015); // 11.0

double floorVal = Math.`floor`(10.8); // 10.0
double floorVal2 = Math.`floor`(-10.8); // -11.0

double maxVal = Math.`max`(9.5, 9.50001); // 9.50001
int maxVal2 = Math.`max`(0, -1); // 0


[자바 Math 클래스 min, random, rint, round 메서드 정리]

* static double min(double a, double b) / float / int / long
    - 설명: 주어진 두 값을 비교하여 작은 쪽을 반환한다.
    - 예제 및 결과: double d = Math.min(9.5, 9.50001); -> d = 9.5, int i = Math.min(0, -1); -> i = -1

* static double random()
    - 설명: 0.0 이상 1.0 미만 범위의 임의의 실수값을 반환한다 (1.0은 포함되지 않음).
    - 예제 및 결과: double d = Math.random(); -> 0.0 <= d < 1.0, int i = (int)(Math.random() * 10) + 1; -> 1 <= i < 11

* static double rint(double a), 짝수 반올림.
    - 설명: 주어진 실수값과 가장 가까운 정수값을 실수형으로 반환한다. 단, 두 정수의 정가운데 있는 값(1.5, 2.5, 3.5 등)은 짝수 값을 반환한다.
    - 예제 및 결과: double d = Math.rint(1.2); -> d = 1.0, double d2 = Math.rint(2.6); -> d2 = 3.0, double d3 = Math.rint(3.5); -> d3 = 4.0, double d4 = Math.rint(4.5); -> d4 = 4.0

* static long round(double a) / float a, 일반 반올림
    - 설명: 소수점 첫째 자리에서 반올림한 정수값(long)을 반환한다. 두 정수의 정가운데에 있는 값은 항상 큰 정수를 반환한다 (rint 메서드와 차이점).
    - 예제 및 결과: long l = Math.round(3.5); -> l = 4, long l2 = Math.round(4.5); -> l2 = 5, 소수점 자리 반올림 응용 연산: double d2 = Math.round(d * 100) / 100.0; -> d2 = 9.076



// Math 클래스 min, random, rint, round 메서드 활용 예시 코드
double minVal = Math.min(9.5, 9.50001); // 9.5
int minVal2 = Math.min(0, -1); // -1

double randVal = Math.random(); // 0.0 <= d < 1.0
int randInt = (int)(Math.random() * 10) + 1; // 1 <= i < 11

double rintVal1 = Math.rint(1.2); // 1.0
double rintVal2 = Math.rint(3.5); // 4.0 (짝수 반환)

long roundVal1 = Math.round(3.5); // 4
long roundVal2 = Math.round(4.5); // 5
double target = 90.7552;
double roundedResult = Math.round(target * 100) / 100.0; // 90.76