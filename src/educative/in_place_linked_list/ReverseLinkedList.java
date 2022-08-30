package educative.in_place_linked_list;

import leetcode.easy.linked_list.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(8);
        node.next.next.next.next = new ListNode(10);


        ListNode reversedNode = reverse(node);

        for (ListNode current = reversedNode; current != null; current = current.next) {
            System.out.println(current.val);
        }

    }

    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
