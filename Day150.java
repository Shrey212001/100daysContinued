/*

Topic:- Caesar Cipher

Link:- https://www.hackerrank.com/challenges/caesar-cipher-1/problem?isFullScreen=true

Problem:-

Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

Function Description

Complete the caesarCipher function in the editor below.

caesarCipher has the following parameter(s):

string s: cleartext
int k: the alphabet rotation factor

Returns

string: the encrypted string


Input Format

The first line contains the integer, n, the length of the unencrypted string.
The second line contains the unencrypted string, s.
The third line contains k, the number of letters to rotate the alphabet by.


Constraints

1  <=  n  <=  100
0  <=  k   <=  100
s is a valid ASCII string without any spaces.

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
        int len = s.nextInt(); s.nextLine();
        String str = s.nextLine();
        int shift = s.nextInt();
        
        char sarr[] = str.toCharArray();
        for (int i=0; i<sarr.length; i++) {
            sarr[i] = cryptIt(sarr[i], shift);
        }
        System.out.println(new String(sarr));
    }
    
    public static char cryptIt(char c, int shift) {
        if (!Character.isAlphabetic(c)) return c;
        char base = 'A';
        if (c >= 'a') base = 'a';
        return (char)(((c - base + shift) % 26) + base);
    }
}

