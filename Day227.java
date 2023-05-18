/*

Topic:- Breadth First Search: Shortest Reach

Link:- https://www.hackerrank.com/challenges/bfsshortreach/problem?isFullScreen=true

Problem:-

Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n  and the edge between any two nodes is always of length 6. We define node s to be the starting position for a BFS. Given a graph, determine the distances from the start node to each of its descendants and return the list in node number order, ascending. If a node is disconnected, it's distance should be -1.

For example, there are  n = 6 nodes in the graph with a starting node s = 1 . The list of edges = [ [1,2], [2, 3],[3, 4 ], [1, 5 ] ] and each has a weight of 6 .

Function Description

Define a Graph class with the required methods to return a list of distances.

Input Format

The first line contains an integer, q, the number of queries.

Each of the following q sets of lines is as follows:

The first line contains two space-separated integers, n and m, the number of nodes and the number of edges.
Each of the next m lines contains two space-separated integers, u and v, describing an edge connecting node u to node v.
The last line contains a single integer, s, the index of the starting node.

Output Format

For each of the q queries, print a single line of n - 1 space-separated integers denoting the shortest distances to each of the n - 1 other nodes from starting position s. These distances should be listed sequentially by node number (i.e.1, 2 , . . . , n ), but should not include node s. If some node is unreachable from s , print -1 as the distance to that node.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2


Sample Output

6 6 -1
-1 6




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        private int V;
        private LinkedList<Integer> [] G;
        
        public Graph(int size) {
            this.V = size;
            this.G = new LinkedList[V];
            
            for(int v = 0; v < V; v++)
                G[v] = new LinkedList<>();
        }

        public void addEdge(int first, int second) {
            G[first].add(second);
            G[second].add(first);
        }
        
        public int[] shortestReach(int startId) {
            boolean [] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(startId);
            visited[startId] = true;
            int size = 1;
            int distance = 6;
            int [] distTo = new int[V];
            Arrays.fill(distTo, -1);
            while(!q.isEmpty()) {
                int v = q.poll();
                for(int w : G[v]) {
                    if(!visited[w]) {
                        visited[w] = true;
                        distTo[w] = distance;
                        q.add(w);
                    }
                }
                
                if(--size == 0) {
                    size = q.size();
                    distance+=6;
                }
            }
            return distTo;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
            
                graph.addEdge(u, v);
            }
           
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
