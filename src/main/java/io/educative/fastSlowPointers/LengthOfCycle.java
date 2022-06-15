package io.educative.fastSlowPointers;

public class LengthOfCycle {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast)
                return calculateLengthOfCycle(slow);
        }
        return 0;
    }

    private static int calculateLengthOfCycle(ListNode slow) {
        ListNode current = slow;
        int count = 0;
        do {
            count++;
            current = current.next;
        } while (current != slow);
        return count;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next =  listNode.next;
        System.out.println(lengthOfCycle(listNode));
    }
}
