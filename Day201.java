/*

Topic:- Poker Nim

Link:-https://www.hackerrank.com/challenges/poker-nim-1/problem?isFullScreen=true

Problem:-

Poker Nim is another -player game that's a simple variation on a Nim game. The rules of the games are as follows:

The game starts with  piles of chips indexed from  to . Each pile  (where ) has  chips.
The players move in alternating turns. During each move, the current player must perform either of the following actions:

Remove one or more chips from a single pile.
Add one or more chips to a single pile.
At least  chip must be added or removed during each turn.

To ensure that the game ends in finite time, a player cannot add chips to any pile  more than  times.
The player who removes the last chip wins the game.
Given the values of , , and the numbers of chips in each of the  piles, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Input Format

The first line contains an integer, , denoting the number of test cases.
Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

Two space-separated integers,  (the number of piles) and  (the maximum number of times an individual player can add chips to some pile ), respectively.
 space-separated integers, , where each  describes the number of chips at pile .

Output Format

For each test case, print the name of the winner on a new line (i.e., either  First or  Second ).



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
        int i,j,k,n;
        
        int nimsum;
        for(int tt =0;tt<t;tt++){
            n = in.nextInt();
            k = in.nextInt();
            for(i = 0;i<n;i++){
                s[i]=in.nextInt();
            }
            nimsum = s[0];
            for(i = 1;i<n;i++){
                nimsum^=s[i];
            }
            
            if (nimsum > 0) System.out.println("First");
            else System.out.println("Second");
        }
    }
}
