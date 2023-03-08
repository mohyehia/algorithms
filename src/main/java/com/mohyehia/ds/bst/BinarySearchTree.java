package com.mohyehia.ds.bst;

import java.util.LinkedList;
import java.util.Queue;

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

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
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
