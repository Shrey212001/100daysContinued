/*

Topic:- Sam and substrings

Link:- https://www.hackerrank.com/challenges/sam-and-substrings/problem?isFullScreen=true

Problem:-

Samantha and Sam are playing a numbers game. Given a number as a string, no leading zeros, determine the sum of all integer values of substrings of the string.

Given an integer as a string, sum all of its substrings cast as integers. As the number may become large, return the value modulo 10^9 +7.

Example

n = '42'
Here n is a string that has 3 integer substrings: 4, 2, and 42. Their sum is 48, and 48 modulo{10^9 +7)=48.

Function Description

Complete the substrings function in the editor below.

substrings has the following parameter(s):

string n: the string representation of an integer

Returns

int: the sum of the integer values of all substrings in n, modulo 10^9 + 7

Input Format

A single line containing an integer as a string, without leading zeros.

Constraints

1 <= n cast as an integer <= 2 x 10^5




Solution:-
*/
import java.util.Scanner;
public class Solution {
    static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char s[] = cin.next().toCharArray();
        long ten[] = new long[s.length + 2];
        ten[0] = 1;
        for (int i=1; i<ten.length; i++) {
            ten[i] = ten[i - 1] * 10 + 1;
            ten[i] %= mod;
        }       
        long ans = 0;
        for (int i=0; i<s.length; i++) {
            ans += ((s[i] - '0') * ten[s.length - i - 1]) % mod * (i + 1) % mod;
            ans %= mod;
        }       
        System.out.println(ans);
        cin.close();
    }
}

