/*

Topic:- Kruskal (MST): Really Special Subtree

Link:- https://www.hackerrank.com/challenges/kruskalmstrsub/problem?isFullScreen=true

Problem:-

Given an undirected weighted connected graph, find the Really Special SubTree in it. The Really Special SubTree is defined as a subgraph consisting of all the nodes in the graph and:

There is only one exclusive path from a node to every other node.

The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.

No cycles are formed

To create the Really Special SubTree, always pick the edge with smallest weight. Determine if including it will create a cycle. If so, ignore the edge. If there are edges of equal weight available:

Choose the edge that minimizes the sum where and are vertices and is the edge weight.

If there is still a collision, choose any of them.

Print the overall weight of the tree formed using the rules.

For example, given the following edges:

u	v	wt
1	2	2
2	3	3
3	1	5
First choose 1==> at weight 2. 1==> Next choose 2==> 3 at weight 3 . All nodes are connected without cycles for a total weight of 3+2=5.

Function Description

Complete the function in the editor below. It should return an integer that represents the total weight of the subtree formed.

kruskals has the following parameters:

g_nodes: an integer that represents the number of nodes in the tree

g_from: an array of integers that represent beginning edge node numbers

g_to: an array of integers that represent ending edge node numbers

g_weight: an array of integers that represent the weights of each edge

Input Format

The first line has two space-separated integers and , the number of nodes and edges in the graph.

The next lines each consist of three space-separated integers , and , where and denote the two nodes between which the undirected edge exists and denotes the weight of that edge.

Constraints

**Note: ** If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

Print a single integer denoting the total weight of the Really Special SubTree.




Solution:-
*/
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Kruskal_MST_Really_Special_Subtree {
    static class Edge implements Comparable<Edge> {
        int v, w, weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int from() {
            return v;
        }

        public int to() {
            return w;
        }

        public int weight() {
            return weight;
        }

        @Override
        public int compareTo(Edge that) {
            if (weight == that.weight) {
                if (v == that.v) return Integer.compare(w, that.w);
                return Integer.compare(v, that.v);
            }
            return Integer.compare(weight, that.weight);
        }
    }

    
    static Set<Edge> edges = new TreeSet<>();
    static int[] id;
    static int[] size;

    static int find(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    static void union(int v, int w) {
        int i = find(v);
        int j = find(w);
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = id[i];
            size[i] += size[j];
        }
    }

    static boolean connected(int v, int w) {
        return find(v) == find(w);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        id = new int[V + 1];
        size = new int[V + 1];
        for (int i = 0; i <= V; i++) id[i] = i;
       
        for (int i = 0; i < E; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), weight = sc.nextInt();
            edges.add(new Edge(Math.min(v, w), Math.max(v, w), weight));
        }
        int weightMST = 0;
        for (Edge e : edges) {
            if (!connected(e.v, e.w)) {
                union(e.v, e.w);
                weightMST += e.weight;
            }
        }
        System.out.println(weightMST);
    }
}
