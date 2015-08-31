package com.keith.study.adapter.adapter1;

/**
 * Created by Keith on 15/8/7.
 */
public class AdapterOne {
    public static void main (String args[]) {
        Target target = new Adapter();
        target.request();

       
    }
}
interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {
        System.out.println("Special");
    }
}

class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }
}
