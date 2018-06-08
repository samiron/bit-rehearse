package org.samiron.drilling;

import org.samiron.mylibs.MergeSorter;

public class Sortings {

    public static void main(String[] args) {
        Integer[] unsortedNumbers = {2, 3, 5, 7, 1, 9, 10, -1, 0, 200};
        MergeSorter<Integer> mSorter = new MergeSorter<>(unsortedNumbers);
        mSorter.sort();
        mSorter.show();
    }
}
