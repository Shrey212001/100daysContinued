/*

Topic:- Yet Another Minimax Problem

Link:- https://www.hackerrank.com/challenges/yet-another-minimax-problem/problem?isFullScreen=true

Problem:-

You are given n non-negative integers, a0,a1,...,an-1. We define the score for some permutation () of length  to be the maximum of api ^ apI+1 for 0 <= i < n-1.

Find the permutation with the minimum possible score and print its score.

Note: ^ is the exclusive-OR (XOR) operator.

Input Format

The first line contains single integer, n, denoting the number of integers.
The second line contains n space-separated integers, a0,a1,...,an-1, describing the respective integers.

Constraints
2 <= n <= 3000
0 <= ai <= 10^9

Output Format

Print a single integer denoting the minimum possible score.




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
        
        if (a[0]==a[n-1]) {
            System.out.println(0);
            return;
        }
        
        int min = 0;
        int max = 0;
        
        for (int i = 1; i < 31; i++) {
            if (a[0] >= (1<<i))
                min++;
        }
        
        for (int i = 1; i < 31; i++) {
            if (a[n-1] >= (1<<i))
                max++;
        }
        
        while (min==max&&min!=0) {
            for (int i = 0; i < n; i++) {
                a[i] -= 1<<min;
            }
            min = 0;
            max = 0;
            for (int i = 1; i < 31; i++) {
                if (a[0] >= (1<<i))
                    min++;
            }
            for (int i = 1; i < 31; i++) {
                if (a[n-1] >= (1<<i))
                    max++;
            }
        }
        
        if (max==0) {
            System.out.println(0);
            return;
        }
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> h = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            if (a[i] < (1<<max))
                l.add(a[i]);
            else
                h.add(a[i]);
        }
        
        int result = Integer.MAX_VALUE;
        for (int i : l) {
            for (int j : h) {
                if ((i^j)<result)
                    result = i^j;
                if (result == (1<<max))
                    break;
            }
            if (result == (1<<max))
                break;
        }
        System.out.println(result);
    }
}
