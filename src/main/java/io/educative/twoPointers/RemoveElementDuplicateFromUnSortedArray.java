package io.educative.twoPointers;

public class RemoveElementDuplicateFromUnSortedArray {

    private static int remove(int[] arr, int k) {
        int firstPointer = 0;
        for (int secondPointer = 0; secondPointer < arr.length; secondPointer++) {
            if (arr[secondPointer] != k) {
                arr[firstPointer++] = arr[secondPointer];
            }
        }
        return firstPointer;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3)); // 4
        System.out.println(remove(new int[]{2, 11, 2, 2, 1}, 2)); // 2
    }
}
