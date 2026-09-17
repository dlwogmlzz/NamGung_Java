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