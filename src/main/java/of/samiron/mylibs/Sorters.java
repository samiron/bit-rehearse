package of.samiron.mylibs;

import java.util.Comparator;

public abstract class Sorters<T extends Comparable> {
    protected T[] items;

    protected Comparator<T> DEFAULT_COMPARATOR = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    };

    public Sorters(T[] items) {
        this.items = items;
    }

    public abstract void sort();
    public void sort(Comparator<T> checker){
        this.sort();
    }

    public void show() {
        for (T i : this.items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    protected void show(int start, int end){
        while(start <= end){
            System.out.print(this.items[start++] + " ");
        }
    }

    protected void swap(int i, int j) {
        T temp = this.items[i];
        this.items[i] = this.items[j];
        this.items[j] = temp;
    }
}
