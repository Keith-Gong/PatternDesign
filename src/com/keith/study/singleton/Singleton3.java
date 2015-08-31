package com.keith.study.singleton;

/**
 * Created by Keith on 15/7/19.
 * The singleton pattern we called hungry singleton and based on the classloader mechanism
 * to avoid multi-thread issues
 */
public class Singleton3 {
    /*
    Method 1
     */

    /*private static Singleton3 instance = new Singleton3();
    private Singleton3 () {

    }
    public static Singleton3 getInstance() {
        return instance;
    }*/

    /*
    Method 2
     */

    private static Singleton3 instance = null;
    static  {
        instance = new Singleton3();
    }
    private Singleton3() {

    }
    public Singleton3 getInstance() {
        return instance;
    }
}
