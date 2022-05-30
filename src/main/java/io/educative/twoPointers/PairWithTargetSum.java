package io.educative.twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairWithTargetSum {

    /**
     * Time O(N + Log(N) ) ==> O(N)
     * Space O(N)
     * @param numbers
     * @param target
     * @return indices
     */
    private static int[] search4(int[] numbers, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> numberWithIndexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int secondNumber = target - numbers[i];
            if (numberWithIndexMap.containsKey(secondNumber)) {
                indices[0] = i;
                indices[1] = numberWithIndexMap.get(secondNumber);
                break;
            } else {
                numberWithIndexMap.put(numbers[i], i);
            }
        }
        return indices;
    }


    /**
     * Using Two Pointers Approach
     * Time O(N)
     * Space O(1)
     *
     * @param numbers
     * @param target
     * @return indices
     */
    private static int[] search3(int[] numbers, int target) {
        int[] indices = new int[2];
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            if (numbers[left] + numbers[right] == target) {
                indices[0] = left;
                indices[1] = right;
                break;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return indices;
    }


    /**
     * Time O(NLogN) using BinarySearch
     * Space O(1)
     *
     * @param numbers array of numbers
     * @param target
     * @return indices
     */
    private static int[] search2(int[] numbers, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int result = binarySearch(numbers, (target - numbers[i]), i + 1, numbers.length - 1);
            if (result != -1) {
                indices[0] = i;
                indices[1] = result;
                break;
            }
        }
        return indices;
    }

    //Helper Method
    private static int binarySearch(int[] arr, int target, int left, int right) {
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    /**
     * using Two Loops
     * Time O(N^2)
     * Space O(1)
     *
     * @param numbers array of numbers
     * @param target
     * @return indices
     */
    private static int[] search(int[] numbers, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }


    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search(new int[]{2, 5, 9, 11}, 11))); // [0, 2]

        System.out.println(Arrays.toString(search2(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search2(new int[]{2, 5, 9, 11}, 11))); // [0, 2]

        System.out.println(Arrays.toString(search3(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search3(new int[]{2, 5, 9, 11}, 11))); // [0, 2]

        System.out.println(Arrays.toString(search4(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search4(new int[]{2, 5, 9, 11}, 11))); // [0, 2]
//        long end = System.currentTimeMillis();

    }
}
