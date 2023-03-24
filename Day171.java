/*

Topic:-Game of Thrones - I

Link:- https://www.hackerrank.com/challenges/game-of-thrones/problem?isFullScreen=true

Problem:-

Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

But, to lock the door he needs a key that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be rearranged into a palindrome. Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.

Example

s = 'aabbccdd'

One way this can be arranged into a palindrome is aabbccdd. Return YES.

Function Description

Complete the gameOfThrones function below.

gameOfThrones has the following parameter(s):

string s: a string to analyze



Returns

string: either YES or NO


Input Format

A single line which contains s.

Constraints

1  <=   |s|   <=  10^5
s contains only lowercase letters in the range ascii[a . . . z ]




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String s;
    static int hash[];
    public static void main(String[] args) {
       hash=new int[26];
       Scanner sc = new Scanner(System.in); 
       s=sc.next();
       s.toUpperCase();
       int i;
       for(i=0;i<s.length();i++)
       {
           int temp;
           temp=s.charAt(i)-'a';
           
           hash[temp]=hash[temp]+1;
       }
       int odd=0; 
       int set=0;
       for(i=0;i<26;i++)
        {
            if(hash[i]%2!=0)
            {
                if(odd==1){set=1;break;}
                else odd=1;
            }
        }
       if(set==0)
           System.out.println("YES");
       else if(set==1)
                   System.out.println("NO");
    }
}
