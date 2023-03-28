/*

Topic:- Missing Numbers

Link:- https://www.hackerrank.com/challenges/missing-numbers/problem?isFullScreen=true

Problem:-

Given two arrays of integers, find which elements in the second array are missing from the first array.

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
Return the missing numbers sorted ascending.
Only include a missing number once, even if it is missing multiple times.
The difference between the maximum and minimum numbers in the original list is less than or equal to 100.


Function Description

Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.

missingNumbers has the following parameter(s):

int arr[n]: the array with missing numbers
int brr[m]: the original array of numbers
Returns

int[]: an array of integers


Input Format

There will be four lines of input:

 - the size of the first list, 
The next line contains  space-separated integers 
 - the size of the second list, 
The next line contains  space-separated integers




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void ans(int a[],int b[]){
        int count_array1[] = new int[101];
        int count_array2[] = new int[101];
        int min = min(b);
        int max = max(b);
        int diff = max - min;
        for(int i=0;i<a.length;i++){
            count_array1[a[i]-min]++;
        }
        for(int i=0;i<b.length;i++){
            count_array2[b[i]-min]++;
        }
        for(int i=0;i<=100;i++){
            int diff_count = count_array2[i] - count_array1[i];
            if(diff_count > 0){
                System.out.print((i+min) + " ");
            }
        
        }
    }
    static int min(int a[]){
       int min = a[0];
        for(int i=1;i<=a.length-1;i++){
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }
    static int max(int b[]){
        int max = b[0];
        for(int i=1;i<=b.length-1;i++){
            if(b[i] > max){
                max = b[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int N,M;
       N = s.nextInt();
       int array1[] = new int[N];
       for(int i=0;i<=N-1;i++){
            array1[i] = s.nextInt();
       }
       M = s.nextInt();
       int array2[] = new int[M];
       for(int i=0;i<=M-1;i++){
            array2[i] = s.nextInt();
       } 
       ans(array1,array2); 
        
    }
}
