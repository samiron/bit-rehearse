package org.samiron.algorithms;

import java.util.Random;

/**
 * Created by samir on 4/12/2017.
 */
public class QuickSortMain {
    private int[] numbers;

    public QuickSortMain init() {
        this.numbers = new int[50];
        Random r = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(100);
        }
        return this;
    }

    public QuickSortMain run() {
        this._sort_numbers(0, this.numbers.length - 1);
        return this;
    }

    private void _sort_numbers(int left, int right) {
        if (left >=right) return;
        int p1 = left;
        int p2 = right;
        int pivot = this.numbers[left];

        /** p1-1 is the pivot element **/
        while((p1 <= p2)){
            while(this.numbers[p1] <= pivot && (p1 < right)){ p1++;}
            while(this.numbers[p2] > pivot && (p2 > left)){ p2--;}
            if(p1 <= p2){
                this._swap(p1, p2);
                p1++;
                p2--;
            }
        }
        this._swap(left, p1-1);

        if(left < p1-1){
            this._sort_numbers(left, p1-2);
        }

        if(right > p1){
            this._sort_numbers(p1, right);
        }
    }

    private void _swap(int p1, int p2) {
        int _tmp  = this.numbers[p1];
        this.numbers[p1] = this.numbers[p2];
        this.numbers[p2] = _tmp;
    }

    public QuickSortMain show() {
        for (int n : this.numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        return this;
    }

    public static void main(String[] args) {
        QuickSortMain main = new QuickSortMain();
        main.init();

        System.out.println("Before sorting:");
        main.show();
        main.run();
        System.out.println("After sorting:");
        main.show();

    }
}
