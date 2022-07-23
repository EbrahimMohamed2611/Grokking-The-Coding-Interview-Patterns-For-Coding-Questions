package io.educative.modifiedBinarySearch;

public class OrderAgnosticBinarySearch {

    // Iterative Way
    public static int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        boolean isAscending = array[start] < array[end];
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target)
                return mid;

            if (isAscending) {
                if (target < array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target > array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }

    // Iterative Way
    public static int searchRec(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        boolean isAscending = array[start] < array[end];
        return  search(start,end,array,target,isAscending);
    }

    private static int search(int start, int end, int[] array, int key, boolean isAscending) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (array[mid] == key)
            return mid;
        if (isAscending) {
            if (key < array[mid])
                return search(start, mid - 1, array, key, isAscending);
            else
                return search(mid + 1, end, array, key, isAscending);
        } else {
            if (key > array[mid])
                return search(start, mid - 1, array, key, isAscending);
            else
                return search(mid + 1, end, array, key, isAscending);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 4, 6, 7}, 3)); // 1
        System.out.println(search(new int[]{1, 3, 4, 6, 7}, 1)); // 0
        System.out.println(search(new int[]{1, 3, 4, 6, 7}, 7)); // 4
        System.out.println(search(new int[]{7, 6, 4, 3, 1}, 3)); // 3
        System.out.println("==========================");
        System.out.println(searchRec(new int[]{1, 3, 4, 6, 7}, 3)); // 1
        System.out.println(searchRec(new int[]{1, 3, 4, 6, 7}, 1)); // 0
        System.out.println(searchRec(new int[]{1, 3, 4, 6, 7}, 7)); // 4
        System.out.println(searchRec(new int[]{7, 6, 4, 3, 1}, 3)); // 3
    }
}
