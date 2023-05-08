/*

Topic:- Connected Cells in a Grid

Link:-https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem?isFullScreen=true

Problem:-

Consider a matrix where each cell contains either a 0 or a 1. Any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. In the following grid, all cells marked X are connected to the cell marked Y.

XXX
XYX  
XXX    
If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to zero or more cells in the region but is not necessarily directly connected to all the other cells in the region.

Given an  matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more than one region in the matrix.

Function Description

Complete the connectedCell function in the editor below.

connectedCell has the following parameter(s):
- int matrix[n][m]:  represents the  row of the matrix

Returns
- int: the area of the largest region

Input Format

The first line contains an integer , the number of rows in the matrix.
The second line contains an integer , the number of columns in the matrix.
Each of the next  lines contains  space-separated integers .




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        int maxRegion = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 1){
                    int count = countRegion(matrix, m, n, i, j);                   
                    if(count > maxRegion)
                        maxRegion = count;
                }
            }
        }
        System.out.println(maxRegion);
    }
    
    static int countRegion(int[][] matrix, int m, int n, int x, int y) {
        if ((x < 0) || (x >= m) || (y < 0) || (y >= n) || (matrix[x][y] == 0))
                return 0;
        matrix[x][y] = 0;
        return 1 + countRegion(matrix,m,n, x - 1, y) 
                + countRegion(matrix,m,n,x + 1, y) 
                + countRegion(matrix,m,n,x, y - 1) 
                + countRegion(matrix,m,n,x, y + 1)
                + countRegion(matrix, m, n, x+1, y+1)
                + countRegion(matrix, m, n, x-1, y+1)
                + countRegion(matrix, m, n, x+1, y-1)
                + countRegion(matrix, m, n, x-1, y-1);
    }
}
