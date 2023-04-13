/*

Topic:- Maximizing XOR

Link:- https://www.hackerrank.com/challenges/maximizing-xor/problem?isFullScreen=true

Problem:-

Given two integers, l and r, find the maximal value of a xor b, written a+b, where a and b satisfy the following condition:
l <= a <= b <= r

For example, if l=11 and r=12, then
11 + 11 = 0
11 + 12 = 7
12 + 12 = 0

Our maximum value is 7.

Function Description

Complete the maximizingXor function in the editor below. It must return an integer representing the maximum value calculated.

maximizingXor has the following parameter(s):

l: an integer, the lower bound, inclusive
r: an integer, the upper bound, inclusive
Input Format

The first line contains the integer l.
The second line contains the integer r.

Constraints

1 <= l <= r <= 10^3

Output Format

Return the maximal value of the xor operations for all permutations of the integers from l to r, inclusive.





Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maxXor(int l, int r) {
        int max = 0;
        for(int i = l;i <= r;i++) {
            for(int j = l;j <= r;j++) {
                int a = i ^ j;
                max = Math.max(a, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
