/*
Topic:- Beautiful Triplets

Link:- https://www.hackerrank.com/challenges/beautiful-triplets/problem?isFullScreen=true

Problem:-

Complete the beautifulTriplets function in the editor below. It must return an integer that represents the number of beautiful triplets in the sequence.

beautifulTriplets has the following parameters:

d: an integer
arr: an array of integers, sorted ascending
 

Input Format

The first line contains 2 space-separated integers n and d, the length of the sequence and the beautiful difference.
The second line contains n space-separated integers arr[i].

Output Format

Print a single line denoting the number of beautiful triplets in the sequence.

Sample Input


7 3
1 2 4 5 7 8 10

Sample Output

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            set.add(a[i]);
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (set.contains(a[i]+d)&&set.contains(a[i]+2*d))
                ans++;
        }
        
        System.out.println(ans);
    }
}
