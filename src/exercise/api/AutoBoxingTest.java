package exercise.api;

import java.util.ArrayList;

// 오토박싱 테스트
public class AutoBoxingTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(); // ArrayList도 원래 객체만 저장가능!!
        list.add(new Integer(100)); // list에는 원래 객체만 추가가능
        list.add(100);  // JDK1.5이전에는 에러였음!!

//        Integer i = list.get(0);    // list에 저장된 첫번째 객체를 꺼낸다.
//        Integer i = list.get(0).intValue();    // intValue()로 Integer를 int로 변환
        // 원래는 「intValue() 나 valueOf()、언박싱」를 써야됨...
        Integer i = list.get(0);    // intValue()로 Integer를 int로 변환
    }
}