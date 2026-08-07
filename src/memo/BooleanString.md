* 논리형 - boolean, 논리(y/n, on/off)구현에 사용

boolean power = true; // true 또는 false만 가능.
boolean checked = False; // 에러. 대소문자가 구분되며, 무조건 소문자로. 


* 문자형 - char, 하나의 문자

char ch = 'A'; // OK. 문자 'A'를 char타입의 변수 ch에 저장.
char ch = 65;  // OK. 문자의 코드를 직접 변수 ch에 저장.

* 특수문자 저장하기

char tab = '\t';  // 변수 tab에 탭 문자를 저장.

tap - \t
backspace - \b
form feed - \f
new line - \n
carriage return - \r
역슬래쉬(\) - \\
작은따옴표 - \'
큰따옴표 - \"
유니코드 - \u유니코드(예: char a='\u0041')


* 인코딩과 디코딩(encoding vs decoding)

사람   컴퓨터
'A' -> 65(인코딩)
65 -> 'A'(디코딩)
