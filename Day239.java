/*

Topic:- Rust & Murderer

Link:- https://www.hackerrank.com/challenges/rust-murderer/problem?isFullScreen=true
 
Problem:-

Detective Rust is investigating a homicide and he wants to chase down the murderer. The murderer knows he would definitely get caught if he takes the main roads for fleeing, so he uses the village roads (or side lanes) for running away from the crime scene.

Rust knows that the murderer will take village roads and he wants to chase him down. He is observing the city map, but it doesn’t show the village roads (or side lanes) on it and shows only the main roads.

The map of the city is a graph consisting N nodes (labeled 1 to N) where a specific given node S represents the current position of Rust and the rest of the nodes denote other places in the city, and an edge between two nodes is a main road between two places in the city. It can be suitably assumed that an edge that doesn’t exist/isn’t shown on the map is a village road (side lane). That means, there is a village road between two nodes a and b iff(if and only If) there is no city road between them.
In this problem, distance is calculated as number of village roads (side lanes) between any two places in the city.
Rust wants to calculate the shortest distance from his position (Node S) to all the other places in the city if he travels only using the village roads (side lanes).
Note: The graph/map of the city is ensured to be a sparse graph.
Input Format
The first line contains T, denoting the number of test cases. T testcases follow. First line of each test case has two integers N. denoting the number of cities in the map and M. denoting the number of roads in the map.
The next M lines each consist of two space-separated integers x and y denoting a main road between city a and city y. The last line has an integer S, denoting the current position of Rust.

Note

No nodes will have a road to itself.
There will not be multiple edges between any pair of nodes i.e. there is at most one undirected edge between them.
Graph is guaranteed to be sparse.
It is guranteed that there will be a path between any pair of nodes using the side lanes.
Output Format

For each of T test cases, print a single line consisting of N-1 space separated integers, denoting the shortest distances of the remaining N-1 places from Rust’s position (that is all distances, except the source node to itself) using the village roads/side lanes in ascending order based on vertex number.

Sample Input 0

2
4 3
1 2
2 3
1 4
1
4 2
1 2
2 3
2
Sample Output 0

3 1 2
2 2 1
Explanation 0

The graph in the first testcase can be shown as:

node is 1 (marked S).
The distance from 1 to 2 is 3. Path: 1 -> 3 -> 4 -> 2
The distance from 1 to 3 is 1. Path: 1 -> 3
The distance from 1 to 4 is 2. Path: 1 -> 3 -> 4




So.ution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t = 0; t < T; t++)
        {
            int N = input.nextInt();
            int M = input.nextInt();
            HashMap<Integer,HashSet<Integer>> cityMap = new HashMap<>();

            for(int i = 0; i < M; i++)
            {
                int source = input.nextInt();
                int target = input.nextInt();
                if(cityMap.containsKey(source)) cityMap.get(source).add(target);
                else 
                {
                    HashSet<Integer> roads = new HashSet<>(); roads.add(target);
                    cityMap.put(source, roads);
                }
                if(cityMap.containsKey(target)) cityMap.get(target).add(source);
                else 
                {
                    HashSet<Integer> roads = new HashSet<>(); roads.add(source);
                    cityMap.put(target, roads);
                }
            }
            
            int startingPoint = input.nextInt();
          
            int[] distances = BFS_Distance(startingPoint, cityMap, N);
         
            StringBuilder output = new StringBuilder("");
            for(int i = 0; i < distances.length; i++)
            {
                if(i+1 != startingPoint)
                    output.append(distances[i]+" ");
            }
            System.out.println(output);
        }
    }
    static int[] BFS_Distance(int root, HashMap<Integer,HashSet<Integer>> graph, int N)
    {
        int[] distances = new int[N];
        
        HashSet<Integer> notVisited = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 1; i <= N; i++) notVisited.add(i);
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(root);
        notVisited.remove(root);
        distances[0] = 0;
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            HashSet<Integer> neighbors = graph.get(curr);
                
            for(int nv : notVisited)
            {
                if(neighbors == null || !neighbors.contains(nv))
                {
                    queue.offer(nv);
                    distances[nv-1] = distances[curr-1]+1;
                    visited.add(nv);
                } 
            }
            notVisited.removeAll(visited);
            visited = new HashSet<>();
        }
        return distances;
    }
}
