package io.educative.modifiedBinarySearch;

public class SearchInRotatedArray {

    public static int searchInRotatedArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (arr[mid] == k) return mid;

            if (arr[mid] >= arr[start]) {
                if (arr[start] <= k && k <= arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {

                if (arr[mid] <= k && k <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static int searchInSortedRotatedArray(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (arr[mid] == k) return mid;

            if (arr[mid] >= arr[low]) {
                if (arr[low] <= k && k <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (arr[mid] <= k && k <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Searching ......");
        System.out.println(searchInRotatedArray(new int[]{10, 15, 1, 3, 8}, 15)); //1
        System.out.println(searchInRotatedArray(new int[]{4, 5, 7, 9, 10, -1, 2}, 10)); // 4
        System.out.println(searchInRotatedArray(new int[]{4, 5, 7, 9, 10, 11, 12}, 10)); // 4
        System.out.println(searchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(searchInRotatedArray(new int[]{3, 7, 3, 3, 3}, 7)); // will not work properly
        System.out.println("Searching ......");

        System.out.println(searchInSortedRotatedArray(new int[]{10, 15, 1, 3, 8}, 15)); //1
        System.out.println(searchInSortedRotatedArray(new int[]{4, 5, 7, 9, 10, -1, 2}, 10)); // 4
        System.out.println(searchInSortedRotatedArray(new int[]{4, 5, 7, 9, 10, 11, 12}, 10)); // 4
        System.out.println(searchInSortedRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(searchInSortedRotatedArray(new int[]{3, 7, 3, 3, 3}, 7)); // will not work properly

    }
}
