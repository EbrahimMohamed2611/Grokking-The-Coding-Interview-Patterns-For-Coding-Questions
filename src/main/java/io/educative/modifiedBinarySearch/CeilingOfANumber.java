package io.educative.modifiedBinarySearch;

public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        if (key > array[end])
            return -1;
        if (key < array[start])
            return start;

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
        return start;
    }


    public static void main(String[] args) {
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10},6)); // 1
        System.out.println(searchCeilingOfANumber(new int[]{1, 3, 8, 10, 15},12)); // this is edge case for why return start not end
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10},17));
        System.out.println(searchCeilingOfANumber(new int[]{4, 6, 10},-1));
    }
}
