package com.mohyehia.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    int numOfNodes;
    List<Integer>[] graph;
    boolean[] visited;

    @SuppressWarnings("unchecked")
    void solve(){
        //numOfNodes = 10;
        graph = new ArrayList[numOfNodes];
        visited = new boolean[numOfNodes];
        bfs(0);
    }

    /*
    recursive BFS
    time complexity => O(V + E) vertices & edges
     */
    private void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i : graph[temp]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
