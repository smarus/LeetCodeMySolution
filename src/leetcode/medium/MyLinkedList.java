package leetcode.medium;


class MyLinkedList {
    Node head;
    int n;

    public MyLinkedList() {
        n = 0;

    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.printLinkendList();
        int val = myLinkedList.get(1);              // return 2
        System.out.println(val);
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.printLinkendList();
        val = myLinkedList.get(1);              // return 3
        System.out.println(val);


    }

    private Node getNode(int index) {
        Node node = head;

        for (int i = 0; i < index && node != null; ++i) {
            node = node.next;
        }

        return node;
    }

    public int get(int index) {
        Node current = getNode(index);
        return current.val;
    }

    public Node getTail() {
        Node current = head;

        while (current != null && current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node current = getTail();
        current.next = new Node(val);

    }

    public void addAtIndex(int index, int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = getNode(index);
        Node prevNode = getNode(index - 1);
        newNode.next = current;
        prevNode.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = getNode(index);
        Node prevNode = getNode(index - 1);
        prevNode.next = current.next;
    }

    public void printLinkendList() {
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.val + " ->");
        }
        System.out.println();
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
