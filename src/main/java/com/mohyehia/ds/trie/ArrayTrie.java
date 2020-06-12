package com.mohyehia.ds.trie;

/**
 * Created by mohammed
 * Date: 6/12/20
 * Time: 11:35 PM
 */
public class ArrayTrie {

    Node root;
    public ArrayTrie(){
        root = new Node();
    }

    void insert(String word){
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }

    boolean search(String word){
        Node node = searchNode(word);
        return node != null && node.isLeaf;
    }

    boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    Node searchNode(String s){
        Node curr = root;
        for(char c : s.toCharArray()){
            curr = curr.children[c - 'a'];
            if(curr == null) return null;
        }
        return curr;
    }

    static class Node{
        Node[] children;
        boolean isLeaf;
        Node(){
            children = new Node[26];
        }
    }
}
