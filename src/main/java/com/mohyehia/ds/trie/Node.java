package com.mohyehia.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammed
 * Date: 6/12/20
 * Time: 11:20 PM
 */
public class Node {
    Map<Character, Node> children;
    boolean isLeaf; // determine if this character is endOfWord;
    public Node(){
        children = new HashMap<>();
    }
}
