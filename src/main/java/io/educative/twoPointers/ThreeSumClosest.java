package io.educative.twoPointers;

import java.util.*;

public class ThreeSumClosest {

    /**
     * Time (nLog(N) + N^2) == N^2
     * Space O(1)
     *
     * Runtime: 8 ms, faster than 81.99% of Java online submissions for 3Sum Closest.
     * Memory Usage: 43 MB, less than 52.59% of Java online submissions for 3Sum Closest.
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int currentCloses = 0;
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length - 1;
            while (right > left) {
                int diff = target - (nums[i] + nums[left] + nums[right]);
                if (diff == 0) {
                    currentCloses = nums[i] + nums[left] + nums[right];
                    return currentCloses;
                } else if (Math.abs(diff) < Math.abs(smallestDiff)) {
                    smallestDiff = diff;
                    currentCloses = nums[i] + nums[left] + nums[right];
                } else if (diff > 0)
                    left++;
                else
                    right--;
            }
        }
        return currentCloses;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-2, 0, 1, 2}, 2)); // 1
        System.out.println(threeSumClosest(new int[]{-3, -1, 1, 2}, 1)); // 0
        System.out.println(threeSumClosest(new int[]{1, 0, 1, 1}, 100)); // 3
    }
}
