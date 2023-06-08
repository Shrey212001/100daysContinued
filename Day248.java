/*

Topic:- Flipping the Matrix

Link:- https://www.hackerrank.com/challenges/flipping-the-matrix/problem?isFullScreen=true

Problem:-

Sean invented a game involving a 2n * 2n matrix where each cell of the matrix contains an integer. He can reverse any of its rows or columns any number of times. The goal of the game is to maximize the sum of the elements in the n * n submatrix located in the upper-left quadrant of the matrix.

Given the initial configurations for q matrices, help Sean reverse the rows and columns of each matrix in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal.

Example
 matrix = [[1,2],[3,4]]
1 2
3 4
It is 2*2 and we want to maximize the top left quadrant, a 1*1 matrix. Reverse row 1:

1 2
4 3
And now reverse column 0:

4 2
1 3
The maximal sum is 4.

Function Description

Complete the flippingMatrix function in the editor below.

flippingMatrix has the following parameters:
- int matrix[2n][2n]: a 2-dimensional array of integers

Returns
- int: the maximum sum possible.

Input Format

The first line contains an integer q, the number of queries.

The next q sets of lines are in the following format:

The first line of each query contains an integer, n.
Each of the next 2n lines contains 2n space-separated integers matrix[i][j] in row i of the matrix.

Constraints
1 <= q <= 16
1 <= n <= 128
0 <= matrix[i][j] <= 4096, where 0 <= i,j < 2n.




Solution :-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        for(int t1=0;t1<t;t1++){
            int n=Integer.parseInt(in.readLine());
            String[][] s=new String[2*n][2*n];
            for(int i=0;i<2*n;i++)
                s[i]=in.readLine().split(" ");
            long sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    sum+=Math.max(Math.max(Integer.parseInt(s[i][j]),
                                  Integer.parseInt(s[2*n-1-i][j])),
                                  Math.max(Integer.parseInt(s[i][2*n-1-j]),
                                  Integer.parseInt(s[2*n-1-i][2*n-1-j])));
                }
            }
            System.out.println(sum);
        }
    }
}
