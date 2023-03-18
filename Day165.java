/*

Topic:- Closest Numbers

Link:- https://www.hackerrank.com/challenges/closest-numbers/problem?isFullScreen=true

Problem:-

Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well. In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.


Note
As shown in the example, pairs may overlap.

Given a list of unsorted integers, arr , find the pair of elements that have the smallest absolute difference between them. If there are multiple pairs, find them all.

Function Description

Complete the closestNumbers function in the editor below.

closestNumbers has the following parameter(s):

int arr[n]: an array of integers
Returns
- int[]: an array of integers as described

Input Format

The first line contains a single integer n, the length of arr.
The second line contains n  space-separated integers, arr[i].




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
        int[] dat = new int[n];
        for(int i = 0; i < n; i++) {
            dat[i] = in.nextInt();
        }
        Arrays.sort(dat);
        int minDiff = Integer.MAX_VALUE;
        String out = "";
        for(int i = 0; i < n - 1; i++) {
            if(dat[i + 1] - dat[i] <= minDiff) {
                if(dat[i + 1] - dat[i] == minDiff) {
                    out += " " + dat[i] + " " + dat[i + 1];
                } else {
                    out = dat[i] + " " + dat[i + 1];
                }
                minDiff = dat[i + 1] - dat[i];
            }
        }
        System.out.println(out);
    }
}
