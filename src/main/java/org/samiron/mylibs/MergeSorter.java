package org.samiron.mylibs;

import java.util.Collection;

public class MergeSorter<T> {

    private T[] items;
    public MergeSorter(T[] items){
        this.items = items;
    }

    public void show(){
        for(T i : items){
            System.out.println(i);
        }
    }

    public void sort() {

    }

    /**
     * Another sort function will receive a comparison function which
     * can be used to customize the sorting behavior.
     */
}
