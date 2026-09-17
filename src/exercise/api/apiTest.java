package exercise.api;

import java.util.Objects;

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야한다.
    public int hashCode() {
        return Objects.hash(kind, number);  // 매개변수가 가변인자(Object...)라서 호출 시 지정하는 값의 개수가 정해져 있지 않다.
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;

        Card c = (Card)obj;
        return this.kind.equals(c.kind) && this.number == c.number;
    }

    // Object클래스의 toString()을 오버라이딩
    public String toString() {
        return "kind:" + kind + ", number:" + number;
    }
}

public class apiTest {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println(c1.equals(c2));  // equals 결과가 true면

        // 해쉬코드의 결과도 같아야 된다.
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
