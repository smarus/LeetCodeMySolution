package Linked_list;


//Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
//
//        Implement these functions in your linked list class:
//
//        get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
//        addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
//        addAtTail(val) : Append a node of value val to the last element of the linked list.
//        addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
//        deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.

import easy.linked_list.ListNode;

class MyLinkedList {
    Node head;
    Node last;
    int N;
    int val;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        N = 0;

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > N)
            return -1;
        Node currentNode = head;
        if (currentNode != null && index == 0) {
            return currentNode.data;
        }
        int counter = 0;
        while (currentNode != null) {
            if (counter == index)
                return currentNode.data;
            else {
                currentNode = currentNode.next;
                counter++;
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node();
            head.setVal(val);
        } else {
            Node old = head;
            head = new Node();
            head.setVal(val);
            head.next = old;
        }
        N++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.data = val;
        Node current = head;
        while (current.next != null)
            current = current.next;
        current = newNode;
        N++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > N)
            return;
        if (index == N)
            addAtTail(val);


        Node newNode = new Node();
        newNode.data = val;
        int counter = 0;
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (counter == index) {
                newNode.next = current;
                if (prev != null)
                    prev.next = newNode;
                N++;
                break;
            } else {
                prev = current;
                current = current.next;
                counter++;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > N)
            return;

        Node current = head, prev = null;
        if (index == 0 && current != null) {
            head = current.next;
            return;
        }

        int counter = 0;

        while (current != null) {
            if (counter == index) {
                prev.next = current.next;
                break;
            } else {
                prev = current;
                current = current.next;
                counter++;
            }
        }

        N--;


    }

    public void printList() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + "-");
        }
        System.out.println("Length :" + N);
    }

    static class Node {

        int data;
        Node next;

        Node() {
            next = null;
        }

        public void setVal(int data) {
            this.data = data;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */