package io.educative.modifiedBinarySearch;

public class BitonicArrayMaximum {

    public static int findMax(int[] arr) {
        int mid;
        int start = 0;
        int end = arr.length - 1;
        while (end > start) { // OR end != start
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1, 3, 8, 12, 4, 2})); // 12
        System.out.println(findMax(new int[]{3, 8, 3, 1})); // 8
        System.out.println(findMax(new int[]{1, 3, 8, 12})); // 12
        System.out.println(findMax(new int[]{10, 9, 8})); // 10
    }
}
