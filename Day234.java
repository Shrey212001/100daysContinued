/*

Topic:- Minimum Penalty Path

Link:- https://www.hackerrank.com/challenges/beautiful-path/problem?isFullScreen=true

Problem:-

Consider an undirected graph containing N nodes and M edges. Each edge M; has an integer cost, C, associated with it.
The penalty of a path is the bitwise OR of every edge cost in the path between a pair of nodes, A and B. In other words, if a path contains edges M1, M2,…, M, then the penalty for this path is C₁ OR C2 OR… OR Ck
Given a graph and two nodes, A and B, find the path between A and B having the minimal possible penalty and print its penalty; if no such path exists, print -1 to indicate that there is no path from A to B.
Note: Loops and multiple edges are allowed. The bitwise OR operation is known as or in Pascal and as | in C++ and Java.
Input Format
The first line contains two space-separated integers, N (the number of nodes) and M (the number of edges), respectively.

Each line of the M subsequent lines contains three space-separated integers U₁, Vi, and C₁, respectively, describing edge Mi connecting the nodes Ui and Vi and its associated penalty (Ci).
The last line contains two space-separated integers, A (the starting node) and B (the ending node), respectively

Output Format
Print the minimal penalty for the optimal path from node A to node B; if no path exists from node A to node B, print -1.

Sample Input

3 4
1 2 1
1 2 1000
2 3 3
1 3 100
1 3
Sample Output

3
Explanation
The optimal path is 1 →2→ 3.
C(1,2) = 1 and C(2,3) = 3.
The penalty for this path is: 1 OR 3 = 3, so we print 3.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int beautifulPath(int[][] edges, int A, int B) {
        Map<Integer, Set<Edge>> adjacents = makeAdjacencyList(edges);
        
        boolean[][] dp = new boolean[1001][1024];
        
        dfs(A, 0, adjacents, dp);
        
        for(int i=0; i<1024; ++i) {
            if(dp[B][i]) return i;
        } 
        
        return -1;
    }
    
    private static void dfs(int from, int cost, Map<Integer, Set<Edge>> adjacents, boolean dp[][]) {
        dp[from][cost]=true;
        Set<Edge> nextNodes = adjacents.get(from);
        if(nextNodes != null) {
            for(Edge e : nextNodes) {
                int newCost = cost | e.cost;
                if(!dp[e.target][newCost]) {
                    dfs(e.target, newCost, adjacents, dp);
                }
            }
        }
        
    }
    
    private static Map<Integer, Set<Edge>> makeAdjacencyList(int[][] edges) {
        Map<Integer, Set<Edge>> adjacents = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if(!adjacents.containsKey(u)) adjacents.put(u, new HashSet<>());
            adjacents.get(u).add(new Edge(v,weight));
            if(!adjacents.containsKey(v)) adjacents.put(v, new HashSet<>());
            adjacents.get(v).add(new Edge(u,weight));
        }
        return adjacents;
    }
    
    private static class Edge {
        Edge(int target, int cost) {this.target = target; this.cost=cost;}
        int target;
        int cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] edges = new int[m][3];
        for(int edges_i = 0; edges_i < m; edges_i++){
            for(int edges_j = 0; edges_j < 3; edges_j++){
                edges[edges_i][edges_j] = in.nextInt();
            }
        }
        int A = in.nextInt();
        int B = in.nextInt();
        int result = beautifulPath(edges, A, B);
        System.out.println(result);
        in.close();
    }
}
