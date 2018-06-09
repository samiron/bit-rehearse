package org.samiron.leetcode;


public class TwoSum {

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 3, 7, 1, 8};
//        int target = 10;
//        int[] arr = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] arr = new int[]{-3, 4, 3, 90};
//        int target = 0;
        int[] arr = new int[]{-1, -2, -3, -4, -5};
        int target = -8;
        TwoSum ob = new TwoSum();
        int[] result = ob.twoSum(arr, target);
        System.out.printf("[%d, %d]", result[0], result[1]);
    }

    private static final int OFFSET = 500;

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] diffMap = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            if (diffMap[shiftUp(nums[i])] > 0) {
                result[0] = shiftDown(diffMap[shiftUp(nums[i])]);
                result[1] = i;
            } else {
                int diff = target - nums[i];
                diffMap[shiftUp(diff)] = shiftUp(i);

            }
        }
        return result;
    }

    private int shiftUp(int i) {
        return i + OFFSET;
    }

    private int shiftDown(int i) {
        return i - OFFSET;
    }
}
