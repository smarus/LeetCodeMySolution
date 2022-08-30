package leetcode.medium.linked_list;

import leetcode.easy.linked_list.ListNode;

class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        removeNthFromEnd(l1, 2);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1)
            return null;

        ListNode current = head;
        print(current);
        ListNode reversed = reverse(current);
        print(reversed);
        current = reversed;
        int i = 1;
        while (i < n) {
            current = reversed;
            reversed = reversed.next;
            i++;
        }
        System.out.println(current.val + "  : " + reversed.val);
        ListNode next = reversed.next;
        reversed.next = null;
        current.next = next;
        print(current);

        current = reverse(current);
        print(current);
        return current;
    }

    public static void print(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + "--");
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
