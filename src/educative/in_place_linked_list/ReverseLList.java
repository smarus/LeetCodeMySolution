package educative.in_place_linked_list;

import leetcode.easy.linked_list.ListNode;

public class ReverseLList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3

        System.out.println(myLinkedList.get(1));// return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));


        ListNode reversedNode = reverse(node, 2, 4);

        for (ListNode current = reversedNode; current != null; current = current.next) {
            System.out.println(current.val);
        }

    }

    public static ListNode reverse(ListNode head, int p, int q) {
        return new ListNode(2);

    }

    static class MyLinkedList {

        ListNode head;

        public MyLinkedList() {

        }

        public int get(int index) {
            int i = 0;
            ListNode current = head;
            while (i < index && current != null) {
                current = current.next;
                i++;
            }

            return current.val;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode current;
            for (current = head; current.next != null; current = current.next) {

            }
            current.next = node;
        }

        public void addAtIndex(int index, int val) {
            int i = 0;
            ListNode newNode = new ListNode(val);
            ListNode current = head;
            ListNode prev = null;
            while (i < index) {
                prev = current;
                current = current.next;
                i++;
            }
            newNode.next = current;
            prev.next = newNode;
            printLinkedList();

        }

        public void printLinkedList() {
            for (ListNode current = head; current != null; current = current.next) {
                System.out.print("->" + current.val);
            }
            System.out.println();
        }

        public void deleteAtIndex(int index) {

            int i = 0;
            ListNode current = head;
            ListNode prev = null;
            while (i < index) {
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;
        }
    }
}
