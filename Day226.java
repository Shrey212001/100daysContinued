/*

Topic:- Synchronous Shopping

Link:- https://www.hackerrank.com/challenges/synchronous-shopping/problem?isFullScreen=true

Problem:-

Bitville is a seaside city that has a number of shopping centers connected by bidirectional roads, each of which has a travel time associated with it. Each of the shopping centers may have a fishmonger who sells one or more kinds of fish. Two cats, Big Cat and Little Cat, are at shopping center  (each of the centers is numbered consecutively from  to ). They have a list of fish they want to purchase, and to save time, they will divide the list between them. Determine the total travel time for the cats to purchase all of the types of fish, finally meeting at shopping center . Their paths may intersect, they may backtrack through shopping center , and one may arrive at a different time than the other. The minimum time to determine is when both have arrived at the destination.

For example, there are  shopping centers selling  types of fish. The following is a graph that shows a possible layout of the shopping centers connected by  paths. Each of the centers is labeled . Here  and  represent Big Cat and Little Cat, respectively. In this example, both cats take the same path, i.e.  and arrive at time  having purchased all three types of fish they want. Neither cat visits shopping centers  or.

Function Description

Complete the shop function in the editor below. It should return an integer that represents the minimum time required for their shopping.

shop has the following parameters:
– n: an integer, the number of shopping centers
– k: an integer, the number of types of fish
– centers: an array of strings of space-separated integers where the first integer of each element is the number of types of fish sold at a center and the remainder are the types sold
– roads: a 2-dimensional array of integers where the first two values are the shopping centers connected by the bi-directional road, and the third is the travel time for that road

Input Format

The first line contains  space-separated integers:  (the number of shopping centers),  (the number of roads), and  (the number of types of fish sold in Bitville), respectively.

Each line  of the  subsequent lines () describes a shopping center as a line of space-separated integers. Each line takes the following form:

The first integer, , denotes the number of types of fish that are sold by the fishmonger at the  shopping center.
Each of the  subsequent integers on the line describes a type of fish sold by that fishmonger, denoted by , where  going forward.
Each line  of the  subsequent lines () contains  space-separated integers that describe a road. The first two integers,  and , describe the two shopping centers it connects. The third integer, , denotes the amount of time it takes to travel the road.

Output Format

Print the minimum amount of time it will take for the cats to collectively purchase all  fish and meet up at shopping center .

Sample Input

5 5 5
1 1
1 2
1 3
1 4
1 5
1 2 10
1 3 10
2 4 10
3 5 10
4 5 10
Sample Output

30
Explanation

 represents a location Big Cat visits,  represents a location where Little Cat visits.

Big Cat can travel  and buy fish at all of the shopping centers on his way.

Little Cat can then travel , and buy fish from the fishmonger at the  shopping center only.




Solution:-
*/

import java.io.*;
import java.util.*;


public class Result {
    static class Node {
        int label, time, status;
        public Node(int label, int time, int status) {
            this.label = label;
            this.time = time;
            this.status = status;
        }
    }
    
    private static int minTime(int n, int k, int[] sale, List<List<Node>> graph) {
        int[][] time = new int[1 << k][n];
        for (int[] t : time) Arrays.fill(t, Integer.MAX_VALUE);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return n1.time - n2.time;
            }
        });
        minHeap.offer(new Node(0, 0, sale[0]));
        time[sale[0]][0] = 0;
        List<Node> candidates = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (cur.label == n - 1) candidates.add(cur);
            for (Node node : graph.get(cur.label)) {
                int newStatus = (cur.status | sale[node.label]);
                if (cur.time + node.time < time[newStatus][node.label]) {
                    time[newStatus][node.label] = cur.time + node.time;
                    minHeap.offer(new Node(node.label, cur.time + node.time, newStatus));
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < candidates.size(); i++) {
            Node cur = candidates.get(i);
            for (int j = i; j < candidates.size(); j++) {
                Node another = candidates.get(j);
                if ((cur.status | another.status) == (1 << k) - 1) {
                    min = Math.min(min, Math.max(cur.time, another.time));
                }
            }
        }
        return min;
    }
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String nmk = SCANNER.nextLine();
        String[] nmkVals = nmk.split(" ");
        int n = Integer.valueOf(nmkVals[0]), m = Integer.valueOf(nmkVals[1]), k = Integer.valueOf(nmkVals[2]);
        
        int[] sale = new int[n];
        for (int i = 0; i < n; i++) {
            String items = SCANNER.nextLine();
            String[] types = items.split(" ");
            for (int j = 1; j < types.length; j++) {
                sale[i] |= (1 << (Integer.valueOf(types[j]) - 1));
            }
        }
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            String edge = SCANNER.nextLine();
            String[] detail = edge.split(" ");
            int n1 = Integer.valueOf(detail[0]) - 1, n2 = Integer.valueOf(detail[1]) - 1, t = Integer.valueOf(detail[2]);
            graph.get(n1).add(new Node(n2, t, 0));
            graph.get(n2).add(new Node(n1, t, 0));
        }
        
        System.out.print(minTime(n, k, sale, graph));
    }
}
