package leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            list.add(n.val);

            for (int i = n.children.size() - 1; i >= 0; i--) {
                Node node = n.children.get(i);
                if (node != null) {
                    stack.push(node);
                }
            }
        }
        return list;


    }
}