package com.mohyehia.algo.graph;

import java.util.LinkedList;
import java.util.List;

public class ConnectedComponents {
    int numOfNodes;
    List<Integer>[] graph;
    boolean[] visited;

    public ConnectedComponents(int numOfNodes){
        this.numOfNodes = numOfNodes;
        graph = new List[numOfNodes];
        visited = new boolean[numOfNodes];
        for(int i = 0; i < numOfNodes; i++)
            graph[i] = new LinkedList<>();
    }

    void dfs(int node){
        visited[node] = true;
        System.out.print(node + " ");
        for(int i : graph[node])
            if(!visited[i]) dfs(i);
    }
    /*
    Time complexity => O(V + E) vertices & edges
    Space Complexity =>O(V + E)
     */
    void findConnectedComponents(){
        for(int i = 0; i < numOfNodes; i++){
            if(!visited[i]){
                dfs(i);
                System.out.println();
            }
        }
    }

    int countOfConnectedComponents(){
        int count = 0;
        for(int i = 0; i < numOfNodes; i++){
            if(!visited[i]){
                dfs(i);
                count++;
                System.out.println();
            }
        }
        return count;
    }

    void addEdge(int from, int to){
        graph[from].add(to);
        graph[to].add(from);
    }

    public static void main(String[] args) {
        ConnectedComponents components = new ConnectedComponents(5);
        components.addEdge(1, 0);
        components.addEdge(2, 3);
        components.addEdge(3, 4);
        System.out.println("Following are connected components");
//        components.findConnectedComponents();
        System.out.println(components.countOfConnectedComponents());
    }
}
