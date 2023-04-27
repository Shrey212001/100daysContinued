/*

Topic:- Sherlock and the Valid String

Link:- https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true

Problem:-

Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times. Given a string s, determine if it is valid. If so, return YES, otherwise return NO.

Function Description

Complete the isValid function in the editor below.

isValid has the following parameter(s):

string s: a string
Returns

string: either YES or NO
Input Format

A single string s.

Sample Input 0

aabbcd
Sample Output 0

NO




Solution:-
*/
import java.io.*;
import java.util.Arrays;
import java.util.Locale;


public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }


    private void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().trim().toCharArray();
        int[] cnt = new int[26];
        for (char c : s) {
            cnt[c - 'a']++;
        }
        
        Arrays.sort(cnt);
        
        int cntMin = 0;
        int cntMax = 0;
        
        int min = Integer.MAX_VALUE;
        int max = 0;
        
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                min = Math.min(min, cnt[i]);
                max = Math.max(max, cnt[i]);
            }
        }   
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                cntMin += Math.abs(min - cnt[i]);
            }
            if (cnt[i] < max) {
                cntMax += cnt[i];
            }
        }
           System.out.println(cntMin <= 1 || cntMax <= 1 ? "YES" : "NO");
    }


}
