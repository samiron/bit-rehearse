package of.samiron.leetcode;

import java.util.*;

/**
 * Leetcode: 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */
public class LongestSubstringWithoutRepeatedChar {


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLength = 0;

        for(int i = 0, j = 0 ; j < s.length() ; j++) {
            if(indexMap.containsKey(s.charAt(j))) {
                i = Math.max(i, indexMap.get(s.charAt(j)) + 1);
            }

            maxLength = Math.max(maxLength, j - i + 1);
            indexMap.put(s.charAt(j), j);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() < 1) return 0;

        int maxLength = 1;
        String substr = s.substring(0, 1);

        for(int i = 1 ; i < s.length() ; i ++) {
            int previousIndex = substr.indexOf(s.charAt(i));
            if(previousIndex >= 0) {
                substr = substr.substring(previousIndex + 1);
            }

            substr = substr.concat(String.valueOf(s.charAt(i)));
            maxLength = Math.max(maxLength, substr.length());
        }

        return maxLength;
    }

    public static void main(String[] args) {

        List<String> inputs = Arrays.asList(
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                " ",
                "",
                "abba"
        );

        for(String s : inputs) {
            System.out.printf("%s -> %s\n",
                    s,
                    new LongestSubstringWithoutRepeatedChar().lengthOfLongestSubstring(s));
        }
    }
}
