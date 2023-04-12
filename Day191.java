/*

Topic:- Lonely Integer

Link:- https://www.hackerrank.com/challenges/lonely-integer/problem?isFullScreen=true

Problem:-

Given an array of integers, where all elements but one occur twice, find the unique element.

Example
a = [1,2,3,4,3,2,1]
The unique element is 4.

Function Description

Complete the lonelyinteger function in the editor below.

lonelyinteger has the following parameter(s):

int a[n]: an array of integers
Returns

int: the element that occurs only once
Input Format

The first line contains a single integer, n, the number of integers in the array.
The second line contains n space-separated integers that describe the values in a.

Constraints
1 <= n < 100
It is guaranteed that n is an odd number and that there is one unique element.
0 <= a[i] <= 100, where 0 <= i < n.




Solution:-
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution{
    public static void main(String[] args) throws IOException {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[a] = !arr[a];
        }
        for (int i = 0; i < 101; i++) {
            if(arr[i]) {
                System.out.println(i);
                break;
            }
        }
        }
    catch(Exception e) {
    }
}
}
