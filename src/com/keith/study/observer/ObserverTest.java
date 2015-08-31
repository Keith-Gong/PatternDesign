package com.keith.study.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 15/8/6.
 */
public class ObserverTest {
    public static void main (String args[]) {
        Watched girl = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("Happy");
    }
}

//抽象观察者角色
interface Watcher {
    public void update (String string);
}

//抽象被观察者
interface Watched {
    public void addWatcher (Watcher watcher);
    public void removeWatcher (Watcher watcher);
    public void notifyWatchers (String string);
}

//具体观察者
class ConcreteWatcher implements Watcher {
    @Override
    public void update(String string) {
        System.out.println(string);
    }
}

class ConcreteWatched implements Watched {

    private List<Watcher> list = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifyWatchers(String string) {
        for (Watcher watcher : list) {
            watcher.update(string);
        }
    }
}
