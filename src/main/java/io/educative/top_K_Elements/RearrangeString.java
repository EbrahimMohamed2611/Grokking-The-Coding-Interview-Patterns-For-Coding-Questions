package io.educative.top_K_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/reorganize-string/
public class RearrangeString {

    /*
    Runtime: 5 ms, faster than 63.76% of Java online submissions for Reorganize String.
    Memory Usage: 40.8 MB, less than 88.54% of Java online submissions for Reorganize String.
     */
    public static String reorganizeString(String string) {
        Map<Character, Integer> characterWithCount = new HashMap<>();
        for (char ch : string.toCharArray())
            characterWithCount.put(ch, characterWithCount.getOrDefault(ch, 0) + 1);

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        queue.addAll(characterWithCount.entrySet());

        StringBuilder result = new StringBuilder(string.length());

        while (queue.size() > 1) {
            Map.Entry<Character, Integer> maxRepeated = queue.poll();
            Map.Entry<Character, Integer> secondMaxRepeated = queue.poll();
            result.append(maxRepeated.getKey());
            result.append(secondMaxRepeated.getKey());
            if (maxRepeated.getValue() - 1 > 0) {
                maxRepeated.setValue(maxRepeated.getValue() - 1);
                queue.add(maxRepeated);
            }
            if (secondMaxRepeated.getValue() - 1 > 0) {
                secondMaxRepeated.setValue(secondMaxRepeated.getValue() - 1);
                queue.add(secondMaxRepeated);
            }
        }
        if(!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            if(entry.getValue()>1)
                return "";
            result.append(entry.getKey());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
