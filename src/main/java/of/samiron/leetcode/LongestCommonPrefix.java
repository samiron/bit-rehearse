package of.samiron.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        var sorted = Arrays.stream(strs).sorted(String::compareTo).toList();

        int i = 0;

        for (; i < sorted.get(0).length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }

        return strs[0].substring(0, i);

    }


    public String longestCommonPrefixVerticalScanning(String[] strs) {

        //TBD
        return "";



    }

    public static void main(String[] args) {
        var inputs = new String[][]{
                {"",""},
                {"a"},
                {"ab", "a"},
                {"flower", "flow", "flight"}
        };

        Stream.of(inputs).forEach(input -> {
//            var result = new LongestCommonPrefix().longestCommonPrefix(input);
            var result = new LongestCommonPrefix().longestCommonPrefixVerticalScanning(input);
            System.out.printf("%s -> %s\n", Arrays.toString(input), result);
        });
    }
}