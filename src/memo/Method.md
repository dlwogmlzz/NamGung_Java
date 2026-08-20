* 메서드란? - 서로 관련된 `여러문장을 괄호 및 하나로` 묶은 것

메서드 - 선언부와 구현부
반환타입(출력, 작업결과) 메서드이름 (타입 변수명, 타입 변수명, ... )   // 선언부(약속이자 계약, 입력)

// 구현부(작업)
{   
    // 메서드 호출시 수행될 코드
}

      3         5  (입력값: 매개변수)
      [입력]     [입력]
      │         │
      ▼         ▼
┌────\ /───────\ /────────┐
│  x[ 3 ]    y[ 5 ]       │
│         add             │
│                         │
│                         │
└─────────────────/ ↓ \───┘
　　　　　　　       [int]
                   출력

1. 반환 타입 - 메서드가 반환하는 값의 타입
int add(int x, int y) {
    int result = x + y;
    return result;  // 호출한 메서드로 결과를 반환
}

int - 반환타입(출력)
add - 메서드 이름
(int x, int y) - 매개변수 선언(입력)


2. 반환 타입 - 메서드가 반환하는 값의 타입

void print99danAll() {  // void는 결과를 반환(return x)하지 않음을 의미
    for (int i=2; i<=9; i++) {
        for (int j=2; i<=9; i++) {
            System.out.print(j+"*"+i+"="+(j*i)+" ");
        }
        System.out.println();
    }
}

3. return문 - 메서드를 종료하고 호출한 곳으로 되돌아감.

// int와 result의 타입이 일치해야 하고, 자동형변환도 가능.

`int` add(int x, int y)
{
    int result = x + y;
    return `result`;  // 작업 결과(반환값)를 반환
}

`void` printGugudan(int dan) {
    for(int i=1; i<=9; i++) {
        System.out.printf("%d * %d = %d%n", dan, i, dan * i);
    }
    `return;` // 반환 타입이 void이므로 생략 가능! 컴파일러가 자동 추가. 
}

`int` multiply(int x, int y) {
    int result = x * y;
    `return result;`    // 반환타입이 void가 아니므로 생략 불가!
}

4. 매개변수는 지역변수 - 해당 메서드 내에서만 유효

int add(int x, int y) { // x, y가 지역변수를 의미 하고, 메서드 내부이기 때문에 유효
    int result = x + y;
    return result;
}

int multiply(int x, int y) {
    int result = x * y;
    return result;
}

5. 메서드 호출(호출은 메서드에게 일을 시킨다는 의미)
메서드 이름(값1, 값2, ...*(값은 작업에 필요한 입력)); // 메서드를 호출하는 방법
print99danAll();        // void print99danAll()을 호출
int result = add(3,5);  // int add(int x, int y)를 호출하고, 결과를 result에 저장

6. return문 - 반환타입이 있을 때(void가 아닐때), 항상 값을 반환해야함.

int max(int a, int b) {
    if(a > b) return a; // 에러. 조건식이 참일 때만 반환하기 때문, 그래서 조건에 상관없이 항상 값을 반환해줘야 함.
}

int max(int a, int b) { // OK. 조건식이 참이건 아니건 값을 반환함. 
    if(a > b) return a;
    else return b;
}

7. 매개변수의 유효성 검사
→ 작업 전에 매개변수로 전달된 값을 반드시 확인 해야함.

float divide(int x, int y) {
    // 작업을 하기 전에 나누는 수(y)가 0인지 확인한다.
    if (y == 0) {
        System.out.println("0으로 나눌 수 없습니다.");
        return 0;   // 매개변수가 유효하지 않으므로 메서드를 종료한다.
    }
    return x / (float)y;
}