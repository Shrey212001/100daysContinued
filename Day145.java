/*

Topic:- Insertion Sort - Part 1

Link:- https://www.hackerrank.com/challenges/insertionsort1/problem?isFullScreen=true

Problem:-

Sorting
One common task for computers is to sort data. For example, people might want to see all their files on a computer sorted by size. Since sorting is a simple problem with many different possible solutions, it is often used to introduce the study of algorithms.

Insertion Sort
These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm. We will first start with a nearly sorted list.

Insert element into sorted list
Given a sorted list with an unsorted number  in the rightmost cell, can you write some simple code to insert  into the array so that it remains sorted?

Since this is a learning exercise, it won't be the most efficient way of performing the insertion. It will instead demonstrate the brute-force method in detail.

Function Description

Complete the insertionSort1 function in the editor below.

insertionSort1 has the following parameter(s):

n: an integer, the size of arr
arr: an array of integers to sort

Returns

None: Print the interim and final arrays, each on a new line. No return value is expected.

Input Format

The first line contains the integer n, the size of the array arr.
The next line contains n space-separated integers arr[0]  . . . arr[ n - 1 ] .

Constraints

1  <=  n  <=  1000
-10000 <=  arr[ i ]  <=  10000


Output Format

Print the array as a row of space-separated integers each time there is a shift or insertion.


Solution:-
*/
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
        int s=scan.nextInt();
        int ar[]=new int[s];
        boolean check=false;
        for(int i=0;i<s;i++)
        {
            ar[i]=scan.nextInt();
        }
        int var=ar[s-1];
        for(int i=s-2;i>=-1;i--)
        {
            if(i!=-1)
            {
            if(var<ar[i])
            {
                ar[i+1]=ar[i];
            }
            else
            {
                ar[i+1]=var;
                check=true;
            }
            }
            else
            {
                ar[0]=var;
            }
            for(int j=0;j<s;j++)
                System.out.print(ar[j]+" ");
            System.out.println();
            if(check)
                break;
        }
    }
}
