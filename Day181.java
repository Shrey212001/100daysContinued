/*

Topic:- Maximum Perimeter Triangle

Link:- https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem?isFullScreen=true

Problem:-

Given an array of stick lengths, use  of them to construct a non-degenerate triangle with the maximum possible perimeter. Return an array of the lengths of its sides as  integers in non-decreasing order.

If there are several valid triangles having the maximum perimeter:

Choose the one with the longest maximum side.
If more than one has that maximum, choose from them the one with the longest minimum side.
If more than one has that maximum as well, print any one them.
If no non-degenerate triangle exists, return .


Function Description

Complete the maximumPerimeterTriangle function in the editor below.

maximumPerimeterTriangle has the following parameter(s):

int sticks[n]: the lengths of sticks available
Returns

int[3] or int[1]: the side lengths of the chosen triangle in non-decreasing order or -1

Input Format

The first line contains single integer , the size of array .
The second line contains  space-separated integers , each a stick length.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        
        int ans = -1;
        for (int i = 2; i < n; i++) {
            if (a[i-2]+a[i-1]>a[i])
                ans = i;
        }
        if (ans == -1)
            System.out.println(-1);
        else
            System.out.println(a[ans-2]+" "+a[ans-1]+" "+a[ans]);
    }
}
