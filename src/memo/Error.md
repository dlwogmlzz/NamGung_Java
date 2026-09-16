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


# printStackTrace()와 getMessage()

printStackTrace() : 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.



# 멀티 catch블럭
 - 내용이 같은 catch블럭을 하나로 합친 것(JDK1.7 부터)

try {
    ...
} catch (ExceptionA e) {
    e.printStackTrace();
} catch (ExceptionB e2) {
    e2.printStackTrace();
} 

↓

try {
    ...
} catch (ExceptionA | ExceptionB e) {   // 동일 내용 중복 제거 그외 다른 내용은 제거 안됨, 부모 자식관계 일때는 부모만 쓰면됨. 
    e.printStackTrace();
}


# 예외 발생시키기

 1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
    Exception e = new Exception("고의로 발생시켰음");
    ╰Exception에 예외에 대한 정보가 담겨 있음.

 2. 키워드 throw를 이용해서 예외를 발생시킨다.
    throw e;

 3. 위 1,2 코드를 한번에 할수 있음.
    throw new Exception("고의로 발생시켰음");
    ╰컴파일러가 예외 처리 여부를 체크하고, try-catch문(예외처리)이 필수로 있어야함. 안그러면 `컴파일 에러 발생!!`
    ╰unchecked예외(런타임예외)는 try-catch문이 필요없음
    
    public static void main(String[] args) {
        // throw new Exception("고의로 발생시켰음"); // 컴파일 에러 발생!(`try-catch문이 필수!!`)
        throw new RuntimeException(); // 컴파일 에러 안뜸(try-catch문이 선택). `런타임 에러가 발생!!`
    }

# checked예외, unchecked예외
 - checked예외: 컴파일러가 예외 처리 여부를 체크(예외 처리 필수)
   ╰Exception과 자손들

 - unchecked예외: 컴파일러가 예외 처리 여부를 체크 안함(예외 처리 선택)
   ╰RuntimeException과 자손들


# 메서드에 예외 선언하기
 - 예외를 처리하는 방법: ①try-catch문(직접처리), ②예외 선언하기(예외 떠넘기기, 알리기), ③은폐하기(감추기, 덮기 / 빈 catch블록)
 - 메서드가 호출시 발생가능한 예외를 호출하는 쪽에 알리는 것

* 사용예
void method() throws Exception1, Exception2, ... ExceptionN {  // 메서드 선언시에는 throw`s`
    // 메서드 내용
}

// method()에서 Exception과 그 자손 예외 발생 가능
void method() throws Exception {
    // 메서드 내용
}

★메서드 안의 예외는 예외처리 필수만 적는다(Exception과 그 자손들)



# finally 블럭

 - 예외 발생여부와 관계없이 수행되어야 하는 코드를 넣는다.
 - try블럭 안에 return문이 있어서 try블럭을 벗어나갈 때도 finally블럭이 실행된다.
 - try-catch문의 코드 중복 제거


# 사용자 정의 예외 만들기

 - 우리가 직접 예외 클래스를 정의할 수 있다.
 - 1. 조상은 Exception과 RuntimeException중에서 선택
 - 2. String 매개변수가 있는 생성자(super(매개변수))를 넣어줌.


# 예외 되던지기(Exception re-throwing)

 - 예외를 처리한 후에 다시 예외를 발생시키는 것
 - 호출한 메서드와 호출된 메서드 양쪽 모두에게 예외처리하는 것
