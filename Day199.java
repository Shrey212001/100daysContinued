/*

Topic:- Misère Nim

Link:- https://www.hackerrank.com/challenges/misere-nim-1/problem?isFullScreen=true 

Problem:-

Two people are playing game of Misère Nim. The basic rules for this game are as follows:

The game starts with  piles of stones indexed from  to . Each pile  (where ) has  stones.
The players move in alternating turns. During each move, the current player must remove one or more stones from a single pile.
The player who removes the last stone loses the game.
Given the value of  and the number of stones in each pile, determine whether the person who wins the game is the first or second person to move. If the first player to move wins, print First on a new line; otherwise, print Second. Assume both players move optimally.

There is no permutation of optimal moves where player 2 wins. For example, player 1 chooses the first pile. If player 2 chooses 1 from another pile, player 1 will choose the pile with 2 left. If player 2 chooses a pile of 2, player 1 chooses 1 from the remaining pile leaving the last stone for player 2. Return First.

Function Description

Complete the misereNim function in the editor below.

misereNim has the following parameters:

int s[n]: the number of stones in each pile

Returns

string: either First or Second

Input Format

The first line contains an integer, , the number of test cases.
Each test case is described over two lines:

An integer, , the number of piles.
 space-separated integers, , that describe the number of stones at pile .
 
 
 
 Solution:-
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] s = new int[100];
        int i,j,n, max;
        
        int nimsum;
        for(int tt =0;tt<t;tt++){
            n = in.nextInt();
            max = 0;
            for(i = 0;i<n;i++){
                s[i]=in.nextInt();
                max = Math.max(s[i], max);
            }
            
            nimsum = s[0];
            for(i = 1;i<n;i++){
                nimsum^=s[i];
            }
            
            if (max==1 && nimsum == 1 || max>1 && nimsum==0) System.out.println("Second");
            else System.out.println("First");
        }
    }
}
