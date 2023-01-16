/*
Topic:- Extra Long Factorials

Link:- https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true

Problem:-

The factorial of the integer n, written n!, is defined as:
         n! = n * (n-1) * (n-2) * ........ * 3 * 2 * 1
Calculate and print the factorial of a given integer.

For example, if n = 30, we calculate 30 * 29 * 28 * ...... * 3 * 2 * 1 and get 265252859812191058636308480000000.


Function Description

Complete the extraLongFactorials function in the editor below. It should print the result and return.
extraLongFactorials has the following parameter(s):
n: an integer


Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.

We recommend solving this challenge using BigIntegers.


Input Format

Input consists of a single integer n


Constraints
1 <= n <= 100


Output Format

Print the factorial of n.

Solution:-
*/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        int N,i;
            Scanner in=new Scanner(System.in);
            N=in.nextInt();
        BigInteger res=BigInteger.ONE;
       for(i=2;i<=N;i++){
       res = res.multiply(BigInteger.valueOf(i));
 
}
        System.out.println(res);
    }
}
