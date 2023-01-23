/*
Topic:- Jumping on the Clouds

Link:- https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true

Problem:-
There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.

For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.

Function Description

Complete the jumpingOnClouds function in the editor below.

jumpingOnClouds has the following parameter(s):

int c[n]: an array of binary integers

Returns

int: the minimum number of jumps required

Input Format

The first line contains an integer n, the total number of clouds. The second line contains n space-separated binary integers describing clouds c[ i ] where 0  <=  i  < n.

Constraints

2  <=  n  <=   100

Output Format

Print the minimum number of jumps needed to win the game.

Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rounds = input.nextInt();
        int[] ar = new int[rounds];
        int i = 0;
        for(i = 0; i < rounds; i++)
            ar[i] = input.nextInt();
        int count = 0;
        i = 0;
        while(i != rounds-1)
        {
            if(i != ar.length - 2 && ar[i+2] == 0)
                i+=2;
            else
                i++;
            count++;
        }    
        System.out.println(count);
    }
}
         
