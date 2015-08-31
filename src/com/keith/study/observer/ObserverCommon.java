package com.keith.study.observer;

import java.util.*;

/**
 * Created by Keith on 15/8/7.
 */
public class ObserverCommon {
    public static void main (String args[]) {
        CommonSubject subject = new CommonSubject();

        CommonObserver girl = new CommonObserver();
        CommonObserver mother = new CommonObserver();
        girl.setObserveName("Girl");
        mother.setObserveName("Mother");

        subject.addObserver(girl);
        subject.addObserver(mother);
        subject.setContent("Frog");

    }
}

class CommonSubject extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();

        //push
        this.notifyObservers(content);
        //pull
        this.notifyObservers();
    }
}

class CommonObserver implements java.util.Observer {
    private String observeName;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(observeName + arg);
        System.out.println(observeName + ((CommonSubject)o).getContent());
    }

    public String getObserveName() {
        return observeName;
    }

    public void setObserveName(String observeName) {
        this.observeName = observeName;
    }
}
