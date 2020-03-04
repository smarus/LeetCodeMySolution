package easy.linked_list;

import java.util.Stack;

public class Leet206 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = reverseList(head);
        for (ListNode x = head; x != null; x = head.next) {
            System.out.println(x.val);
        }
    }


//    public static ListNode reverseList(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//        for(ListNode node = head; node != null; node = node.next){
//            stack.push(node.val);
//        }
//
//        ListNode node = new ListNode(stack.pop());
//        ListNode newHead = null;
//        for(Integer integer: stack){
//           node.next = new ListNode(integer);
//           newHead = node.next;
//           node = newHead;
//            System.out.println(integer);
//        }
//        return node;
//    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
