package io.educative.modifiedBinarySearch;

public class FindMinimumInRotatedSortedArray2_154 {
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
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                if (arr[start] > arr[start + 1])
                    return arr[start + 1];
                start++;
                if (arr[end] < arr[end - 1])
                    return arr[end];
                end--;
            } else {

                if (end > mid && arr[mid] > arr[mid + 1])
                    return arr[mid + 1];
                if (start < mid && arr[mid] < arr[mid - 1])
                    return arr[mid];

                if (arr[mid] > arr[start] || (arr[mid] == arr[start] && arr[mid] < arr[end])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }
        }
        return arr[0];
    }


    public static int findMinimum(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (high > low) {
            mid = (high + low) / 2;
            if (arr[mid] < arr[high])
                high = mid;
            else if (arr[mid] > arr[high])
                low = mid + 1;
            else {
                high--;
                if (arr[low] == arr[mid] && mid > low)
                    low++;
            }
        }

        return arr[high];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5})); // 1
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1})); // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17})); // 11

        System.out.println(findMinimum(new int[]{1, 3, 5})); // 1
        System.out.println(findMinimum(new int[]{2, 2, 2, 0, 1})); // 0
        System.out.println(findMinimum(new int[]{11, 13, 15, 17})); // 11
    }
}
