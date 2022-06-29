package io.educative.InPlaceReversalLinkedList;

public class ReverseFirstKElements {

    public static ListNode reverseFirstKElements(ListNode head, int k) {
        ListNode current = head;
        ListNode firstNode = head;
        ListNode next;
        ListNode prev = null;
        for (int i = 0; current != null && i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        firstNode.next = current;
        head = prev;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
        head.next.next.next = new ListNode(4, null);
        head.next.next.next.next = new ListNode(5, null);
        System.out.println("Before Reversing");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println("\nAfter Reversing");
        ListNode current2 = reverseFirstKElements(head, 3);
        while (current2 != null) {
            System.out.print(current2.val + " -> ");
            current2 = current2.next;
        }
        System.out.print("null");
    }
}
