package io.educative.modifiedBinarySearch;

public class RotationCount {

    public static int countRotations(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int mid;
        while (end > start) {
            mid = start + (end - start) / 2;
            if (end > mid && arr[mid] > arr[mid + 1])
                return mid + 1;
            if (start < mid && arr[mid] < arr[mid - 1])
                return mid;
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(countRotations(new int[]{10, 15, 1, 3, 8})); // 2
        System.out.println(countRotations(new int[]{4, 5, 7, 9, 10, -1, 2})); // 5
        System.out.println(countRotations(new int[]{1, 3, 8, 10})); // 0
    }
}
