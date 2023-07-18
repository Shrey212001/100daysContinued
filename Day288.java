/*

Topic:- Swap Permutation

Link:- https://www.hackerrank.com/challenges/swappermutation/problem?isFullScreen=true

Problem:-

You are given an array A = [1, 2, 3, ..., n]:

How many sequences (S1) can you get after exact k adjacent swaps on A?

How many sequences (S2) can you get after at most k swaps on A?

An adjacent swap can be made between two elements of the Array A, A[i] and A[i+1] or A[i] and A[i-1].
A swap otherwise can be between any two elements of the array A[i] and A[j] ∀ 1 ≤ i, j ≤ N, i ≠ j.

Input Format

First and only line contains n and k separated by space.

Constraints

1 ≤ n ≤ 2500
1 ≤ k ≤ 2500

Output Format

Output S1 % MOD and S2 % MOD in one line, where MOD = 1000000007.

Sample Input

3 2
Sample Output

3 6
Explanation

Original array: [1, 2, 3]
1. After 2 adjacent swaps:
We can get [1, 2, 3], [2, 3, 1], [3, 1, 2] ==> S1 == 3

2. After at most 2 swaps:
1) After 0 swap: [1, 2, 3]
2) After 1 swap: [2, 1, 3], [3, 2, 1], [1, 3, 2].
3) After 2 swaps: [1, 2, 3], [2, 3, 1], [3, 1, 2]
==> S2 == 6 




Solution:-
*/
import java.io.*;
import java.util.Arrays;

public class Solution {

    final static long mod = 1000000007;

    public static void solve(Input in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] d = new long[k + 1];
        d[0] = 1;
        for (int it = 0; it < n; ++it) {
            long[] dd = new long[k + 1];
            long sum = 0;
            for (int i = 0; i <= k; ++i) {
                sum = (sum + d[i]) % mod;
                dd[i] = sum;
                if (i >= it) {
                    sum = (sum + mod - d[i - it]) % mod;
                }
            }
            d = dd;
        }
        long ans1 = 0;
        for (int i = 0; i <= k; ++i) {
            if (i % 2 == k % 2) {
                ans1 = (ans1 + d[i]) % mod;
            }
        }
        long[] d1 = new long[n + 1];
        d1[0] = 1;
        for (int it = 0; it < n; ++it) {
            for (int i = n; i >= 1; --i) {
                d1[i] = (d1[i] * it + d1[i - 1]) % mod;
            }
            d1[0] = 0;
        }
        long ans2 = 0;
        for (int i = 1; i <= n; ++i) {
            if (n - i <= k) {
                ans2 = (ans2 + d1[i]) % mod;
            }
        }
        out.println(ans1 + " " + ans2);
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        solve(new Input(new BufferedReader(
        new InputStreamReader(System.in))), out);
        out.close();
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public Input(String s) {
            this.in = new BufferedReader(new StringReader(s));
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char)c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char)c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
} 
