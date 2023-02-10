/*
Topic:- Cavity Map

Link:- https://www.hackerrank.com/challenges/cavity-map/problem?isFullScreen=true

Problem:-

You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side, or edge.

Find all the cavities on the map and replace their depths with the uppercase character X.

Example

grid=[‘989′,’191′,’111’]

The grid is rearranged for clarity:

989
191
111
Return:


989
1X1
111
The center cell was deeper than those on its edges: [8,1,1,1]. The deep cells in the top two corners do not share an edge with the center cell, and none of the border cells is eligible.

Function Description

Complete the cavityMap function in the editor below.

cavityMap has the following parameter(s):

string grid[n]: each string represents a row of the grid
Returns

string{n}: the modified grid
Input Format


The first line contains an integer , the number of rows and columns in the grid.

Each of the following lines (rows) contains positive digits without spaces (columns) that represent the depth at .

Sample Input

STDIN Function
----- --------
4 grid[] size n = 4
1112 grid = ['1112', '1912', '1892', '1234']
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
Explanation


The two cells with the depth of 9 are not on the border and are surrounded on all sides by shallower cells. Their values are replaced by X.



Solution:-
*/
import java.util.*;
class Solution
    {
        public static void main(String ar[])
            {
                Scanner in=new Scanner(System.in);
                int n=in.nextInt(),i,j;
                char c[][]=new char[n][];
                for(i=0;i<n;i++)
                    {
                        c[i]=in.next().toCharArray();
                    }
                for(i=1;i<n-1;i++)                
                    {
                        for(j=1;j<n-1;j++)
                            {
                                if(c[i][j]>c[i][j-1] && c[i][j]>c[i][j+1] && c[i][j]>c[i-1][j] && c[i][j]>c[i+1][j])
                                    c[i][j]='X';
                            }
                    }
                for(i=0;i<n;i++)
                    System.out.println(new String(c[i]));
            }
    }
