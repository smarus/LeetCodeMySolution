package leetcode.easy.hashing;

import java.util.HashMap;

class MyHashSet {

    private static final Object PRESENT = new Object();
    private transient HashMap<Integer, Object> hashMap;

    public MyHashSet() {
        hashMap = new HashMap<>();
    }

    public void add(int key) {
        hashMap.put(key, PRESENT);
    }

    public void remove(int key) {
        hashMap.remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return hashMap.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */