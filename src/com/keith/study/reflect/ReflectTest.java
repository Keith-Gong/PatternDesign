package com.keith.study.reflect;

import java.lang.reflect.Field;

/**
 * Created by Keith on 15/7/20.
 */
public class ReflectTest {
    public static void main (String args[]) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        //get instance
        Class c = ReflectMode.class;

        //get fields
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Object object = c.newInstance();
        Field f = c.getDeclaredField("param1");
        System.out.println(f.get(object));

        f.setAccessible(true);
        f.set(object, "Test");


        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println(f.get(object));
    }
}
