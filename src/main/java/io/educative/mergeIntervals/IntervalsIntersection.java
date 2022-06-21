package io.educative.mergeIntervals;

import java.util.*;

public class IntervalsIntersection {
    /**
     * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
     * Output: [2, 3], [5, 6], [7, 7]
     */
    public static List<Interval> intersection(List<Interval> firstList, List<Interval> secondList) {
        List<Interval> intersected = new ArrayList<>();
        int firstIntervalPointer = 0;
        int secondIntervalPointer = 0;
        while (firstIntervalPointer < firstList.size() && secondIntervalPointer < secondList.size()) {
            Interval firstInterval = firstList.get(firstIntervalPointer);
            Interval secondInterval = secondList.get(secondIntervalPointer);

            if (secondInterval.start >= firstInterval.start && firstInterval.end >= secondInterval.start
                    || firstInterval.start >= secondInterval.start && secondInterval.end >= firstInterval.start) {
                intersected.add(new Interval(Math.max(firstInterval.start, secondInterval.start), Math.min(secondInterval.end, firstInterval.end)));
            }
            if (firstInterval.end < secondInterval.end)
                firstIntervalPointer++;
            else
                secondIntervalPointer++;


        }
        return intersected;
    }

    /**
     * Runtime: 2 ms, faster than 99.95% of Java online submissions for Interval List Intersections.
     * Memory Usage: 42.7 MB, less than 99.54% of Java online submissions for Interval List Intersections.
     * @param firstList
     * @param secondList
     * @return
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersected = new ArrayList<>();
        int firstIntervalPointer = 0;
        int secondIntervalPointer = 0;
        while (firstIntervalPointer < firstList.length && secondIntervalPointer < secondList.length) {
            int firstIntervalStart = firstList[firstIntervalPointer][0];
            int firstIntervalEnd = firstList[firstIntervalPointer][1];

            int secondIntervalStart = secondList[secondIntervalPointer][0];
            int secondIntervalEnd = secondList[secondIntervalPointer][1];

            if (secondIntervalStart >= firstIntervalStart && firstIntervalEnd >= secondIntervalStart
                    || firstIntervalStart >= secondIntervalStart && secondIntervalEnd >= firstIntervalStart) {
                intersected.add(new int[]{Math.max(firstIntervalStart, secondIntervalStart), Math.min(secondIntervalEnd, firstIntervalEnd)});
            }
            if (firstIntervalEnd < secondIntervalEnd)
                firstIntervalPointer++;
            else
                secondIntervalPointer++;


        }
        return intersected.toArray(new int[intersected.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(intersection(Arrays.asList(
                        new Interval(1, 3),
                        new Interval(5, 6),
                        new Interval(7, 9)
                ),
                Arrays.asList(
                        new Interval(2, 3),
                        new Interval(5, 7))));

        /**
         *  [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
         * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
         */
        System.out.println(Arrays.deepToString(intervalIntersection(new int[][]{
                        {1, 3},
                        {5, 6},
                        {7, 9},},
                new int[][]{
                        {2, 3},
                        {5, 7}})));
    }
}
