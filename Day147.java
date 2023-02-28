/*

Topic:- Two Characters

Link:- https://www.hackerrank.com/challenges/two-characters/problem?isFullScreen=true

Problem:-

Given a string, remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Determine the longest string possible that contains just two alternating letters.

Example

s = 'abcacdabd'

Delete a, to leave bcdbd. Now, remove the character c to leave the valid string bdbd with a length of 4. Removing either b or d at any point would not result in a valid string. Return 4.

Given a string s, convert it to the longest possible string t made up only of alternating characters. Return the length of string t. If no string t can be formed, return 0.

Function Description

Complete the alternate function in the editor below.

alternate has the following parameter(s):

string s: a string

Returns.

int: the length of the longest valid string, or 0 if there are none

Input Format

The first line contains a single integer that denotes the length of s.
The second line contains string s.

Constraints

1  <=  length of s  <=  1000

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
        int n = in.nextInt();
        String str = in.next();
        HashSet<Character> set = new HashSet<Character>();
        char[] ar = str.toCharArray();
        for (char c : ar) set.add(c);
        int ans = 0;
        Character[] keys = set.toArray(new Character[set.size()]);
        for (int i = 0 ; i < set.size() ; i++) {
            for (int j = i+1 ; j < set.size() ; j++) {
                String b = str;
                for (char c : set) {
                    if (c != keys[i] && c != keys[j]) b = b.replace(c + "", "");
                }
                
                char[] ts = b.toCharArray();
                boolean valid = ts.length > 0;
                for (int k = 0 ; valid && k < ts.length - 1 ; k++) {
                    if (ts[k] == ts[k+1]) valid = false; 
                }
                if (valid) ans = Math.max(ans, ts.length);
            }
        }
        System.out.println(ans);
    }
}
