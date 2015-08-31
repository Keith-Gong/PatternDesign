package com.keith.study.singleton;

/**
 * Created by Keith on 15/7/19.
 * This kind of singleton is the easiest and called lazy man singleton and is not thread safe
 */
public class Singleton1 {
    private Singleton1 instance;
    private Singleton1() {

    }
    public Singleton1 getInstance () {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
