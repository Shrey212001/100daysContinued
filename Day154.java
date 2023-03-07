/*

Topic:- Quicksort 1 - Partition

Link:- https://www.hackerrank.com/challenges/quicksort1/problem?isFullScreen=true

Problem:-

The previous challenges covered Insertion Sort, which is a simple and intuitive sorting algorithm with a running time of . In these next few challenges, we're covering a divide-and-conquer algorithm called Quicksort (also known as Partition Sort). This challenge is a modified version of the algorithm that only addresses partitioning. It is implemented as follows:

Step 1: Divide
Choose some pivot element, , and partition your unsorted array, , into three smaller arrays: , , and , where each element in , each element in , and each element in .

Example

In this challenge, the pivot will always be at , so the pivot is .

 is divided into , , and .
Putting them all together, you get . There is a flexible checker that allows the elements of  and  to be in any order. For example,  is valid as well.

Given  and , partition  into , , and  using the Divide instructions above. Return a 1-dimensional array containing each element in  first, followed by each element in , followed by each element in .

Function Description

Complete the quickSort function in the editor below.

quickSort has the following parameter(s):

int arr[n]:  is the pivot element
Returns

int[n]: an array of integers as described above
Input Format

The first line contains , the size of .
The second line contains  space-separated integers  (the unsorted array). The first integer, , is the pivot element, .c





Solution:-
*/
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
           printArray(ar);
    }
    static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
    }
    static void partition(int[] ar) {
        int p=ar[0];
        int[] copy=Arrays.copyOf(ar, ar.length);
        int c=0;
        for(int i=1;i<ar.length;i++){
            if(copy[i]<=p){
                ar[c]=copy[i];
                c++;
            }
        }
        ar[c]=p;
        c++;
        for(int j=0;j<ar.length;j++){
            if(copy[j]>p){
                ar[c]=copy[j];
                c++;
            }
        }
    }   
}
