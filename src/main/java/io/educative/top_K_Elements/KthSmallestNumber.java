package io.educative.top_K_Elements;

import java.util.*;

public class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] numbers, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int number : numbers)
            queue.add(number);
        while (k-- > 1)
            queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5},3)); // 5
        System.out.println(findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5},4)); // 5
        System.out.println(findKthSmallestNumber(new int[]{5, 12, 11, -1, 12},3)); // 11
    }
}
