/*

Topic:- Mr K marsh

Link:- https://www.hackerrank.com/challenges/mr-k-marsh/problem?isFullScreen=true

Problem:-

Mr K has a rectangular plot of land which may have marshes where fenceposts cannot be set. He wants you to find the perimeter of the largest rectangular fence that can be built on this land.

For example, in the following m*n = 4*4 grid, x marks a marsh and . marks good land.

....
..x.
..x.
x...

If we number the rows and columns starting with 1, we see that there are two main areas that can be fenced: (1,1)-(3,2) and (1,2)-(4,4). The longest perimeter is 10.

Function Description

Complete the kMarsh function in the editor below. It should print either an integer or impossible.

kMarsh has the following parameter(s):

grid: an array of strings that represent the grid
Input Format

The first line contains two space-separated integers m and n, the grid rows and columns.
Each of the next m lines contains n characters each describing the state of the land. 'x' (ascii value: 120) if it is a marsh and '.' ( ascii value:46) otherwise.

Constraints
2 <= m,n <= 500

Output Format

Output contains a single integer - the largest perimeter. If the rectangular fence cannot be built, print impossible.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int      m, n;
    static String[] land;

    static int[][]  row;
    static int[][]  col;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        in.nextLine();
        land = new String[m];
        for (int i = 0; i < m; i++) {
            land[i] = in.nextLine().trim();
        }
        System.out.println(solve());
    }

    private static String solve() {
        row = new int[m][n];
        col = new int[m][n];
        calcReach();
        int max = getMaxPeri();
        if (max == 0) {
            return "impossible";
        } else {
            return max + "";
        }
    }

    private static int getMaxPeri() {
        int max = 0;
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (land[i].charAt(j) == 'x') {
                    continue;
                }
                int t = getMaxPeri(i, j);
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }

    private static int getMaxPeri(int r, int c) {
        int mr = row[r][c];
        int mc = col[r][c];
        int cc = c;
        int mpr = 0;
        for (int i = mr; i < r; i++) {
            for (int j = mc; j < c && j < cc; j++) {
                if (row[r][j] <= i && col[i][c] <= j) {
                    cc = j;
                    int tp = 2 * (r - i + c - j);
                    if (tp > mpr) {
                        mpr = tp;
                    }
                    break;
                }
            }
        }
        return mpr;
    }

    private static void calcReach() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i].charAt(j) == 'x') {
                    row[i][j] = -1;
                    col[i][j] = -1;
                } else {
                    if (j > 0 && land[i].charAt(j - 1) == '.') {
                        col[i][j] = col[i][j - 1];
                    } else {
                        col[i][j] = j;
                    }
                    if (i > 0 && land[i - 1].charAt(j) == '.') {
                        row[i][j] = row[i - 1][j];
                    } else {
                        row[i][j] = i;
                    }
                }
            }
        }
    }

}
