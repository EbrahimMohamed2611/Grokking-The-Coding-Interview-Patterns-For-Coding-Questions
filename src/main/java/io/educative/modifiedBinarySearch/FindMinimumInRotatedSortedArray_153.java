package io.educative.modifiedBinarySearch;

public class FindMinimumInRotatedSortedArray_153 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
    Memory Usage: 42.6 MB, less than 39.86% of Java online submissions for Find Minimum in Rotated Sorted Array.
     */
    public static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (end > start) {
            mid = start + (end - start) / 2;
            if (end > mid && arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            if (start < mid && arr[mid] < arr[mid - 1])
                return arr[mid];
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[0];
    }

    public static int findMinimum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (high >= low) {
            mid = (high + low) / 2;
            if (arr[mid] < arr[high])
                high = mid;
            else
                low = mid + 1;
        }

        return arr[high];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2})); // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17})); // 11

        System.out.println(findMinimum(new int[]{3, 4, 5, 1, 2})); // 1  ==> 3
        System.out.println(findMinimum(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0 ==> 4
        System.out.println(findMinimum(new int[]{11, 13, 15, 17})); // 11 == > 0
    }
}
