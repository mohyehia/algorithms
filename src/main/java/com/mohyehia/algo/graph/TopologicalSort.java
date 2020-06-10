package com.mohyehia.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mohammed
 * Date: 6/10/20
 * Time: 10:23 PM
 */
public class TopologicalSort {
    static List<Integer>[] graph;
    static Stack<Integer> stack;
    static int[] incomingDegrees;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int nodes = 6;
        graph = new List[nodes];
        stack = new Stack<>();
        incomingDegrees = new int[nodes];
        for(int i = 0; i < nodes; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        List<Integer> sortedOrder = topologicalSort(nodes);
        System.out.println("Printing graph in topological order_____________");
        for(int i : sortedOrder) System.out.print(i + ", ");
    }

    /*
    Time complexity => O(V + E)
    Space complexity => O(V)
     */
    private static List<Integer> topologicalSort(int nodes) {
        for(int i = 0; i < nodes; i++){
            if(incomingDegrees[i] == 0) stack.push(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            int visited = stack.pop();
            ans.add(visited);
            for(int i : graph[visited]){
                incomingDegrees[i]--;
                if(incomingDegrees[i] == 0) stack.push(i);
            }
        }
        // check if ans size == nodes if not then there is a cycle in the graph
        if(ans.size() != nodes) return new ArrayList<>();
        return ans;
    }

    static void addEdge(int from, int to){
        graph[from].add(to);
        incomingDegrees[to]++;
    }
}
