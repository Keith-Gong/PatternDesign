package com.keith.study.proxy;

/**
 * Created by Keith on 8/28/15.
 */
public class SimpleProxy {
    public static void main (String args[]) {
        Callback callback = new ProxyHolder (new RealObject());
    }
}

interface Callback {
    void fun1();
}

class RealObject implements Callback {

    @Override
    public void fun1() {

    }
}

class ProxyHolder implements Callback {
    private Callback proxied;
    public ProxyHolder (Callback proxied) {
        this.proxied = proxied;
    }
    @Override
    public void fun1() {
        proxied.fun1();
    }
}