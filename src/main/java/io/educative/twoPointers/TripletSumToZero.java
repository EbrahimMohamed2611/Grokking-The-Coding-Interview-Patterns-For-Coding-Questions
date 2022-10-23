package io.educative.twoPointers;

import java.util.*;

public class TripletSumToZero {
    public static List<List<Integer>> threeSum(int[] num) {
//        int numberOfResult = 0;
        List<List<Integer>> threeSumList = new ArrayList<>();
        Arrays.sort(num); // to ease avoid duplicate
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue; // to avoid duplicate in first number for all Results
            int target = -(num[i]); // since x + y +z = 0;
            int leftPointer = i + 1, rightPointer = num.length - 1;
            while (leftPointer < rightPointer) {
                if (num[leftPointer] + num[rightPointer] == target) {
                    threeSumList.add(Arrays.asList(num[i], num[leftPointer], num[rightPointer]));
//                    System.out.println("Result num(" + (++numberOfResult) + ")" + num[i] + "," + num[leftPointer] + "," + num[rightPointer]);
                    leftPointer++;
                    rightPointer--;
                    while (leftPointer < rightPointer && num[leftPointer] == num[leftPointer - 1])
                        leftPointer++;
                    while (leftPointer < rightPointer && num[rightPointer] == num[rightPointer + 1])
                        rightPointer--;
                } else if (num[leftPointer] + num[rightPointer] < target)
                    leftPointer++;
                else
                    rightPointer--;

            }
        }
        return threeSumList;
    }

    public static List<List<Integer>> threeSumToZero(int[] nums) {
        // can we have duplicates element so sort the element will give me easy way to avoid a duplicates Three elements
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int current = nums[i];
                int missing = -1 * current;
                findPairWithSum(i + 1, nums, size, missing, triplets, current);
            }


        }
        return triplets;
    }

    private static void findPairWithSum(int index, int[] nums, int length, int missing, List<List<Integer>> triplets, int current) {
        int left = index;
        int right = length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == missing) {
                triplets.add(Arrays.asList(current, nums[left], nums[right]));
                left++;
                right--;
                // we don't need to check two sides we can ignore one of them
                while (left < right && nums[left] == nums[left - 1])
                    left++;// to avoid duplicate elements
//                while (left < right && nums[right] == nums[right + 1])
//                    right--;
            } else if (nums[left] + nums[right] > missing) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2})); // [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(threeSum(new int[]{-5, 2, -1, -2, 3})); //[[-2, -1, 3], [-5, 2, 3]]

        System.out.println(threeSumToZero(new int[]{-3, 0, 1, 2, -1, 1, -2})); // [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(threeSumToZero(new int[]{-5, 2, -1, -2, 3})); //[[-2, -1, 3], [-5, 2, 3]]
    }
}
