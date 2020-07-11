package com.mohyehia.ds.unionfind;

/**
 * Created by mohammed
 * Date: 7/11/20
 * Time: 12:58 AM
 */
public class UnionFindOptimized {
    static int[] a;
    static int[] rank;
    static void initialize(int len){
        a = new int[len];
        rank = new int[len];
        // create n disjoint sets (one for each item)
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
            rank[i] = 0;
        }
    }
    static int find(int i){
        if(a[i] == i) return i;
        return a[i] = find(a[i]);
    }
    static void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);
        if(iRoot == jRoot) return;
        /*
        Always attach smaller depth tree under the
        root of the deeper tree.
         */
        if(rank[iRoot] > rank[jRoot]) a[jRoot] = iRoot;
        else if(rank[iRoot] < rank[jRoot]) a[iRoot] = jRoot;
        else{
            a[iRoot] = jRoot;
            rank[jRoot] += 1;
        }
    }

    static void printSets(){
        for (int i : a) System.out.print(find(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 10;
        initialize(len);
        union(2, 1);
        printSets();

        union(4, 3);
        printSets();

        union(8, 4);
        printSets();

        union(9, 3);
        printSets();
    }
}
