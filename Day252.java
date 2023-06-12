/*

Topic:- Construct the Array

Link:- https://www.hackerrank.com/challenges/construct-the-array/problem?isFullScreen=true

Problem:-

Your goal is to find the number of ways to construct an array such that consecutive positions contain different values.

Specifically, we want to construct an array with n elements such that each element between 1 and k, inclusive. We also want the first and last elements of the array to be 1 and x.

Given n, k and x, find the number of ways to construct such an array. Since the answer may be large, only find it modulo 10^9 + 7.

For example, for n=4, k=3, x=2, there are 3 ways, as shown here:

Complete the function countArray which takes input n, k and x. Return the number of ways to construct the array such that consecutive elements are distinct.

Constraints

3 <= n <=10^5
2 <= k <= 10^5
1 <= x <= k




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countArray(int n, int k, int x) {
        long max = 1000000007;
        long[] f = new long[n + 1]; //[1,...,1]
        long[] g = new long[n + 1]; //[1,...,2]
        f[3] = k - 1;
        g[2] = 1;
        g[3] = k - 2;
        for (int i = 4; i <= n; i++) {
            f[i] = (k - 1) * g[i - 1] % max;
            g[i] = (f[i - 1] + (k - 2) * g[i - 1]) % max;
        }
        return x == 1 ? f[n] : g[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}
