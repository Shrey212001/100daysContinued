/*

Topic:- Funny String

Link:- https://www.hackerrank.com/challenges/funny-string/problem?isFullScreen=true

Problem:-

In this challenge, you will determine whether a string is funny or not. To determine whether a string is funny, create a copy of the string in reverse e.g. abc  ->  cab. Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute differences is the same for both strings, they are funny.

Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.

Function Description

Complete the funnyString function in the editor below.

funnyString has the following parameter(s):

string s: a string to test

Returns

string: either Funny or Not Funny

Input Format

The first line contains an integer s, the number of queries.
The next q lines each contain a string, s.

Constraints


1  <=  q  <=  10
2  <=  length of  s  <=  10000


Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=0;j<t;j++)
        {
        String s=sc.next();
        int len=s.length();
        int stop=(len/2);
        int flag=0;
        int i=0;
        for(i=0;i<stop;i++)
            {
            int diff_fwd=(int)(s.charAt(i))-(int)(s.charAt(i+1));
            int diff_back=(int)(s.charAt(len-1-i))-(int)(s.charAt(len-1-(i+1)));
            if(Math.abs(diff_fwd)!=Math.abs(diff_back))
                {
                    flag=1;
                    break;
                }
        }
        if(flag==1)
            System.out.println("Not Funny");
        else
            System.out.println("Funny");
    }
}
}
