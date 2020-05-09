package com.mohyehia.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    int numOfNodes;
    List<Integer>[] graph;
    boolean[] visited;

    @SuppressWarnings("unchecked")
    void solve(){
        //numOfNodes = 10;
        graph = new ArrayList[numOfNodes];
        visited = new boolean[numOfNodes];
        dfs(0);
    }
    /*
    recursive DFS
    time complexity => O(V + E) vertices & edges
     */
    private void dfs(int node) {
        if(visited[node]) return;
        visited[node] = true;
        for(int i : graph[node])
            dfs(i);
    }

    private void iterativeDfs(int node){
        Stack<Integer> st = new Stack<>();
        visited[node] = true;
        st.push(node);
        while(!st.isEmpty()){
            int temp = st.pop();
            for(int i : graph[temp]){
                if(!visited[i]){
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
}
