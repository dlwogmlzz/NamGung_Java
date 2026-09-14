package ReviewEx;

abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() { System.out.println("멈춥니다."); }
}

interface Fightable { // 인터페이스의 모든 메서드는 예외없이 public abstract.
    void move(int x, int y);        // public abstract가 생략됨
    void attack(Fightable f);       // public abstract가 생략됨
}

class Fighter extends Unit implements Fightable {
    // public 없으면 에러, 오버라이딩 규칙: 조상(public)보다 접근 제어자가 좁으면 안된다!!!!
    @Override
    public void move(int x, int y) { // public을 생략하면 안됨
        System.out.println("[" + x + "," + y + "]로 이동");
    }

    @Override
    public void attack(Fightable f) { // public을 생략하면 안됨
        System.out.println(f + "를 공격");
    }

    Fightable getFightable() {
//        Fighter f = new Fighter();  // Fighter를 생성해서 반환
        Fightable f = (Fightable) new Fighter();  // Fighter를 생성해서 반환, (Fightable) 생략가능!
        return (Fightable) f;   // (Fightable) 생략가능!
    }
}

public class FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        f.move(100, 200);
        f.attack(new Fighter());
        // ╰ = Fighter f2 = new Fighter();   /    f.attack(f2);
        Fightable f2 = f.getFightable();
    }
}
