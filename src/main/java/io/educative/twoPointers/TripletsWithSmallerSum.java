package io.educative.twoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSum {
    /*
    Runtime: 12 ms, faster than 86.26% of Java online submissions for 3Sum Smaller.
    Memory Usage: 41.9 MB, less than 92.40% of Java online submissions for 3Sum Smaller.
    */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int counter = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int currentTarget = (target - nums[i]);
            counter += searchOnTwoSmallerPair(i + 1, size - 1, currentTarget, nums);
        }
        return counter;
    }

    private static int searchOnTwoSmallerPair(int start, int end, int target, int[] nums) {
        int counter = 0;
        while (end > start) {
            if (nums[start] + nums[end] < target) {
                counter += (end - start);
                start++;
            } else {
                end--;
            }
        }
        return counter;
    }

    // To Get All Values
    public static List<List<Integer>> threeSumSmaller2(int[] nums, int target) {
        List<List<Integer>> threeSumSmaller = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            searchOnTwoSmallerPair2(i, target - nums[i], nums, threeSumSmaller);
        }
        return threeSumSmaller;
    }

    private static void searchOnTwoSmallerPair2(int first, int target, int[] nums, List<List<Integer>> threeSumSmaller) {
        int left = first + 1;
        int right = nums.length - 1;
        while (right > left) {
            if (nums[left] + nums[right] < target) {
                // have to take element from left to right but exclusive the right because may be give the equality

                for (int i = right; i > left; i--)
                    threeSumSmaller.add(Arrays.asList(nums[first], nums[i], nums[left]));

                left++;
            } else {
                right--;
            }
        }

    }

    public static void main(String[] args) {
        /*
        [[-1, 3, 0], [-1, 2, 0]]
        [[-1, 4, 1], [-1, 3, 1], [-1, 2, 1], [-1, 3, 2]]
         */
        System.out.println(threeSumSmaller2(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(threeSumSmaller2(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
