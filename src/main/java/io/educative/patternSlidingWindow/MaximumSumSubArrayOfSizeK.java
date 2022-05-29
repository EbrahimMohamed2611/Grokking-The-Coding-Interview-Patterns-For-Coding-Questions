package io.educative.patternSlidingWindow;

public class MaximumSumSubArrayOfSizeK {

    /**
     * using Sliding window ( Fixed Sliding window )
     * Time O(N)
     * Space O(1)
     *
     * @param numbers
     * @param k
     * @return maximum sum sub array of size K
     */
    private static int maximumSumSubArrayOfSizeK(int[] numbers, int k) {
        int sumOfKElements = 0;
        for (int i = 0; i < k; i++)
            sumOfKElements += numbers[i];
        int maxSum = sumOfKElements;

        for (int i = 1; i <= numbers.length - k; i++) {
            sumOfKElements = (sumOfKElements - numbers[i - 1]) + numbers[i + k - 1];
            maxSum = Math.max(maxSum, sumOfKElements);
        }
        System.out.println(maxSum);
        return maxSum;
    }


    /**
     * Using bruteforce approach
     * TimeO(N^2)
     * Space O(1)
     * @param numbers
     * @param k
     * @return
     */
    private static int maximumSumSubArrayOfSizeK_2(int[] numbers, int k) {
        //  0  1  2  3  4  5
        //  2, 1, 5, 1, 3, 2    k = 3
        int currentMaxSum = 0;
        for (int i = 0; i <= numbers.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < k + i; j++)
                currentSum += numbers[j];

            currentMaxSum = Math.max(currentMaxSum, currentSum);
        }
        System.out.println(currentMaxSum);
        return currentMaxSum;
    }

    public static void main(String[] args) {
        maximumSumSubArrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3); // 9
        maximumSumSubArrayOfSizeK(new int[]{2, 3, 4, 1, 5}, 2); //7
        maximumSumSubArrayOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3); // 9
        maximumSumSubArrayOfSizeK(new int[]{2, 3, 4, 1, 5}, 2); // 7
        System.out.println("============");
        maximumSumSubArrayOfSizeK_2(new int[]{2, 1, 5, 1, 3, 2}, 3); // 9
        maximumSumSubArrayOfSizeK_2(new int[]{2, 3, 4, 1, 5}, 2); //7
        maximumSumSubArrayOfSizeK_2(new int[]{2, 1, 5, 1, 3, 2}, 3); // 9
        maximumSumSubArrayOfSizeK_2(new int[]{2, 3, 4, 1, 5}, 2); // 7
    }
}
