package leetcode.easy.linked_list;

public class Reverse {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode head = reverseLinkedList(listNode);
        for (ListNode node = head; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode pointer1 = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pointer1;
            pointer1 = head;
            head = next;
        }

        return pointer1;
    }
}
