package com.spaul.algorithms;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by samir on 4/15/2017.
 */
public class StairDenomination {

    private int stairs;
    private ArrayList<Integer> results;

    public static void main(String[] args) {
        StairDenomination main = new StairDenomination();
        while(main.input()){
            main.run();
            main.show();
        }
    }

    private void show() {
        Iterator i = this.results.iterator();
        while(i.hasNext()){
            System.out.print(i.next().toString() + " ");
        }
        System.out.println();
    }

    private boolean run() {
        this.results = new ArrayList<>();
        this._calculateDenomination(this.stairs, 0);
        return true;
    }

    private void _calculateDenomination(int stairsLeft, int level) {
        if(stairsLeft == 0){
            this.show();
        }

        for(int i=1; i<=3; i++){
            if(stairsLeft >= i){
                this.results.add(level, i);
                this._calculateDenomination(stairsLeft-i, level+1);
                this.results.remove(level);
            }
        }
    }

    private boolean input() {
        char[] input = new char[5];
        try {
            System.out.print("Enter number of stairs or -1 to exit: ");
            new InputStreamReader(System.in).read(input);
            this.stairs = Integer.parseInt(new String(input).trim());
        } catch (IOException e) {
            this.stairs = -1;
            e.printStackTrace();
        }
        if(this.stairs == -1)
            return false;
        return true;
    }
}
