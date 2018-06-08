package org.samiron.patterns.visitor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by samir on 4/9/2017.
 */
public abstract class FruitPartitioner {
    public Collection<Apple> apples = new ArrayList<>();
    public Collection<Orange> oranges = new ArrayList<>();
    public Collection<Banana> bananas = new ArrayList<>();


    abstract void visit(Apple a);
    abstract void visit(Orange a);
    abstract void visit(Banana a);

}
