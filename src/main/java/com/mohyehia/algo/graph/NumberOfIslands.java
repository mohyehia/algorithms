package com.mohyehia.algo.graph;

public class NumberOfIslands {
    /*
    Given a 2d grid map of '1's (land) and '0's (water),
     count the number of islands. An island is surrounded by water
      and is formed by connecting adjacent lands horizontally or vertically.
     You may assume all four edges of the grid are all surrounded by water.
     ex =>
     11110
     11010
     11000
     00000
     output is 1
     ex =>
     11000
     11000
     00100
     00011
     output is 3
     */
    public int numIslands(char[][] a){
        if(a == null || a.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] == '1'){
                    dfs(a, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] a, int i, int j) {
        // base case
        if(a[i][j] == '0') return;
        // outOfBounds cases
        if(i > 0) dfs(a, i - 1, j); // go top
        if(i < a.length - 1) dfs(a, i + 1, j); // go down
        if(j > 0) dfs(a, i, j - 1); // go left
        if(j < a.length - 1) dfs(a, i, j + 1); // go right
    }
}
