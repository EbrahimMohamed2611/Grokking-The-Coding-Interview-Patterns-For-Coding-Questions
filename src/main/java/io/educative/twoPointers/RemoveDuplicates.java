package io.educative.twoPointers;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {


    public int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() == 1)
            return 1;
        int insertPosition = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(insertPosition) < a.get(i)) {
                insertPosition++;
                a.set(insertPosition, a.get(i));
            }
        }
        return insertPosition + 1;
    }

    /**
     * Time O(N)
     * Space O(1) in place
     *
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
        return firstPointer + 1;
    }

    /**
     * Time O(N)
     * space O(N)
     *
     * @param arr
     * @return
     */
    private static int removeDuplicate2(int[] arr) {
        Set<Integer> elementsSet = new TreeSet<>();
        for (int num : arr) {
            elementsSet.add(num);
        }
        return elementsSet.size();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(removeDuplicate(new int[]{2, 2, 2, 11})); // 2
        System.out.println(removeDuplicate(new int[]{5000, 5000, 5000})); // 2

        System.out.println(removeDuplicate2(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(removeDuplicate2(new int[]{2, 2, 2, 11})); // 2
    }
}
