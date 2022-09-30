package io.educative.cyclicSort;

import java.util.*;

public class FindAllMissingNumbers {

    /*
    Runtime: 5 ms, faster than 97.68% of Java online submissions for Find All Numbers Disappeared in an Array.
    Memory Usage: 50.4 MB, less than 92.65% of Java online submissions for Find All Numbers Disappeared in an Array.
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int pointer = 0;
        while (pointer < nums.length) {
            int current = nums[pointer] - 1;
            if (nums[pointer] == nums[current]) // we should here compare with values not index to avoid cycle
                pointer++;
            else
                swap(nums, pointer, current);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i])
                missingNumbers.add(i + 1);
        }

        return missingNumbers;
    }


    private static void swap(int[] nums, int firstPosition, int secondPosition) {
        int temp = nums[firstPosition];
        nums[firstPosition] = nums[secondPosition];
        nums[secondPosition] = temp;
    }


    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // 5 6
        System.out.println(findDisappearedNumbers(new int[]{1, 1})); //2
    }
}
