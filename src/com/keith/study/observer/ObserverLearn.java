package com.keith.study.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 15/8/6.
 */
public class ObserverLearn {
    public static void main (String args[]) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver();
        subject.add(observer1);
        subject.notifyDataChanged("Fuu");
    }
}

//被观察者,包含N个观察者实例对象
interface Subject {
    void add (Observer observer);
    void remove (Observer observer);
    void notifyDataChanged(String str);
}

class ConcreteSubject implements Subject {

    List<Observer> list = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    //通知所有观察者
    @Override
    public void notifyDataChanged(String str) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(str);
        }
    }
}

interface Observer {
    void update(String str);
}

class ConcreteObserver implements Observer {
    String observerState;

    @Override
    public void update(String str) {
        observerState = str;
        System.out.println(observerState);
    }
}
