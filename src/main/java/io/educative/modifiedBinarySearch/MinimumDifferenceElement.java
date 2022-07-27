package io.educative.modifiedBinarySearch;

public class MinimumDifferenceElement {

    public static int findMinimumDifferenceElement(int[] elements, int key) {
        if (elements[0] > key)
            return elements[0];
        if (elements[elements.length - 1] < key)
            return elements[elements.length - 1];
        int start = 0;
        int end = elements.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (elements[mid] == key)
                return elements[mid];
            else if (key > elements[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Since we reach here that is mean start == end+1
        if((elements[start] - key) > (key - elements[end]))
            return elements[end];
        return elements[start];
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDifferenceElement(new int[]{4, 6, 10}, 7));
        System.out.println(findMinimumDifferenceElement(new int[]{4, 6, 10}, 4));
        System.out.println(findMinimumDifferenceElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(findMinimumDifferenceElement(new int[]{4, 6, 10}, 17));
    }
}
