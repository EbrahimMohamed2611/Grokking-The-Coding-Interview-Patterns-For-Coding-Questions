package io.educative.twoPointers;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    /**
     * Time O(N)
     * Space O(1) in place
     * @param arr
     * @return
     */
    private static int removeDuplicate(int[] arr) {
        int firstPointer = 0;
        for (int secondPointer = 1; secondPointer < arr.length; secondPointer++) {
            if (arr[firstPointer] != arr[secondPointer]) {
                firstPointer++;
                arr[firstPointer] = arr[secondPointer];
            }
        }
        return firstPointer+1;
    }

    /**
     * Time O(N)
     * space O(N)
     * @param arr
     * @return
     */
    private static int removeDuplicate2(int[] arr) {
        Set<Integer> elementsSet = new HashSet<>();
        for (int num:arr) {
            elementsSet.add(num);
        }
        return elementsSet.size();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(removeDuplicate(new int[]{2, 2, 2, 11})); // 2

        System.out.println(removeDuplicate2(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(removeDuplicate2(new int[]{2, 2, 2, 11})); // 2
    }
}
