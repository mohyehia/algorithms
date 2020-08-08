package com.mohyehia.algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammed
 * Date: 8/8/20
 * Time: 4:52 PM
 */
public class FindSubArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> subArrays = findSubArrays(a);
        for(List<Integer> list : subArrays)
            System.out.println(list);
    }

    private static List<List<Integer>> findSubArrays(int[] a) {
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                temp = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    temp.add(a[k]);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}
