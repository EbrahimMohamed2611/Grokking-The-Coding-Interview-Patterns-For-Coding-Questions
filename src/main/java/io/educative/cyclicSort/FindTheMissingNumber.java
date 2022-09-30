package io.educative.cyclicSort;

public class FindTheMissingNumber {

    /*
     Runtime: 1 ms, faster than 82.67% of Java online submissions for Missing Number.
     Memory Usage: 42.9 MB, less than 96.48% of Java online submissions for Missing Number.
     */
    public static int findMissingNumber(int[] nums) {
        int pointer = 0;
        while (pointer < nums.length) {
            if (nums[pointer] == nums.length || nums[pointer] == pointer) {
                pointer++;
            } else
                swap(nums, pointer, nums[pointer]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }

        return nums.length; // when we don't find any missing number so the next number after the largest number will the missing number
    }

    private static void swap(int[] nums, int firstPosition, int secondPosition) {
        int temp = nums[firstPosition];
        nums[firstPosition] = nums[secondPosition];
        nums[secondPosition] = temp;
    }

    // Another Solution Using XOR Bit Manipulation
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
    Memory Usage: 42.9 MB, less than 94.39% of Java online submissions for Missing Number.
    */
    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor ^ i;
    }


    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4, 0, 3, 1})); // 2
        System.out.println(findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1})); //7
        System.out.println(missingNumber(new int[]{4, 0, 3, 1})); // 2
        System.out.println(missingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1})); //7
    }
}
