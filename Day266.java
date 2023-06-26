/*

Topic:- Substring Diff

Link:- https://www.hackerrank.com/challenges/substring-diff/problem?isFullScreen=true

Problem:-

In this problem, we'll use the term "longest common substring" loosely. It refers to substrings differing at some number or fewer characters when compared index by index. For example, 'abc' and 'adc' differ in one position, 'aab' and 'aba' differ in two.

Given two strings and an integer k, determine the length of the longest common substrings of the two strings that differ in no more than k positions.

For example, k=1. Strings s1=abcd and s2=bbca. Check to see if the whole string (the longest substrings) matches. Given that neither the first nor last characters match and 2>k, we need to try shorter substrings. The next longest substrings are s1' = [abc, bcd] and s2' = [bbc, bca]. Two pairs of these substrings only differ in 1 position: [abc, bbc] and [bcd, bca]. They are of length 3.

Function Description

Complete the substringDiff function in the editor below. It should return an integer that represents the length of the longest common substring as defined.

substringDiff has the following parameter(s):

k: an integer that represents the maximum number of differing characters in a matching pair
s1: the first string
s2: the second string

Input Format

The first line of input contains a single integer, t, the number of test cases follow.
Each of the next t lines contains three space-separated values: an integer k and two strings, s1 and s2.

Constraints

1 <= t <= 10
0 <= k <= |s1|
|s1|  = |s2|
1 <= |s1|, |s2| <= 1500
All characters in s1 and s2 ∈ ascii[a-z].

Output Format

For each test case, output a single integer which is the length of the maximum length common substrings differing at k or fewer positions.




Solution:-
*/
import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Solution {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
               in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
           
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    void solve() throws IOException {
        int n = readInt();
        for (int i = 0; i < n; i++)
        {
            int k = readInt();
            String s1 = readString();
            String s2 = readString();
            out.println(Math.max(find(k, s1, s2), find(k, s2, s1)));
        }
    }
    
    int find(int k, String s1, String s2)
    {
        int max = 0;
        for (int startFrom = 0; startFrom < s1.length(); startFrom++)
        {
            int l = 0;
            int penalty = 0;
            for (int r = 0; (r < s2.length()) && (startFrom + r < s1.length()); r++)
            {
                if (s1.charAt(startFrom + r) != s2.charAt(r))
                    penalty++;
                while (penalty > k)
                {
                   if (s1.charAt(startFrom + l) != s2.charAt(l))
                       penalty--;
                   l++;
                }
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}

