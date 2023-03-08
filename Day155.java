/*

Topic:- Pangrams

Link:- https://www.hackerrank.com/challenges/pangrams/problem?isFullScreen=true

Problem:-
A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.

Example

s =  "The quick brown fox jumps over a lazy dog"

The string contains all letters in the English alphabet, so return pangram.

Function Description

Complete the function pangrams in the editor below. It should return the string pangram if the input string is a pangram. Otherwise, it should return not pangram.

pangrams has the following parameter(s):

string s: a string to test


Returns

string: either pangram or not pangram
Input Format

A single line with string .

Constraints

0   <=  length of s  <=  10^3


Sample Input

Sample Input 0

We promptly judged antique ivory buckles for the next prize


Sample Output 0

pangram



Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static boolean isPangram(String s) {
        boolean[] isInside = new boolean[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                isInside[Character.toLowerCase(c)-'a'] = true;
            }
        }
        for (boolean b : isInside) {
            if (!b) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isPangram(s)) System.out.println("pangram");
        else System.out.println("not pangram");
    }
}
