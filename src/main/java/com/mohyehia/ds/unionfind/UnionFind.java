package com.mohyehia.ds.unionfind;

/**
 * Created by mohammed
 * Date: 7/11/20
 * Time: 12:12 AM
 */
public class UnionFind {
    static void initialize(int[] a){
        // create n disjoint sets (one for each item)
        for(int i = 0; i < a.length; i++) a[i] = i;
    }
    // Find the root of the set in which element k belongs
    static int find(int[] a, int i){
        // if i is root
        if(a[i] == i) return i;
        // recur for parent until we find root
        return find(a, a[i]);
    }
    // Perform Union of two subsets
    static void union(int[] a, int i, int j){
        /*
        find root of the sets in which elements
        i & j belongs
         */
        int iRoot = find(a, i);
        int jRoot = find(a, j);

        a[iRoot] = jRoot;
    }

    static void printSets(int[] a){
        for (int i : a) System.out.print(find(a, i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        initialize(a);
        union(a, 2, 1);
        printSets(a);

        union(a, 4, 3);
        printSets(a);

        union(a, 8, 4);
        printSets(a);

        union(a, 9, 3);
        printSets(a);
    }
}
