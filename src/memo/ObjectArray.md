* 객체 배열 - 참조변수 배열
Tv tv1, tv2, tv3; → Tv[] tvArr = new Tv[3];

tvArr → tvArr[0] tvArr[1] tvArr[2]

// 객체를 생성해서 배열의 각 요소에 저장
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();

★클래스
①설계도
②변수 + 메서드
③사용자 정의 타입(새로운 타입 만들기, 기본형은 8개, 참조형이 무한개라서.)

- 클래스의 또 다른 정의 - 사용자 정의 타입
int hour;       // 시간을 표현하기 위한 변수
int minute;     // 분을 표현하기 위한 변수
float second;   // 초를 표현하기 위한 변수, 1/100초까지 표현하려고 float로 함.

★class를 새롭게 정의한다는 것은 새로운 타입을 만드는 것이다.

- 변수의 종류 - 선언위치에 따라 달라짐


class MyClass {
    // ①클래스 영역
    int iv;             // 인스턴스 변수(개별적)
    static int cv ;     // 클래스 변수(static변수, 공유 변수)

    // ②메서드 영역
    void method() 
    {
        int lv = 0;     // 지역 변수
    }
}

변수의 종류
■선언위치 - 클래스 영역
클래스변수(class variable) - 생성시기: 클래스가 메모리에 올라갈 때, 바로 사용 가능
인스턴스 변수(instance variable) - 생성시기: 인스턴스가 생성될 때, 사용가능

■선언위치 - 클래스 영역 이외의 영역(메서드, 생성자, 초기화 블럭 내부)
지역변수(local variable) - 생성시기: 변수 선언문이 수행될 때 