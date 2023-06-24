/*

Topic:- Summing Pieces

Link:- https://www.hackerrank.com/challenges/summing-pieces/problem?isFullScreen=true

Problem:-

Consider an array, A, of length n. We can split A into contiguous segments called pieces and store them as another array, B. For example, if A = [1,2,3], we have the following arrays of pieces:

 B = [(1),(2),(3)] contains three 1-element pieces.
 B = [(1,2),(3)] contains two pieces, one having 2 elements and the other having 1 element.
 B = [(1),(2,3)] contains two pieces, one having 1 element and the other having 2 elements.
 B = [(1,2,3)] contains one 3-element piece.
We consider the value of a piece in some array B to be (sum of all numbers in the piece) * (length of piece), and we consider the total value of some array B to be the sum of the values for all pieces in that B. For example, the total value of B = [1,2,4),(5,1),(2)] is (1+2+4)*3+(5+1)*2+(2)*1 = 35.

Given A, find the total values for all possible B's, sum them together, and print this sum modulo (10^9 +  7) on a new line.

Input Format

The first line contains a single integer, n, denoting the size of array A.
The second line contains n space-separated integers describing the respective values in A (i.e.,a0,a1,...,an-1).

Constraints
1 <= n <= 10^6
1 <= ai <= 10^9

Output Format

Print a single integer denoting the sum of the total values for all piece arrays (B's) of A, modulo (10^9 + 7).




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
        long sum = 0;
        long[] powers2 = new long[n+1];
        powers2[0] = 1;
        for(int i=1; i<=n; i++)
            powers2[i] = (powers2[i-1] << 1) % 1000000007;       
        for(int i=1; i<=n; i++){
            long left = ((powers2[i] - 1) * powers2[n-i]) % 1000000007;
            long right = ((powers2[1+n-i]-1) * powers2[i-1]) % 1000000007;
            long v = left + right - powers2[n-1];
            sum = (sum + (v * in.nextLong())) % 1000000007;
        }     
        System.out.println(sum);
        
    }
}
