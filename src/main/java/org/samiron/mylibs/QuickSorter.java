package org.samiron.mylibs;

import java.util.Comparator;

public class QuickSorter<T extends Comparable> extends Sorters<T> {

    public QuickSorter(T[] items) {
        super(items);
    }

    @Override
    public void sort() {
        this.quickSort(0, this.items.length - 1, this.DEFAULT_COMPARATOR);
    }

    @Override
    public void sort(Comparator<T> checker){
        this.quickSort(0, this.items.length - 1, checker);
    }

    private void quickSort(int start, int end, Comparator<T> checker) {

        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        T pivot = this.items[start];

        /**
         * At end of this loop the pivot index should be determined
         * left will just cross the pivot point, so left - 1 will be pivot position
         *
         */
        while (left <= right) {
            while (checker.compare(this.items[left], pivot) <= 0 && left < end) {
                left++;
            }
            while (checker.compare(this.items[left], pivot)  > 0 && right > start) {
                right--;
            }

            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        swap(start, left-1);
        quickSort(start, left - 2, checker);
        quickSort(left, end, checker);
    }
}
