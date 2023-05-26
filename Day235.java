/*

Topic:- Jack goes to Rapture

Link:- https://www.hackerrank.com/challenges/jack-goes-to-rapture/problem?isFullScreen=true

Problem:-

Jack has just moved to a new city called Rapture. He wants to use the public public transport system. The fare rules are as follows:

Each pair of connected stations has a fare assigned to it regardless of direction of travel.
If Jack travels from station A to station B, he only has to pay the difference between (the fare from A to B) and (the cumulative fare paid to reach station A), [fare(A,B) – total fare to reach station A]. If the difference is negative, travel is free of cost from A to B.
Jack is low on cash and needs your help to figure out the most cost efficient way to go from the first station to the last station. Given the number of stations g_nodes (numbered from 1 to g_nodes), and the fares (weights) between the g_edges pairs of stations that are connected, determine the lowest fare from station 1 to station g_nodes.
Example
g_nodes 4
9 from [1,1,2,3]
g_to= [2, 3, 4, 4]
g_weight [20, 5, 30, 40]

Travel from station 1 →2→ 4 costs 20 for the first segment (12) then the cost
differential, an additional 30-20= 10 for the remainder. The total cost is 30.
Travel from station 134 costs 5 for the first segment, then an additional 40-5=35
for the remainder, a total cost of 40.
The lower priced option costs 30.
Function Description
Complete the getcost function in the editor below.
getCost has the following parameters:

int g nodes: the number of stations in the network
intg fromig edges]: end stations of a bidirectional connection
int g_toig edges]: g_from[i] is connected to g_to[i] at cost g_weight[i]
int g_weight[g edges]: the cost of travel between associated stations

Prints
-int or string: the cost of the lowest priced route from station 1 to station g_nodes or NO
PATH EXISTS. No return value is expected.

Input Format
The first line contains two space-separated integers, g_nodes and g_edges, the number of stations and the number of connections between them. Each of the next g edges lines contains three space-separated integers, g_from, g_to and g_weight, the connected stations and the fare between them.




Solution:-
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int edges = fr.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<edges;i++){
            int u = fr.nextInt()-1;
            int v = fr.nextInt()-1;
            int w = fr.nextInt();
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }
        long dis = dijkstraAlgorithm(graph);
        if(dis == Long.MAX_VALUE) output.write("NO PATH EXISTS\n");
        else output.write(dis+"\n");
        output.flush();
    }
    private static long dijkstraAlgorithm(List<List<int[]>> graph){
        int n = graph.size();
        long[] shortestDistance = new long[n];
        Arrays.fill(shortestDistance,Long.MAX_VALUE);
        shortestDistance[0] = 0L;
        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{0,0});
        while(!queue.isEmpty()){
            long[] current = queue.remove();
            int vertex = (int)current[0];
            long parentDistance = current[1];
            for(int[] edge: graph.get(vertex)){
                int child = edge[0];
                int child_weight = edge[1];
                long childDistance = parentDistance + Math.max(0,child_weight-parentDistance);
                if(shortestDistance[child] > childDistance){
                    shortestDistance[child] = childDistance;
                    queue.offer(new long[]{child,shortestDistance[child]});
                }
            }
        }
        return shortestDistance[n-1];
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
