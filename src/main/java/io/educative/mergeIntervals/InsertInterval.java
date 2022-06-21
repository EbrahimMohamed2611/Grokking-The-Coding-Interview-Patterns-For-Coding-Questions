package io.educative.mergeIntervals;

import java.util.*;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        int intervalPointer = 0;
        while (intervalPointer < intervals.size() && intervals.get(intervalPointer).end < newInterval.start) {
            Interval currentInterval = intervals.get(intervalPointer++);
            mergedIntervals.add(currentInterval);
        }

        while (intervalPointer < intervals.size() && intervals.get(intervalPointer).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(intervalPointer).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(intervalPointer++).end);
        }

        mergedIntervals.add(newInterval);

        while (intervalPointer < intervals.size()) {
            mergedIntervals.add(intervals.get(intervalPointer++));
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        // [1,3], [5,7], [8,12]
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(5,7), new Interval(8,12));
        System.out.println(insert(intervals, new Interval(4,6))); // [[1,3], [4,7], [8,12]]
        List<Interval> intervals2 = Arrays.asList(new Interval(1,3), new Interval(5,7), new Interval(8,12));
        System.out.println(insert(intervals2, new Interval(4,10))); // [[1,3], [4,12]]
    }
}