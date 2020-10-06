package Linked_list;

public class Solution {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.printList();
        linkedList.addAtIndex(3, 0);
        linkedList.printList();
        linkedList.deleteAtIndex(2);
        linkedList.printList();
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        linkedList.printList();
        System.out.println(linkedList.get(4));
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(4);
        linkedList.printList();

//        linkedList.printList();
//        linkedList.addAtTail(3);
//        linkedList.printList();
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        linkedList.printList();
//        int val =  linkedList.get(1);// returns 2
//        System.out.println(val+ " -- return 2");
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        linkedList.printList();
//        val = linkedList.get(1);

//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//                    [[],      [7],     [2],       [1],       [3,0],         [2],          [6],         [4],       [4],     [4],       [5,0],        [6]]

        String s = "DF77020102DF620103DF63020306DF740501020304055A01025F24030102035F34030102035F2A0201029F02060102030405069F360201029F26080102030405060708820201029F1001019F370401020103DF010102DF02020305DF75020102DF760103";

        System.out.println(calculateTagLength(s));

    }

    private static String calculateTagLength(String tagValue) {
        int len = AuxUtils.h2b(tagValue).length;
        return AuxUtils.b2h(((byte) len));
    }
}
