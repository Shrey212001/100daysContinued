/*

Topic:- Extremum Permutations

Link:- https://www.hackerrank.com/challenges/extremum-permutations/problem?isFullScreen=true

Problem:-

Let's consider a permutation P = {p1, p2, ..., pN} of the set of N = {1, 2, 3, ..., N} elements .

P is called a magic set if it satisfies both of the following constraints:

Given a set of K integers, the elements in positions a1, a2, ..., aK are less than their adjacent elements, i.e., pai-1 > pai < pai+1
Given a set of L integers, elements in positions b1, b2, ..., bL are greater than their adjacent elements, i.e., pbi-1 < pbi > pbi+1
How many such magic sets are there?

Input Format
The first line of input contains three integers N, K, L separated by a single space.
The second line contains K integers, a1, a2, ... aK each separated by single space.
the third line contains L integers, b1, b2, ... bL each separated by single space.

Output Format
Output the answer modulo 1000000007 (109+7).

Constraints
3 <= N <= 5000
1 <= K, L <= 5000
2 <= ai, bj <= N-1, where i ∈ [1, K] AND j ∈ [1, L]

Sample Input #00

4 1 1
2
3
Sample Output #00

5
Explanation #00

Here, N = 4 a1 = 2 and b1 = 3. The 5 permutations of {1,2,3,4} that satisfy the condition are

2 1 4 3
3 2 4 1
4 2 3 1
3 1 4 2
4 1 3 2
Sample Input #01

10 2 2
2 4
3 9
Sample Output #01

161280




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
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int[] a = new int[5005];
        int[] b = new int[5005];
        long[][] dp = new long[5005][5005];
        for (int i = 0; i < k; i++) {
            a[in.nextInt()] = 1;
        }
        for (int i = 0; i < l; i++) {
            b[in.nextInt()] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] == 1 && b[i] == 1){
                System.out.println("0");
                return;
            }
            if ((a[i-1] == 1 && a[i] == 1) || (b[i-1]==1 && b[i] == 1)){
                System.out.println("0");
                return;
            }
        }
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++){
            if (!(a[i-1] == 1  || b[i] == 1)){
                long sum = 0;
                for (int j=1; j <= i; j++){
                    dp[i][j] = add(dp[i][j], sum);
                    sum = add(sum, dp[i-1][j]);
                }
            }
            if (!(b[i-1] == 1 || a[i] == 1)){
                long sum = 0;
                for (int j=i; j>=1; j--){
                    dp[i][j] = add(dp[i][j], sum);
                    sum = add(sum, dp[i-1][j-1]);
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++){
            ans = add(ans, dp[n][i]);
        }
        System.out.println(ans);

    }
    private static long add(long x, long v){
        return (x+v) % 1000000007;
    }
}
