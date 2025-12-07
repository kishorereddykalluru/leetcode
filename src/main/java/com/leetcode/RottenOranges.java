package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(grid)); // Output: 4
    }

    private static int orangesRotting(int[][] grid) {
       
        int m = grid.length;
        int n = grid[0].length;
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<Integer[]> q = new LinkedList<>();

        int freshOranges = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    q.add(new Integer[]{i, j});

                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        int elapsedMinutes = 0;

        while(!q.isEmpty()){
            elapsedMinutes++;

            int len = q.size();
            while(len-- > 0) {

                Integer[] pop = q.remove();

                for(int[] dir : direction) {
                    int newRow = pop[0] + dir[0];
                    int newCol = pop[1] + dir[1];

                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        q.add(new Integer[]{newRow, newCol});
                    }
                }
            }
    
        }

        if(freshOranges > 0)
            return -1;

        return Math.max(0, elapsedMinutes - 1);
    }

}
