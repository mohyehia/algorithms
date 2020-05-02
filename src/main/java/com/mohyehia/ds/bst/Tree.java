package com.mohyehia.ds.bst;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root;
    int size;
    public Tree(){
        this.root = null;
        this.size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    Node add(int val){
        if(contains(val)) return root;
        root = add(root, val);
        size++;
        return root;
    }

    private Node add(Node root, int val) {
        if(root == null) return new Node(val);
        if(root.val > val)
            root.left = add(root.left, val);
        else if(root.val < val)
            root.right = add(root.right, val);
        return root;
    }

    boolean contains(int val){
        if(size == 0) return false;
        Node curr = root;
        while(curr != null){
            if(curr.val > val) curr = curr.left;
            else if(curr.val < val) curr = curr.right;
            else return true;
        }
        return false;
    }

    boolean containsRec(Node root, int val){
        if(root == null) return false;
        if(root.val > val) return containsRec(root.left, val);
        else if(root.val < val) return containsRec(root.right, val);
        else return true;
    }

    Node remove(int val){
        if(contains(val)){
            root = remove(root, val);
            size--;
            return root;
        }
        return root;
    }

    private Node remove(Node root, int val) {
        if(root == null) return null;
        if(root.val > val)
            root.left = remove(root.left, val);
        else if(root.val < val)
            root.right = remove(root.right, val);
        else{
            if(root.left != null && root.right != null){
                Node temp = findMin(root.right);
//                Node temp = findMax(root.left);
                root.val = temp.val;
                root.right = remove(root.right, temp.val);
            }else if(root.left != null)
                root = root.left;
            else if(root.right != null)
                root = root.right;
            else root = null;
        }
        return root;
    }

    Node findMin(){
        return findMin(root);
    }

    private Node findMin(Node root) {
        Node curr = root;
        while(curr.left != null)
            curr = curr.left;
        return curr;
    }

    Node findMax(){
        return findMax(root);
    }

    private Node findMax(Node root) {
        Node curr = root;
        while (curr.right != null)
            curr = curr.right;
        return curr;
    }

    int height(){
        return height(root);
    }

    private int height(Node root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root) {
        if(root != null){
            System.out.println(root.left);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root) {
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root) {
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
}
