/*

Topic:- Short Palindrome

Link:- https://www.hackerrank.com/challenges/short-palindrome/problem?isFullScreen=true

Problem:-

Consider a string, , of  lowercase English letters where each character,  (, denotes the letter at index  in . We define an  palindromic tuple of  to be a sequence of indices in  satisfying the following criteria:

, meaning the characters located at indices  and  are the same.
, meaning the characters located at indices  and  are the same.
, meaning that , , , and  are ascending in value and are valid indices within string .
Given , find and print the number of  tuples satisfying the above conditions. As this value can be quite large, print it modulo .

unction Description
Complete the function shortPalindrome in the editor below.

shortPalindrome has the following paramter(s):
- string s: a string

Returns
- int: the number of tuples, modulo 

Input Format

A single string, .

Constraints

It is guaranteed that  only contains lowercase English letters.




Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
BufferedReader inR = new BufferedReader(new InputStreamReader(System.in));
        String s = inR.readLine().trim();
        long MOD = 1000000000L+7;
        long[] cnt = new long[26];
        long[][] sumK = new long[26][26];
        long[][] delta = new long[26][26];
        long ans = 0;
        for(int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for(int j=0; j<26; j++) {
                ans = (ans + delta[c][j]) % MOD;
            }
            
            for(int j=0; j<26; j++) {
                delta[j][c] = (delta[j][c] + sumK[j][c]) % MOD;
                sumK[j][c] = (sumK[j][c] + cnt[j]) % MOD;
            }
            
            cnt[c] += 1;
        }
        System.out.println(ans % MOD);
        inR.close();
    }
}
