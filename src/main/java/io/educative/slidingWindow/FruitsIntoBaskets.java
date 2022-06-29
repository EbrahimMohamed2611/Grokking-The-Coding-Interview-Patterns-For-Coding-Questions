package io.educative.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    private static final int MAX_COUNT = 2;

    /**
     *
     * Time O(N)
     * Space O(maxCount) == O(2)
     *
     * Input: Fruit=['A', 'B', 'C', 'A', 'C']
     * Output: 3
     * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
     *
     */
    private static int maxFruitCountOf2Types(char[] fruit) {
        int maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        int startCount = 0;
        for (int endCount = 0; endCount < fruit.length; endCount++) {
            char currentFruit = fruit[endCount];
            fruitFrequencyMap.put(currentFruit, fruitFrequencyMap.getOrDefault(currentFruit, 0) + 1);
            while (fruitFrequencyMap.size() > MAX_COUNT) {
                char startFruit = fruit[startCount];
                fruitFrequencyMap.put(startFruit, fruitFrequencyMap.get(startFruit) - 1);
                if (fruitFrequencyMap.get(startFruit) == 0)
                    fruitFrequencyMap.remove(startFruit);
                startCount++;
            }
            maxLength = Math.max(maxLength, endCount - startCount + 1);
        }
        return maxLength;
    }

    /**
     * Using BruteForce Approach
     * Time O(N)
     * Space O(K)
     */
    private static int maxFruitCountOf2Types2(char[] fruit) {
        int maxLength = 0;
        int currentMaxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for (int i = 0; i < fruit.length; i++) {
            for (int j = i; j < fruit.length; j++) {
                fruitFrequencyMap.put(fruit[j], fruitFrequencyMap.getOrDefault(fruit[j], 0) + 1);
                if (fruitFrequencyMap.size() == MAX_COUNT)
                    currentMaxLength = (j - i + 1);
                else if (fruitFrequencyMap.size() > MAX_COUNT) {
                    fruitFrequencyMap.clear();
                    break;
                }
            }
            maxLength = Math.max(maxLength, currentMaxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxFruitCountOf2Types(new char[]{'A', 'B', 'C', 'A', 'C'})); //3
        System.out.println(maxFruitCountOf2Types(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})); //5
        System.out.println(maxFruitCountOf2Types2(new char[]{'A', 'B', 'C', 'A', 'C'})); //3
        System.out.println(maxFruitCountOf2Types2(new char[]{'A', 'B', 'C', 'B', 'B', 'C'})); //5
    }
}
