package com.keith.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Keith on 8/28/15.
 */
public class DynamicProxy {
    public static void main (String args[]) {
        DynamicProxy dynamicProxy = (DynamicProxy) Proxy.newProxyInstance(
                DynamicCallback.class.getClassLoader(),
                new Class[] {DynamicCallback.class},
                new DynamicHandler(new ConcreteObject())
        );

    }
}

interface DynamicCallback {
    void fun1();
}

class ConcreteObject implements DynamicCallback {

    @Override
    public void fun1() {

    }
}

class DynamicHandler implements InvocationHandler {
    private DynamicCallback proxied;
    public DynamicHandler (DynamicCallback proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
