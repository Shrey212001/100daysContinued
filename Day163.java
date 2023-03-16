/*

Topic:- The Full Counting Sort

Link:- https://www.hackerrank.com/challenges/countingsort4/problem?isFullScreen=true

Problem:-

Use the counting sort to order a list of strings associated with integers. If two strings are associated with the same integer, they must be printed in their original order, i.e. your sorting algorithm should be stable. There is one other twist: strings in the first half of the array are to be replaced with the character - (dash, ascii 45 decimal).

Insertion Sort and the simple version of Quicksort are stable, but the faster in-place version of Quicksort is not since it scrambles around elements while sorting.

Design your counting sort to be stable.


Function Description

Complete the countSort function in the editor below. It should construct and print the sorted strings.

countSort has the following parameter(s):

string arr[n][2]: each arr[i] is comprised of two strings, x and s
Returns
- Print the finished array with each element separated by a single space.

Note: The first element of each , , must be cast as an integer to perform the sort.

Input Format

The first line contains , the number of integer/string pairs in the array .
Each of the next  contains  and , the integers (as strings) with their associated strings.


Output Format

Print the strings in their correct order, space-separated on one line.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuffer[] map = new StringBuffer[100];
        for(int i = 0; i < 100; i++) {
            map[i] = new StringBuffer();
        }
        for(int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(tok.nextToken());
            String s = tok.nextToken();
            map[v].append(i < n / 2 ? "-" : s).append(" ");
        }
        for(int i = 0; i < 100; i++) {
            System.out.print(map[i]);
        }
        System.out.println();
    }
}
