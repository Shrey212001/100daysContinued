/*

Topic:- The Maximum Subarray

Link:- https://www.hackerrank.com/challenges/maxsubarray/problem?isFullScreen=true

Problem:-

We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.

Given an array, find the maximum possible sum among:

1.all nonempty subarrays.
2.all nonempty subsequences.
Print the two values as space-separated integers on one line.

Note that empty subarrays/subsequences should not be considered.

Example
arr = [-1, 2, 3, -4, 5,10]
The maximum subarray sum is comprised of elements at inidices [1-5]. Their sum is 2 + 3 + -4 +5 + 10 = 16. The maximum subsequence sum is comprised of elements at indices [1,2,4,5] and their sum is 2 + 3 + 5 + 10 = 20.

Function Description

Complete the maxSubarray function in the editor below.

maxSubarray has the following parameter(s):

int arr[n]: an array of integers
Returns

int[2]: the maximum subarray and subsequence sums
Input Format

The first line of input contains a single integer t, the number of test cases.

The first line of each test case contains na single integer n.
The second line contains  space-separated integers arr[i] where 0 <= i < n.

Constraints

1 <= t <= 10
1 <= n <= 10^5
-10^4 <= arr[i] <= 10^4
The subarray and subsequences you consider should have at least one element.




Solution :-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int T = myScan.nextInt();
        while(T--!=0){
            int N = myScan.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i]=myScan.nextInt();
            }
            int curr_sum=0;
            int best_sum=0;
            int non_cont_sum=0;
            for(int j=0; j<N; j++){
                curr_sum += arr[j];
                if(curr_sum>0){
                    if(curr_sum>best_sum){
                        best_sum=curr_sum;
                    }
                }else{
                    curr_sum=0;
                }
                if(arr[j]>0){
                    non_cont_sum +=arr[j];
                }
            }
            if(best_sum ==0 && non_cont_sum==0){
                int max = arr[0];
                for(int l=1; l<N; l++){
                    if(arr[l]>max){
                        max=arr[l];
                    }
                }
                best_sum=max;
                non_cont_sum=max;
            }
            System.out.print(best_sum+" "+non_cont_sum);
            System.out.println();
        }
    }
}
