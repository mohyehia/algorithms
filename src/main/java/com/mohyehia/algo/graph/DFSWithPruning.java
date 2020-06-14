package com.mohyehia.algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammed
 * Date: 6/14/20
 * Time: 11:28 PM
 */
public class DFSWithPruning {
    List<Node>[] graph;
    boolean[] visited;
    int min;
    @SuppressWarnings("unchecked")
    int findCheapestFlight(int n, int[][] flights, int src, int dst, int k){
        min = Integer.MAX_VALUE;
        graph = new List[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] a : flights)
            graph[a[0]].add(new Node(a[1], a[2]));

        dfs(src, dst, k, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int src, int dst, int k, int cost) {
        if(src == dst){
            min = Math.min(min, cost);
            return;
        }
        if(k <= -1) return;
        if(cost > min) return;

        visited[src] = true;
        for(Node node : graph[src]){
            if(!visited[node.to])
                dfs(node.to, dst, k - 1, cost + node.cost);
        }
        visited[src] = false;
    }

    static class Node{
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        DFSWithPruning dfs = new DFSWithPruning();
        int[][] flights = {{0, 1, 100}, {0, 2, 500}, {1, 2, 100}};
        int n = 3, k = 1, src = 0, dst = 2;
        int cheapestFlight = dfs.findCheapestFlight(n, flights, src, dst, k);
        System.out.println(cheapestFlight);
    }
}
