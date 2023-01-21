/*
Topic:- Non-Divisible Subset

Link:- https://www.hackerrank.com/challenges/non-divisible-subset/problem?isFullScreen=true

Problem:-
Given a set of distinct integers, print the size of a maximal subset of S where the sum of any 2 numbers in S’ is not evenly divisible by k.

Example
 S = [19, 10, 12, 10, 24, 25, 22] k = 4

One of the arrays that can be created is S‘[0] = [10, 12, 25]. Another is S‘[1] = [19, 22, 24]. After testing all permutations, the maximum length solution array has 3 elements.

Function Description

Complete the nonDivisibleSubset function in the editor below.

nonDivisibleSubset has the following parameter(s):

int S[n]: an array of integers
int k: the divisor

Returns

int: the length of the longest subset of S meeting the criteria

Input Format
The first line contains 2 space-separated integers, n and k, the number of values in S and the non factor.
The second line contains n space-separated integers, each an S[i], the unique values of the set.

Constraints

1 <= n <= 105
1 <= k <= 100
1 <= S[i] <= 109
All of the given numbers are distinct.

Sample Input

STDIN    Function
-----    --------
4 3      S[] size n = 4, k = 3
1 7 2 4  S = [1, 7, 2, 4]

Sample Output

3

Explanation

The sums of all permutations of two elements from S = {1, 7, 2, 4} are:

Only S‘ = {1, 7, 4} will not ever sum to a multiple of k = 3.



Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        new Solution().run();
    }
    
    public void run() throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[]a = new int[n];
        int[]c = new int[k];
        
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
            a[i]=a[i]%k;
            c[a[i]]++;
        }
        
        int ans=0;
        ans+=(c[0]>0)?1:0;//good if 1 exists, cannot be more
        for(int i=1;i<=k-i;i++){
            if(i<k-i) {
                ans+=Math.max(c[i],c[k-i]);
            } else {//i==k-i
                ans+=(c[i]>0)?1:0;//not more possible
            }
        }
        log.write("" +ans+"\n"); 
        
        log.flush();
    }
}
