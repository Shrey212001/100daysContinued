/*

Topic:-  Cut Tree

Link:- https://www.hackerrank.com/challenges/cuttree/problem?isFullScreen=true

Problem:-

Given a tree T with n nodes, how many subtrees (T') of T have at most K edges connected to (T - T')?

Input Format

The first line contains two integers n and K followed by n-1 lines each containing two integers a & b denoting that there's an edge between a & b.

Constraints

1 <= K <= n <= 50
Every node is indicated by a distinct number from 1 to n.

Output Format

A single integer which denotes the number of possible subtrees.

Sample Input

3 1
2 1
2 3
Sample Output

6
Explanation

There are 2^3 possible sub-trees:

{} {1} {2} {3} {1, 2} {1, 3} {2, 3} {1, 2, 3}

But:
the sub-trees {2} and {1,3} are not valid. {2} isn't valid because it has 2 edges connecting to it's complement {1,3} whereas K = 1 in the sample test-case {1,3} isn't valid because, well, it's not a sub-tree. The nodes aren't connected.




Solution:-
*/
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static long rooted[][] = new long [55][55];
    static int size[] = new int[55];
    static int outDegree[] = new int[55];
    static ArrayList<Integer> tree[] = new ArrayList[55];
    static int n;
    static int k;
    
    static void dfs(int u, int p) {
        size[u] = 1;
        
        for (int v : tree[u]) {
            if (v == p) continue;
            dfs(v, u);
            
            outDegree[u]++;
            size[u] += size[v];
        }
        long pre[] = rooted[u];
        rooted[u][0] = 1;
        for (int v : tree[u]) {
            if (v == p) continue;
        
            rooted[u] = new long[55];
            for (int i=0; i<=k; i++) {
                if (i >= 1) rooted[u][i] += pre[i - 1];
                for (int j=0; j<=i; j++)
                    rooted[u][i] += pre[i - j] * rooted[v][j];
            }
            pre = rooted[u];    
        }
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        n = cin.nextInt();
        k = cin.nextInt();
        for (int i=0; i<n; i++) tree[i] = new ArrayList<Integer>();
        for (int i=0; i<n-1; i++) {
            int u = cin.nextInt(); u--;
            int v = cin.nextInt(); v--;
            tree[u].add(v);
            tree[v].add(u);
        }
        
        dfs(0, -1);

        long ans = 0;
        for (int i=0; i<n; i++)
            if (i == 0)
                for (int j=0; j<=k; j++) ans += rooted[i][j];
            else 
                for (int j=1; j<=k; j++) ans += rooted[i][j - 1];
        System.out.println(ans + 1);
    }
}
