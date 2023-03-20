/*

Topic:- Find the Median

Link:- https://www.hackerrank.com/challenges/find-the-median/problem?isFullScreen=true

Problem:-

The median of a list of numbers is essentially its middle element after sorting. The same number of elements occur after it as before. Given a list of numbers with an odd number of elements, find the median?


Function Description

Complete the findMedian function in the editor below.

findMedian has the following parameter(s):

int arr[n]: an unsorted array of integers
Returns

int: the median of the array

Input Format

The first line contains the integer n, the size of arr.
The second line contains n space-separated integers arr[i]





Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int quickSort(int[] a, int p, int r,int index)
    {
        if(p==r)
            return a[p];
        if(p<r)
        {
            int q=partition(a,p,r);
            if(q==index)
                return a[q];
            else if(q>index)
                return quickSort(a,p,q-1,index);
            else
                return quickSort(a,q+1,r,index);
        }
        
        return 0;
    }

    private static int partition(int[] a, int p, int r) {

        int x = a[r];
        int i = p-1 ;
        int j = p ;
        
        for(;j<r;++j)
        {
              if(a[j]<=x)  
              {
                  ++i;
                  int temp = a[i];
                  a[i]=a[j];
                  a[j]=temp;
              }
        }
        
        a[r]=a[i+1];
        a[i+1]=x;
        
        return i+1;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for(int i=0;i<N;++i)
            arr[i]=sc.nextInt();
        
        System.out.println(quickSort(arr, 0, N-1,N/2));
    }
}
