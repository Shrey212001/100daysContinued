/*

Topic:- Roads in HackerLand

Link:- https://www.hackerrank.com/challenges/johnland/problem?isFullScreen=true

Problem:-

John lives in HackerLand, a country with N cities and M bidirectional roads. Each of the roads has a distinct length, and each length is a power of two (l.e.. 2 raised to some exponent). It’s possible for John to reach any city from any other city. Given a map of HackerLand, can you help John determine the sum of the minimum distances between each pair of cities? Print your answer in binary representation.

Input Format

The first line contains two space-seperated integers denoting N (the number of cities) and M (the number of roads), respectively.
Each line i of the M subsequent lines contains the respective values of A, B, and C, as three space-separated integers. These values define a bidirectional road between cities A, and B, having length 2Ci

Output Format

Find the sum of minimum distances of each pair of cities and print the answer in binary representation.

Sample Input

5 6
1 3 5
4 5 0
2 1 3
3 2 1
4 3 4
4 2 2

Sample Output

1000100




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
  public static class Edge {
    public int node1, node2, power;
    long count;

    public Edge(int node1, int node2, int power) {
      this.node1 = node1;
      this.node2 = node2;
      this.power = power;
    }
  }

  public static class Node {
    public int id;

    public ArrayList<Edge> edges;

    public Node(int id) {
      this.id = id;
      edges = new ArrayList<>();
    }
  }

  static long[] results;
  static int N, M;
  static Node[] nodes;

  static int[] forests;

  static int find(int node) {
    if (forests[node] < 0) return node;
    return forests[node] = find(forests[node]);
  }

  static void join(int root1, int root2) {
    if (forests[root2] < forests[root1]) forests[root1] = root2;
    else {
      if (forests[root1] == forests[root2]) forests[root1]--;
      forests[root2] = root1;
    }
  }

  static int descend(Node parent, Node node) {
    int total = 1;

    for (Edge edge : node.edges) {
      if (parent != null && (edge.node1 == parent.id || edge.node2 == parent.id)) continue;

      Node target;

      if (edge.node1 == node.id) target = nodes[edge.node2];
      else target = nodes[edge.node1];

      edge.count = descend(node, target);

      total += edge.count;
    }

    return total;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    N = scanner.nextInt();
    M = scanner.nextInt();

    Edge[] edges = new Edge[M];

    results = new long[2 * M];

    nodes = new Node[N];
    for (int n = 0; n < N; n++) nodes[n] = new Node(n);

    for (int m = 0; m < M; m++) {
      int node1 = scanner.nextInt() - 1;
      int node2 = scanner.nextInt() - 1;
      int power = scanner.nextInt();
      edges[power] = new Edge(node1, node2, power);
    }

    ArrayList<Edge> bucket = new ArrayList<>();

    forests = new int[N];
    Arrays.fill(forests, -1);

    for (int m = 0; m < M; m++) {
      int n1 = edges[m].node1, n2 = edges[m].node2;
      if (find(n1) != find(n2)) {
        join(find(n1), find(n2));

        nodes[n1].edges.add(edges[m]);
        nodes[n2].edges.add(edges[m]);

        bucket.add(edges[m]);
      }
    }

    Node root = nodes[bucket.get(0).node1];

    descend(null, root);

    for (Edge edge : bucket) results[edge.power] = edge.count * (N - edge.count);

    long carry;
    long nm;

    long[] buffer = new long[2 * M];

    for (int i = 0; i < 2 * M; i++) {
      nm = results[i];
      int j = 0;
      while (nm != 0) {
        buffer[i + j] += nm % 2;
        nm /= 2;
        j++;
      }
    }

    carry = 0;
    Arrays.fill(results, 0);
    for (int i = 0; i < 2 * M; i++) {
      results[i] = (buffer[i] + carry) % 2;
      carry = (buffer[i] + carry) / 2;
    }

    boolean init = false;
    for (int i = 2 * M - 1; i >= 0; i--) {
      if (results[i] == 0 && init) System.out.print(0);
      else if (results[i] == 1) {
        System.out.print(1);
        init = true;
      }
    }
  }
}
