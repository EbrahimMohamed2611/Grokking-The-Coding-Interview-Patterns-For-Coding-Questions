package io.educative.twoPointers;

import java.util.*;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
 */
public class SquaringSortedArray {
    /**
     * Time O(N)
     * Space (N)
     * @param nums
     * @return
     */
    // -2, -1, 0, 2, 3
    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] squaringArray = new int[length];
        int firstPointer = 0, endPointer = length - 1;
        while (endPointer >= firstPointer) {
            int leftSquared = nums[firstPointer] * nums[firstPointer];
            int rightSquared = nums[endPointer] * nums[endPointer];
            if (leftSquared > rightSquared) {
                squaringArray[--length] = leftSquared;
                firstPointer++;
            } else {
                squaringArray[--length] = rightSquared;
                endPointer--;
            }
        }
        return squaringArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-2, -1, 0, 2, 3}))); // 0, 1, 4, 4, 9
        System.out.println(Arrays.toString(sortedSquares(new int[]{-3, -1, 0, 1, 2}))); // 0 1 1 4 9
    }
}
