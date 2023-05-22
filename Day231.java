/*

Topic:- The Story of a Tree

Link:- https://www.hackerrank.com/challenges/the-story-of-a-tree/problem?isFullScreen=true

Problem:-

One day Bob drew a tree, T, with n nodes and n – 1 edges on a piece of paper. He soon discovered that parent of a node depends on the root of the tree.

Learning the fact, Bob invented an exciting new game and decided to play it with Alice. The rules of the game is described below:

Bob picks a random node to be the tree’s root and keeps the identity of the chosen node a secret from Alice. Each node has an equal probability of being picked as the root.
Alice then makes a list of g guesses, where each guess is in the form u v and means Alice guesses that parent(v) = u is true. It’s guaranteed that an undirected edge connecting u and v exists in the tree.
For each correct guess, Alice earns one point. Alice wins the game if she earns at least k points (i.e., at least k of her guesses were true).
Alice and Bob play a games. Given the tree, Alice’s guesses, and the value of k for each game, find the probability that Alice will win the game and print it on a new line as a reduced fraction in the format p/q.
Input Format
The first line contains an integer, q, denoting the number of different games. The subsequent lines describe each game in the following format:

The first line contains an integer, n, denoting the number of nodes in the tree.
Then – 1 subsequent lines contain two space-separated integers, u and v, defining an undirected edge between nodes u and v.
The next line contains two space-separated integers describing the respective values of g (the number of guesses) and k (the minimum score needed to win).
Each of the g subsequent lines contains two space-separated integers, u and v. indicating Alice guesses parent(v) = u.
Sample Input 0

2
4
1 2
1 3
3 4
2 2
1 2
3 4
3
1 2
1 3
2 2
1 2
1 3
Sample Output 0

1/2
1/3
Explanation 0
Alice and Bob play the following g = 2 games:

Alice makes two guesses, (1 2) and (3 4), meaning she guessed that parent(2) = 1 and parent (4) = 3. To win the game, at least k = 2 of her guesses must be true. In the diagrams below, you can see that at least 2 guesses are true if the root of the tree is either node 1 or 3:
There are 4 nodes in total and the probability of picking node 1 or 3 as the root is 2, which reduces to 1/2

In this game, Alice only wins if node 1 is the root of the tree. There are 3 nodes in total, and the probability of picking node 1 as the root is 1/3




Solution:-
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    
    static int N, K;
    static int num;
    static LinkedList<Integer>[] adj;
    static HashSet<Integer>[] outdegree;
    static HashSet<Integer>[] indegree;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        
        for (int Q = 0; Q < q; Q++) {
            N = input.nextInt();
            num = 0;
            adj = new LinkedList[N]; outdegree = new HashSet[N]; indegree = new HashSet[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new LinkedList<Integer>();
                outdegree[i] = new HashSet<Integer>();
                indegree[i] = new HashSet<Integer>();
            }
            for (int i = 0; i < N - 1; i++) {
                int v = input.nextInt() - 1;
                int w = input.nextInt() - 1;
                adj[v].add(w);
                adj[w].add(v);
            }
            int g = input.nextInt();
            K = input.nextInt();
            for (int G = 0; G < g; G++) {
                int u = input.nextInt() - 1;
                int v = input.nextInt() - 1;
                indegree[u].add(v);
                outdegree[v].add(u);
            }
            
            int v = 0;
            walk(v, new boolean[N], init(v));
            int gcd = GCD(N, num);
            System.out.println((num / gcd) + "/" + (N / gcd));
        }
    }
    
    static int GCD(int a, int b) {
        if (a < b)
            return GCD(b, a);
        if (b == 0)
            return a;
        else
            return GCD(b, a % b);
    }
    
    static void walk(int v, boolean[] visited, int amount) {
        visited[v] = true;
        if (amount >= K) num++;
        for (int w : adj[v]) {
            if (!visited[w]) {
                int temp = amount;
                if (indegree[v].contains(w)) temp--;
                if (outdegree[v].contains(w)) temp++;
                walk(w, visited, temp);
            }
        }
    }
    
    static int init(int v) {
        return dfs(v, new boolean[N]);
    }
    
    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int k = 0;
        for (int w : adj[v]) {
            if (!visited[w]) {
                k += dfs(w, visited);
                if (indegree[v].contains(w)) k++;
            }
        }
        return k;
    }
}
