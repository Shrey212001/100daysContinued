/*

Topic:-Recursive Digit Sum

Link:- https://www.hackerrank.com/challenges/recursive-digit-sum/problem?isFullScreen=true

Problem:-

We define super digit of an integer x using the following rules:

Given an integer, we need to find the super digit of the integer.

If x has only 1 digit, then its super digit is x.
Otherwise, the super digit of x  is equal to the super digit of the sum of the digits of x.

For example, the super digit of9875  will be calculated as:

	super_digit(9875)   	9+8+7+5 = 29 
	super_digit(29) 	2 + 9 = 11
	super_digit(11)		1 + 1 = 2
	super_digit(2)		= 2  

Function Description
Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.

superDigit has the following parameter(s):

string n: a string representation of an integer
int k: the times to concatenate n to make p

Returns
int: the super digit of n repeated k times

Input Format
The first line contains two space separated integers, n and k.

Constraints
1   <=   n   <=   10^100000
1  <=   k   <=  10^5




Solution:-
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        String str_n = sc.next();
        int k = sc.nextInt();
        int pSum = Integer.parseInt(s.supdig(str_n));
        pSum *= k;
        String sup = Integer.toString(s.supdig(pSum));   
        System.out.println(sup);
    }
    String supdig(String n) {
        if(n.length() == 1) return n;
        else {
            int np = 0;
            for(int i = 0; i < n.length(); i++) {
                np += Character.getNumericValue( n.charAt(i) );    
            }       
            return supdig(Integer.toString(np));
        }       
    }
    int supdig(int n) {
        if(n / 10 == 0) return n;
        else {
            int r = 0;
            while(n > 0) {
                r += n % 10;
                n /= 10;
            }   
            return supdig(r);
        }
    }
}
