/*

Topic:- Snakes and Ladders: The Quickest Way Up

Link:- https://www.hackerrank.com/challenges/the-quickest-way-up/problem?isFullScreen=true

Problem:-

Markov takes out his Snakes and Ladders game, stares at the board and wonders: "If I can always roll the die to whatever number I want, what would be the least number of rolls to reach the destination?"

Rules The game is played with a cubic die of  faces numbered  to .

Starting from square , land on square  with the exact roll of the die. If moving the number rolled would place the player beyond square , no move is made.

If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.

If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.

Function Description

Complete the quickestWayUp function in the editor below. It should return an integer that represents the minimum number of moves required.

quickestWayUp has the following parameter(s):

ladders: a 2D integer array where each  contains the start and end cell numbers of a ladder
snakes: a 2D integer array where each  contains the start and end cell numbers of a snake
Input Format

The first line contains the number of tests, .

For each testcase: 
- The first line contains , the number of ladders. 
- Each of the next  lines contains two space-separated integers, the start and end of a ladder. 
- The next line contains the integer , the number of snakes. 
- Each of the next  lines contains two space-separated integers, the start and end of a snake.

Constraints 

The board is always  with squares numbered  to . 
Neither square  nor square  will be the starting point of a ladder or snake. 
A square will have at most one endpoint from either a snake or a ladder.

Output Format

For each of the t test cases, print the least number of rolls to move from start to finish on a separate line. If there is no solution, print -1.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        int M,N;
        for (int i = 0; i < T; i++){
            N = sc.nextInt();
            
            HashMap<Integer,Integer> ladders = new HashMap<>();
            int start, end;
            for (int j = 0; j < N; j++){
                start = sc.nextInt();
                end = sc.nextInt();
                ladders.put(start,end);
            }
            
            HashMap<Integer,Integer> snakes = new HashMap<>();
            M = sc.nextInt();
            for (int j = 0; j < M; j++){
                start = sc.nextInt();
                end = sc.nextInt();
                snakes.put(start, end);
            }
            
            int[] distances = new int[100];
            for (int j = 0; j < 100; j++){
                distances[j] = Integer.MAX_VALUE;
            }
            
            getShortestPathToEnd(getGameGraph(ladders, snakes), 1, distances, 0);
            
            System.out.println(distances[99] == Integer.MAX_VALUE ? -1 : distances[99]);
        }
    }
    
    private static int getShortestPathToEnd(HashMap<Integer,HashSet<Integer>> graph, int start, int[] distances, int depth){
       if (distances[start-1] > depth){
           distances[start-1] = depth;
       }
       else{
           return 0;
       }
        
       if (!graph.get(start).isEmpty()){
           for (Integer child : graph.get(start)){
               getShortestPathToEnd(graph, child, distances, depth + 1);
           }
            
           return 0;
       }
       else{
           return -1;
       }
    }
    
    private static HashMap<Integer,HashSet<Integer>> getGameGraph(HashMap<Integer,Integer> ladders, HashMap<Integer,Integer> snakes){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        
        HashSet<Integer> neighbours;
        for (int i = 1; i <= 100; i++){
            neighbours = new HashSet<Integer>();
            for (int j = 1; j <= 6 && (i + j <= 100); j++){
                if(ladders.containsKey(i+j)){
                    neighbours.add(ladders.get(i+j));
                }
                else if (snakes.containsKey(i+j)){
                    neighbours.add(snakes.get(i+j));
                }
                else{
                    neighbours.add(i+j);
                }
            }
            graph.put(i, neighbours);
        }
        
        return graph;
    }
}
