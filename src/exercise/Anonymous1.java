package exercise;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Anonymous1 {
    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {    // 클래스의 정의와 객체 생성을 동시에 함.
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}