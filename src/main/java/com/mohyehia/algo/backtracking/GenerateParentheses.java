package com.mohyehia.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammed
 * Date: 7/6/20
 * Time: 11:54 PM
 */
public class GenerateParentheses {
    static List<String> ans;
    public static List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve("", 0, 0, n);
        return ans;
    }
    static void solve(String s, int open, int close, int n){
        if(s.length() == n * 2){
            ans.add(s);
            return;
        }
        if(open < n)
            solve(s + "(", open + 1, close, n);
        if(close < open)
            solve(s + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        for(String s : list)
            System.out.println(s);
    }
}
