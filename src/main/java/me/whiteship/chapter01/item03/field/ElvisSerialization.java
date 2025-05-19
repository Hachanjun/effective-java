package me.whiteship.chapter01.item03.field;

import java.io.*;

// 역직렬화로 여러 인스턴스 만들기
// 객체에 대한 정보를 직렬화를 통해서 객체 정보를 저장할 수 있고 역직렬화로 객체 정보를 읽어올 수 있다.
// 역직렬화로 새로운 인스턴스를 생성할 수 있다. 
public class ElvisSerialization {

    public static void main(String[] args) {
    	// 저장하는 코드
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
            out.writeObject(Elvis.INSTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 읽어오는 코드
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
            Elvis elvis3 = (Elvis) in.readObject();
            // 역질렬화 할 때 다른 인스턴스가 생성
            System.out.println(elvis3 == Elvis.INSTANCE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
