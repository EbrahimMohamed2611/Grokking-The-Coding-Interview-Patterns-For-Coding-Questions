package io.educative.mergeIntervals;

import java.util.*;

public class MaximumCPULoad {
    private static class Job {
        private int start;
        private int end;
        private int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }

    public static int maximumCPULoad(List<Job> jobs) {
        int maxLoad = 0;
        int currentLoad = 0;
        Queue<Job> minHeap = new PriorityQueue<>((job1, job2) -> job1.end - job2.end);
        jobs.sort((job1, job2) -> job1.start - job2.start);
        for (Job job : jobs) {
            while (!minHeap.isEmpty()) {
                if (job.start >= minHeap.peek().end) {
                    Job remove = minHeap.remove();
                    currentLoad -= remove.cpuLoad;
                } else
                    break;
            }

            minHeap.add(job);
            currentLoad += job.cpuLoad;
            maxLoad = Math.max(maxLoad,currentLoad);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
//        [[1,4,3], [2,5,4], [7,9,6]]  7
//        [[6,7,10], [2,4,11], [8,12,15]] 15
        System.out.println(maximumCPULoad(Arrays.asList(
                new Job(1,4,3),
                new Job(2,5,4),
                new Job(7,9,6)
                )));
        System.out.println(maximumCPULoad(Arrays.asList(
                new Job(6,7,10),
                new Job(2,4,11),
                new Job(8,12,15)
        )));
    }
}
