/*

Topic:- Pairs

Link:- https://www.hackerrank.com/challenges/pairs/problem?isFullScreen=true
 
Problem:-

Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

Function Description

Complete the pairs function below.

pairs has the following parameter(s):

int k: an integer, the target difference
int arr[n]: an array of integers
Returns

int: the number of pairs that satisfy the criterion
Input Format

The first line contains two space-separated integers n and k, the size of arr and the target value.
The second line contains n space-separated integers of the array arr .

Constraints

2   <=   n   <=   10^5
0   <=   k   <=   10^9
0   <=   arr[ i ]  <=  2^31 -1
each integer arr[ i ]  will be unique

Sample Input

STDIN          Function
-----                 --------
5 2              arr[] size n = 5, k =2
1 5 3 4 2    arr = [1, 5, 3, 4, 2]

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
    static int pairs(int[] a,int k) {
        Arrays.sort(a);
        int N = a.length;
		int count = 0;
		for (int i = 0; i < N - 1; i++)
		{
			int j = i + 1;
			while((j < N) && (a[j++] - a[i]) < k);
			j--;
			while((j < N) && (a[j++] - a[i]) == k)
				count++;			
		}

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
