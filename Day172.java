/*
Topic:-Two Strings

Link:- https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true

Problem:-

Given two strings, determine if they share a common substring. A substring may be as small as one character.

Example

s1 = 'and'
s2  = 'art'


These share the common substring a.

s1 = 'be'
s2 = 'cat'


These do not share a substring.

Function Description

Complete the function twoStrings in the editor below.

twoStrings has the following parameter(s):

string s1: a string
string s2: another string

Returns

string: either YES or NO

Input Format

The first line contains a single integer p, the number of test cases.

The following p pairs of lines are as follows:

The first line contains string s1.
The second line contains string s2.


Constraints

s1 and s2 consist of characters in the range ascii[a-z].
1  <=  p  <= 10
1  <=  | s1 |, | s2 |  <= 10^5

Output Format

For each pair of strings, return YES or NO.



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
      int t = sc.nextInt();
      while(t-- > 0){
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        int[] chs = new int[1000];
        for(int i = 0; i < s1.length; i++){
          chs[s1[i]]++;
        }
        String result = "NO";
        for(int i = 0; i < s2.length; i++){
          if(chs[s2[i]]>0){
            result = "YES";
            break;
          }
        }
        System.out.println(result);
      }
    }
}
