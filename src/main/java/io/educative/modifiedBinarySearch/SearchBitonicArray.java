package io.educative.modifiedBinarySearch;

public class SearchBitonicArray {

    public static int search(int[] arr, int k) {

        int maximumElementIndex = findMaximumElementIndex(arr);

        int firstPortionResult = searchOnK(0, maximumElementIndex, arr, k);
        if (firstPortionResult != -1)
            return firstPortionResult;
        return searchOnK(maximumElementIndex + 1, arr.length - 1, arr, k);
    }

    private static int findMaximumElementIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (end > start) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // OR return end
    }

    private static int searchOnK(int start, int end, int[] arr, int k) {
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (arr[mid] == k)
                return mid;
            if (arr[start] < arr[end]) { // array is Increasing
                if (arr[mid] < k) {
                    start = mid + 1;
                } else if (arr[mid] > k) {
                    end = mid - 1;
                }
            } else { // Array is Decreasing
                if (arr[mid] < k) {
                    end = mid - 1;
                } else if (arr[mid] > k) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumElementIndex(new int[]{1, 3, 8, 4, 3})); // 2
        System.out.println(findMaximumElementIndex(new int[]{3, 8, 3, 1})); // 1
        System.out.println(findMaximumElementIndex(new int[]{1, 3, 8, 12})); // 3
        System.out.println(findMaximumElementIndex(new int[]{10, 9, 8})); // 0
        System.out.println("Searching.......");
        System.out.println(search(new int[]{1, 3, 8, 4, 3}, 4)); // 3
        System.out.println(search(new int[]{3, 8, 3, 1}, 8)); // 1
        System.out.println(search(new int[]{1, 3, 8, 12}, 12)); // 3
        System.out.println(search(new int[]{10, 9, 8}, 10)); // 0
    }
}
