package org.samiron.drilling;

import org.samiron.mylibs.MergeSorter;

public class Sortings {

    public static void main(String[] args) {
        Integer[] unsortedNumbers = {3, 2, 5, 7, 1, 9, 10, -1, 0, 200};
        MergeSorter<Integer> numSorter= new MergeSorter<>(unsortedNumbers);
        numSorter.sort();
        numSorter.show();

        String[] unsortedNames = {"Samiron", "jolly", "Shreyasi", "Srijon"};
        MergeSorter<String> nameSorter = new MergeSorter<>(unsortedNames);
        nameSorter.sort();
        nameSorter.show();

    }
}
