package com.keith.study.singleton;

/**
 * Created by Keith on 15/7/20.
 * Double Check Lock Singleton。 Volatile means read after write
 */
public class Singleton6 {
    private volatile  static Singleton6 instance = null;
    private Singleton6 () {

    }
    public static Singleton6 getInstance () {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
