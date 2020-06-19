package com.mohyehia.algo.graph;

import java.util.*;

/**
 * Created by mohammed
 * Date: 6/19/20
 * Time: 12:58 PM
 */
public class DijkstraAlgorithm {
    List<Node>[] graph;
    boolean[] visited;
    int[] cost;

    public DijkstraAlgorithm(int nodes) {
        graph = new List[nodes];
        visited = new boolean[nodes];
        cost = new int[nodes];
        for(int i = 0; i < nodes; i++){
            graph[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }
    }

    void addEdge(int from, int to, int cost){
        graph[from].add(new Node(to, cost));
    }

    static class Node{
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(5);
        algorithm.addEdge(0, 1, 5);
        algorithm.addEdge(0, 3, 8);
        algorithm.addEdge(1, 2, 6);
        algorithm.addEdge(1, 3, 9);
        algorithm.addEdge(2, 4, 4);
        algorithm.addEdge(3, 2, 2);
        algorithm.addEdge(3, 4, 7);
        algorithm.addEdge(4, 1, 5);
        int minDest = algorithm.dijkstra(0, 4);
        System.out.println(minDest);
    }
    /*
    Time complexity => O(Nlog(N))
    Space complexity => O(N)
     */
    private int dijkstra(int src, int dest) {
        if(src == dest) return 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        cost[src] = 0;
        queue.add(new Node(src, 0));
        while(!queue.isEmpty()){
            int prev = queue.poll().to;
            if(visited[prev]) continue;
            visited[prev] = true;
            for(Node node : graph[prev]){
                int to = node.to;
                int tempCost = node.cost;
                if(!visited[to] && (cost[prev] + tempCost < cost[to])){
                    cost[to] = cost[prev] + tempCost;
                    node.cost = cost[to];
                    queue.add(node);
                }
            }
        }
        return cost[dest];
    }
}
