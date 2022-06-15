package io.educative.fastSlowPointers;

public class DetermineLinkedListCycle {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next =  listNode.next;
        System.out.println(hasCycle(listNode));
    }
}
