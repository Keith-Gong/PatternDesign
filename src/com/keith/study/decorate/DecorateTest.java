package com.keith.study.decorate;

/**
 * Created by Keith on 8/28/15.
 */
public class DecorateTest {
    public static void main (String args[]) {
        Component componentA = new ConcreteDecoratorA(new ConcreteComponent());
        componentA.simpleOperation();
    }
}

interface Component {
    void simpleOperation();
}

class ConcreteComponent implements Component {

    @Override
    public void simpleOperation() {

    }
}

class Decorator implements Component {
    private Component component;
    public Decorator (Component component) {
        this.component = component;
    }

    @Override
    public void simpleOperation() {
        component.simpleOperation();
    }
}

class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void simpleOperation() {
        super.simpleOperation();

        //Decorator begin
        System.out.println("I am decorator A");
    }
}

class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void simpleOperation() {
        super.simpleOperation();

        System.out.println("I am decorator B");
    }
}
