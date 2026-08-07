* 형식화된 출력 - printf()
  - printf의 'f' formatted
  System.out.println("age:%d", age); 
  - %d는 출력형식 지시자로 age변수에 담긴 값을 어떻게 출력할 건지 숫자 10진수로 출력을 하겠다는 것.

  // 지시자와 출력 변수, 값은 개수가 맞아야 된다.
  System.out.println("age:%d year:%d", age, year);
  System.out.println("age:%d year:%d", 14, 2003); 


* 형식화된 출력 - %f 
  System.out.printf("d=%14.10f%n", d);
  - %전체자리.소수점뒷자리f

1 2 3 4 1 2 3 4 5 6 7 8 9 0
공백 1 . 2 3 4 5 6 7 8 9 0 0


* 화면에서 입력받기 - Scanner

// Scanner클래스의 객체를 생성
Scanner scanner = new Scanner(System.in);

// 입력받은 내용을 input에 저장
// nextLine - 입력받은 내용을 한 줄씩 읽고, 입력받아서 그것을 문자로 바꾸는 것.
String input = scanner.nextLine();
// 입력받은 내용을 int타입, 숫자의 값으로 변환
int num = Integer.parseInt(input);

위 두 코드를 한번에
int num = Scanner.nextInt(); // 정수를 입력받아서 변수 num에 저장.

