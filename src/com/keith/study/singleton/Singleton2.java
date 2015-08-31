package com.keith.study.singleton;

/**
 * Created by Keith on 15/7/19.
 * The singleton pattern is lazy too, but is thread safe
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2() {

    }
    public static synchronized Singleton2 getInstance () {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
