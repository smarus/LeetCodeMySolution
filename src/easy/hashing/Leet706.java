package easy.hashing;

import java.util.Arrays;

//All keys and values will be in the range of [0, 1000000].
//The number of operations will be in the range of [1, 10000].
//Please do not use the built-in HashMap library.
public class Leet706 {
    public static void main(String[] args) {

    }

    class MyHashMap {

        int[] values;
        int N = 1;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            values = new int[1000000];
            Arrays.fill(values, -1);
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            values[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return values[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            values[key] = -1;
        }

    }
}

//Best  Solution
//class MyHashMap {
//
//    private class Node {
//        int k;
//        int v;
//        Node prev;
//        Node next;
//        public Node(int k, int v) {
//            this.k = k;
//            this.v = v;
//        }
//    }
//
//    int size = 0;
//    Node[] arr;
//    int len = 10000;
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//        size = 0;
//        arr = new Node[len];
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        Node head = arr[hash(key)];
//        if(head == null) {
//            arr[hash(key)] = new Node(key, value);
//            return;
//        }
//
//        Node curr = head;
//        Node prev = null;
//        while(curr != null) {
//            if(curr.k == key) {
//                curr.v = value;
//                return;
//            }
//            prev = curr;
//            curr = curr.next;
//        }
//        Node newNode = new Node(key, value);
//        //not found
//        prev.next = newNode;
//        newNode.prev = prev;
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        Node head = arr[hash(key)];
//        if(head == null) {
//            return -1;
//        }
//
//        Node curr = head;
//        while(curr != null) {
//            if(curr.k == key) {
//                return curr.v;
//            }
//            curr = curr.next;
//        }
//
//        return -1;
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        Node head = arr[hash(key)];
//        if(head == null) {
//            return;
//        }
//
//        Node fh = new Node(-1,-1);
//        fh.next = head;
//        head.prev = fh;
//        Node curr = head;
//        while(curr != null) {
//            if(curr.k == key) {
//
//                Node prev = curr.prev;
//                Node next = curr.next;
//                prev.next = next;
//                if(next != null) {
//                    next.prev = prev;
//                }
//            }
//            curr = curr.next;
//        }
//
//        arr[hash(key)] = fh.next;
//    }
//
//
//    public int hash(int key) {
//        return key % len;
//    }
//}
//}
