package io.educative.top_K_Elements;

import java.util.*;

public class Top_K_Numbers {
    // First Approach Using max Heap
    public static List<Integer> find_K_TopElement(int[] nums, int k) {
        List<Integer> top_K_Element = new ArrayList<>(k);
        Queue<Integer> queue = new PriorityQueue<>((number1, number2) -> number2 - number1);
        for (int number : nums)
            queue.add(number);
        while (k-- != 0)
            top_K_Element.add(queue.poll());

        return top_K_Element;
    }

    // Second Approach Using Min Heap
    public static List<Integer> findKTopElement(int[] nums, int k) {
        if(k> nums.length)
            throw new IllegalArgumentException();

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return new ArrayList<>(queue);
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(5);
        queue.add(12);
        queue.add(2);
        queue.add(11);
        while (!queue.isEmpty())
            System.out.println(queue.poll());
        System.out.println("Top K Elements");
        System.out.println(find_K_TopElement(new int[]{3, 1, 5, 12, 2, 11}, 3));
        System.out.println(findKTopElement(new int[]{3, 1, 5, 12, 2, 11}, 3));
    }
}
