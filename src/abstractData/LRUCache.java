package abstractData;

import com.sun.java.swing.action.BackAction;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private Deque<Node> cache;
    // Max capacity
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(1));
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // Using put method to bring it forward to the head
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // Initialize new node x
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // Delete the old node, add to the head
            cache.remove(map.get(key));
            cache.addFirst(x);
            // Update the corresponding record in map
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // Delete the last node in the linked list
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // Add to the head
            cache.addFirst(x);
            map.put(key, x);
        }


    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }


}
