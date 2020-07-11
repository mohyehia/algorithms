package com.mohyehia.algo.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammed
 * Date: 7/11/20
 * Time: 7:56 PM
 */
public class Permutation {
    public static void main(String[] args) {
        String s = "aabbc";
        permute(s);
    }

    private static void permute(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray())
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char[] result = new char[s.length()];
        permute(str, count, result, 0);
    }

    private static void permute(char[] str, int[] count, char[] result, int level) {
        if(level == result.length){
            System.out.println(new String(result));
            return;
        }
        for(int i = 0; i < str.length; i++){
            if(count[i] == 0) continue;
            result[level] = str[i];
            count[i]--;
            permute(str, count, result, level + 1);
            count[i]++;
        }
    }
}
