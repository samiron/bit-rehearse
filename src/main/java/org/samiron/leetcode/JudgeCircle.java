package org.samiron.leetcode;

public class JudgeCircle {
    static final String[] INPUTS = {
            "UD",
            "LL"
    };

    public static void main(String[] args) {
        JudgeCircle jc = new JudgeCircle();
        for(String input : INPUTS){
            System.out.println(jc.judgeCircle(input) ? "true" : false);
        }
    }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i = 0 ; i < moves.length() ; i ++){  // gives 17ms runtime
            char c = moves.charAt(i);
//        }
//        for(Character c : moves.toCharArray()){   // gives 37ms runtime
            switch (c){
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
            }
//            if(c == 'U'){y++;}  // Gives 20ms runtime
//            else if(c == 'D') {y--;}
//            else if(c == 'R') {x++;}
//            else {x--;}
        }
        return x==0 && y==0;
    }
}
