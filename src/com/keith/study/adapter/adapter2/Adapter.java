package com.keith.study.adapter.adapter2;

/**
 * Created by Keith on 15/7/20.
 */
public class Adapter {
    private Adaptee adaptee;
    public Adapter (Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    public void operation1 () {
        this.adaptee.operation1();
    }
    public void operation2 () {

    }
}
