/*

Topic:- The Great XOR

Link:- https://www.hackerrank.com/challenges/the-great-xor/problem?isFullScreen=true

Problem:-

Given a long integer x, count the number of values of a satisfying the following conditions:
a + x > x
0 < a < x
where a and x are long integers and ^ is the bitwise XOR operator.

You are given q queries, and each query is in the form of a long integer denoting x. For each query, print the total number of values of a satisfying the conditions above on a new line.

For example, you are given the value x=5. Condition 2 requires that a<x. The following tests are run:

1^5 = 4
 ^ 5 = 7
3 ^ 5 = 6
4 ^ 5 =1

We find that there are 2 values meeting the first condition: 2 and 3.

Function Description

Complete the theGreatXor function in the editor below. It should return an integer that represents the number of values satisfying the constraints.

theGreatXor has the following parameter(s):

x: an integer
Input Format

The first line contains an integer q, the number of queries.
Each of the next q lines contains a long integer describing the value of x for a query.

Constraints
1 <= q <= 10^5
1 <= x <= 10^10




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
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long b = 1;
            long total = 0;
            while(b < x) {
                if((b & x) == 0) {
                    total += b;
                }
                b = b * 2;
            }
            System.out.println(total);
        }
    }
}
