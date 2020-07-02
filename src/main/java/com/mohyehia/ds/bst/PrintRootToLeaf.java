package com.mohyehia.ds.bst;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by mohammed
 * Date: 7/1/20
 * Time: 8:18 PM
 */
public class PrintRootToLeaf {
    static void printRootToLeafPath(Node root){
        if(root == null) return;
        printRootToLeaf(root, new ArrayDeque<>());
    }

    static private void printRootToLeaf(Node root, Deque<Integer> path) {
        if(root == null) return;
        path.addLast(root.val);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.removeLast();
    }

    /*
    our tree is
               1
         2         3
       4   5     6   7
               8   9
      our paths are:
        [1, 2, 4]
        [1, 2, 5]
        [1, 3, 6, 8]
        [1, 3, 6, 9]
        [1, 3, 7]
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        root.right.right = new Node(7);

        printRootToLeafPath(root);
    }
}
