/*

Topic:- Nimble Game

Link:- https://www.hackerrank.com/challenges/nimble-game-1/problem?isFullScreen=true

Problem:-

Two people are playing Nimble! The rules of the game are:

The game is played on a line of  squares, indexed from  to . Each square  (where ) contains  coins. For example:

The players move in alternating turns. During each move, the current player must remove exactly  coin from square  and move it to square  if and only if .
The game ends when all coins are in square  and nobody can make a move. The first player to have no available move loses the game.
Given the value of  and the number of coins in each square, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Input Format

The first line contains an integer, , denoting the number of test cases.
Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

An integer, , denoting the number of squares.
 space-separated integers, , where each  describes the number of coins at square .
 
 
 
 
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
        int i,j,n;
        
        int nimsum;
        for(int tt =0;tt<t;tt++){
            n = in.nextInt();
            if( n==1 ) {
                n=in.nextInt();
                System.out.println("Second");
            } else {
                for(i = 0;i<n;i++){
                    s[i]=in.nextInt();
                }
                nimsum = 0;
                for(i = 1;i<n;i++){
                    nimsum^=(s[i]%2==1)?i:0;
                }

                if (nimsum > 0) System.out.println("First");
                else System.out.println("Second");
            }
        }
    }
}
