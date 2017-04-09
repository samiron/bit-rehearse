package com.spaul.patterns.visitor;

/**
 * Created by samir on 4/9/2017.
 */
public abstract class Fruit{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public Fruit(String s) {
        this.name = s;
    }

    public abstract void accept(FruitPartitioner partitioner);
}
