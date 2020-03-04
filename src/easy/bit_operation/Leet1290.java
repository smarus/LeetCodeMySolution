package easy.bit_operation;

public class Leet1290 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        System.out.println(getDecimalValue(listNode));
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        for (ListNode node = head; node != null; node = node.next) {
            sb.append(node.val);
        }

        System.out.println(sb);
        return Integer.parseInt(sb.toString(), 2);
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}



