/*

Topic:- Tower Breakers, Revisited!

Link:- https://www.hackerrank.com/challenges/tower-breakers-revisited-1/problem?isFullScreen=true

Problem:-

Two players (numbered  and ) are playing a game of Tower Breakers! The rules of the game are as follows:

Player  always moves first, and both players always move optimally.
Initially there are  towers of various heights.
The players move in alternating turns. In each turn, a player can choose a tower of height  and reduce its height to , where  and  evenly divides .
If the current player is unable to make any move, they lose the game.
Given the value of  and the respective height values for all towers, can you determine who will win? If the first player wins, print ; otherwise, print .

Input Format

The first line contains an integer, , denoting the number of test cases.
Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

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

Test Case 0:
Player  reduces the second tower to height  and subsequently wins.

Test Case 1:
There are two possible moves:

Reduce the second tower to 
Reduce the third tower to .
Whichever move player  makes, player  will make the other move. Thus, player  wins.




Solution:-
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int q = 0;
            while(n-- > 0){
                int sum = getPrimeFactor(sc.nextInt(), 0);
                q = q^sum;
            }
            if(q==0){System.out.println("2");}
            else{System.out.println("1");}
        }
    }
    public static int getPrimeFactor(int num, int sum){
        while(num%2==0){
            sum = sum+1;
            num = num/2;
        }
        for(int i=3;i<=Math.sqrt(num); i=i+2){
            while(num%i==0){
                sum = sum +1;
                num = num/i;
            }
        }
        if(num>2)
            sum++;
        return sum;
    }
}
