/*

Topic:- Xor-sequence

Link:- https://www.hackerrank.com/challenges/xor-se/problem?isFullScreen=true

Problem:-

An array, A, is defined as follows:
A0 = 0
Ax = Ax-1 + x for x >0, where  is the symbol for XOR
You will be given a left and right index l r. You must determine the XOR sum of the segment of A as A[l] + A[l+1] + ... + A[[r-l] + A[r].

For example, A = [0,1,3,0,4,1,7,0,8]. The segment from l=1 to r=4 sums to 1 +3 +0 + 4 = 6.

Print the answer to each question.

Function Description

Complete the xorSequence function in the editor below. It should return the integer value calculated.

xorSequence has the following parameter(s):

l: the lower index of the range to sum
r: the higher index of the range to sum
Input Format

The first line contains an integer q, the number of questions.
Each of the next q lines contains two space-separated integers, l[i] and r[i], the inclusive left and right indexes of the segment to query.

Constraints
1 <= q <= 10^5
1 <= l[i] <= r[i] <= 10^15

Output Format

On a new line for each test case, print the XOR-Sum of A's elements in the inclusive range between indices l[i] and r[i].




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
        int Q = in.nextInt();
        
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            System.out.println(ant(R)^ant(L-1));
        }
        
    }
    public static long ant (long n){
        if(n%2==0){
            return 2*ans(n/2);
        }
        return ans(n)+2*ans(n/2);
    }
    public static long ans (long n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n%2==1){
            if(n%4==1){
                return 1;
            }
            return 0;
        }
        else{
            return n^(ans(n-1));
        }
    }
}
