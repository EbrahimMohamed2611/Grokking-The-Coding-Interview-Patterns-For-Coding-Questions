package io.educative.cyclicSort;

public class FindTheDuplicateNumber {


    // When modifying the original array
    public static int findDuplicate(int[] nums) {
        int pointer = 0;
        while (pointer < nums.length) {
            if (pointer + 1 != nums[pointer]) {
                int currentValue = nums[pointer] - 1;
                if (nums[pointer] == nums[currentValue]) // if the current value does not exist in the correct position,
                                                          // and it is equal to the correct value in the correct position so that's mean this value is duplicate
                    return nums[pointer];
                else
                    swap(nums, pointer, currentValue);
            } else
                pointer++;
        }

        return -1;
    }

    private static void swap(int[] nums, int firstPosition, int secondPosition) {
        int temp = nums[firstPosition];
        nums[firstPosition] = nums[secondPosition];
        nums[secondPosition] = temp;
    }


    // Without  modifying the original array using fast slow pointers
    public static int findDuplicate2(int[] nums) {
        int slow =0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }while (slow != fast);

        fast = 0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // note that the pointer stored the actual value
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 4, 4, 3, 2})); // 4
        System.out.println(findDuplicate(new int[]{2, 1, 3, 3, 5, 4})); // 3
        System.out.println(findDuplicate(new int[]{2, 4, 1, 4, 4})); // 4

        System.out.println(findDuplicate2(new int[]{1, 4, 4, 3, 2})); // 4
        System.out.println(findDuplicate2(new int[]{2, 1, 3, 3, 5, 4})); // 3
        System.out.println(findDuplicate2(new int[]{2, 4, 1, 4, 4})); // 4
    }
}
