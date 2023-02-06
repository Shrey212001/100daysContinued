/*
Topic:- Service Lane

Link:- https://www.hackerrank.com/challenges/service-lane/problem?isFullScreen=true

Problem:-

If the entry index, i=1 and the exit, j=2 , there are two segment widths of 2 and 3 respectively. The widest vehicle that can fit through both is 2. If i=2 and j=4, the widths are [3,2,1] which limits vehicle width to 1.

Function Description

Complete the serviceLane function in the editor below.

serviceLane has the following parameter(s):

int n: the size of the width array
int cases[t][2]: each element contains the starting and ending indices for a segment to consider, inclusive
Returns

int[t]: the maximum width vehicle that can pass through each segment of the service lane described

Input Format


The first line of input contains two integers,n and t, where n denotes the number of width measurements and ,t the number of test cases. The next line has n space-separated integers which represent the array .

The next lines contain two integers, i and j, where i is the start index and j is the end index of the segment to check.

Sample Input

STDIN Function
----- --------
8 5 n = 8, t = 5
2 3 1 2 3 2 3 3 width = [2, 3, 1, 2, 3, 2, 3, 3]
0 3 cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]
4 6
6 7
3 5
0 7
Sample Output


1
2
3
2
1
Explanation

Below is the representation of the lane:

|HIGHWAY|Lane| -> Width

0: | |--| 2
1: | |---| 3
2: | |-| 1
3: | |--| 2
4: | |---| 3
5: | |--| 2
6: | |---| 3
7: | |---| 3



Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] rags) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[]r = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            r[i] = Integer.parseInt(st.nextToken());
        }
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int mini = 3;
            for(int k=i;k<=j;k++) {
                mini = Math.min(mini, r[k]);
            }
            pw.println(mini);
        }
        pw.flush();
    }
}
