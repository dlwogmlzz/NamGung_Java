# 프로그램 오류
 - 컴파일 에러(compile-time error) : 컴파일 할 때 발생하는 에러
 - 런타임 에러(runtime error) : 실행 할 때 발생하는 에러
   ╰에러(error)      - 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
   ╰예외(exception)  - 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류

 - 논리적 에러(logical error) : 작성 의도와 다르게 동작
 - 에러(error)는 어쩔 수 없지만, 예외(exception)는 처리하자

 - 예외처리의 정의와 목적
   ╰정의: 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것.
   ╰목적: 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것.


# Exception과 RuntimeException

 - Exception클래스들: 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
 - RuntimeException클래스들: 프로그래머의 실수로 발생하는 예외

# 예외 처리하기 try-catch문

try {   * catch블럭 내에 포함된 문장이 하나뿐이어도 괄호{}를 생략할 수 없다!! 
    // 예외가 발생할 가능성이 있는 문장들을 넣는다.
} catch (Exception1 e1) {
    // Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
} catch (Exception2 e2) {
    // Exception2이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
} catch (ExceptionN eN) {
    // ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
}


# 예외의 발생과 catch블럭

 - 예외가 발생하면, 이를 처리할 catch블럭을 찾아 내려감
 - 일치하는 catch블럭이 없으면, 예외는 처리 안됨.
 - Exception이 선언된 catch블럭은 모든 예외 처리(마지막 catch블럭)