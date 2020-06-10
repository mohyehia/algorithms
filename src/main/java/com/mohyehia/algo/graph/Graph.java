package com.mohyehia.algo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammed
 * Date: 6/2/20
 * Time: 11:42 PM
 */
public class Graph {
    List<List<Integer>> graph;
    boolean[] visited, recursive;
    int nodes;
    Graph(int nodes){
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        recursive = new boolean[nodes];
        this.nodes = nodes;
        for(int i = 0; i < nodes; i++)
            graph.add(i, new ArrayList<>());
    }
    void addEdge(int from, int to){
        graph.get(from).add(to);
    }

    public static void main(String[] args) {
        int nodes = 5;
        Graph graph = new Graph(nodes);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        System.out.println(graph.isDirectedGraphHasCycle());
    }
    /*
    Time complexity => O(V + E)
    Space complexity => O(V)
     */
    private boolean isDirectedGraphHasCycle() {
        for(int i = 0; i < nodes; i++){
            if(ifCycleExists(i)) return true;
        }
        return false;
    }

    /*
    1 => check if node is present in recursiveStack.
        if present => return true;
    2 => check if node is already visited.
        if visited => return false;
    3 => mark node as visited & add node to the recursive stack.
    4 => get adjacency nodes of the current node & repeat steps 1 to 5 for all nodes;
    5 => remove node from the recursive stack.
    6 => return false for the last step;
     */
    private boolean ifCycleExists(int i) {
        if(recursive[i]) return true;

        if(visited[i]) return false;

        visited[i] = true;
        recursive[i] = true;

        for(int node : graph.get(i)){
            if(ifCycleExists(node)) return true;
        }

        recursive[i] = false;
        return false;
    }

    private boolean undirectedHasCycle(int index, int parent){
        visited[index] = true;
        for(int i : graph.get(index)){
            if(!visited[i])
                undirectedHasCycle(i, index);
            else if(i != parent)
                return true;
        }
        return false;
    }
}
