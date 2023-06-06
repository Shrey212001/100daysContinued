/*

Topic:- The Coin Change Problem

Link:- https://www.hackerrank.com/challenges/coin-change/problem?isFullScreen=true

Problem:-

Given an amount and the denominations of coins available, determine how many ways change can be made for amount. There is a limitless supply of each coin type.

Example
n = 3
c = [8,3,1,2]
There are 3 ways to make change for n=3: {1,1,1}, {1,2}, and {3}.

Function Description

Complete the getWays function in the editor below.

getWays has the following parameter(s):

   int n: the amount to make change for
   int c[m]: the available coin denominations

Returns

   int: the number of ways to make change

Input Format

The first line contains two space-separated integers n and m, where:
n is the amount to change
m is the number of coin types
The second line contains m space-separated integers that describe the values of each coin type.

Constraints

   1 <= c[i] <= 50
   1 <= n <= 250
   1 <= m <= 50
   Each c[i] is guaranteed to be distinct.
   
   
   
   
Solution:-
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
  public static long getWays(int n, List<Long> c) {
   long[][] dp = new long[c.size()+1][n+1];
        int m = c.size();
        for(int j=0;j<=n;j++){
            dp[0][j]  = 0; 
        }
        for(int i=0;i<=m;i++){
            dp[i][0]  = 1; 
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                
                if(c.get(i-1).intValue()>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] =  dp[i-1][j] + dp[i][j-c.get(i-1).intValue()];
                }
            }
        }
        return dp[m][n];
    }
   }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());
       long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
