/*

Topic:- Sherlock and Cost

Link:- https://www.hackerrank.com/challenges/sherlock-and-cost/problem?isFullScreen=true

Problem:-

you will be given an array B and must determine an array A. There is a special rule: For all i, A[i] <= B[i]. That is, A[i] can be any number you choose such that 1 <= A[i] <= B[i]. Your task is to select a series of A[i] given B[i] such that the sum of the absolute difference of consecutive pairs of A is maximized. This will be the array's cost, and will be represented by the variable S below.

The equation can be written:
  S = (E^N )i=2 |A[i]-A[i-1]|

For example, if the array B = [1, 2, 3], we know that 1 <= A[1] <= 1, 1 <= A[2] <= 2, and 1 <= A[3] <= 3. Arrays meeting those guidelines are:

[1,1,1], [1,1,2], [1,1,3]
[1,2,1], [1,2,2], [1,2,3]
Our calculations for the arrays are as follows:

|1-1| + |1-1| = 0	|1-1| + |2-1| = 1	|1-1| + |3-1| = 2
|2-1| + |1-2| = 2	|2-1| + |2-2| = 1	|2-1| + |3-2| = 2
The maximum value obtained is 2.

Function Description

Complete the cost function in the editor below. It should return the maximum value that can be obtained.

cost has the following parameter(s):

B: an array of integers
Input Format

The first line contains the integer t, the number of test cases.

Each of the next t pairs of lines is a test case where:
- The first line contains an integer n, the length of B
- The next line contains n space-separated integers B[i]

Constraints

1 <= t <= 20
1 <= n <= 10^5
1 <= B[i] <= 100 

Output Format

For each test case, print the maximum sum on a separate line.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int dpLow = 0;
        int dpHigh = 0;

        for (int i = 1; i < n; i++) {
            int nextLow = Math.max(dpLow, dpHigh + a[i - 1] - 1);
            int nextHigh = Math.max(dpLow + a[i] - 1,
                    dpHigh + Math.abs(a[i] - a[i - 1]));
            dpLow = nextLow;
            dpHigh = nextHigh;
        }
        
        out.println(Math.max(dpLow, dpHigh));
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
