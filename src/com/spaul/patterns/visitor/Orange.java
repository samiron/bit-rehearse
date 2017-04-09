package com.spaul.patterns.visitor;

/**
 * Created by samir on 4/9/2017.
 */
public class Orange extends Fruit{
    public Orange(String s) {
        super(s);
    }

    @Override
    public void accept(FruitPartitioner partitioner) {
        partitioner.visit(this);
    }
}
