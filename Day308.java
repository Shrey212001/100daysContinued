/*

Topic:- Tower Breakers, Again!

Link:- https://www.hackerrank.com/challenges/tower-breakers-again-1/problem?isFullScreen=true

Problem:-

Two players (numbered  and ) are playing a game of Tower Breakers! The rules of the game are as follows:

Player  always moves first.
Initially there are  towers of various heights.
The players move in alternating turns. In each turn, a player must choose a tower of height  and break it down into  towers, each of height . The numbers  and  must satisfy  and .
If the current player is unable to make any move, they lose the game.
Given the value of  and the respective height values for all towers, can you determine who will win, assuming both players always move optimally? If the first player wins, print ; otherwise, print .

Input Format

The first line contains an integer, , denoting the number of test cases.
The  subsequent lines define the test cases. Each test case is described by two lines:

An integer, , denoting the number of towers.
 space-separated integers, , where each  describes the height of tower .
Constraints

Output Format

For each test case, print a single integer denoting the winner (i.e., either  or ) on a new line.

Sample Input

2
2 
1 2
3 
1 2 3

Sample Output

1
2

Explanation

In the first test case, the first player simply breaks down the second tower of height  into two towers of height  and wins.

In the second test case, there are only two possible moves:

Break the second tower into  towers of height .
Break the third tower into  towers of height .
Whichever move player  makes, player  can make the other move and win the game.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

       static int countOddPrimeFactor(int num) {
        int count = 0;
        if (num % 2 == 0) count++;
        
        while (num % 2 == 0) {
            num /= 2;
        }
        for (int i = 3; i*i <= num; i++) {
            while (num % i == 0) {
                num /= i;
                if (i % 2 != 0) count++;
            }
        }
        if (num > 2) count++;
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int nim = 0;
            for (int j = 0; j < m; j++) {
                int k = in.nextInt();
                nim ^= countOddPrimeFactor(k);
            }
            if (nim == 0)
                System.out.println("2");
            else
                System.out.println("1");
        }
    }
}
