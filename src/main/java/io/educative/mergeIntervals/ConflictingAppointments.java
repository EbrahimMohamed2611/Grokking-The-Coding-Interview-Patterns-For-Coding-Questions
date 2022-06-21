package io.educative.mergeIntervals;

import java.util.*;

public class ConflictingAppointments {

    /**
     * Appointments: [[1,4], [2,5], [7,9]]
     * Output: false
     *
     * Appointments: [[6,7], [2,4], [8,12]]
     * Output: true
     */

    public static boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((i1,i2)-> i1.start- i2.start);
        int size = intervals.size();
        if(size == 1)
            return true;

        for (int i = 1; i < size; i++) {
            Interval current = intervals.get(i-1);
            Interval next =  intervals.get(i);
            if(current.end > next.start)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(Arrays.asList(
                new Interval(1,4),
                new Interval(2,5),
                new Interval(7,9)
        )));
        System.out.println(canAttendMeetings(Arrays.asList(
                new Interval(6,7),
                new Interval(2,4),
                new Interval(8,12)
        )));
    }
}