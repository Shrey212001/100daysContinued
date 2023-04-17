/*

Topic:- Tower Breakers

Link:- https://www.hackerrank.com/challenges/tower-breakers-1/problem?isFullScreen=true

Problem:-

Two players are playing a game of Tower Breakers! Player  always moves first, and both players always play optimally.The rules of the game are as follows:

Initially there are  towers.
Each tower is of height .
The players move in alternating turns.
In each turn, a player can choose a tower of height  and reduce its height to , where  and  evenly divides .
If the current player is unable to make a move, they lose the game.
Given the values of  and , determine which player will win. If the first player wins, return . Otherwise, return .

Function Description

Complete the towerBreakers function in the editor below.

towerBreakers has the following paramter(s):

int n: the number of towers
int m: the height of each tower
Returns

int: the winner of the game


Input Format

The first line contains a single integer , the number of test cases.
Each of the next  lines describes a test case in the form of  space-separated integers,  and .




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int numPrimeFactors(int n) {
        int answer = 0;
        for (int i=2; i<=n; i++) {
            if (n%i == 0) {
                answer++;
                n /= i;
                i = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 1) {
                System.out.println(2);
                continue;
            }
            if (n%2 == 0) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
            
        }
        
    }
}
