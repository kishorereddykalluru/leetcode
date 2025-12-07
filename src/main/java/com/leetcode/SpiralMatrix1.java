package com.leetcode;

public class SpiralMatrix1 {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3,4,1},
            {5, 6, 7, 8,1},
            {9, 10, 11, 12,1},
            {13,14,15,16,4}
        };
        spiralOrder(matrix);
    }

    private static void spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int colB = 0;
        int colE = n - 1;
        int rowB = 0;
        int rowE = m - 1;

        while(colB <= colE && rowB <= rowE) {
            for( int i = colB; i <= colE; i++) {
                System.out.print(matrix[rowB][i]+" ");
            }
            rowB++;
            for(int i = rowB; i <= rowE; i++){
                System.out.print(matrix[i][colE]+ " ");
            }
            colE--;
            if(colB < colE)
                for(int i = colE; i >= colB; i--) {
                    System.out.print(matrix[rowE][i]+ " ");
                }
            rowE--;
            if(rowB < rowE)
                for(int i = rowE; i >= rowB ; i--) {
                    System.out.print(matrix[i][colB]+ " ");
                }
            colB++;
        }
    }

}
