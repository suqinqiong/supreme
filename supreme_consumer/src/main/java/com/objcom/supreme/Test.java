package com.objcom.supreme;

public class Test {
    String a = "abc";

    public void stt(String s){
        s = "123";
    }

    public void achege(String i){
        i = "123";
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.achege(t.a);
        System.out.println(t.a);
    }
}
