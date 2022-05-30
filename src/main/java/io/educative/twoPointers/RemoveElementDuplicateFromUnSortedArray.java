package io.educative.twoPointers;

public class RemoveElementDuplicateFromUnSortedArray {

    private static int remove(int[] arr, int k) {
        int firstPointer = 0;
        for (int secondPointer = 0; secondPointer < arr.length; secondPointer++) {
            if(arr[firstPointer] ==k && arr[secondPointer] !=k){
               int temp = arr[secondPointer];
               arr[secondPointer] = arr[firstPointer];
               arr[firstPointer] = temp;
            }
            if(arr[firstPointer] != k)
                firstPointer++;
        }
        return firstPointer;
    }

    public static void main(String[] args) {
        System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3)); // 4
        System.out.println(remove(new int[]{2, 11, 2, 2, 1}, 2)); // 2
    }
}
