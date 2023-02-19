/*
Topic:- Larry's Array

Link:- https://www.hackerrank.com/challenges/larrys-array/problem?isFullScreen=true

Problem:-

Larry has been given a permutation of a sequence of natural numbers incrementing from 1 as an array. He must determine whether the array can be sorted using the following operation any number of times:

Choose any 3 consecutive indices and rotate their elements in such a way that

ABC->BCA->CAB->ABC.

For example, A = {1,6,5,2,4,3}  :

A		rotate 
[1,6,5,2,4,3]	[6,5,2]
[1,5,2,6,4,3]	[5,2,6]
[1,2,6,5,4,3]	[5,4,3]
[1,2,6,3,5,4]	[6,3,5]
[1,2,3,5,6,4]	[5,6,4]
[1,2,3,4,5,6]

YES
On a new line for each test case, print YES if A can be fully sorted. Otherwise, print NO.

Function Description

Complete the larrysArray function in the editor below. It must return a string, either YES or NO.

larrysArray has the following parameter(s):

A: an array of integers
Input Format

The first line contains an integer t, the number of test cases.

The next t pairs of lines are as follows:


The first line contains an integer n, the length of A.
The next line contains n space-separated integers A[i].
Output Format

For each test case, print YES if A can be fully sorted. Otherwise, print NO.

Sample Input

3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4
Sample Output

YES
YES
NO



Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
        static int[] aux;
    
    
    
    public static long insertSort(int[] ar)
    {
        aux = new int[ar.length];
        long count = mergeSort(ar, 0, ar.length-1);
        return count;
        
    }
    
    public static long mergeSort(int[] ar, int from, int to) {
        long count = 0;
        if (from + 8 >= to) {
            for (int i = from+1; i <= to; i++) {
                int x = ar[i];
                int j = i-1;
                while (j >= from && ar[j] > x) {
                    ar[j+1] = ar[j];
                    count++;
                    j--;
                }
                ar[j+1] = x;
            }
            return count;
        }
        int middle = (from + to) / 2;
        count += mergeSort(ar, from, middle);
        count += mergeSort(ar, middle+1, to);
        count += merge(ar, from, middle+1,  to);
        return count;
    }
    
    public static long merge(int[] ar, int from, int second, int to) {
        long count = 0;
        for (int i = from; i <= to; i++) {
            aux[i] = ar[i]; 
        }
        int i = from;
        int j = second;
        int k = from;
        while (k <= to) {
            if (i >= second) ar[k] = aux[j++];
            else if (j > to) ar[k] = aux[i++];
            else if (aux[i] <= aux[j]) ar[k] = aux[i++];
            else {
                ar[k] = aux[j++];
                count += (second-i);
            }
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
                //System.err.println(ar[j]);
            }
            long c = insertSort(ar);
            String answer = "YES";
            if (c%2 == 1) answer = "NO";
            System.out.println(answer);
        }
}
}
