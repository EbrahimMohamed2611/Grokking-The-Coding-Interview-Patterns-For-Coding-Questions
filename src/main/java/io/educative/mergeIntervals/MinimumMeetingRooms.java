package io.educative.mergeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MinimumMeetingRooms {

    /*
    Runtime: 7 ms, faster than 79.22% of Java online submissions for Meeting Rooms II.
    Memory Usage: 41.9 MB, less than 97.28% of Java online submissions for Meeting Rooms II.
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, ((interval1, interval2) -> interval1[0] - interval2[0]));
        Queue<int[]> meetingQueue = new PriorityQueue<>((interval1, interval2) -> interval1[1] - interval2[1]);

        meetingQueue.add(intervals[0]);
        int minRooms = 1;
        for (int i = 1; i < intervals.length; i++) {
            while (!meetingQueue.isEmpty() && meetingQueue.peek()[1] <= intervals[i][0])
                meetingQueue.poll();

            meetingQueue.add(intervals[i]);
            minRooms = Math.max(minRooms, meetingQueue.size());
        }

        return minRooms;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{
                {0, 30}, {5, 10}, {15, 20}
        })); // 2
        System.out.println(minMeetingRooms(new int[][]{
                {7, 10}, {2, 4}
        })); // 1
        System.out.println(minMeetingRooms(new int[][]{
                {5, 8}, {6, 8}
        })); // 1
    }
}
