/*
Topic:- 3D Surface Area

Link:- https://www.hackerrank.com/challenges/3d-surface-area/problem?isFullScreen=true

Problem:-

Madison is a little girl who is fond of toys. Her friend Mason works in a toy manufacturing factory . Mason has a 2D board A of size H x W  with H rows and W columns. The board is divided into cells of size 1 x 1 with each cell indicated by its coordinate (i, j). The cell (i, j) has an integer Aij written on it. To create the toy Mason stacks Aij number of cubes of size 1 x 1 x 1 on the cell (i, j).

Given the description of the board showing the values of Aij and that the price of the toy is equal to the 3d surface area find the price of the toy.

Input Format
The first line contains two space-separated integers H and W the height and the width of the board respectively.

The next H lines contains W space separated integers. The jth integer in ith line denotes Aij.

Constraints
1 <= H, W <= 100
1 <= Aij <= 100
Output Format
Print the required answer, i.e the price of the toy, in one line.

Sample Input 0

1 1
1
Sample Output 0
6
Explanation 0

The surface area of 1 x 1 x 1 cube is 6.

Sample Input 1

3 3
1 3 4
2 2 3
1 2 4
Sample Output 1

60
Explanation 1

The object is rotated so the front row matches column 1 of the input, heights 1, 2, and 1.


The front face is 1 + 2 + 1 = 4 units in area.
The top is 3 units.
The sides are 4 units.
None of the rear faces are exposed.
The underside is 3 units.
The front row contributes 4 + 3 + 4 + 3 = 14 units to the surface area.



Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A) {
        int cost = 0 ;
        int m = A.length-2;
        int k = A[0].length-2;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=k;j++){
                cost+=2;
                cost+=(A[i-1][j]<A[i][j]?(A[i][j] - A[i-1][j]):0);
                cost+=(A[i+1][j]<A[i][j]?(A[i][j] - A[i+1][j]):0);
                cost+=(A[i][j-1]<A[i][j]?(A[i][j] - A[i][j-1]):0);
                cost+=(A[i][j+1]<A[i][j]?(A[i][j] - A[i][j+1]):0);
                
            }
            
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H+2][W+2];
        for(int A_i = 1; A_i <= H; A_i++){
            for(int A_j = 1; A_j <= W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A);
        System.out.println(result);
        in.close();
    }
}
