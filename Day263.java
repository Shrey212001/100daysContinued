/*

Topic:- HackerRank City

Link:- https://www.hackerrank.com/challenges/hr-city/problem?isFullScreen=true

Problem:-

HackerRank-city is an acyclic connected graph (or tree). Its not an ordinary place, the construction of the whole tree takes place in N steps. The process is described below:

It initially has 1 node.
At each step, you must create 3 duplicates of the current tree, and create 2 new nodes to connect all 4 copies in the following H shape:

At each ith step, the tree becomes 4 times bigger plus 2 new nodes, as well as 5 new edges connecting everything together. The length of the new edges being added at step i is denoted by input Ai.

Calculate the sum of distances between each pair of nodes; as these answers may run large, print your answer modulo 1000000007.

Input Format

The first line contains an integer, N (the number of steps). The second line contains N space-separated integers describing A0,A1,...,An-2,An-1 .

Constraints
1 <= N <= 10^6
1 <= Ai <= 9

Subtask
For 50% score 1 <= N <=10

Output Format

Print the sum of distances between each pair of nodes modulo 1000000007.




Solution:-
*/
import java.util.*;

public class Solution {

    public static final long mod = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        long b = 1, c = 0, d = 0, e = 0;
        for (int i = 1; i <= n; i++) {
            c = (a[i] +
                    8 * d +
                    12 * a[i] * b +
                    12 * ((b * d) % mod) +
                    16 * a[i] * ((b * b) % mod) +
                    (c * 4) % mod) % mod;
            d = (4 * d +
                    8 * a[i] * b +
                    3 * a[i] +
                    ((3 * b + 2)  * e) % mod) % mod;
            b = (4 * b + 2) % mod;
            e = (3 * a[i] + 2 * e) % mod;
        }
        System.out.println(c);
    }
}
