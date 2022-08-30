package educative.in_place_linked_list;

import leetcode.easy.linked_list.ListNode;

public class ReverseSubList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        ListNode reversedNode = reverseSubList(node, 2, 4);

        for (ListNode current = reversedNode; current != null; current = current.next) {
            System.out.println(current.val);
        }

    }

    public static ListNode reverseSubList(ListNode head, int p, int q) {
        ListNode prev = null;
        ListNode current = head;

        // after skipping 'p- 1' nodes, current will point to 'p' th node
        for (int i = 0; i < p - 1 && current != null; i++) {
            prev = current;
            current = current.next;
        }

        // wer are interested in three part of linkedList
        //part before p , part between p and q , and the part after index '1'
        ListNode firstHalf = prev;
        ListNode secondHalf = current;
        ListNode next = null;
        for (int i = 0; i < q - p + 1 && current != null; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (firstHalf != null)
            firstHalf.next = prev;
        else
            firstHalf = head;

        secondHalf.next = current;

        return firstHalf;
    }


}

