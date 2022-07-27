package io.educative.modifiedBinarySearch;

import java.util.Arrays;

public class NumberRange {

    public static int[] findRange(int[] array, int key) {
        int[] range = new int[]{-1, -1};
        int start = 0, end = array.length - 1;

        int startRange = binarySearch(start, end, array, key, true);
        if (startRange == -1)
            return range;
        range[0] = startRange;
        int endRange = binarySearch(startRange, end, array, key, false);
        range[1] = endRange;
        return range;
    }

    private static int binarySearch(int start, int end, int[] array, int key, boolean isFirstIndex) {
        int mid;
        int index = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == key) {
                index = mid;
                if (isFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (key > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRange(new int[]{4, 6, 6, 6, 9}, 6)));
        System.out.println(Arrays.toString(findRange(new int[]{1, 3, 8, 10, 15}, 10)));
        System.out.println(Arrays.toString(findRange(new int[]{1, 3, 8, 10, 15}, 12)));
    }
}
