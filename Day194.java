/*

Topic:- Flipping bits

Link:- https://www.hackerrank.com/challenges/flipping-bits/problem?isFullScreen=true

Problem:-

You will be given a list of 32 bit unsigned integers. Flip all the bits (1->0 and 0->1) and return the result as an unsigned integer.

Example
n=9(10)
9(10)=1001(2). We're working with 32 bits, so:
000000000000000000000000000001001 = 9(10)
111111111111111111111111111110110 = 4294967286(10)
Return 4294967286.

Function Description

Complete the flippingBits function in the editor below.

flippingBits has the following parameter(s):

int n: an integer
Returns

int: the unsigned decimal integer result
Input Format

The first line of the input contains q, the number of queries.
Each of the next q lines contain an integer, n, to process.

Constraints

1 <= q <= 100
0 <= n < 2^32




Solution:-
*/
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        long mask = (1L << 32) - 1;    
        for (int t = 0; t < T; t++) {
            long n = scanner.nextLong();
            System.out.println(n ^ mask);            
        }
                scanner.close();

    }

}
