# java.lang패키지와 유용한 클래스 - hashCode()

 - 객체의 해시코드(hash code)를 반환하는 메서드
 - Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
 - equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야 한다.
   ╰equals()의 결과가 true인 두 객체의 해시코드는 같아야 하기 때문
 - System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일


# java.lang패키지와 유용한 클래스 - toString(), toString의 오버라이딩

 - toString() : 객체를 문자열(String)으로 변환하기 위한 메서드


# java.lang패키지와 유용한 클래스 - Object클래스

 - 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다.
 - notify(), wait() 등은 쓰레드와 관련된 메서드이다.

# java.lang패키지와 유용한 클래스 - equals(Object obj)

 - 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true 다르면 false
 - Object클래스의 equals() `객체의 주소를 비교`(참조변수 값 비교)

public boolean equals(Object obj) {
    return (this==obj);
}



public static void main(String[] args) {
    Value v1 = new Value(10);
    Value v2 = new Value(10);

    System.out.println(v1.equals(v2));  // false, 주소가 다르기 때문
}



# java.lang패키지와 유용한 클래스 - String클래스 👈 문자열을 다루기 위한 클래스

 - String클래스 = 데이터(char[]) + 메서드(문자열 관련)
 - 내용을 변경할 수 없는 불변(immutable) 클래스


문자열의 비교
String str = "abc";와 String str = new String("abc");의 비교

String str1 = "abc";    // 문자열 리터럴 "abc"의 주소가 str1에 저장됨
String str2 = "abc";    // 문자열 리터럴 "abc"의 주소가 str2에 저장됨
// new를 사용하면 항상 새로운 객체가 만들어짐.
String str3 = new String("abc");    // 새로운 String인스턴스를 생성
String str4 = new String("abc");    // 새로운 String인스턴스를 생성


[자바 문자열 메모리 구조 다이어그램 (정렬 버전)]

1. 리터럴 방식 (str1 == str2 -> true)
   [ str1: 0x100 ] ──────┐
                         ▼
                  [ "abc" (0x100) ]
                         ▲
   [ str2: 0x100 ] ──────┘

str1 == str2 ? true
str1.equals(str2) ? true
╰==는 주소비교!
╰equals는 내용비교!

2. new 연산자 방식 (str3 == str4 -> false)
   [ str3: 0x200 ] ──────▶ [ "abc" (0x200) ]

   [ str4: 0x300 ] ──────▶ [ "abc" (0x300) ]

str3 == str4 ? false
str3.equals(str4) ? true

※문자열 같고 다름을 비교할 때는 대입연산자(==)가 아니라 equals를 쓴다.


[자바 문자열 리터럴과 상수 풀 구조]

* 핵심 개념
    - 문자열 리터럴은 프로그램 실행 시 자동으로 생성되며, 상수 풀(constant pool)에 저장됩니다.
    - 같은 내용의 문자열 리터럴은 상수 풀에 하나만 만들어져 재사용됩니다.
    - 문자열 리터럴(String 객체)은 불변(Immutable) 성격을 가지므로 내용 변경이 불가합니다.

* 메모리 참조 구조 설명
    - s1, s2, s3 변수 모두 동일한 내용인 "AAA"를 리터럴로 생성하므로, 상수 풀 내의 같은 주소(0x100)를 공유합니다.


[자바 문자열 리터럴 메모리 공유 다이어그램]

---------------------------------------
[ s1 ] ──> [ 0x100 ] ──┐
│
[ s2 ] ──> [ 0x100 ] ──┼──> "AAA" 객체 (주소: 0x100)
│    (상수 풀에 1개만 생성되어 공유됨)
[ s3 ] ──> [ 0x100 ] ──┘
---------------------------------------

```java
class Ex9_7 {
public static void main(String[] args) {
        String s1 = "AAA";
        String s2 = "AAA";
        String s3 = "AAA";
        String s4 = "BBB";
    }
}

```


[빈 문자열("", empty string)]
 - 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열

String str = "";    // str을 빈 문자열로 초기화

 - 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능

char[] chArr = new char[0]; // 길이가 0인 char배열
int[] iArr = {};            // 길이가 0인 int배열


[자바 문자(char)와 문자열(String)의 초기화]

* 기본 초기화 방식 (추천)
    - String s = ""; (빈 문자열로 초기화)
    - char c = ' '; (공백으로 초기화)

* 리터럴 방식 vs new 연산자 방식 비교
    - 리터럴 방식: String str1 = ""; (상수 풀을 공유하여 효율적)
    - new 방식: String str4 = new String(""); (힙 영역에 매번 새로운 객체 생성)

```java
// 문자 및 문자열 초기화 코드 예시
String s = "";
char c = ' ';

// 빈 문자열 리터럴 방식
String str1 = "";
String str2 = "";
String str3 = "";

// 빈 문자열 new 연산자 방식
String str4 = new String("");
String str5 = new String("");
String str6 = new String("");
```


# String 클래스의 생성자와 메서드

[자바 주요 String 생성자 및 메서드 정리]

* String(char[] value)
    - 설명: 주어진 문자 배열(value)을 갖는 String 인스턴스를 생성합니다.
    - 예제: char[] c = {'H','e','l','l','o'}; String s = new String(c); -> 결과: s = "Hello"

* String(StringBuffer buf)
    - 설명: StringBuffer 인스턴스가 갖고 있는 문자열과 같은 내용의 String 인스턴스를 생성합니다.

* char charAt(int index)
    - 설명: 지정된 위치(index)에 있는 문자를 알려줍니다. (index는 0부터 시작)
    - 예제: String s = "Hello"; char c = s.charAt(1); -> 결과: c = 'e'

* int compareTo(String str)
    - 설명: 문자열(str)과 사전순서로 비교합니다. 같으면 0, 이전이면 음수를, 이후면 양수를 반환합니다.
    - 예제: "aaa".compareTo("aaa") -> 결과: 0
    - 예제: "aaa".compareTo("bbb") -> 결과: -1
    - 예제: "bbb".compareTo("aaa") -> 결과: 1

```java

// String 생성자 및 메서드 코드 예시
char[] c = {'H', 'e', 'l', 'l', 'o'};
String s1 = new String(c); // s1 = "Hello"

String s2 = "Hello";
char resultChar = s2.charAt(1); // 'e'

int compResult = "aaa".compareTo("bbb"); // -1

```





[자바 주요 String 메서드 정리]

* String concat(String str)
    - 설명: 문자열(str)을 뒤에 덧붙입니다.
    - 예제: String s = "Hello"; String s2 = s.concat(" World"); -> 결과: s2 = "Hello World"

* boolean contains(CharSequence s)
    - 설명: 지정된 문자열(s)이 포함되었는지 검사합니다.
    - 예제: String s = "abcedfg"; boolean b = s.contains("bc"); -> 결과: b = true

* boolean endsWith(String suffix)
    - 설명: 지정된 문자열(suffix)로 끝나는지 검사합니다.
    - 예제: String file = "Hello.txt"; boolean b = file.endsWith("txt"); -> 결과: b = true

* boolean equals(Object obj)
    - 설명: 매개변수로 받은 문자열(obj)과 String 인스턴스의 문자열을 비교합니다. obj가 String이 아니거나 문자열이 다르면 false를 반환합니다.
    - 예제: String s = "Hello"; boolean b = s.equals("Hello"); boolean b2 = s.equals("hello"); -> 결과: b = true, b2 = false

* boolean equalsIgnoreCase(String str)
    - 설명: 문자열과 String 인스턴스의 문자열을 대소문자 구분없이 비교합니다.
    - 예제: String s = "Hello"; boolean b = s.equalsIgnoreCase("HELLO"); boolean b2 = s.equalsIgnoreCase("hello"); -> 결과: b = true, b2 = true

* int indexOf(int ch)
    - 설명: 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다. (index는 0부터 시작)
    - 예제: String s = "Hello"; int idx1 = s.indexOf('o'); int idx2 = s.indexOf('k'); -> 결과: idx1 = 4, idx2 = -1


```java
// String 주요 메서드 코드 예시
String s = "Hello";
String s2 = s.concat(" World");

String file = "Hello.txt";
boolean isTxt = file.endsWith("txt");

int idx = "Hello".indexOf('o');
```



[자바 주요 String 검색 및 길이 메서드 정리]

* int indexOf(int ch, int pos)
    - 설명: 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여 위치(index)를 알려준다. 못 찾으면 -1을 반환한다. (index는 0부터 시작)
    - 예제: String s = "Hello"; int idx1 = s.indexOf('e', 0); int idx2 = s.indexOf('e', 2); -> 결과: idx1 = 1, idx2 = -1

* int indexOf(String str)
    - 설명: 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다. 없으면 -1을 반환한다. (index는 0부터 시작)
    - 예제: String s = "ABCDEFG"; int idx = s.indexOf("CD"); -> 결과: idx = 2

* int lastIndexOf(int ch)
    - 설명: 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.
    - 예제: String s = "java.lang.Object"; int idx1 = s.lastIndexOf('.'); int idx2 = s.indexOf('.'); -> 결과: idx1 = 9, idx2 = 4

* int lastIndexOf(String str)
    - 설명: 지정된 문자열을 인스턴스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다. 못 찾으면 -1을 반환한다.
    - 예제: String s = "java.lang.java"; int idx1 = s.lastIndexOf("java"); int idx2 = s.indexOf("java"); -> 결과: idx1 = 10, idx2 = 0

* int length()
    - 설명: 문자열의 길이를 알려준다.
    - 예제: String s = "Hello"; int length = s.length(); -> 결과: length = 5


```java
// String 검색 및 길이 메서드 코드 예시
String s1 = "Hello";
int idx1 = s1.indexOf('e', 0); // 1
int idx2 = s1.indexOf('e', 2); // -1

String s2 = "java.lang.Object";
int lastIdx = s2.lastIndexOf('.'); // 9

int len = s1.length(); // 5

```



[자바 주요 String split, startsWith, substring 메서드 정리]

* String[] split(String regex)
    - 설명: 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.
    - 예제: String animals = "dog,cat,bear"; String[] arr = animals.split(","); -> 결과: arr[0] = "dog", arr[1] = "cat", arr[2] = "bear"

* String[] split(String regex, int limit)
    - 설명: 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다. 단, 문자열 전체를 지정된 수(limit)로 자른다.
    - 예제: String animals = "dog,cat,bear"; String[] arr = animals.split(",", 2); -> 결과: arr[0] = "dog", arr[1] = "cat,bear"

* boolean startsWith(String prefix)
    - 설명: 주어진 문자열(prefix)로 시작하는지 검사한다.
    - 예제: String s = "java.lang.Object"; boolean b = s.startsWith("java"); boolean b2 = s.startsWith("lang"); -> 결과: b = true, b2 = false

* String substring(int begin) / String substring(int begin, int end)
    - 설명: 주어진 시작위치(begin)부터 끝 위치(end) 범위에 포함된 문자열을 얻는다. 이 때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다. (begin <= x < end)
    - 예제: String s = "java.lang.Object"; String c = s.substring(10); String p = s.substring(5, 9); -> 결과: c = "Object", p = "lang"

```java
// String 분할 및 추출 메서드 코드 예시
String animals = "dog,cat,bear";
String[] arr1 = animals.split(",");
String[] arr2 = animals.split(",", 2);

String s = "java.lang.Object";
boolean starts = s.startsWith("java");
String sub1 = s.substring(10);
String sub2 = s.substring(5, 9);
```



[자바 주요 String 변환 및 valueOf 메서드 정리]

* String toLowerCase()
    - 설명: String인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.
    - 예제: String s = "Hello"; String s1 = s.toLowerCase(); -> 결과: s1 = "hello"

* String toUpperCase()
    - 설명: String인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.
    - 예제: String s = "Hello"; String s1 = s.toUpperCase(); -> 결과: s1 = "HELLO"

* String trim()
    - 설명: 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다. 이 때 문자열 중간에 있는 공백은 제거되지 않는다.
    - 예제: String s = " Hello World "; String s1 = s.trim(); -> 결과: s1="Hello World"

* static String valueOf(종류별 타입 매개변수)
    - 설명: 지정된 값을 문자열로 변환하여 반환한다. 참조변수의 경우, toString()을 호출한 결과를 반환한다.
    - 예제: String b = String.valueOf(true); -> 결과: b = "true"
    - 예제: String i = String.valueOf(100); -> 결과: i = "100"


```java
String s = "Hello";
String lower = s.toLowerCase();
String upper = s.toUpperCase();

String spaced = " Hello World ";
String trimmed = spaced.trim();

String strBool = String.valueOf(true);
String strInt = String.valueOf(100);

```


# join()과 StringJoiner

 - join()은 여러 문자열 사이에 구분자를 넣어서 결합한다.

String animals = "dog,cat,bear";
String[] arr = animals.`split`(",");      // 문자열을 ','를 구분자로 나눠서 배열에 저장
String str = String.`join`("-", arr);     // 배열의 문자열을 '-'로 구분해서 결합
System.out.println(str);                // dog-cat-bear


# 문자열과 기본형 간의 변환

 - 숫자를 문자열로 바꾸는 방법
int i = 100;
String str1 = i + "";               // 100을 "100"으로 변환하는 방법1 
String str2 = String.valueOf(i);    // 100을 "100"으로 변환하는 방법2 


- 문자열을 숫자로 바꾸는 방법
  int i      = Integer.parseInt("100");  // "100"을 100으로 변환하는 방법1
  int i2     = Integer.valueOf("100");   // "100"을 100으로 변환하는 방법1
  Integer i2 = Integer.valueOf("100");   // 원래는 반환 타입이 Integer


[자바 기본형과 문자열 간 변환 메서드 정리]

* 기본형 -> 문자열 변환
    - String.valueOf(boolean b): boolean 값을 문자열로 변환
    - String.valueOf(char c): char 값을 문자열로 변환
    - String.valueOf(int i): int 값을 문자열로 변환 (byte, short을 문자열로 변경할 때도 이 메서드를 사용하면 된다)
    - String.valueOf(long l): long 값을 문자열로 변환
    - String.valueOf(float f): float 값을 문자열로 변환
    - String.valueOf(double d): double 값을 문자열로 변환

* 문자열 -> 기본형 변환 (파싱 메서드)
    - boolean Boolean.parseBoolean(String s): 문자열을 boolean 기본형으로 변환
    - byte Byte.parseByte(String s): 문자열을 byte 기본형으로 변환
    - short Short.parseShort(String s): 문자열을 short 기본형으로 변환
    - int Integer.parseInt(String s): 문자열을 int 기본형으로 변환
    - long Long.parseLong(String s): 문자열을 long 기본형으로 변환
    - float Float.parseFloat(String s): 문자열을 float 기본형으로 변환
    - double Double.parseDouble(String s): 문자열을 double 기본형으로 변환

```java
// 기본형과 문자열 변환 코드 예시
String strVal = String.valueOf(100);
int intVal = Integer.parseInt("100");

boolean boolVal = Boolean.parseBoolean("true");
double doubleVal = Double.parseDouble("10.5");
```


# StringBuffer 클래스
 - String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.

```java
public final class StringBuffer implements  java.io.Serializable {
    private char[] value;
    ...
}
```

 - 그러나, String과 달리 내용을 변경할 수 있다. (mutable)
   // StringBuffer 객체 생성 예시

   [자바 StringBuffer 메모리 구조 다이어그램]
   StringBuffer sb = new StringBuffer("abc");
    ---------------------------------------
    sb[ 0x100 ] ──> [ a ][ b ][ c ][   ][   ][   ]...
    (내부 버퍼 배열, 주소: 0x100)
    ---------------------------------------



[자바 StringBuffer append 메서드 메모리 구조 정리]

* 핵심 개념
    - sb.append("123"); 코드는 기존 StringBuffer 객체의 내용 뒤에 새로운 문자열 "123"을 추가한다.
    - 새로운 객체를 생성하지 않고 기존 메모리 공간(0x100) 내부의 버퍼 배열에 값을 이어 붙이므로 효율적이다.

    // StringBuffer append 코드 예시
    StringBuffer sb = new StringBuffer("abc");
    sb.append("`123`"); // sb의 내용 뒤에 "123"을 추가한다.(내용 변경 가능)

* 메모리 구조 다이어그램
    ---------------------------------------
    [ sb ] ──> [ 0x100 ] ──> [ a ][ b ][ c ]`[ 1 ][ 2 ][ 3 ]`[   ][   ]...
    (내부 버퍼 배열, 주소: 0x100)
    ---------------------------------------



# StringBuffer의 생성자
 - 배열은 길이 변경불가. 공간이 부족하면 새로운 배열 생성해야...


[자바 배열 확장(System.arraycopy 등)을 위한 메모리 구조 다이어그램]

* 핵심 개념
    - 기존 배열(arr)은 공간이 부족할 때 더 큰 새로운 배열(tmp)을 생성하여 데이터를 복사해야 합니다.
    - arr 배열은 주소 0x100에 크기 5로 존재하며 값 [1, 2, 3, 4, 5]를 담고 있습니다.
    - tmp 배열은 주소 0x200에 더 큰 크기(10)로 새로 생성되어 초기값 0들로 채워져 있습니다.

* 메모리 구조 다이어그램
-------------------------------------------------------------------------
arr[ 0x100 ] ──> [ 1 ][ 2 ][ 3 ][ 4 ][ 5 ]
(주소: 0x100, 크기: 5)

tmp[ 0x200 ] ──> [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]
(주소: 0x200, 크기: 10)
-------------------------------------------------------------------------


 - StringBuffer는 저장할 문자열의 길이를 고려해서 적절한 크기로 생성해야...

[자바 StringBuffer 생성자 및 버퍼 크기 초기화 정리]

```java
// StringBuffer 생성자 내부 구현 예시 코드
public StringBuffer(int length) {
value = new char[length];
shared = false;
}

public StringBuffer() {
this(16); // 버퍼의 크기를 지정하지 않으면 버퍼의 크기는 16이 된다.
}

public StringBuffer(String str) {
this(str.length() + 16); // 지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성한다.
append(str);
}
```

* public StringBuffer(int length)
    - 설명: 지정된 크기(length)만큼의 문자 배열(char[]) 버퍼를 생성한다.
    - 코드 동작: value = new char[length]; shared = false;로 초기화한다.

* public StringBuffer()
    - 설명: 버퍼의 크기를 지정하지 않으면 기본값으로 16 크기의 버퍼를 생성한다.
    - 코드 동작: this(16);을 호출하여 크기 16짜리 버퍼를 생성한다.

* public StringBuffer(String str)
    - 설명: 지정한 문자열(str)의 길이보다 16이 더 크게 버퍼를 생성하고 문자열을 추가한다.
    - 코드 동작: this(str.length() + 16);을 호출한 뒤 append(str);을 수행한다.


# StringBuffer의 변경
 - StringBuffer는 String과 달리 내용 변경이 가능하다.
 - append()는 지정된 내용을 StringBuffer에 추가 후, StringBuffer의 참조를 반환

[자바 StringBuffer append 메서드의 참조 반환과 메서드 체이닝 정리]

```java
// StringBuffer append 참조 반환 및 메서드 체이닝 예시 코드
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = sb.append("ZZ"); // sb의 내용 뒤에 "ZZ"를 추가한다.

System.out.println(sb);  // abc123ZZ
System.out.println(sb2); // abc123ZZ


// 메서드 체이닝 활용 예시
StringBuffer sb = new StringBuffer("abc");
sb.append("123").append("ZZ");
```

* 핵심 개념
    - append() 메서드는 지정된 내용을 StringBuffer에 추가한 후, 자기 자신의 참조를 반환한다.
    - 따라서 sb.append("ZZ")를 실행하면 sb의 내용 뒤에 "ZZ"가 추가될 뿐만 아니라, sb 객체의 참조 자체가 반환되어 새로운 변수(sb2)에 대입할 수 있다.
    - 반환된 참조를 이용해 메서드를 연속해서 호출하는 방식인 메서드 체이닝(Method Chaining)이 가능하다.


# StringBuffer의 비교


[자바 StringBuffer의 비교 메서드 및 주의사항 정리]

* 핵심 개념
    - StringBuffer는 equals() 메서드가 오버라이딩되어 있지 않다. (Object 클래스의 equals를 그대로 사용하여 주소 비교를 수행함)
    - 따라서 내용이 같은 두 StringBuffer 객체를 비교할 때 == 연산자와 equals() 모두 false를 반환한다.
    - 내용을 비교하려면 toString()을 통해 String으로 변환한 후에 equals()를 사용해야 한다.


```java
// StringBuffer 비교 코드 예시
StringBuffer sb = new StringBuffer("abc");
StringBuffer sb2 = new StringBuffer("abc");

System.out.println(sb == sb2);      // false (주소 비교)
System.out.println(sb.equals(sb2)); // false (오버라이딩되지 않아 주소 비교 수행)

// StringBuffer를 String으로 변환하여 내용 비교
String s = sb.toString();
String s2 = sb2.toString();

System.out.println(s.equals(s2));   // true (문자열 내용 비교)

```


# StringBuffer의 생성자와 메서드

[자바 StringBuffer 생성자 및 append 메서드 다양성 정리]

* StringBuffer()
    - 설명: 16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
    - 예제: StringBuffer sb = new StringBuffer(); -> 결과: sb = "" (크기 16의 기본 버퍼 생성)

* StringBuffer(int length)
    - 설명: 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.
    - 예제: StringBuffer sb = new StringBuffer(10); -> 결과: sb = "" (크기 10의 지정 버퍼 생성)

* StringBuffer(String str)
    - 설명: 지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.
    - 예제: StringBuffer sb = new StringBuffer("Hi"); -> 결과: sb = "Hi" (문자열 길이 + 16 크기의 버퍼 생성)

* StringBuffer append(다양한 타입 매개변수)
    - 설명: 매개변수로 입력된 값을 문자열로 변환하여 StringBuffer 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙인다. 
    (boolean, char, char 배열, double, float, int, long, Object, String 타입 지원)
    - 예제: 다양한 형태의 데이터를 연속해서 추가하는 메서드 체이닝을 사용할 수 있다.

```java
// StringBuffer 생성자 및 append 메서드 활용 코드 예시
StringBuffer sb1 = new StringBuffer();
StringBuffer sb2 = new StringBuffer(10);
StringBuffer sb3 = new StringBuffer("Hi");

StringBuffer sbBase = new StringBuffer("abc");
StringBuffer sbChained = sbBase.append(true).append(10.0f);
sbBase.append('d').append(10.0f);

StringBuffer sbFinal = new StringBuffer("abc");
sbFinal.append("ABC").append(123);
```


[자바 StringBuffer capacity, charAt, delete 메서드 정리]

* int capacity()
    - 설명: StringBuffer 인스턴스의 버퍼 크기를 알려준다. length()는 버퍼에 담긴 문자열의 길이를 알려준다.
    - 예제: StringBuffer sb = new StringBuffer(100); 
    sb.append("abcd"); int bufferSize = sb.capacity(); int stringSize = sb.length(); -> 결과: bufferSize = 100, stringSize = 4 (sb에 담긴 문자열이 "abcd"이므로)

* char charAt(int index)
    - 설명: 지정된 위치(index)에 있는 문자를 반환한다.
    - 예제: StringBuffer sb = new StringBuffer("abc"); char c = sb.charAt(2); -> 결과: c = 'c'

* StringBuffer delete(int start, int end)
    - 설명: 시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다. 단, 끝 위치의 문자는 제외.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); StringBuffer sb2 = sb.delete(3, 6); -> 결과: sb = "0126", sb2 = "0126"

* StringBuffer deleteCharAt(int index)
    - 설명: 지정된 위치(index)의 문자를 제거한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.deleteCharAt(3); -> 결과: sb = "012456"

```java
// StringBuffer 주요 메서드 코드 예시
StringBuffer sb1 = new StringBuffer(100);
sb1.append("abcd");
int bufSize = sb1.capacity(); // 100
int strSize = sb1.length();   // 4

StringBuffer sb2 = new StringBuffer("0123456");
StringBuffer sb3 = sb2.delete(3, 6); // "0126"

StringBuffer sb4 = new StringBuffer("0123456");
sb4.deleteCharAt(3); // "012456"
```

[자바 StringBuffer insert, length, replace, reverse 메서드 정리]

* StringBuffer insert(int pos, 타입 변수)
    - 설명: 두 번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가한다. pos는 0부터 시작한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.insert(4, '.'); -> 결과: sb = "0123.456"

* int length()
    - 설명: StringBuffer 인스턴스에 저장되어 있는 문자열의 길이를 반환한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); int length = sb.length(); -> 결과: length = 7

* StringBuffer replace(int start, int end, String str)
    - 설명: 지정된 범위(start~end)의 문자들을 주어진 문자열로 바꾼다. end 위치의 문자는 범위에 포함되지 않는다 (start <= x < end).
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.replace(3, 6, "AB"); -> 결과: sb = "012AB6" ("345"가 "AB"로 바뀜)

* StringBuffer reverse()
    - 설명: StringBuffer 인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.reverse(); -> 결과: sb = "6543210"


```java
// StringBuffer 삽입, 대체, 반전 메서드 코드 예시
StringBuffer sb1 = new StringBuffer("0123456");
sb1.insert(4, '.');

StringBuffer sb2 = new StringBuffer("0123456");
int len = sb2.length();

StringBuffer sb3 = new StringBuffer("0123456");
sb3.replace(3, 6, "AB");

StringBuffer sb4 = new StringBuffer("0123456");
sb4.reverse();

```




[자바 StringBuffer setCharAt, setLength, toString, substring 메서드 정리]

* void setCharAt(int index, char ch)
    - 설명: 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.setCharAt(5, 'o'); -> 결과: sb = "01234o6"

* void setLength(int newLength)
    - 설명: 지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우에는 나머지 빈 공간을 널문자 '\u0000'로 채운다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); sb.setLength(5); -> 결과: sb = "01234"
    - 예제: StringBuffer sb2 = new StringBuffer("0123456"); sb2.setLength(10); String str = sb2.toString().trim(); -> 결과: sb2 = "0123456    ", str = "0123456"

* String toString()
    - 설명: StringBuffer 인스턴스의 문자열을 String으로 변환한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); String str = sb.toString(); -> 결과: str = "0123456"

* String substring(int start) / String substring(int start, int end)
    - 설명: 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다. 시작위치(start)만 지정하면 시작위치부터 문자열 끝까지 뽑아서 반환한다.
    - 예제: StringBuffer sb = new StringBuffer("0123456"); String str = sb.substring(3); String str2 = sb.substring(3, 5); -> 결과: str = "3456", str2 = "34"


```java
// StringBuffer 변경 및 변환 메서드 코드 예시
StringBuffer sb1 = new StringBuffer("0123456");
sb1.setCharAt(5, 'o');

StringBuffer sb2 = new StringBuffer("0123456");
sb2.setLength(5);

StringBuffer sb3 = new StringBuffer("0123456");
String convertedStr = sb3.toString();

StringBuffer sb4 = new StringBuffer("0123456");
String subStr = sb4.substring(3);
String subStr2 = sb4.substring(3, 5);

```


