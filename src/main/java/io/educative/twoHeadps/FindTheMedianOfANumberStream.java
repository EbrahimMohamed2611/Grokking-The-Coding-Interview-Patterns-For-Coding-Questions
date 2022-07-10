package io.educative.twoHeadps;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheMedianOfANumberStream {

    Queue<Integer> minHeap; // to peek the largest
    Queue<Integer> maxHeap; // to peek the smallest

    public FindTheMedianOfANumberStream() {
        this.minHeap = new PriorityQueue<>((element1, element2) -> element1 - element2);
        this.maxHeap = new PriorityQueue<>((element1, element2) -> element2 - element1);

    }

    public void insertNumber(int number) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= number)
            maxHeap.add(number);
        else
           minHeap.add(number);

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());

    }

    public double findMedian() {

        if (maxHeap.size() == minHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return minHeap.peek();

    }


    public static void main(String[] args) {
        FindTheMedianOfANumberStream findTheMedianOfANumberStream = new FindTheMedianOfANumberStream();
        findTheMedianOfANumberStream.insertNumber(3);
        findTheMedianOfANumberStream.insertNumber(1);
        System.out.println(findTheMedianOfANumberStream.findMedian());
        findTheMedianOfANumberStream.insertNumber(5);
        findTheMedianOfANumberStream.insertNumber(4);
        System.out.println(findTheMedianOfANumberStream.findMedian());
    }
}
