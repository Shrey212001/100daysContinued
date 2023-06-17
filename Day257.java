/*

Topic:- Abbreviation
 
Link:- https://www.hackerrank.com/challenges/abbr/problem?isFullScreen=true

Problem:-

You can perform the following operations on the string, a:

1.Capitalize zero or more of a's lowercase letters.
2.Delete all of the remaining lowercase letters in a.
Given two strings, a and b, determine if it's possible to make a equal to b as described. If so, print YES on a new line. Otherwise, print NO.

For example, given a = AbcDE and b = ABDE, in a we can convert b and delete c to match b. If a = AbcDE and b = AFDE, matching is not possible because letters may only be capitalized or discarded, not changed.

Function Description

Complete the function abbreviation in the editor below. It must return either YES or NO.

abbreviation has the following parameter(s):

a: the string to modify
b: the string to match
Input Format

The first line contains a single integer q, the number of queries.

Each of the next q pairs of lines is as follows:
- The first line of each query contains a single string, a.
- The second line of each query contains a single string, b.

Constraints

1 <= q <= 10
1 <= |a|,|b| <= 1000
String a consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String b consists only of uppercase English letters, ascii[A-Z].
Output Format

For each query, print YES on a new line if it's possible to make string a equal to string b. Otherwise, print NO.




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
        int q = sc.nextInt();
        sc.nextLine();
        for (int z = 0; z < q; z++) {
            char[] a = sc.nextLine().toCharArray();
            char[] b = sc.nextLine().toCharArray();
            boolean[][] dp = new boolean[a.length+1][b.length+1];
            for (int i = 0; i <= a.length; i++)
            dp[i][0] = true;
            for (int i = 1; i <= a.length; i++) {
                if (a[i-1]>='A'&&a[i-1]<='Z') {
                    for (int j = 1; j <= b.length; j++) {
                        if (b[j-1]==a[i-1])
                            dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    char c = (char)(a[i-1]-32);
                    for (int j = 1; j <= b.length; j++) {
                        if (b[j-1]==c)
                            dp[i][j] = dp[i-1][j-1];
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[a.length][b.length]?"YES":"NO");
        }
    }
}
