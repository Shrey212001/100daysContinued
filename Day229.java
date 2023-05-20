/*

Topic:- Even Tree

Link:- https://www.hackerrank.com/challenges/even-tree/problem?isFullScreen=true

Problem:-

You are given a tree (a simple connected graph with no cycles). The tree has N nodes numbered from 1 to N.

Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of vertices.

Input Format:
The first line of input contains two integers N and M. N is the number of vertices, and M is the number of edges. 
The next M lines contain two integers ui and vi which specifies an edge of the tree.

Output Format:
Print the number of removed edge..

Constraints:
2 < N < 100
Sample Input:
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8

Sample Output:

2

Explanation:

On removing edges (1, 3) and (1, 6), we can get the desired result.




Solution:-
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {

    private static class Node<T> {
        private final List<Node<T>> childNodes = new ArrayList<>();
        
        private void addChildNode(Node<T> node) {
            this.childNodes.add(node);
        }
    }
   
    private static int[] decomposeTree(Node<Integer> node) {
        
        int count = 0, edgesToRemove = 0;
        for(Node<Integer> childNode : node.childNodes) {
           
            final int[] tmpMetadata = decomposeTree(childNode);
          
            edgesToRemove += tmpMetadata[1];
          
            if(tmpMetadata[0] % 2 == 0) {
                edgesToRemove++;
            } else {
                count += tmpMetadata[0];
            }
        }
        count++;
       
        return new int[]{count, edgesToRemove};
    }
    
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int M = in.nextInt();
        
        final Node<Integer>[] treeNodes = (Node<Integer>[]) new Node[N];
        for(int i = 0; i < M; i++) {
          
            final int node1 = in.nextInt() - 1;
            
            final int node2 = in.nextInt() - 1;
          
            treeNodes[node1] = (treeNodes[node1] == null ? new Node<Integer>() : treeNodes[node1]);
            treeNodes[node2] = (treeNodes[node2] == null ? new Node<Integer>() : treeNodes[node2]);
            
            if(node1 < node2) {
                treeNodes[node1].addChildNode(treeNodes[node2]);
            } else {
                treeNodes[node2].addChildNode(treeNodes[node1]);
            }
        }
        
        final int[] metadata = decomposeTree(treeNodes[0]);
    
        System.out.println(metadata[1]);
        
        in.close();
    }
}
