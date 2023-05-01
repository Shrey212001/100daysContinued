/*
 
Topic:- Common Child

Link:- https://www.hackerrank.com/challenges/common-child/problem?isFullScreen=true

Problem:-

A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings, s1 and s2.

Constraints

1  <=   | s1 | , | s2 |  <=  5000
All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string s, such that  is a child of both s1 and s2.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		String s2 = s.nextLine();
		int[][] lengths = new int[s1.length()+1][s2.length()+1];
		
		for (int i = 1; i < lengths.length; i++) {
			for (int j = 1; j < lengths.length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lengths[i][j] = lengths[i-1][j-1] + 1;
				}
				else if (lengths[i][j-1] > lengths[i-1][j]) {
					lengths[i][j] = lengths[i][j-1];
				}
				else {
					lengths[i][j] = lengths[i-1][j];
				}
			}
		}
		System.out.println(lengths[lengths.length-1][lengths.length-1]);
    }
}
