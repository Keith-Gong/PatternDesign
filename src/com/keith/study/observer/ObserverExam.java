package com.keith.study.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 15/8/6.
 */
public class ObserverExam {
    public static void main (String args[]) {
        WeatherSubject weatherBroadcast = new WeatherSubject();

        IWeatherObserver person1 = new WeatherObserver("Mike", "Wash Car");
        IWeatherObserver person2 = new WeatherObserver("Rose", "Go shopping");
        weatherBroadcast.addObserver(person1);
        weatherBroadcast.addObserver(person2);
        weatherBroadcast.setWeatherState("Rain");
    }
}

interface IWeatherSubject {
    void addObserver (IWeatherObserver observer);
    void removeObserver (IWeatherObserver observer);
    void notifyDataStateChanged (String msg);
}

class WeatherSubject implements IWeatherSubject {

    private String weatherState;

    private List<IWeatherObserver> list = new ArrayList<>();
    @Override
    public void addObserver(IWeatherObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(IWeatherObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifyDataStateChanged(String msg) {
        for (IWeatherObserver observer : list) {
            observer.update(msg);
        }
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
        this.notifyDataStateChanged(this.weatherState);
    }
}

interface IWeatherObserver {
    void update (String msg);
}

class WeatherObserver implements IWeatherObserver {
    private String observerName;
    private String weatherContent;
    private String remindMsg;

    public WeatherObserver (String name, String msg) {
        this.setObserverName(name);
        this.setRemindMsg(msg);
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindMsg() {
        return remindMsg;
    }

    public void setRemindMsg(String remindMsg) {
        this.remindMsg = remindMsg;
    }

    @Override
    public void update(String msg) {
        this.setWeatherContent(msg);
        System.out.println(getObserverName() + " " + getWeatherContent() + " " + getRemindMsg());
    }
}
