package io.educative.modifiedBinarySearch;

public class FlooringOfANumber {

    public static int searchFlooringOfANumber(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        if (key < array[start])
            return -1;

        int mid;
        // do binary search
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (key == array[mid]) return mid;
            else if (key > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end; // OR  return start -1;
    }


    public static void main(String[] args) {
        System.out.println(searchFlooringOfANumber(new int[]{4, 6, 10}, 6)); // 1
        System.out.println(searchFlooringOfANumber(new int[]{1, 3, 8, 10, 15}, 12)); // 3
        System.out.println(searchFlooringOfANumber(new int[]{4, 6, 10}, 17)); // 2
        System.out.println(searchFlooringOfANumber(new int[]{4, 6, 10}, -1)); // -1
    }
}
