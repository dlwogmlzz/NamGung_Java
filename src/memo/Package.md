# 패키지(package) - 클래스의 묶음

┌──────────────────────────────────────────┐
│ 모듈 (Module) ── (가장 큰 단위)             │
│                                          │
│    패키지 (Package/Folder)    패키지       │
│    ┌──────────────────┐   ┌────────┐     │
│    │ 클래스 (*.class)  │   │ 클래스  │     │
│    └──────────────────┘   └────────┘     │
│    ┌──────────────────┐                  │
│    │ 클래스 (*.class)  │                  │
│    └──────────────────┘                  │
└──────────────────────────────────────────┘

* jar파일(*.jar) - 여러 패키지와 클래스를 묶은것.　rt(runtime을 의미).jar
  ╰java.lang.String에서 java.lang이 패키지, String은 클래스

* 패키지의 선언
  ╰package 패키지 이름;

   package com.codechobo.book; // 안적으면 이름 없는 패키지가 되는데, 적어주는게 좋다.
   
   class PackageTest {
     public static void main(String[] args) {
        System.out.println("Hello World!");
     }
   }


* 클래스 패스(classpath) - 클래스 파일의 위치를 알려줌


PS D:\workspace\Practice_Java\NamGung_Java\src\exercise> javac PackageTest.java
PS D:\workspace\Practice_Java\NamGung_Java\src\exercise> dir

    ディレクトリ: D:\workspace\Practice_Java\NamGung_Java\src\exercise


Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----                                                                                                                                                                             
d-----        2026/08/21     14:07                Super
-a----        2026/08/21     15:25            448 PackageTest.class // .class파일이 생김..                                                                                                                                                                
-a----        2026/08/21     15:24            161 PackageTest.java

PS D:\workspace\Practice_Java\NamGung_Java\src\exercise> javac -d . PackageTest.java
PS D:\workspace\Practice_Java\NamGung_Java\src\exercise> tree   // 트리구조로 보여줌.
フォルダー パスの一覧:  ボリューム ボリューム
ボリューム シリアル番号は 00000042 A671:C6D4 です
D:. // 새롭게 com.codechobo.book 패키지가 생성되고 그안에 PackageTest.class가 생성됨.
├─com
│  └─codechobo
│      └─book
└─Super

PS D:\workspace\Practice_Java\NamGung_Java\src\exercise>
PS D:\workspace\Practice_Java\NamGung_Java\src\exercise> java com.codechobo.book.PackageTest
Hello, World!       // 실행문이 제대로 출력됨.

PS D:\> java com.codechobo.book.PackageTest
エラー: メイン・クラスcom.codechobo.book.PackageTestを検出およびロードできませんでした
原因: java.lang.ClassNotFoundException: com.codechobo.book.PackageTest
PS D:\>     // 여기에서 하면 당연히 안나옴
그래서 환경변수에서 변수이름에 classpath와 경로 등록(.;D:\workspace\Practice_Java\NamGung_Java\src\exercise)을 해야됨.

★터미널에서도 classpath를 지정하는 방법이 있음...
★java -cp 실행할 파일 경로


등록후에 터미널로 상위 폴더로 가서 java D:\workspace\Practice_Java\NamGung_Java\src\exercise를 치면 해당 파일이 실행됨.

* import문
  ╰클래스 이름에서 `패키지 이름(java.lang)을 생략`할 수 있게 해줌.

import문을 작성하는 방법
import 패키지이름.클래스이름;
        or
import 패키지이름.*; // 여기서 *은 패키지를 의미하는것이 아니라 class만을 의미함. 그래서 import java.*;는 안됨.

* 자바파일 작성 순서
①package문
②import문
③클래스 선언


* static import문
  ╰static멤버의 `클래스 이름을 생략`할 수 있게 해줌.

  import static java.lang.Integer.*;       // Integer클래스의 모든 static메서드
  import static java.lang.Math.random;     // Math.random()만. 괄호 안붙임.
  import static java.lang.System.out;      // System.out을 out만으로 참조가능.
