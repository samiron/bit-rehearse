package of.samiron.leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int i = 0;
        int j = numbers.length - 1;

        while(true) {
            int s = numbers[i] + numbers[j];

            if(s == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }

            if(s < target) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        printOutput(new TwoSum2().twoSum(arr, target));
    }

    private static void printOutput(int[] result) {
        System.out.printf("%d, %d", result[0], result[1]);
    }
}
