/*

Topic:- Stock Maximize

Link:- https://www.hackerrank.com/challenges/stockmax/problem?isFullScreen=true

Problem:-

Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next number of days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

Example
prices = [1,2]
Buy one share day one, and sell it day two for a profit of 1. Return 1.
prices = [2,1]
No profit can be made so you do not buy or sell stock those days. Return 0.

Function Description

Complete the stockmax function in the editor below.

stockmax has the following parameter(s):

prices: an array of integers that represent predicted daily stock prices
Returns

int: the maximum profit achievable
Input Format

The first line contains the number of test cases t.

Each of the next t pairs of lines contain:
- The first line contains an integer n, the number of predicted prices for WOT.
- The next line contains n space-separated integers prices[i], each a predicted stock price for day i.

Constraints
1 <= t <= 10
1 <= n <= 5000
1 <= prices[i]  <= 100000

Output Format

Output t lines, each containing the maximum profit which can be obtained for the corresponding test case.




Solution:-
*/
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t=0; t<T; t++) {
            int N = input.nextInt();
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = input.nextInt();
            }
            boolean[] buy = new boolean[N];
            int max = A[N-1];
            for (int n=N-2; n>=0; n--) {
                int value = A[n];
                if (value > max) {
                    max = value;
                } else {
                    buy[n] = true;
                }
            }
            long money = 0;
            long stock = 0;
            for (int n=0; n<N; n++) {
                if (buy[n]) {
                    money -= A[n];
                    stock++;
                } else {
                    money += stock*A[n];
                    stock = 0;
                }
            }
            System.out.println(money);
        }
    }
    
}
