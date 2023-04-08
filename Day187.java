/*

Topic:- Largest Permutation

Link:- https://www.hackerrank.com/challenges/largest-permutation/problem?isFullScreen=true

Problem:-

You are given an unordered array of unique integers incrementing from . You can swap any two elements a limited number of times. Determine the largest lexicographical value array that can be created by executing no more than the limited number of swaps.

Example

The following arrays can be formed by swapping the  with the other elements:

[2,1,3,4]
[3,2,1,4]
[4,2,3,1]
The highest value of the four (including the original) is . If , we can swap to the highest possible value: .

Function Description

Complete the largestPermutation function in the editor below. It must return an array that represents the highest value permutation that can be formed.

largestPermutation has the following parameter(s):

int k: the maximum number of swaps
int arr[n]: an array of integers
Input Format

The first line contains two space-separated integers  and , the length of  and the maximum swaps that can be performed. The second line contains  distinct space-separated integers from  to  as  where .




Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        int n = scc.nextInt();
        int k = scc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scc.nextInt();
        }
        
        
        for(int i=0; i<k && i<n; i++){
            int j;
            for(j=i; j<n; j++){
                if(arr[j]==n-i){
                    break;
                }
            }
            if(j!=i){
               int temp = arr[j];
               arr[j] = arr[i];
               arr[i] = temp;
            }
            else{
                k++;
            }
        }
        
        for(int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
