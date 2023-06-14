/*

Topic:- Kingdom Division

Link:- https://www.hackerrank.com/challenges/kingdom-division/problem?isFullScreen=true

Problem:-

King Arthur has a large kingdom that can be represented as a tree, where nodes correspond to cities and edges correspond to the roads between cities. The kingdom has a total of n cities numbered from 1 to n.

The King wants to divide his kingdom between his two children, Reggie and Betty, by giving each of them 0 or more cities; however, they don't get along so he must divide the kingdom in such a way that they will not invade each other's cities. The first sibling will invade the second sibling's city if the second sibling has no other cities directly connected to it. For example, consider the kingdom configurations below:

image

Given a map of the kingdom's n cities, find and print the number of ways King Arthur can divide it between his two children such that they will not invade each other. As this answer can be quite large, it must be modulo 10^9 + 7.

Input Format

The first line contains a single integer denoting n (the number of cities in the kingdom).
Each of the n-1 subsequent lines contains two space-separated integers, u and v, describing a road connecting cities u and v.

Constraints

2 <= n <= 10^5
1 <= u, v <= n
It is guaranteed that all cities are connected.

Subtasks

2 <= n <= 20 for 40% of the maximum score.
Output Format

Print the number of ways to divide the kingdom such that the siblings will not invade each other, modulo 10^9 + 7.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int MOD = 1_000_000_007;
    boolean[] visited;
    Graph g;
    
    private class Graph {
        private Map<Integer, LinkedList<Integer>> nb;

        public Graph(int n) {
            nb = new HashMap<Integer, LinkedList<Integer>>();
            for (int i = 0; i < n; ++i) {
                nb.put(i, new LinkedList<Integer>());
            }
        }

        private void addNb(int node1, int node2) {
            nb.get(node1).add(node2);
        }

        private List<Integer> getNb(int node) {
            return nb.get(node);
        }
    }
    
    class Count {
        long strong, weak;
        Count(long strong, long weak) {
            this.strong = strong;
            this.weak = weak;
        }
    }
    
    private Count compute(int node) {
        visited[node] = true;
        List<Integer> nb = g.getNb(node);
        int cnb = 0;
        for (int nei : nb) {
            if (!visited[nei]) {
                cnb++;
            }
        }
        if (cnb == 0) {
            return new Count(0, 1);
        }
        Count[] count = new Count[cnb];
        int last = 0;
        for (int nei : nb) {
            if (!visited[nei]) {
                count[last++] = compute(nei);
            }
        }
        Count res = new Count(0, 0);
        res.weak = 1;
        for (int i = 0; i < cnb; i++) {
            res.weak = (res.weak * count[i].strong) % MOD;
        }
         res.strong = 1;
        long prodStrong = 1;
        for (int i = 0; i < cnb; i++) {
            res.strong = (res.strong *(2 * count[i].strong + count[i].weak)) % MOD;
            prodStrong = (prodStrong * count[i].strong) % MOD;
        }
        res.strong = (res.strong + MOD - prodStrong) % MOD;
        return res;
    }
    
    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        g = new Graph(n);
        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g.addNb(u, v);
            g.addNb(v, u);
        }
        visited = new boolean[n];
        Count res = compute(0);
        System.out.println((2 * res.strong) % MOD);
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
