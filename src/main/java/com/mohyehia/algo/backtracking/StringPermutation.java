package com.mohyehia.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mohammed
 * Date: 6/20/20
 * Time: 4:49 PM
 */
public class StringPermutation {
    static List<List<Integer>> ans;
    static List<List<Integer>> permute(int[] a){
        ans = new ArrayList<>();
        if(a.length == 0) return ans;
        permute(a, 0, a.length);
        return ans;
    }

    private static void permute(int[] a, int left, int right) {
        if(left == right){
            ans.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = left; i < right; i++){
            swap(a, i, left);
            permute(a, left + 1, right);
            swap(a, i, left);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> list = permute(a);
        for(List<Integer> l : list) System.out.println(l);
    }
}
