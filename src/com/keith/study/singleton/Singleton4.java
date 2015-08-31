package com.keith.study.singleton;

/**
 * Created by Keith on 15/7/19.
 * Also we can use static inner class to implements the singleton
 */
public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4() {

    }
    public Singleton4 getInstance () {
        return SingletonHolder.INSTANCE;
    }

}
