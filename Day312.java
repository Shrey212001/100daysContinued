/*

Topic:-Fun Game

Link:- https://www.hackerrank.com/challenges/fun-game-1/problem?isFullScreen=true 

Problem:-

Kyle and Mike are bored on a rainy day and decide to pass the time by creating a new game having the following rules:

The game starts with two -sized integer arrays,  and , and is played by two players,  and .
The players move in alternating turns, with  always moving first. During each move, the current player must choose an integer, , such that . If the current player is , then  receives  points; if the current player is , then  receives  points.
Each value of  can be chosen only once. That is, if a value of  is already chosen by some player, none of the player can re-use it. So, game always ends after  moves.
The player with the maximum number of points wins.
The arrays A and B are accessible to both the players P1 and P2. So the players make a optimal move at every turn.
Given the values of , , and , can you determine the outcome of the game? Print  if  will win,  if  will win, or  if they will tie. Assume both players always move optimally.

Input Format

The first line of input contains a single integer, , denoting the number of test cases. Each of the  subsequent lines describes a test case. A single test case is defined over the following three lines:

An integer, , denoting the number of elements in arrays  and .
 space-separated integers, , where each  describes the element at index  of array .
 space-separated integers, , where each  describes the element at index  of array .
Constraints

Output Format

For each test case, print one of the following predicted outcomes of the game on a new line:

Print  if  will win.
Print  if  will win.
Print  if the two players will tie.
Sample Input

3
3
1 3 4
5 3 1
2
1 1
1 1
2
2 2
3 3
Sample Output

First
Tie
Second
Explanation

Test Case 0: ,  The players make the following  moves:

 chooses  and receives  points.
 chooses  and receives  points. Note that  will not choose , because this would cause  to win.
 chooses  (which is the only remaining move) and receives  points.
As all  moves have been made, the game ends. 's score is  points and 's score is  points, so  is the winner and we print  on a new line.

Test Case 1: ,  Because both players will only make  move and all possible point values are , the players will end the game with equal scores. Thus, we print  on a new line.

Test Case 1: , 
Because both players will only make  move and all the possible point values for  are greater than all the possible point values for ,  will win the game. Thus, we print  on a new line.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int t=0; t<T; t++){
            int n = input.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int aScore = 0, bScore = 0;
            TreeSet<Pair> c = new TreeSet<>();
            
            for(int i=0; i<n; i++){
                a[i] = input.nextInt();
            }
            
            for(int i=0; i<n; i++){
                b[i] = input.nextInt();
                c.add(new Pair(a[i]+b[i], i));
            }
            
            int turn = 0;
            for(Pair p:c){
                if(turn == 0)
                    aScore += a[p.index];
                else
                    bScore += b[p.index];
                turn = 1 - turn;
            }
            if(aScore > bScore){
                System.out.println("First");
            }else if(aScore == bScore){
                System.out.println("Tie");
            }else{
                System.out.println("Second");
            }
            
        }
    }
    public static class Pair implements Comparable<Pair>{
        int sum;
        int index;
        
        Pair(int s, int i){
            this.sum = s;
            this.index = i;
        }
        
        @Override
        public int compareTo(Pair p){
            if(this.sum < p.sum){
                return 1;
            }else{
                return -1;
            }
        }
        
        public String toString(){
            return "{ s = "+sum+", i = "+index+" }";
        }
    }
}
