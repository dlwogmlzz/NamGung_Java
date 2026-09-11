package ReviewEx;

abstract class Player { // 2. 추상(abstract) 클래스로 지정해줘야 한다.
    abstract void play(int pos);    // 1. 추상(abstract) 메서드를 가지고 있으면
    abstract void stop();           // 추상 메서드
}

// 추상클래스는 상속을 통해 완성해야 객체 생성 가능
//class AudioPlayer extends Player {
//    void play(int pos) {
//        System.out.println(pos + "위치 부터 play합니다.");
//    }
//    void stop() {
//        System.out.println("재생을 멈춥니다.");
//    }
//
//}

abstract class AudioPlayer extends Player {
    void play(int pos) {
        System.out.println(pos + "위치 부터 play합니다.");
    }
    // 만약 Player에 있는 메서드를 구현 안하면 클래스에 abstract를 붙여줘야함.
}

public class PlayerTest {
    public static void main(String[] args) {
        // Player p = new Player();    // 추상 클래스의 객체를 생성, Error
        // AudioPlayer ap = new AudioPlayer();
//        Player ap = new AudioPlayer(); // 이렇게 다형성으로 객체생성도 가능함.
//        ap.play(100);
//        ap.stop();
    }
}
