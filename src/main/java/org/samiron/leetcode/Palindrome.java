package org.samiron.leetcode;

public class Palindrome {

    private static final String[] INPUTS = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "1 2 abcb a21",
            "1 2 abcb a211",
    };

    public static void main(String[] args) {
        Palindrome pl = new Palindrome();
        for(String input: INPUTS){
            System.out.println(pl.isPalindrome(input) ? "true" : "false");
        }
    }
    public boolean isPalindrome(String input) {
        if(input.isEmpty()){return true;}
        String s = input.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            while(!validChar(s.charAt(i)) && i < j){
                i++;
            }
            while(!validChar(s.charAt(j)) && i < j){
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validChar(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
