package io.educative.cyclicSort;

import java.util.Arrays;

public class CycleSort {

    public static void sort(int[] arr) {
        int pointer = 0;
        while (pointer < arr.length) {
            int current = arr[pointer];
            if (current == pointer + 1)
                pointer++;
            else {
                swap(arr, pointer, current);
            }
        }
    }

    private static void swap(int[] arr, int pointer, int current) {
        int temp = arr[current - 1];
        arr[current - 1] = arr[pointer];
        arr[pointer] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
