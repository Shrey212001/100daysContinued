/*

Topic:- Prim's (MST) : Special Subtree

Link:- https://www.hackerrank.com/challenges/primsmstsub/problem?isFullScreen=true

Problem:-

Given a graph which consists of several edges connecting its nodes, find a subgraph of the given graph with the following properties:

The subgraph contains all the nodes present in the original graph.
The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
It is also required that there is exactly one, exclusive path between any two nodes of the subgraph.
One specific node S is fixed as the starting point of finding the subgraph using Prim’s
Algorithm.
Find the total weight or the sum of all edges in the subgraph.
Example
n = 3
edges = [[1, 2, 2], [2, 3, 2], [1, 3, 3]]
start = 1

Starting from node 1, select the lower weight edge, i.e. 1 → 2, weight 2.
Choose between the remaining edges, 13, weight 3, and 2 → 3, weight 2.
The lower weight edge is 2 + 3 weight 2.
All nodes are connected at a cost of 2 + 2 = 4. The edge 1 → 3 is not included in the subgraph.

Function Description

Complete the prims function in the editor below.

prims has the following parameter(s):

int n: the number of nodes in the graph
int edges[m][3]: each element contains three integers, two nodes numbers that are connected and the weight of that edge
int start: the number of the starting node
Returns

int: the minimum weight to connect all nodes in the graph
Input Format
The first line has two space-separated integers n and m, the number of nodes and edges in
the graph.
Each of the next m lines contains three space-separated integers u. v and w, the end nodes of edges[i], and the edge’s weight.
The last line has an integer start, the starting node.

Sample Input 0

5 6
1 2 3
1 3 4
4 2 6
5 2 2
2 3 5
3 5 7
1
Sample Output 0

15
Explanation 0

The graph given in the test case is shown as :

The starting node is 1 (in the given test case)
Applying the Prim’s algorithm, edge choices available at first are:
1 → 2 (WT. 3) and 1→ 3 (WT. 4), out of which 1→ 2 is chosen (smaller weight of edge). Now the available choices are:
1→ 3 (WT. 4), 2 →3 (WT. 5), 25 (WT. 2) and 2 → 4 (WT. 6), out of which 2 → 5 is chosen by the algorithm.
Following the same method of the algorithm, the next chosen edges, sequentially are:
1 → 3 and 2 → 4.
Hence the overall sequence of edges picked up by Prim’s are:
12:25:13:2 → 4
and the total weight of the MST (minimum spanning tree) is: 3+2+4+6=15




Solution:-
*/
import java.util.*;

public class Solution {

    static int[] distances;
    static int[][] matrix;
    static Set <Integer> visited;
    static boolean[] vis;
    static int minEdge;
    static int min = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount = scanner.nextInt();
        matrix = new int[nodesCount + 1][nodesCount + 1];
        int edgesCount = scanner.nextInt();
        visited = new HashSet<>();
        vis = new boolean[nodesCount + 1];
        for (int i = 0; i<edgesCount; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int weight = scanner.nextInt();
            matrix[source][target] = weight == 0 ? -1 : weight;
            matrix[target][source] = weight == 0 ? -1 : weight;
        }
        int start = scanner.nextInt();
        visited.add(start);
        vis[start] = true;
        long sum = 0;
        while (visited.size() != nodesCount) {
            minEdge = 0;
            min = Integer.MAX_VALUE;

            for (Integer in : visited) {

                getNeighbours(in);
            }

            if (min == -1) {
                min = 0;
            }
            sum += min;

            visited.add(minEdge);
            vis[minEdge] = true;

        }
        System.out.println(sum);
    }

    static void getNeighbours(int node) {
        for (int in = 0; in< matrix[node].length; in++) {
            if (in != 0 &&in != node) {
                if (!vis[in] && matrix[node][in] != 0) {
                    if (min > matrix[node][in]) {
                        minEdge = in;
                        min = matrix[node][in];
                        if (matrix[node][in] == -1) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
