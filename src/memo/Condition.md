* 조건연산자(삼항연산자) - ?:


조건식 ? 식1(참일때) : 식2(거짓일때)

* 중첩 if문 - 주의사항

if (num >= 0)
if (num != 0)
sign = '+';
else
sign = '-'

위의 괄호가 없는 조건문에서 else는 가장 가까운 if문과 엮여서 실행됨

위의 코드와 같음.
if (num >= 0) {
if (num != 0) {
sign = '+';
} else {
sign = '-';
}
}

switch문 - 여러 조건 처리에 유리

①조건식을 계산한다.
②조건식의 결과와 일치하는 case문으로 이동한다.
③이후의 문장들을 실행한다.
④break문이나 switch문의 끝을 만나면 switch문 전체를 빠져나간다.

switch문 - 제약조건
1. switch문의 조건식 결과는 정수 값(long타입 제외) 또는 참조형(객체 주소)만 허용
2. case문에는 정수 값, 문자열 리터럴 또는 참조형만 가능(중복 불가)

switch(result) {
case '1':           // OK. 문자 리터럴(49와 동일)
case ONE:           // OK. 정수 상수
case "YES":         // OK. 문자열 리터럴. JDK7부터 허용
case Double d:      // OK. 참조형. JDK14부터 허용
case num:           // 에러. 변수는 불가
case 1.0:           // 에러. 실수도 불가
...


switch식 - 결과 값을 반환, yield JDK14

char grade = switch(score/10) {
case 9, 10 -> 'A'; // 콤마(,)로 여러 case를 합칠 수 있다.
case 8     -> 'B'; // break;가 없어도 다음 case로 넘어가지 않는다.
case 7     -> 'C';
default    -> 'F';
}; 끝에 세미콜론을 붙이는것을 잊지말 것.