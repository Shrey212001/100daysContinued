/*

Topic:- Max Min

Link:- https://www.hackerrank.com/challenges/angry-children/problem?isFullScreen=true

Problem:-

Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
Then print the respective minimum and maximum values as a single line of two space-separated long integers. 
Example

arr = [1,3,5,7,9]. Our minimum sum is 1 + 3 + 5 + 7 = 16 and our maximum sum is 3 + 5 + 7 + 9 = 24. The function prints

16 24

Function Description

Complete the miniMaxSum function in the editor below. It should print two space-separated integers on one line: the minimum sum and the maximum sum of 4 of 5 elements.
miniMaxSum has the following parameter(s):
arr: an array of 5 integers
Print

Print two space-separated integers on one line: the minimum sum and the maximum sum of elements.

Input Format

A single line of five space-separated integers.

Constraints

1<=arr[i]<=10^9

Output Format

Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32-bit integer.)

Sample Input

1 2 3 4 5

Sample Output

10 14




Solution:-
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int maxMin(int k, int[] arr) {
        int min=1000000000;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-k+1;i++){
            min=Math.min(min,arr[i+k-1]-arr[i]);
        }
        return min;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
