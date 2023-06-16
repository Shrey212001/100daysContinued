/*

Topic:- Fibonacci Modified

Link:- https://www.hackerrank.com/challenges/fibonacci-modified/problem?isFullScreen=true 
 
Problem:-

Implement a modified Fibonacci sequence using the following definition:

Given terms t[i] and t[i+1] where i ∈ (1,∞), term t[i+2] is computed as:
t(i+2) = ti + t(i+2)^2

Given three integers, t1, t2, and n, compute and print the nth term of a modified Fibonacci sequence.

Example
t1 = 0
t2 =0
n =6

  t3 = 0+1^2 = 1
  t4 = 1+1^2 = 2
  t5 = 1+2^2 = 5
  t6 = 2+5^2 = 27
Return 27.

Function Description

Complete the fibonacciModified function in the editor below. It must return the nth number in the sequence.

fibonacciModified has the following parameter(s):

int t1: an integer
int t2: an integer
int n: the iteration to report

Returns

int: the nth number in the sequence
Note: The value of t[n] may far exceed the range of a 64-bit integer. Many submission languages have libraries that can handle such large results but, for those that don't (e.g., C++), you will need to compensate for the size of the result.

Input Format

A single line of three space-separated integers, the values of t1, t2, and n.

Constraints

0 <= t1, t2 <= 2
3 <= n <= 20
tn may far exceed the range of a 64-bit integer.




Solution :-
*/
import java.math.BigInteger;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = BigInteger.valueOf(in.nextInt());
        BigInteger b = BigInteger.valueOf(in.nextInt());
        int n = in.nextInt();
        for(int i = 2; i < n; i++) {
            BigInteger next = b.multiply(b).add(a);
            a = b;
            b = next;
        }
        System.out.println(b);
    }
}
