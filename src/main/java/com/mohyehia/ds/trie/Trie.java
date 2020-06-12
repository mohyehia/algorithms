package com.mohyehia.ds.trie;

/**
 * Created by mohammed
 * Date: 6/12/20
 * Time: 11:26 PM
 */
public class Trie {
    Node root;
    public Trie(){
        root = new Node();
    }
    void insert(String word){
        Node curr = root;
        for(char c : word.toCharArray()){
            curr = curr.children.computeIfAbsent(c, k -> new Node());
        }
        curr.isLeaf = true;
    }

    boolean search(String word){
        Node node = searchForNode(word);
        return node != null && node.isLeaf;
    }

    boolean startsWith(String prefix){
        return searchForNode(prefix) != null;
    }

    Node searchForNode(String s){
        Node node = root;
        for(char c : s.toCharArray()){
            node = node.children.get(c);
            if(node == null) return null;
        }
        return node;
    }
}
