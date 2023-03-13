/*

Topic:- Counting Sort 2

Link:- https://www.hackerrank.com/challenges/countingsort2/problem?isFullScreen=true

Problem:-

Often, when a list is sorted, the elements being sorted are just keys to other values. For example, if you are sorting files by their size, the sizes need to stay connected to their respective files. You cannot just take the size numbers and output them in order, you need to output all the required file information.

The counting sort is used if you just need to sort a list of integers. Rather than using a comparison, you create an integer array whose index range covers the entire range of values in your array to sort. Each time a value occurs in the original array, you increment the counter at that index. At the end, run through your counting array, printing the value of each non-zero valued index that number of times.

Challenge
Given an unsorted list of integers, use the counting sort method to sort the list and then print the sorted list.

Hint: You can use your previous code that counted the items to print out the actual values in order.

Function Description

Complete the countingSort function in the editor below. It should return the original array, sorted ascending, as an array of integers.

countingSort has the following parameter(s):

arr: an array of integers

Input Format

The first line contains an integer n, the length of arr. The next line contains space-separated integers  arr[i] where 0  <=  i < n .

Constraints

0  <=  n  <= 10000000
0  <=  arr[ i ]  <=  100

Output Format

Print the sorted list as a single line of space-separated integers.





Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   	
	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[100];
		for (int i = 0; i < n; i++) {
			ar[in.nextInt()]++;
		}
		for(int i = 0; i <ar.length ;i++){
			while(ar[i] > 0){
				System.out.print(i + " ");
				ar[i]--;
			}
		}
		
	}
}
