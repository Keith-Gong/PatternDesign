package com.keith.study.adapter.learn;

/**
 * Created by Keith on 15/8/7.
 */
public class AdapterLearn {
    public static void main (String args[]) {
        GBTwoPlug gbTwoPlug = new GBTwoPlug();
        ThreePlug threePlug = new TwoPlugAdapter(gbTwoPlug);
        Laptop laptop = new Laptop(threePlug);
    }
}

//Target
interface ThreePlug {
    void powerWithThree();
}

//Adaptee
class GBTwoPlug {
    void powerWithGBTwo() {
        System.out.println("Use GB Two Plug");
    }
}

//Adapter
// Two -> Three adapter
class TwoPlugAdapter implements ThreePlug {

    private GBTwoPlug gbTwoPlug;
    public TwoPlugAdapter (GBTwoPlug gbTwoPlug) {
        this.gbTwoPlug = gbTwoPlug;
    }
    @Override
    public void powerWithThree() {
        System.out.println("Two -> Three");
        gbTwoPlug.powerWithGBTwo();
    }
}

//Client
class Laptop {
    private ThreePlug threePlug;
    public Laptop (ThreePlug threePlug) {
        this.threePlug = threePlug;
    }
    public void charge () {
        threePlug.powerWithThree();
    }
}
