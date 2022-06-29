package io.educative.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String word) {
        int maxLength = 0;
        Map<Character, Integer> characterWithIndexMap = new HashMap<>();
        int startRange = 0;
        for (int endRange = 0; endRange < word.length(); endRange++) {
            char currentCharacter = word.charAt(endRange);
            if (characterWithIndexMap.containsKey(currentCharacter)) {
                startRange = Math.max(startRange, characterWithIndexMap.get(currentCharacter) + 1);
            }
            maxLength = Math.max(maxLength, endRange - startRange + 1);

            characterWithIndexMap.put(currentCharacter, endRange);
        }
        return maxLength;
    }

    /**
     Runtime: 2 ms, faster than 99.99% of Java online submissions for Longest Substring Without Repeating Characters.
     Memory Usage: 43.4 MB, less than 74.39% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param word
     * @return
     */
    public static int lengthOfLongestSubstringUsingArray(String word) {
        int maxLength = 0;
        int[] characterWithIndex = new int[128];
        int startRange = 0;
        for (int endRange = 0; endRange < word.length(); endRange++) {
            char currentCharacter = word.charAt(endRange);
            startRange = Math.max(startRange, characterWithIndex[currentCharacter]);
            maxLength = Math.max(maxLength, endRange - startRange + 1);
            System.out.println((int)currentCharacter);
            characterWithIndex[currentCharacter] = endRange+1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));// 3
        System.out.println(lengthOfLongestSubstringUsingArray("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringUsingArray("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstringUsingArray("pwwkew"));// 3
    }
}
