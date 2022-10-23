package io.educative.monotonicStac;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    // bruteForce
    public static int[] nextGreaterElement(int[] arr) {
        int[] nextGreater = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nextGreater[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    nextGreater[i] = arr[j];
                    break;
                }
            }
        }
        return nextGreater;
    }

    // Using Monotonic Stack
    public static int[] nextGreaterElementUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        int rightPointer = length - 1;
        while (rightPointer >= 0) {
            while (!stack.isEmpty() && stack.peek() <= arr[rightPointer]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result[rightPointer] = -1;
            else
                result[rightPointer] = stack.peek();

            stack.push(arr[rightPointer]);
            rightPointer--;
        }
        return result;
    }

    // Using Monotonic Stack
    public static int[] nextGreaterElementUsingStackVariation(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        for (int rightPointer = 2 * length; rightPointer >= 0; rightPointer--) {
            while (!stack.isEmpty() && stack.peek() <= arr[rightPointer % length]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result[rightPointer % length] = -1;
            else
                result[rightPointer % length] = stack.peek();

            stack.push(arr[rightPointer % length]);
            rightPointer--;
        }
        return result;
    }
    // Using Monotonic Stack
    public static int[] nextGreaterElementUsingStackVariationWithIndex(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int[] result = new int[length];
        for (int rightPointer = 2 * length; rightPointer >= 0; rightPointer--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[rightPointer % length]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[rightPointer % length] = -1;
            else
                result[rightPointer % length] =  arr[stack.peek()];

            stack.push(rightPointer % length);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9})));
        System.out.println(Arrays.toString(nextGreaterElementUsingStack(new int[]{3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9})));
        System.out.println(Arrays.toString(nextGreaterElementUsingStack(new int[]{1, 2, 1})));
        System.out.println("======================");
        System.out.println(Arrays.toString(nextGreaterElementUsingStackVariation(new int[]{3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9})));
        System.out.println(Arrays.toString(nextGreaterElementUsingStackVariation(new int[]{3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9})));
        System.out.println(Arrays.toString(nextGreaterElementUsingStackVariation(new int[]{1, 2, 1})));
    }
}
