/*
Topic:- CamelCase

Link:- https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true

Problem:-

There is a sequence of words in CamelCase as a string of letters, s, having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.

Given s, determine the number of words in s.

Function Description

Complete the camelcase function in the editor below.

camelcase has the following parameter(s):

string s: the string to analyze

Returns

int: the number of words in s

Input Format

A single line containing string s.

Constraints

1  <=  length of s  <=   10^5

Sample Input

saveChangesInTheEditor

Sample Output

5



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
        String s = in.next();
        int count = 1;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='A' && c<='Z') count++;
        }
        System.out.println(count);
    }
}
