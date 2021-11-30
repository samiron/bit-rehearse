package of.samiron.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayIntersection {
    public static void main(String[] args) {
        ArrayIntersection runner = new ArrayIntersection();
        int[] nums1 = {1, 2, 2, 1, 0};
        int[] nums2 = {0, 2, 2, 3};
        int[] result = runner.intersection(nums1, nums2);
        for (int r : result) {
            System.out.print(r);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<>();
        Arrays.sort(nums1);

        for (int candidate : nums2) {
            if (Arrays.binarySearch(nums1, candidate) >= 0) {
                result.add(candidate);
            }
        }

        int[] intersection = new int[result.size()];
        Iterator<Integer> it = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = it.next();
        }
        return intersection;

//        return result.stream().mapToInt(Number::intValue).toArray();
    }

//    public int[] intersection2(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 = makeSet(nums1);
//        HashSet<Integer> set2 = makeSet(nums2);
//        set1.retainAll(set2);
//        set1.toArray();
//    }
//
//    private HashSet<Integer> makeSet(int[] nums1) {
//        HashSet<Integer> set = new HashSet<>();
//        for(int n : nums1){
//            set.add(n);
//        }
//        return set;
//    }
}
