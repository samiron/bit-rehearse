package org.samiron.patterns.visitor;

/**
 * Created by samir on 4/9/2017.
 */
public class Apple extends Fruit{
    public Apple(String s) {
        super(s);
    }

    @Override
    public void accept(FruitPartitioner partitioner) {
        partitioner.visit(this);
    }
}
