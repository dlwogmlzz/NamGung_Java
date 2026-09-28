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




# Wrapper클래스(기본형 값을 감싸는 클래스)

- 8개의 기본형을 객체로 다뤄야할 때 사용하는 클래스

```java
public final class Integer extends Number implements Comparable {
    ...
    private int value;  // 기본형(int)을 감싸고 있음
    ...
}

```



[자바 기본형과 래퍼 클래스(Wrapper Class) 생성자 정리]

* 핵심 개념
    - 자바의 8가지 기본형 데이터는 객체로 다루기 위해 각각 대응하는 래퍼 클래스를 제공한다.
    - 각 래퍼 클래스는 기본형 값 또는 문자열(String)을 매개변수로 받는 생성자를 지원한다.
    - 단, Character 클래스는 문자열을 받는 생성자가 없고 char 타입만 지원하는 특징이 있다.

* 주요 기본형과 래퍼 클래스 매핑
    - boolean -> Boolean (생성자: boolean, String)
    - char -> Character (생성자: char)
    - byte -> Byte (생성자: byte, String)
    - short -> Short (생성자: short, String)
    - int -> Integer (생성자: int, String)
    - long -> Long (생성자: long, String)
    - float -> Float (생성자: double, float, String)
    - double -> Double (생성자: double, String)


```java
// 자바 래퍼 클래스 생성자 활용 예시 코드
Boolean b = new Boolean(true);
Boolean b2 = new Boolean("true");

Character c = new Character('a');

Byte byteVal = new Byte((byte)10);
Byte byteVal2 = new Byte("10");

Short s = new Short((short)10);
Short s2 = new Short("10");

Integer i = new Integer(100);
Integer i2 = new Integer("100");

Long l = new Long(100L);
Long l2 = new Long("100");

Float f = new Float(1.0);
Float f2 = new Float(1.0f);
Float f3 = new Float("1.0f");

Double d = new Double(1.0);
Double d2 = new Double("1.0");

```



# Number클래스
- 모든 숫자 래퍼 클래스의 조상

[텍스트 기반 계층 구조 다이어그램]

Object
├── Boolean
├── Character
└── Number
　　　　├── Byte
　　　　├── Short
　　　　├── Integer
　　　　├── Long
　　　　├── Float
　　　　├── Double
　　　　├── BigInteger
　　　　└── BigDecimal


// Number 추상 클래스의 구조 예시 코드
public `abstract` class `Number` implements java.io.Serializable {
    public `abstract` int    intValue();
    public `abstract` long   longValue();
    public `abstract` float  floatValue();
    public `abstract` double doubleValue();
        public byte byteValue() {
            return (byte)intValue();
        }
        public short shortValue() {
            return (short)intValue();
        }
}


* 문자열을 숫자로 변환하기
 - 문자열을 숫자로 변환하는 다양한 방법

int     i  = new Integer("100").intValue(); // floatValue(), longValue(), ...
int     i2 = Integer.parseInt("100");       // 주로 이 방법을 많이 사용.
integer i3 = Integer.valueOf("100");



[자바 문자열을 기본형 및 래퍼 클래스로 변환하는 메서드 정리]

* 문자열 -> 기본형 변환 (parse 계열 메서드)
    - 설명: 문자열을 읽어들여 각 기본형(primitive type) 값으로 변환한다.
    - 예제:
        * byte b = Byte.parseByte("100");
        * short s = Short.parseShort("100");
        * int i = Integer.parseInt("100");
        * long l = Long.parseLong("100");
        * float f = Float.parseFloat("3.14");
        * double d = Double.parseDouble("3.14");

* 문자열 -> 래퍼 클래스 변환 (valueOf 계열 메서드)
    - 설명: 문자열을 읽어들여 각 래퍼 클래스(wrapper class) 객체로 반환한다.
    - 예제:
        * Byte b = Byte.valueOf("100");
        * Short s = Short.valueOf("100");
        * Integer i = Integer.valueOf("100");
        * Long l = Long.valueOf("100");
        * Float f = Float.valueOf("3.14");
        * Double d = Double.valueOf("3.14");


[자바 n진법 문자열을 숫자로 변환하는 방법 정리]

* n진법의 문자열을 숫자로 변환하기 (Integer.parseInt 메서드 활용)
    - 설명: 문자열과 함께 진법(radix)을 두 번째 인자로 전달하면, 해당 진법 기준으로 해석된 정수값을 반환한다.
    - 예제 및 결과:
        * int i4 = Integer.parseInt("100", 2); -> 결과: 4 (2진법 문자열 "100"을 10진수로 변환)
        * int i5 = Integer.parseInt("100", 8); -> 결과: 64 (8진법 문자열 "100"을 10진수로 변환)
        * int i6 = Integer.parseInt("100", 16); -> 결과: 256 (16진법 문자열 "100"을 10진수로 변환)
        * int i7 = Integer.parseInt("FF", 16); -> 결과: 255 (16진법 문자열 "FF"를 10진수로 변환)
        * 주의사항: 진법을 지정하지 않고 int i8 = Integer.parseInt("FF");와 같이 호출하면 10진법으로 해석하려 시도하므로 `NumberFormatException이` 발생한다.


# 오토박싱 & 언박싱

- JDK1.5이전에는 기본형과 참조형간의 연산이 불가능!!

[자바 기본형과 참조형 연산 및 오토박싱 특징 정리]

* 기본형과 참조형 간의 연산
    - 설명: 기본형 변수(int i)와 래퍼 클래스 참조형 변수(Integer iObj) 사이의 직접적인 덧셈 등 산술 연산은 JDK 1.5 이전에는 에러가 발생했다.
    - 이유: 기본형과 참조형은 타입이 달라 직접 연산할 수 없었기 때문에, 과거에는 참조형의 값을 꺼내기 위해 명시적으로 메서드(예: iObj.intValue())를 호출해야 했다.
    - 현재(JDK 1.5 이후): 오토박싱과 언박싱 기능이 도입되면서 컴파일러가 자동으로 변환을 처리해주므로 기본형과 참조형 간의 연산이 자연스럽게 가능하다.

// 기본형과 참조형 연산 예시 코드
int i = 5;
Integer iObj = new Integer(7);

// JDK 1.5 이후에는 언박싱이 자동으로 일어나 정상적으로 연산됨
int sum = i + iObj; // 내부적으로 i + iObj.intValue()로 처리됨


// 컴파일 전의 코드 예시
int i = 5;
Integer iObj = new Integer(7);
int sum = i + iObj;

// 컴파일 후에 자바 컴파일러에 의해 변환되는 코드 형태
int i = 5;
Integer iObj = new Integer(7);
int sum = i + iObj.`intValue()`; // intValue(), 기본형으로 변환

[자바 오토박싱(Autoboxing)과 언박싱(Unboxing) 정리]

* 핵심 개념
    - 오토박싱 (Autoboxing): 기본형(primitive type) 값을 래퍼 클래스(wrapper class) 객체로 자동 변환해 주는 기능이다. 
    (예: int에서 Integer로 변환)
    - 언박싱 (Unboxing): 래퍼 클래스 객체에 담긴 값을 기본형 값으로 자동 변환해 주는 기능이다. 
    (예: Integer에서 int로 변환)



[자바 컬렉션과 오토박싱/언박싱 활용 정리]

* 핵심 개념 및 코드 동작
    - 기본형의 값을 객체로 자동 변환하는 것을 오토박싱, 그 반대는 언박싱이라 부른다.
    - 컬렉션(예: ArrayList<Integer>)은 객체만 저장할 수 있으므로, 기본형 값을 추가할 때 자동으로 오토박싱이 일어난다.
    - 반대로 컬렉션에서 객체를 꺼내어 기본형 변수에 담을 때는 자동으로 언박싱이 일어난다.

* 예제 분석
    - ArrayList<Integer> list = new ArrayList<Integer>();: Integer 객체를 요소로 갖는 리스트를 생성한다.
    - list.add(10);: 정수 기본형 10을 추가할 때 오토박싱이 발생하여 내부적으로 new Integer(10) 형태로 변환되어 저장된다.
    - int value = list.get(0);: 리스트에서 객체를 꺼낼 때 언박싱이 발생하여 new Integer(10)이 정수 기본형 10으로 변환되어 반환된다.

// 컬렉션 환경에서의 오토박싱과 언박싱 예시 코드
ArrayList<Integer> list = new ArrayList<Integer>();

// 오토박싱: 10 -> new Integer(10)
list.add(10);   // 원래는 list.add(new Integer(10));

// 언박싱: new Integer(10) -> 10
int value = list.get(0);