package io.educative.mergeIntervals;


import java.util.*;

public class MergeIntervals {

        public static List<Interval> merge(List<Interval> intervals) {
            List<Interval> mergedIntervals = new ArrayList<>();
            intervals.sort(Comparator.comparingInt(o -> o.start));
            int size = intervals.size();
            if (size == 1)
                return intervals;
            mergedIntervals.add(intervals.get(0));
            for (int i = 1; i < size; i++) {
                Interval prev = mergedIntervals.get(mergedIntervals.size() - 1);
                Interval current = intervals.get(i);
                if (prev.end >= current.start) {
                    prev.end = Math.max(prev.end, current.end);
                    mergedIntervals.set(mergedIntervals.size() - 1, prev);
                } else {
                    mergedIntervals.add(current);
                }
            }
            return mergedIntervals;
        }

        public static void main(String[] args) {
            List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9));
            System.out.println(merge(intervals));
            List<Interval> intervals2 = Arrays.asList(new Interval(6,7), new Interval(2, 4), new Interval(5,9));
            System.out.println(merge(intervals2));


        }
    }

