package of.samiron.drilling;

public class Anagram {

    static final int MAP_LENGTH = 26;
    static final String[][] INPUTS = {
        {"abcd", "d dc b a"},
            {"abcd", "d c b a"},
    };

    public static void main(String[] args) {
        Anagram anagramChecker = new Anagram();
        for (String[] pair : INPUTS){
            anagramChecker.check(pair[0], pair[1]);
        }
    }

    private void check(String str1, String str2) {
        int[] countMap1 = makeMap(str1);
        int[] countMap2 = makeMap(str2);
        if (compareMap(countMap1, countMap2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean compareMap(int[] countmap1, int[] countmap2) {
        for (int i = 0; i < MAP_LENGTH; i++) {
            if(countmap1[i] != countmap2[i]){
                return false;
            }
        }
        return true;
    }

    private int[] makeMap(String str1) {
        int[] ar = new int[MAP_LENGTH];
        for (char c : str1.toLowerCase().toCharArray()) {
            if(Character.isAlphabetic(c)){
                ar[c - 97]++;
            }
        }
        return ar;
    }
}


