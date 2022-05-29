package io.educative.patternSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    /**
     * Input: String="araaci", K=2
     * Output: 4
     * Explanation: The longest substring with no more than '2' distinct characters is "araa".
     *
     * @param word
     * @param k
     * @return
     */
    private static int longestSubstringWithKDistinctCharacters(String word, int k) {
        int maxLength = 0;
        int firstPointer = 0;
        int secondPointer = 0;
        Map<Character, Integer> charWithFrequency = new HashMap<>();
        while (secondPointer < word.length()) {
            char currentChar = word.charAt(secondPointer);
            charWithFrequency.put(currentChar, charWithFrequency.getOrDefault(currentChar, 0) + 1);

            while (charWithFrequency.size() > k) {
                char ch = word.charAt(firstPointer);
                int freq = charWithFrequency.get(ch);
                charWithFrequency.put(ch, freq - 1);
                if (charWithFrequency.get(ch) == 0)
                    charWithFrequency.remove(ch);
                firstPointer++;
            }
            maxLength = Math.max(secondPointer - firstPointer + 1, maxLength);
            secondPointer++;
        }
        return maxLength;
    }


    /**
     * Using Bruteforce Approach
     * Time O(n^2)
     * Space O (K)
     *
     * @param word
     * @param k
     * @return
     */
    private static int longestSubstringWithKDistinctCharacters2(String word, int k) {
        int currentMAx = 0;
        int maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                char currentCharacter = word.charAt(j);
                charFrequencyMap.put(currentCharacter, charFrequencyMap.getOrDefault(currentCharacter, 0) + 1);
                if (charFrequencyMap.size() == k)
                    currentMAx = (j - i) + 1;
                else if (charFrequencyMap.size() > k) {
                    charFrequencyMap.clear();
                    break;
                }
            }
            maxLength = Math.max(maxLength, currentMAx);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 2)); // 4
        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 1)); // 2
        System.out.println(longestSubstringWithKDistinctCharacters("cbbebi", 3));// 5
        System.out.println("=====================");
        System.out.println(longestSubstringWithKDistinctCharacters2("araaci", 2)); // 4
        System.out.println(longestSubstringWithKDistinctCharacters2("araaci", 1)); // 2
        System.out.println(longestSubstringWithKDistinctCharacters2("cbbebi", 3));// 5
    }
}
