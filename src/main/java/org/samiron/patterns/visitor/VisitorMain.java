package org.samiron.patterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorMain {

    public static void main(String[] args) {

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Orange("Orange 1"));
        fruitList.add(new Apple("Apple 1"));
        fruitList.add(new Apple("Apple 2"));
        fruitList.add(new Banana("Banana 1"));

        FruitPartitioner fruitPartitioner = new FruitTypePartitioner();
        Iterator<Fruit> i = fruitList.iterator();
        while(i.hasNext()){
            i.next().accept(fruitPartitioner);
        }

        System.out.println("Oranges: " + fruitPartitioner.oranges.size());
        System.out.println("Apples: "  + fruitPartitioner.apples.size());
        System.out.println("Bananas: " + fruitPartitioner.bananas.size());
    }
}

