package io.educative.modifiedBinarySearch;

public class SearchInDuplicateRotatedArray {

    public static int searchInRotatedArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (arr[mid] == k) return mid;
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
            } else {
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
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Searching ......");
        System.out.println(searchInRotatedArray(new int[]{10, 15, 1, 3, 8}, 15)); //1
        System.out.println(searchInRotatedArray(new int[]{4, 5, 7, 9, 10, -1, 2}, 10)); // 4
        System.out.println(searchInRotatedArray(new int[]{4, 5, 7, 9, 10, 11, 12}, 10)); // 4
        System.out.println(searchInRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(searchInRotatedArray(new int[]{3, 7, 3, 3, 3}, 7)); // will Work
        System.out.println(searchInRotatedArray(new int[]{2,4,5,6,7,1,2,4}, 2)); // 4

    }
}
