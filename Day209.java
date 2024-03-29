/*

Topic:- Sherlock and Anagrams

Link:- https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true
 
Problem:-

Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example s = mom , the list of all anagrammatic pairs is [m,m], [mo, om] at positions [ [1], [2], [0,1], [1,2] ] respectively .

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in s.

sherlockAndAnagrams has the following parameter(s)
     s: a string .

Input Format

The first line contains an integer q , the number of queries .
Each of the next  q lines contains a string s to analyze.

Constraints
  
   1 <= q <= 10
   2 <= | s| <= 100


Output Format

For each query, return the number of unordered anagrammatic pairs.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    
    private static int count[][] = new int[128][110];

    private static void resetCount() {
        for (int i = 0; i < count.length; i++) for (int j = 0; j < count[i].length; j++) count[i][j] = 0;
    }
    
    private static boolean areAnagrams(int from1, int to1, int from2, int to2) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i][to1+1]-count[i][from1] != count[i][to2+1]-count[i][from2])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int TC = Integer.parseInt(sc.nextLine());
        for (int tc = 0; tc < TC; tc++) {
            final char s[] = sc.nextLine().toCharArray();
            resetCount();
            count[s[0]][1] = 1;
            for (int i = 1; i < s.length; i++) {
                for (int j = 'a'; j <= 'z'; j++) count[j][i+1] = count[j][i];
                count[s[i]][i+1]++;
            }
            int res = 0;
            for (int len = 1; len <= s.length-1; len++) {
                for (int from = 0; from <= s.length-len; from++) {
                    for (int to = from+1; to <= s.length-len; to++) {
                        if (areAnagrams(from, from+len-1, to, to+len-1)) res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
