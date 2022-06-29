package io.educative.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class AverageOfAllContiguousSubArraysOfSizeK {
    /**
     * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
     * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
     */


    // Brute Force Approach
    private static void findAverageForContiguousSubArraysOfSizeK_1(int[] numbers, int k) {
        for (int i = 0; i <= numbers.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++)
                sum += numbers[j];
            System.out.print(sum / k + "  ");
        }
        System.out.println();
    }

    //Using Sliding window
    private static void findAverageForContiguousSubArraysOfSizeK(int[] numbers, int k) {
        List<Double> averages = new ArrayList<>();
        double sumOfFirstKElement = 0;
        for (int i = 0; i < k; i++)
            sumOfFirstKElement += numbers[i];
        averages.add(sumOfFirstKElement / k);
        // now we can use the overlapping between the current window and next Window
        for (int i = 1; i <= numbers.length - k; i++) {
            sumOfFirstKElement =  sumOfFirstKElement -numbers[i - 1] + numbers[i + k-1];
            averages.add(sumOfFirstKElement / k);
        }
        System.out.println(averages);
    }

    public static void main(String[] args) {
        findAverageForContiguousSubArraysOfSizeK(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
    }
}
