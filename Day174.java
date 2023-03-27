/*

Topic:- Ice Cream Parlor

Link:- https://www.hackerrank.com/challenges/icecream-parlor/problem?isFullScreen=true

Problem:-


Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.

Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.

Example.  

The two flavors that cost  and  meet the criteria. Using -based indexing, they are at indices  and .

Function Description

Complete the icecreamParlor function in the editor below.

icecreamParlor has the following parameter(s):

int m: the amount of money they have to spend
int cost[n]: the cost of each flavor of ice cream
Returns

int[2]: the indices of the prices of the two flavors they buy, sorted ascending

Input Format

The first line contains an integer, , the number of trips to the ice cream parlor. The next  sets of lines each describe a visit.

Each trip is described as follows:

The integer , the amount of money they have pooled.
The integer , the number of flavors offered at the time.
 space-separated integers denoting the cost of each flavor: .
Note: The index within the cost array represents the flavor of the ice cream purchased.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for(int k = 0; k < n; k++){
            int C = sc.nextInt();
            int P = sc.nextInt();
            int [] p = new int[P+1];
        
            for(int i = 1; i <= P;i++)p[i] = sc.nextInt();
        
            for(int i = 1; i <= P; i++){
                for(int j = i+1; j <= P; j++){
                    if(p[i]+p[j] == C){
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
