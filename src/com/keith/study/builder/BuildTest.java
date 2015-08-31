package com.keith.study.builder;

public class BuildTest {
    public static void main (String args[]) {

    }
}

class Character {
    private String name;
    private int age;
    private float height;
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}

interface IBuilder {
    void setName(String name);
    void setAge (int age);
    void setHeight (float height);
    void setWeight (float weight);
    Character getCharacter();
}

class Builder implements IBuilder {
    Character character = new Character();

    @Override
    public void setName(String name) {
        character.setName(name);
    }

    @Override
    public void setAge(int age) {
        character.setAge(age);
    }

    @Override
    public void setHeight(float height) {
        character.setHeight(height);
    }

    @Override
    public void setWeight(float weight) {
        character.setWeight(weight);
    }

    @Override
    public Character getCharacter() {
        return character;
    }
}

class Director {

}