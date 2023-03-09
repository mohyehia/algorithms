package com.mohyehia.ds.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;
    int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    Node add(int val) {
        if (contains(val)) return root;
        root = add(root, val);
        size++;
        return root;
    }

    private Node add(Node root, int val) {
        if (root == null) root = new Node(val);
        if (root.val > val) root.left = add(root.left, val);
        else if (root.val < val) root.right = add(root.right, val);
        return root;
    }

    private boolean contains(int val) {
        if (root == null) return false;
        Node curr = root;
        while (curr != null) {
            if (curr.val > val) curr = curr.left;
            else if (curr.val < val) curr = curr.right;
            else return true;
        }
        return false;
    }

    private boolean containsRecursive(Node root, int val) {
        if (root == null) return false;
        if (root.val > val) return containsRecursive(root.left, val);
        else if (root.val < val) return containsRecursive(root.right, val);
        else return true;
    }

    int min(Node root) {
        Node curr = root;
        while (curr.left != null) curr = curr.left;
        return curr.val;
    }

    int max(Node root) {
        Node curr = root;
        while (curr.right != null) curr = curr.right;
        return curr.val;
    }

    int height(Node root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void iterativePreOrder(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.println(temp.val);
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    void iterativeInOrder(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                System.out.println(curr.val);
                curr = curr.right;
            }
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    void iterativePostOrder(Node root) {
        if (root == null) return;
        Stack<Node> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        in.push(root);
        while (!in.isEmpty()) {
            Node temp = in.pop();
            out.push(temp.val);
            if (temp.left != null) in.push(temp.left);
            if (temp.right != null) in.push(temp.right);
        }
        while (!out.isEmpty()) System.out.println(out.pop());
    }

    Node remove(int val) {
        if (containsRecursive(root, val)) {
            root = remove(root, val);
            size--;
            return root;
        }
        return root;
    }

    private Node remove(Node root, int val) {
        if (root == null) return null;
        if (root.val > val) root.left = remove(root.left, val);
        else if (root.val < val) root.right = remove(root.right, val);
        else {
            if (root.left != null && root.right != null) {
                int minElement = min(root.right);
                root.val = minElement;
                root.right = remove(root.right, minElement);
            } else if (root.left != null) root.left = remove(root.left, val);
            else if (root.right != null) root.right = remove(root.right, val);
            else root = null;
        }
        return root;
    }

    void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println(temp.val);
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }
}
