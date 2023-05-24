/*
 
Topic:- Clique

Link:- https://www.hackerrank.com/challenges/clique/problem?isFullScreen=true

Problem:-

A clique in a graph is set of nodes such that there is an edge between any two distinct nodes in the set. Finding the largest clique in a graph is a computationally difficult problem. Currently no polynomial time algorithm is known for solving this. However, you wonder what is the minimum size of the largest clique in any graph with nodes and m edges. For example, consider a graph with n = 4 nodes and m = 5 edges. The graph below shows 4 nodes with 4 edges and no cliques. It is evident that the addition of any 5th edge must create two cliques with 3 members each.

Input Format

The first line contains an integer t, the number of test cases.

Each of the next t lines contains two space-separated integers n and m.

Output Format

For each test case, print the minimum size of the largest clique that must be formed given n and m.

Sample Input

3  
3 2  
4 6  
5 7
Sample Output

2  
4  
3

Explanation

For the first case, we have two cliques with two nodes each:

For the second test case, the only valid graph having 4 nodes and 6 edges is one where each pair of nodes is connected. So the size of the largest clique cannot be smaller than 4.

For the third test case, it is easy to verify that any graph with 5 nodes and 7. The 5 solid lines in the graph below indicate the maximum edges that can be added without forming a clique larger than 2. The dashed lines could connect any two nodes not connected by solid lines producing a clique of size 3.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
  static double turan(int n, int k) {
    k--;
    if (k < 1) return 0;
    double result = Math.pow(n, 2);
    result -= n % k * Math.pow(Math.ceil((double) n / (double) k), 2);
    result -= (k - n % k) * Math.pow(Math.floor((double) n / (double) k), 2);
    return 0.5 * result;
  }

  static int bsearch(int v, int e, int start, int finish) {
    if (start == finish) return start;
    int center = start + (finish - start) / 2;
    double minEdges = turan(v, center);
    if (minEdges == e) return center;
    if (minEdges < e) return bsearch(v, e, center + 1, finish);
    else return bsearch(v, e, start, center == start ? center : center - 1);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    for (int t = 0; t < T; t++) {
      int V = scanner.nextInt();
      int E = scanner.nextInt();

      int estimate = bsearch(V, E, 1, V);

      if (turan(V, estimate) < E) estimate++;
      if (turan(V, estimate) >= E) estimate--;

      System.out.println(estimate);
    }
  }
}
