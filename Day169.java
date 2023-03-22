/*

Topic:- Anagram

Link:- https://www.hackerrank.com/challenges/anagram/problem?isFullScreen=true

Problem:-

Two words are anagrams of one another if their letters can be rearranged to form the other word.

Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of characters to change to make the two substrings into anagrams of one another.

Example

s = abccde

Break s into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous and their lengths are equal. Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two changes were necessary.

Function Description

Complete the anagram function in the editor below.

anagram has the following parameter(s):

string s: a string


Returns

int: the minimum number of characters to change or -1.

Input Format

The first line will contain an integer, q, the number of test cases.
Each test case will contain a string s.


Constraints


1  <=   q   <= 100
1   <=  | s |  <=   10^4
s  consists only of characters in the range ascii[a-z].



Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

    static void solve() throws IOException {
        int tests = nextInt();
        while (tests-- > 0) {
            String s = nextToken();
            int answer = solve(s);
            out.println(answer);
        }
    }

    private static int solve(String s) {
        if ((s.length() & 1) != 0) {
            return -1;
        }
        int k = s.length() >> 1;
        char[] c1 = s.substring(0, k).toCharArray();
        char[] c2 = s.substring(k, 2 * k).toCharArray();
        int[] cnt1 = get(c1);
        int[] cnt2 = get(c2);
        int result = 0;
        for (int i = 0; i < 256; i++) {
            result += Math.abs(cnt1[i] - cnt2[i]);
        }

        return result >> 1;
    }

    private static int[] get(char[] c1) {
        int[] ret = new int[256];
        for (char cc : c1) {
            ++ret[cc];
        }
        return ret;
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        File file = new File("a.in");
        if (file.exists() && file.canRead()) {
            input = new FileInputStream(file);
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        out.close();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}
