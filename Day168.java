/*

Topic:- Palindrome Index

Link:- https://www.hackerrank.com/challenges/palindrome-index/problem?isFullScreen=true

Problem:-

Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

Example

s = "bcbc"

Either remove 'b' at index 0 or 'c' at index 3.

Function Description

Complete the palindromeIndex function in the editor below.

palindromeIndex has the following parameter(s):

string s: a string to analyze

Returns

int: the index of the character to remove or -1.

Input Format

The first line contains an integer q, the number of queries.
Each of the next q lines contains a query string s.

Constraints

1  <=   q  <= 20
1  <=   length of s  <=  10^5 + 5 


All characters are in the range ascii[a-z].




Solution:-
*/
import java.util.*;

public class Solution {
    
    static boolean isPalidrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) !=  s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int t = 0; t < T; t++) {
            String s = in.next();
            
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    if (isPalidrom(s,i,j-1)) {
                        System.out.println(j);
                    } else {
                        System.out.println(i);
                    }
                    break;
                } 
                i ++;
                j --;
            }           
            if (i >= j) {
                System.out.println(-1);
            }
        }      
    }   
}
