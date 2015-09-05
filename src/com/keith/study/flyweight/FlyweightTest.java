package com.keith.study.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keith on 9/4/15.
 */
public class FlyweightTest {
    public static void main (String args[]) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight = factory.factory('a');
        flyweight.operation("First");

        flyweight = factory.factory('b');
        flyweight.operation("Second");

        flyweight = factory.factory('a');
        flyweight.operation("Third");

        List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('d');
        compositeState.add('e');

        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight compositeFlyweight = flyweightFactory.factory(compositeState);
        compositeFlyweight.operation("Composite Call");
    }
}

interface Flyweight {
    void operation (String state);
}

class ConcreteFlyweight implements Flyweight {
    private Character intrinsicState = null;
    public ConcreteFlyweight (Character state) {
        this.intrinsicState = state;
    }

    @Override
    public void operation(String state) {
        System.out.println("IntrinsicState :" + this.intrinsicState);
        System.out.println("ExternalState :" + state);
    }
}

class ConcreteCompositeFlyweight implements Flyweight {
    private Map<Character, Flyweight> map = new HashMap<Character, Flyweight>();

    //add an element
    public void add(Character key, Flyweight value) {
        map.put(key, value);
    }
    @Override
    public void operation(String state) {
        Flyweight flyweight = null;
        for (Object object : map.keySet()) {
            flyweight = map.get(object);
            flyweight.operation(state);
        }
    }
}

class FlyweightFactory {
    private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

    public Flyweight factory(Character state) {
        Flyweight flyweight = files.get(state);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(state);
            files.put(state, flyweight);
        }
        return flyweight;
    }

    public Flyweight factory(List<Character> compositeState) {
        ConcreteCompositeFlyweight compositeFlyweight = new ConcreteCompositeFlyweight();

        for (Character state : compositeState) {
            compositeFlyweight.add(state, this.factory(state));
        }
        return compositeFlyweight;
    }
}
