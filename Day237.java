/*

Topic:- Jeanie's Route

Link:- https://www.hackerrank.com/challenges/jeanies-route/problem?isFullScreen=true

Problem:-

Byteland has N cities (numbered from 1 to N) and N-1 bidirectional roads. It is guaranteed that there is a route from any city to any other city.
Jeanie is a postal worker who must deliver K letters to various cities in Byteland. She can start and end her delivery route in any city. Given the destination cities for K letters and the definition of each road in Byteland, find and print the minimum distance Jeanie must travel to deliver all K letters.
Note: The letters can be delivered in any order.
Input Format
The first line contains two space-separated integers, N (the number of cities) and K (the number of letters), respectively.
The second line contains K space-separated integers describing the delivery city for each
letter.
Each line i of the N – 1 subsequent lines contains 3 space-separated integers describing a road as u, v, d, where d, is the distance (length) of the bidirectional road between cities u, and vi

Output Format

Print the minimum distance Jeanie must travel to deliver all K letters.

Sample Input 0

5 3
1 3 4
1 2 1
2 3 2
2 4 2
3 5 3
Sample Output 0

6




Solution:-
*/
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution{
    static boolean[] prune(int[][][] adj, boolean[] isLett){
    int n=adj.length;
    int[] degree=new int[n];
    for(int i=0;i<n;++i) degree[i]=adj[i].length;
    boolean[] rem=new boolean[n];
    Queue<Integer> q=new ArrayDeque<>();
    for(int i=0;i<n;++i){
        if(!isLett[i] && degree[i]==1) q.add(i);
    }
    while(!q.isEmpty()){
        int leaf=q.remove();
        rem[leaf]=true;
        for(int[] edge: adj[leaf]){
        int node=edge[0];
        if(isLett[node]) break;
        else if(!rem[node]){
            if(--degree[node] == 1){
            q.add(node);
            break;
            }
        }
        }
    }
    return rem;
    }
    static int[] bfs(int[][][] adj, boolean[] rem, int source){
    int n=adj.length, unvis=-1;
    int[] dist=new int[n];
    for(int i=0;i<n;++i) dist[i]=unvis;
    Queue<Integer> q=new ArrayDeque<>();
    q.add(source);
    dist[source]=0;
    int best=0, total=0;
    while(!q.isEmpty()){
        int x=q.remove();
        for(int[] edge: adj[x]){
        int to=edge[0];
        if(!rem[to] && dist[to]==unvis){
            int weight=edge[1];
            total+=weight;
            q.add(to);
            dist[to]=dist[x]+weight;
            if(dist[to]>dist[best]) best=to;
        }
        }
    }
    int[] result={total,dist[best],best};
    return result;
    }
    static int solve(int[][][] adj, int[] lett){
    boolean[] isLett=new boolean[adj.length];
    for(int i: lett) isLett[i]=true;    
    boolean[] rem=prune(adj,isLett);
    int[] result=bfs(adj,rem,lett[0]);
    int totalWeight=result[0], sink=result[2];
    result=bfs(adj,rem,sink);
    int diameter=result[1];
    return 2*totalWeight-diameter;
    }
    static int[][][] weightedAdjacency(int n, int[] from, int[] to, int[] d){
    int[] count=new int[n];
    for(int f: from) ++count[f];
    for(int t: to) ++count[t];
    int[][][] adj=new int[n][][];
    for(int i=0;i<n;++i) adj[i]=new int[count[i]][];
    for(int i=0;i<from.length;++i){
        adj[from[i]][--count[from[i]]]=new int[]{to[i],d[i]};
        adj[to[i]][--count[to[i]]]=new int[]{from[i],d[i]};
    }
    return adj;
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt(), k=sc.nextInt();
    int[] lett=new int[k];
    for(int i=0;i<k;++i) lett[i]=sc.nextInt()-1;
    int[] from=new int[n-1], to=new int[n-1], d=new int[n-1];
    for(int i=0;i<n-1;++i){
        from[i]=sc.nextInt()-1;
        to[i]=sc.nextInt()-1;
        d[i]=sc.nextInt();
    }
    sc.close();
    int[][][] adj=weightedAdjacency(n,from,to,d);
    System.out.println(solve(adj,lett));
    }
}
