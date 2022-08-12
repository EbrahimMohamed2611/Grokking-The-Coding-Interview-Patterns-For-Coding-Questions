package io.educative.subSet;

import java.util.*;

public class SubSet {

    public static List<List<Integer>> findSubSets(int[] numbers) {
        // We will copy every subset and all to all them the new element
        List<List<Integer>> allSubSets = new ArrayList<>();
        allSubSets.add(new ArrayList<>()); // first subSet is an empty subSet
        for (int number : numbers) {
            int currentSubSetsSize = allSubSets.size();
            for (int j = 0; j < currentSubSetsSize; j++) {
                List<Integer> currentSubSets = new ArrayList<>(allSubSets.get(j));
                currentSubSets.add(number); // add the current element in array to all prev subsets
                allSubSets.add(currentSubSets);
            }
        }
        return allSubSets;
    }

    // Using Backtracking
    public static List<List<Integer>> findSubSetsRecursive(int[] numbers) {
        List<List<Integer>> allSubSets = new ArrayList<>();
        findSubSetsRecursive(0, allSubSets, new ArrayList<>(), numbers);
        return allSubSets;
    }

    private static void findSubSetsRecursive(int currentIndex, List<List<Integer>> allSubSets, List<Integer> subSets, int[] numbers) {
        allSubSets.add(new ArrayList<>(subSets));
        for (int i = currentIndex; i < numbers.length; i++) {
            int number = numbers[i];
            subSets.add(number); // peak
            findSubSetsRecursive(i + 1, allSubSets, subSets, numbers);
            subSets.remove(subSets.size() - 1); // not peak it
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubSets(new int[]{1, 5, 3}));
        System.out.println(findSubSetsRecursive(new int[]{1, 5, 3}));
    }
}
