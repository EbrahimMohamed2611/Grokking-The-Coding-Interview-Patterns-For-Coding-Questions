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


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2})); // [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        System.out.println(threeSum(new int[]{-5, 2, -1, -2, 3})); //[[-2, -1, 3], [-5, 2, 3]]
    }
}
