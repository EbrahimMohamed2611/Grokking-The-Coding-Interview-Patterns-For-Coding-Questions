package io.educative.slidingWindow;

public class SmallestSubarrayWithAGivenSum {

    private static int smallestSubarrayWithAGivenSum2(int[] arr, int s) {
        int smallestSubArrayLength = Integer.MAX_VALUE;
        int startWindow = 0;
        int endWindow = 0;
        int currentSum = 0;
        while (endWindow < arr.length && currentSum < s)
            currentSum += arr[endWindow++];

        while (endWindow < arr.length) {
            if (currentSum == s) {
                smallestSubArrayLength = Math.min(smallestSubArrayLength, (endWindow - startWindow + 1));
                currentSum += arr[startWindow];
                endWindow++;
            } else if (currentSum > s) {
                while (currentSum > s && endWindow >= startWindow) {
                    currentSum -= arr[startWindow];
                    if (currentSum == s)
                        smallestSubArrayLength = Math.min(smallestSubArrayLength, (endWindow - startWindow + 1));
                    startWindow++;
                }
            } else {
                while (currentSum < s && endWindow < arr.length) {
                    currentSum += arr[endWindow];
                    if (currentSum == s)
                        smallestSubArrayLength = Math.min(smallestSubArrayLength, (endWindow - startWindow + 1));
                    endWindow++;
                }
            }
        }
        return smallestSubArrayLength == Integer.MAX_VALUE ? 0 : smallestSubArrayLength;
    }

    /**
     * Using Flexible sliding window
     * Time O(N)
     * Space O(1) constant
     */
    private static int smallestSubarrayWithAGivenSum(int[] arr, int s) {
        int startWindow = 0;
        int endWindow = 0;
        int numberOfElements = Integer.MAX_VALUE;
        int currentSum = 0;
        while (endWindow < arr.length) {
            currentSum += arr[endWindow];
            while (currentSum >= s) {
                numberOfElements = Math.min(numberOfElements, (endWindow - startWindow + 1));
                currentSum -= arr[startWindow];
                startWindow++;
            }
            endWindow++;
        }
        return (numberOfElements != Integer.MAX_VALUE) ? numberOfElements : 0;
    }


    /**
     * using bruteforce approach
     * Time O(N^2)
     * Space O(1)
     */
    private static int smallestSubarrayWithAGivenSum_2(int[] arr, int s) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum >= s) length = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (sum + arr[j] >= s) {
                    length = Math.min(length, j - i + 1);
                }
                sum += arr[j];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubarrayWithAGivenSum(new int[]{2, 1, 5, 2, 8}, 7)); //1
        System.out.println(smallestSubarrayWithAGivenSum(new int[]{3, 4, 1, 1, 6}, 8)); //3
        System.out.println(smallestSubarrayWithAGivenSum(new int[]{2, 1, 5, 2, 3, 2}, 7)); //2

        System.out.println(smallestSubarrayWithAGivenSum(new int[]{2, 1, 5, 2, 8}, 7)); //1
        System.out.println(smallestSubarrayWithAGivenSum(new int[]{3, 4, 1, 1, 6}, 8)); //3
        System.out.println(smallestSubarrayWithAGivenSum(new int[]{2, 3, 1, 2, 4, 3}, 7)); //3

        System.out.println(smallestSubarrayWithAGivenSum2(new int[]{2, 1, 5, 2, 8}, 7)); //1
        System.out.println(smallestSubarrayWithAGivenSum2(new int[]{3, 4, 1, 1, 6}, 8)); //3
        System.out.println(smallestSubarrayWithAGivenSum2(new int[]{2, 3, 1, 2, 4, 3}, 7)); //3
        System.out.println(smallestSubarrayWithAGivenSum2(new int[]{2, 3, 1, 2, 4, 3}, 7)); //3
    }
}
