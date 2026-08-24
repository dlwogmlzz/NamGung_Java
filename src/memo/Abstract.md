# 추상 클래스(absract class) ⇔ 구체, 상세
  ╰객체 생성x, 미완성 설계도(template), 추상 메서드(미완성, 몸통x({}x), 선언부만)를 가진 클래스

`abstract` class Player { // 추상 클래스
    `abstract` void play(int pos);        // 추상메서드
    `abstract` void stop();               // 추상메서드
}

class AudioPlayer extends Player {
    void play(int pos) { /* 내용생략 */ }   // 추상메서드 구현({}몸통만들기)
    void stop()        { /* 내용생략 */ }   // 추상메서드 구현({}몸통만들기)
}

* 추상 클래스의 작성

※추상(抽象): 낱낱의 구체적 표상(表象)이나 개념에서 공통된 성질을 뽑아 이를 일반적인 개념으로 파악하는 정신 작용.
※추상화: 클래스간의 공통점을 찾아내서 공통의 조상을 만드는 작업.
※구체화: 상속을 통해 클래스를 구현, 확장하는 작업.

* 팩토리 메서드(factory method)
  ╰`객체`를 생성해서 `반환`하는 메서드. 생성자 대신 사용

  Calendar cal = new Calendar();  // 에러. 추상클래스는 인스턴스를 생성할 수 없다.
  Calendar cal = new GregorianCalendar();  // OK. 경우에 따라 변경되어야
