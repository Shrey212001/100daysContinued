/*

Topic:- The Longest Common Subsequence

Link:- https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem?isFullScreen=true

Problem:-

A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. Longest common subsequence (LCS) of 2 sequences is a subsequence, with maximal length, which is common to both the sequences.

Given two sequences of integers, A = [a[1],a[2],..,a[n]] and B = [b[1],b[2],...,b[m]], find the longest common subsequence and print it as a line of space-separated integers. If there are multiple common subsequences with the same maximum length, print any one of them.

In case multiple solutions exist, print any of them. It is guaranteed that at least one non-empty common subsequence will exist.

Function Description

Complete the longestCommonSubsequence function in the editor below. It should return an integer array of a longest common subsequence.

longestCommonSubsequence has the following parameter(s):

a: an array of integers
b: an array of integers
Input Format

The first line contains two space separated integers n and m, the sizes of sequences A and B.
The next line contains n space-separated integers A[i].
The next line contains m space-separated integers B[j].

Constraints
1 <= n <= 100
1 <= m<= 100
0 <= a[i] < 1000, where i ∈ [1,n]
0 <= b[j] <= 1000, where j ∈ [1,m]

Constraints
1 <= n,m <= 100
0 <= a[i],b[j] <1000

Output Format

Print the longest common subsequence as a series of space-separated integers on one line. In case of multiple valid answers, print any one of them.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sizeM = s.nextInt();
        int sizeN = s.nextInt();
        int[] m = new int[sizeM];
        for (int i = 0; i < sizeM; i++) {
            m[i] = s.nextInt();
        }
        int[] n = new int[sizeN];
        for (int i = 0; i < sizeN; i++) {
            n[i] = s.nextInt();
        }
        System.out.println(LCS(m, n));
    }
    
    private static String LCS(int[] m, int[] n) {
        int[][] table = new int[m.length + 1][n.length + 1];
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                if (m[i - 1] == n[j - 1]) table[i][j] = table[i - 1][j - 1] + 1;
                else table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = m.length;
        int j = n.length;
        while (i > 0 && j > 0) {
            int s = table[i][j];
            int x = table[i - 1][j - 1];
            int y = table[i - 1][j];
            int z = table[i][j - 1];
            if (s > x && s > y && s > z) { 
                sb.insert(0, " " + m[i - 1]); i--; j--; 
            }
            else if (y > z) i--;
            else j--;
        }
        return sb.deleteCharAt(0).toString();
    }
}
