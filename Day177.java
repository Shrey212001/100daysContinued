/*

Topic:- Minimum Absolute Difference in an Array

Link:- https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?isFullScreen=true

Problem:-

The absolute difference is the positive difference between two values a and b, is written | a - b | or | b - a |  and they are equal. If a = 3 and  b = 20,  | 3 - 2 | = | 2 - 3 | = 1 . Given an array of integers, find the minimum absolute difference between any two elements in the array.


Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

int arr[n]: an array of integers
Returns

int: the minimum absolute difference found
Input Format

The first line contains a single integer n, the size of arr.
The second line contains n space-separated integers,  arr [ i ].

Constraints

2  <=  n   <=   10^5
- 10^9   <=   arr[ i ]   <=  10^9


Sample Input 0

3
3 -7 0
Sample Output 0

3
  
  
  
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
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        int minimum=999999999;
        for(int i = 1; i  <  (a.length - 1); i++){
         int temp = Math.abs(a[i+1] - a[i]);
         if (temp  <  minimum)
            minimum = temp;
      }

        System.out.println(minimum);
    }}
