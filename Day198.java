/*

Topic:- Introduction to Nim Game

Link:- https://www.hackerrank.com/challenges/nim-game-1/problem?isFullScreen=true

Problem:-

Nim is the most famous two-player algorithm game. The basic rules for this game are as follows:

The game starts with a number of piles of stones. The number of stones in each pile may not be equal.
The players alternately pick up  or more stones from  pile
The player to remove the last stone wins.
For example, there are  piles of stones having  stones in them. Play may proceed as follows:

Player  Takes           Leaving
                        pile=[3,2,4]
1       2 from pile[1]  pile=[3,4]
2       2 from pile[1]  pile=[3,2]
1       1 from pile[0]  pile=[2,2]
2       1 from pile[0]  pile=[1,2]
1       1 from pile[1]  pile=[1,1]
2       1 from pile[0]  pile=[0,1]
1       1 from pile[1]  WIN
Given the value of  and the number of stones in each pile, determine the game's winner if both players play optimally.

Function Desctription

Complete the nimGame function in the editor below. It should return a string, either First or Second.

nimGame has the following parameter(s):

pile: an integer array that represents the number of stones in each pile

Input Format

The first line contains an integer, , denoting the number of games they play.

Each of the next  pairs of lines is as follows:

The first line contains an integer , the number of piles.
The next line contains  space-separated integers , the number of stones in each pile.


Output Format

For each game, print the name of the winner on a new line (i.e., either First or Second).




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner s=new Scanner(System.in);
        int no=s.nextInt();
        int t=0;
        
        while(t<no)
        {
        int n=s.nextInt();
        int i=0;
        int x=0;
        for(i=0;i<n;i++)
        {
           int in=s.nextInt();
            x=x^in;
        }
        if(x>0)
        {
            System.out.println("First");
        }
        else
        {
            System.out.println("Second");
        }
        t++;
        }
        
    }
}
