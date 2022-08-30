package assesment;

public class DesignMinStack {

    Node head;
    int minValue = Integer.MAX_VALUE;

    public DesignMinStack() {
        head = new Node(Integer.MIN_VALUE);
    }

    public void push(int val) {
        if (minValue > val)
            minValue = val;
        if (head.val == Integer.MIN_VALUE) {
            head.val = val;
        } else {
            Node newHead = new Node(val);
            newHead.next = head;
            head = null;
            head = newHead;
        }
    }

    public void pop() {
        Node newHead = head.next;
        head = null;
        head = newHead;

        int min = Integer.MAX_VALUE;
        for (Node node = head; node != null; node = node.next) {
            if (node.val < min)
                min = node.val;
        }

        minValue = min;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return minValue;
    }

    class Node {
        int val;
        Node next;


        public Node(int val) {
            this.val = val;
        }
    }
}
