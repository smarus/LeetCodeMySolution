package leetcode.medium;

import leetcode.easy.linked_list.ListNode;

public class RemoveNthList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        ListNode first = head;
        int length = 0;
        while (first != null) {
            first = first.next;
            length++;
        }
        length -= n;

        first = head;
        while (length > 0) {
            first = first.next;
            length--;
        }
        first.next = first.next.next;

        return head;

    }

}
