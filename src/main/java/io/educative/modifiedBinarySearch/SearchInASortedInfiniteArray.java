package io.educative.modifiedBinarySearch;

public class SearchInASortedInfiniteArray {

    private static class ArrayReader {
        int[] elements;

        public ArrayReader(int[] elements) {
            this.elements = elements;
        }

        public int getElementAtIndex(int index) {
            if (index >= elements.length)
                return Integer.MAX_VALUE;
            return elements[index];
        }
    }

    public static int searchInInfiniteSortedArray(ArrayReader arrayReader, int key) {

        // First we need to get a proper bound to search in
        int[] bounds = getTheProperBounds(arrayReader, key);
        // Second We Need To Search ON Element
        return search(arrayReader, bounds[0], bounds[1], key);

    }

    private static int[] getTheProperBounds(ArrayReader arrayReader, int key) {
        int start = 0;
        int end = 1;
        while (key > arrayReader.getElementAtIndex(end)) {
            start = end + 1;
            end *= 2; // increase Exponential
        }
        return new int[]{start, end};
    }

    private static int search(ArrayReader arrayReader, int start, int end, int key) {
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (key == arrayReader.getElementAtIndex(mid))
                return mid;
            else if (key > arrayReader.getElementAtIndex(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader arrayReader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        ArrayReader arrayReader2 = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        ArrayReader arrayReader3 = new ArrayReader(new int[]{1, 3, 8, 10, 15});

        System.out.println(searchInInfiniteSortedArray(arrayReader,16));
        System.out.println(searchInInfiniteSortedArray(arrayReader2,11));
        System.out.println(searchInInfiniteSortedArray(arrayReader3,15));
        System.out.println(searchInInfiniteSortedArray(arrayReader3,200));
    }
}
