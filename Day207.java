/*

Topic:- Highest Value Palindrome

Link:- https://www.hackerrank.com/challenges/richie-rich/problem?isFullScreen=true

Problem:-

Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 0's left of all higher digits in your tests. For example 0110 is valid,  0011 is not.

Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints.

Function Description

Complete the highestValuePalindrome function in the editor below.

highestValuePalindrome has the following parameter(s):

string s: a string representation of an integer
int n: the length of the integer string
int k: the maximum number of changes allowed

Returns

string: a string representation of the highest value achievable or -1

Input Format

The first line contains two space-separated integers, n and k, the number of digits in the number and the maximum number of changes allowed.
The second line contains an n-digit string of numbers.

Constraints

0  <=  n  <=  10^5
0  <=  k  <=  10^5
Each character i in the number is an integer where 0  <=  i  <=  9.




Solution:-
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[] c = scanner.next().toCharArray();
        boolean[] ch = new boolean[n];
        for (int i = 0; i < n/2; ++i) {
            if (c[i] != c[n - i - 1]) {
                c[i] = c[n - i - 1] = (char)Math.max(c[i], c[n - i - 1]);
                ch[i] = true;
                --k;
            }
        }
        if (k < 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n/2; ++i) {
            if (c[i] != '9') {
                if (ch[i] && k > 0) {
                    c[i] = c[n - i - 1] = '9';
                    --k;
                }
                if (!ch[i] && k > 1) {
                    c[i] = c[n - i - 1] = '9';
                    k -= 2;
                }
            }
        }
        if (n % 2 == 1 && k > 0) {
            c[n/2] = '9';
        }
        System.out.println(new String(c));
    }
}
