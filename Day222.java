/*

Topic:- Beautiful Quadruples

Link:- https://www.hackerrank.com/challenges/xor-quadruples/problem?isFullScreen=true

Problem:-

We call an quadruple of positive integers, , beautiful if the following condition is true:

Note:  is the bitwise XOR operator.

Given , , , and , count the number of beautiful quadruples of the form  where the following constraints hold:

When you count the number of beautiful quadruples, you should consider two quadruples as same if the following are true:

They contain same integers.
Number of times each integers occur in the quadruple is same.
For example  and  should be considered as same.

Input Format

A single line with four space-separated integers describing the respective values of A, B, C, and D.
Ezoicreport this ad




Solution :

*/import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        
        int[] m = new int[] {A, B, C, D};
        Arrays.sort(m);
        
        long[][] count = new long[3001][4096];
        
        for (int i=1; i<=m[0]; i++) {
            for (int j=i; j<=m[1]; j++) {
                count[j][i ^ j] ++;
            }
        }
        for (int i=0; i<4096; i++) {
            for (int j=1; j<=3000; j++) {
                count[j][i] += count[j-1][i];
            }
        }
        
        
        long[] sum = new long[3001];
        for (int j=1; j<=3000; j++) {
            for (int i=0; i<4096; i++) {
                sum[j] += count[j][i];
            }
        }
        
        long res=0;
        for (int i=1; i<=m[2]; i++) {
            for (int j=i; j<=m[3]; j++) {
                int x = i ^ j;
                res += sum[i] - count[i][i^j];
            }
        }
        System.out.println(res);
    }
}
