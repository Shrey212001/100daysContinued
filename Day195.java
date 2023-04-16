/*

Topic:- Game of Stones

Link:- https://www.hackerrank.com/challenges/game-of-stones-1/problem?isFullScreen=true

Problem:-

Two players called  and  are playing a game with a starting number of stones. Player  always plays first, and the two players move in alternating turns. The game's rules are as follows:

In a single move, a player can remove either , , or  stones from the game board.
If a player is unable to make a move, that player loses the game.
Given the starting number of stones, find and print the name of the winner.  is named First and  is named Second. Each player plays optimally, meaning they will not make a move that causes them to lose the game if a winning move exists.

For example, if ,  can make the following moves:

 removes  stones leaving .  will then remove  stones and win.
 removes  stones leaving .  cannot move and loses.
 would make the second play and win the game.

Function Description

Complete the gameOfStones function in the editor below. It should return a string, either First or Second.

gameOfStones has the following parameter(s):

n: an integer that represents the starting number of stones

Input Format

The first line contains an integer , the number of test cases.
Each of the next  lines contains an integer , the number of stones in a test case.

Output Format

On a new line for each test case, print First if the first player is the winner. Otherwise print Second.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int no_of_testcases=Integer.parseInt(br.readLine());
        while(no_of_testcases-->0){
            int number=Integer.parseInt(br.readLine());
            if(number%7==0 || number%7==1){
                System.out.println("Second");
            }
            else{
                System.out.println("First");
            }
        }
    }
}
