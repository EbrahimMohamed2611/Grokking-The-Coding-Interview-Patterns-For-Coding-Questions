package io.educative.InPlaceReversalLinkedList;

public class ReverseSublist {
    public static ListNode reverseSubList(ListNode head, int start, int end) {

        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; (current != null) && (i < start -1); i++) {
            prev = current;
            current = current.next;
        }
        ListNode firstNodeToReverse = current;
        ListNode prevFirstNodeToReverse = prev;

        ListNode next = null;

        for (int i = 0; (current != null) && (i < end - start + 1); i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        firstNodeToReverse.next = next;

        if (prevFirstNodeToReverse == null)
            head = prev;
        else
            prevFirstNodeToReverse.next = prev;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4, null);
        head.next = new ListNode(1, null);
        head.next.next = new ListNode(3, null);
        head.next.next.next = new ListNode(2, null);
        head.next.next.next.next = new ListNode(5, null);
        System.out.println("Before Reversing");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println("\nAfter Reversing");
        ListNode current2 = reverseSubList(head, 1, 3);
        while (current2 != null) {
            System.out.print(current2.val + " -> ");
            current2 = current2.next;
        }
        System.out.print("null");
    }
}
