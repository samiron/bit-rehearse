package org.samiron.drilling;

import org.samiron.mylibs.MergeSorter;
import org.samiron.mylibs.QuickSorter;
import org.samiron.mylibs.Sorters;

import java.util.Comparator;

public class Sortings {
    private final static Integer[] unsortedNumbers = {3, 2, 5, 7, 1, 9, 10, -1, 0, 200};
    private final static Integer[] descendingNumbers = {300, 200, 155, 77, 61, 59, 40, 31, 20, 12};
    private final static String[] unsortedNames = {"Samiron", "Jolly", "Shreyasi", "Srijon", "Saikat", "Nobonita"};

    private final static Comparator<Integer> digitDescendSorter = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2) * -1;
        }
    };

    public static void main(String[] args) {
        MergeSorter<Integer> mDigitSorter = new MergeSorter<>(unsortedNumbers);
        MergeSorter<String> mNameSorter = new MergeSorter<>(unsortedNames);
        QuickSorter<Integer> qDigitSorter = new QuickSorter<>(descendingNumbers);

        qDigitSorter.sort();
        qDigitSorter.show();

        qDigitSorter.sort(digitDescendSorter);
        qDigitSorter.show();
    }

}
