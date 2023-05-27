/*

Topic:- Crab Graphs

Link:- https://www.hackerrank.com/challenges/crab-graphs/problem?isFullScreen=true

Problem:-

A crab is an undirected graph which has two kinds of vertices: 1 head, and K feet , and exactly K edges which join the head to each of the feet.( 1 <= K <= T, where T is given)

Given an undirected graph, you have to find in it some vertex-disjoint subgraphs where each one is a crab . The goal is to select those crabs in such a way that the total number of vertices covered by them is maximized.

Note: two graphs are vertex-disjoint if they do not have any vertices in common. 

Input Format

The first line of input contains a single integer C. C test-cases follow. The first line of each test-case contains three integers N, T, and M (the number of nodes, max number of feet in the crab graph, and number of edges, respectively). Each of next M lines contains two space separated values v1i, v2i meaning that the there is an edge between vertices v1i and v2i. Note that the graph doesn’t have parallel edges or loops.

Constraints

1 <= C <= 10
2 <= T <= 100
2 <= N <= 100
0 <= M <= N * (N-1)/2
1 <= v1i <= N
1 <= v2i <= N
Output Format

For each test-case, output a single integer indicating the maximum number of vertices which can be covered by vertex-disjoint sub-graphs of crab- graphs.

Sample Input

2  
8 2 7  
1 4  
2 4  
3 4  
5 4  
5 8  
5 7  
5 6  
6 3 8  
1 2  
2 3  
3 4  
4 5  
5 6  
6 1  
1 4  
2 5
Sample Output

6  
6
Explanation

Test #1: The graph for this test-case below. Because T = 2, each crab can have a maximum of 2 feet => each crab can cover a maximum of 3 nodes. We can cover 6 nodes of this graph with these two crabs: One of the crabs has 4 as its head and 1 and 3 as its feet, the other crab has 5 as its head and 7 and 8 as its feet. No additional crabs can be added.

The above is not a unique solution: any combination of two crabs, with one head at 4 and one head at 5, will suffice. We could have also chosen Head[4]feet[1,2] and Head[5]feet[6,7] as our two crabs.

Test #2: The graph for this test-case below. We can cover all 6 nodes using two crabs. One of the crabs has 2 as its head and 1 and 3 as its feet, the other crab has 5 as its head and 4 and 6 as its feet.




Solution:-
*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static int crabGraphs(int n, int t, int[][] graph) {
        List<Set<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new HashSet<>());
        }
        for (int[] edge : graph) {
            int n1 = edge[0] - 1;
            int n2 = edge[1] - 1;
            adjacency.get(n1).add(n2);
            adjacency.get(n2).add(n1);
        }

        Deque<Integer> leaves = new ArrayDeque<>();
        int cover = n;
        for (int i = 0; i < n; i++) {
            if (adjacency.get(i).isEmpty()) {
                cover--;
            } else if (adjacency.get(i).size() == 1) {
                leaves.addLast(i);
            }
        }

        int[] legs = new int[n];
        while (!leaves.isEmpty()) {
            int leaf = leaves.removeFirst();
            if (legs[leaf] > 0) {
                continue;
            }

            if (adjacency.get(leaf).isEmpty()) {
                cover--;
            } else {
                int head = adjacency.get(leaf).stream().findAny().get();
                legs[head]++;
                if (legs[head] == t) {
                    for (int neighbor : adjacency.get(head)) {
                        adjacency.get(neighbor).remove(head);
                        if (adjacency.get(neighbor).size() == 1) {
                            leaves.addLast(neighbor);
                        }
                    }
                }
            }
        }
        return cover;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int c = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int cItr = 0; cItr < c; cItr++) {
            String[] ntm = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int n = Integer.parseInt(ntm[0]);

            int t = Integer.parseInt(ntm[1]);

            int m = Integer.parseInt(ntm[2]);

            int[][] graph = new int[m][2];

            for (int graphRowItr = 0; graphRowItr < m; graphRowItr++) {
                String[] graphRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

                for (int graphColumnItr = 0; graphColumnItr < 2; graphColumnItr++) {
                    int graphItem = Integer.parseInt(graphRowItems[graphColumnItr]);
                    graph[graphRowItr][graphColumnItr] = graphItem;
                }
            }

            int result = crabGraphs(n, t, graph);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
