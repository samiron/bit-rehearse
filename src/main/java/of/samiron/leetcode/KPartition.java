package of.samiron.leetcode;

import java.util.Arrays;

public class KPartition {

    public static void main(String[] args) {
        KPartition solution = new KPartition();
//        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
//        int partitions = 5;
        int[] nums = new int[]{129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22};
        int partitions = 3;
        System.out.println(solution.canPartitionKSubsets(nums, partitions));
    }

    public boolean canPartitionKSubsets(int[] nums, int partitions) {
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        if (sum % partitions != 0) return false;
        int partitionSum = sum / partitions;
        boolean[] flags = new boolean[nums.length];
        return makePartition(nums, partitions, partitionSum, 0, flags);
    }

    private boolean makePartition(int[] nums, int currentPartition, int targetSum, int currentSum, boolean[] visited) {
        if (currentPartition == 1 && currentSum == targetSum) return true;

        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) //Number already in use
                continue;

            int tmpSum = currentSum + nums[i];
            if (tmpSum > targetSum) //Crossed the target partition sum. Try next one.
                continue;

            if (tmpSum == targetSum) {
                visited[i] = true;
                if (makePartition(nums, currentPartition - 1, targetSum, 0, visited)){
                    found = true;
                    break;
                }
            }

            visited[i] = true;
            if (makePartition(nums, currentPartition, targetSum, tmpSum, visited)) {
                found = true;
                break;
            } else {
                visited[i] = false;
                continue;
            }
        }
        return found;
    }
}
