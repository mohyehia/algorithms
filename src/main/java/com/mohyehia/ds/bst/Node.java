package com.mohyehia.ds.bst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    int val;
    Node left, right;
    public Node(int val){
        this.val = val;
    }
}
