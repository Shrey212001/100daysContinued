/*

Topic:- LCS Returns

Link:- https://www.hackerrank.com/challenges/tutzki-and-lcs/problem?isFullScreen=true

Problem:-

Given two strings, a and b, find and print the total number of ways to insert a character at any position in string a such that the length of the Longest Common Subsequence of characters in the two strings increases by one.

Input Format

The first line contains a single string denoting a.
The second line contains a single string denoting b.

Constraints

Scoring

1 <= |a|,|b| <= 5000
Strings a and b are alphanumeric (i.e., consisting of arabic digits and/or upper and lower case English letters).
The new character being inserted must also be alphanumeric (i.e., a digit or upper/lower case English letter).

Subtask

1 <= |a|,|b| <= 1000 for 66.7% of the maximum score.
Output Format

Print a single integer denoting the total number of ways to insert a character into string a in such a way that the length of the longest common subsequence of a and b increases by one.




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
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n+2][m+2];
        int[][] dp2 = new int[n+2][m+2];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int r = dp[n][m], ans = 0;
        
        for (int i=n; i>=1; i--) {
            for (int j=m; j>=1; j--) {
                if (a[i-1] == b[j-1]) {
                    dp2[i][j] = dp2[i+1][j+1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i][j+1], dp2[i+1][j]);
                }
            }
        }
        
        for (int i=0; i<=n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j=1; j<=m; j++) if (!set.contains(b[j-1])) {
                int v = dp[i][j-1] + dp2[i+1][j+1];
                if (v == r) {
                    ans++;
                    set.add(b[j-1]);
                }
            }
         }
        
        System.out.println(ans);
    }
}
