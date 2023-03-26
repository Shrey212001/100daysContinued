/*

Topic:- String Construction

Link:- https://www.hackerrank.com/challenges/string-construction/problem?isFullScreen=true

Problem:-

Amanda has a string of lowercase letters that she wants to copy to a new string. She can perform the following operations with the given costs. She can perform them any number of times to construct a new string :

Append a character to the end of string  at a cost of  dollar.

Choose any substring of  and append it to the end of  at no charge.

Given  strings , find and print the minimum cost of copying each  to  on a new line.

For example, given a string , it can be copied for  dollars. Start by copying ,  and  individually at a cost of  dollar per character. String  at this time. Copy  to the end of  at no cost to complete the copy.

Function Description

Complete the stringConstruction function in the editor below. It should return the minimum cost of copying a string.

stringConstruction has the following parameter(s):

s: a string

Input Format

The first line contains a single integer n, the number of strings

Each of the next  lines contains a single string, .s[ i ].

Constraints

1  <=   n  <=  5

1  <=  | S[ i ] |  <= 10^5

Output Format

For each string s[ i ] print the minimum cost of constructing a new string p [ i ]  on a new line.

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

        for(int a0 = 0; a0 < n; a0++){

            String s = in.next();

            HashSet<Character> hs=new HashSet<Character>();

            int count=0;

            for(int i=0;i<s.length();i++){

                if(!hs.contains(s.charAt(i))){

                    hs.add(s.charAt(i));

                    count++;

                }

            }

            System.out.println(count);

        }

       

        

    }

}
