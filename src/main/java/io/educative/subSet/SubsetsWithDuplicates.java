package io.educative.subSet;

import java.util.*;

public class SubsetsWithDuplicates {

    public static List<List<Integer>> findSubSetWithDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allSubSet = new ArrayList<>();
        allSubSet.add(new ArrayList<>()); // first we add Empty SubSet
        int startIndex, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                startIndex = endIndex + 1;
            endIndex = allSubSet.size()-1;
            for (int j = startIndex; j <=
                    endIndex; j++) {
                List<Integer> newSubSet = new ArrayList<>(allSubSet.get(j));
                newSubSet.add(nums[i]);
                allSubSet.add(newSubSet);
            }
        }
        return allSubSet;
    }

    public static List<List<Integer>> findSubSetWithDuplicateRecursive(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allSubSet = new ArrayList<>();
        findSubSetWithDuplicateRecursive(0, allSubSet, new ArrayList<>(), nums); // first we add Empty SubSet
        return allSubSet;
    }

    private static void findSubSetWithDuplicateRecursive(int index, List<List<Integer>> allSubSet, List<Integer> subSet, int[] nums) {
        allSubSet.add(new ArrayList<>(subSet));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            subSet.add(nums[i]); // peek
            findSubSetWithDuplicateRecursive(i + 1, allSubSet, subSet, nums);
            subSet.remove(subSet.size() - 1); // not peek
        }
    }


    public static void main(String[] args) {
        System.out.println(findSubSetWithDuplicate(new int[]{1, 3, 3}));
        System.out.println(findSubSetWithDuplicateRecursive(new int[]{1, 3, 3}));
        System.out.println();
        System.out.println(findSubSetWithDuplicate(new int[]{1,2,2}));
        System.out.println(findSubSetWithDuplicateRecursive(new int[]{1,2,2}));
    }
}
