package easy.linked_list;

import java.util.List;

public class Leet21 {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(5);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(4);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;

        ListNode list = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        list.next = list2;
        list2.next = list3;

        ListNode node = mergeTwoLists(listNode, list);

        for (ListNode current = node; node != null; node = node.next) {
            System.out.println(node.val + " data");
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }
}
