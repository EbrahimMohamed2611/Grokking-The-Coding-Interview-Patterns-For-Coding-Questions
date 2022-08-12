package io.educative.top_K_Elements;

import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestNumber_215 {
    public static int findKthLargest(int[] numbers, int k) {
        Queue<Integer> queue = new PriorityQueue<>((number1, number2) -> number2 - number1);
        for (int number : numbers)
            queue.add(number);
        while (k-- > 1)
            queue.poll();
        return queue.peek();
    }

    public static int findKthLargestUsingSort(int[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[numbers.length -k];
    }
    public static int findKthLargestUsingMinHeap(int[] numbers, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(numbers[i]);

        for (int i = k; i < numbers.length; i++){
            if(numbers[i] > queue.peek()){
                queue.poll();
                queue.add(numbers[i]);
            }
        }
            return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4

        System.out.println(findKthLargestUsingSort(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargestUsingSort(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4

        System.out.println(findKthLargestUsingMinHeap(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargestUsingMinHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4


    }
}
