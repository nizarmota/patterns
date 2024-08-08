package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Singleton {
    private static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }
//    nothing in this code prevents two threads from accessing this piece of code at the same time
//    public static Singleton getInstance(String data) {
//        if (instance == null) {
//            instance = new Singleton(data);
//        }
//        return instance;
//    }

    // wrap our if statement in a synchronized block to prevent two threads from accessing this piece of code at the same time
    // double checked locked agent
    // limiting synchronization to the rare case of constructing a new instance of this field
    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }

}
