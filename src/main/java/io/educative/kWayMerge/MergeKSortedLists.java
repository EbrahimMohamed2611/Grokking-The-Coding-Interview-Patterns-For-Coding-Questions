package io.educative.kWayMerge;

import io.educative.InPlaceReversalLinkedList.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/*Amazon |53 Facebook|22 Microsoft|11 Apple|8 Uber|5 Google|5 Indeed|3 VMware|3 Adobe|3 */
public class MergeKSortedLists {
    /*
        Runtime: 5 ms, faster than 81.28% of Java online submissions for Merge k Sorted Lists.
        Memory Usage: 43.9 MB, less than 96.49% of Java online submissions for Merge k Sorted Lists.
        */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((list1, list2) -> list1.val - list2.val);

        for (ListNode node : lists)
            if (node != null)
                minHeap.add(node);

        ListNode head = null, tail = null;

        while (!minHeap.isEmpty()) {
            ListNode minElement = minHeap.poll();
            if (head == null)
                head = tail = minElement;
            else {
                tail.next = minElement;
                tail = tail.next;
            }


            if (minElement.next != null)
                minHeap.add(minElement.next);
        }

        return head;
    }
}
