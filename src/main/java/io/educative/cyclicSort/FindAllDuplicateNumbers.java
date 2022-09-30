package io.educative.cyclicSort;

import java.util.*;

public class FindAllDuplicateNumbers {
    public List<Integer> findDuplicates(int[] nums) {

        /*
        Runtime: 5 ms, faster than 99.00% of Java online submissions for Find All Duplicates in an Array.
        Memory Usage: 50.4 MB, less than 91.64% of Java online submissions for Find All Duplicates in an Array.
        */
        List<Integer> duplicateNumbers = new ArrayList<>();
        int pointer = 0;
        while(pointer < nums.length){
            int current = nums[pointer]-1;
            if(nums[pointer] == nums[current])
                pointer++;
            else
                swap(nums, pointer, current);
        }

        for(int i=0; i < nums.length;i++)
            if(i+1 != nums[i])
                duplicateNumbers.add(nums[i]);

        return duplicateNumbers;

    }

    private static void swap(int[] nums, int firstPosition, int secondPosition) {
        int temp = nums[firstPosition];
        nums[firstPosition] = nums[secondPosition];
        nums[secondPosition] = temp;
    }
}
