package leetcode.easy.linked_list;

public class Leet83 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode node = deleteDuplicates(listNode);

        for (ListNode current = node; current != null; current = current.next) {
            System.out.println(current.val);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = head;
        ListNode node = new ListNode(head.val);
        dummy.next = node;
        for (ListNode current = head.next; current != null; current = current.next) {
            if (prev.val != current.val) {
                node.next = new ListNode(current.val);
            } else {
                continue;
            }
            prev = current;
            node = node.next;
        }
        return dummy.next;
    }
}
