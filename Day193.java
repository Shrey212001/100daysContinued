/*

Topic:- Sum vs XOR

Link:- https://www.hackerrank.com/challenges/sum-vs-xor/problem?isFullScreen=true

Problem:-

Given an integer , find each  such that:
0 <= x <= n
n + x = n+x
where + denotes the bitwise XOR operator. Return the number of x's satisfying the criteria.

Example
n = 4
There are four values that meet the criteria:
4 + 0 = 4 + 0 = 4
4 + 1 = 4 + 1 = 5
4 + 2 = 4 + 2 = 6
4 + 3 = 4 + 3 = 7
Return 4.

Function Description

Complete the sumXor function in the editor below.

sumXor has the following parameter(s):
- int n: an integer

Returns
- int: the number of values found

Input Format

A single integer, n.

Constraints

0 <= n <= 10^15




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
        long n = in.nextLong();
        int zeroCount = 0;
        while (n>0) {
            if (n%2==0)
                zeroCount++;
            n/=2;
        }
        System.out.println(1l<<zeroCount);
    }
}
