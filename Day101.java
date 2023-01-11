/*
Topic:- Circular Array Rotation

Link:- https://www.hackerrank.com/challenges/circular-array-rotation/problem?isFullScreen=true

Problem:-

John Watson knows of an operation called a right circular rotation on an array of integers. One rotation operation moves the last array element to the first position and shifts all remaining elements right one. To test Sherlock’s abilities, Watson provides Sherlock with an array of integers. Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.

For each array, perform a number of right circular rotations and return the values of the elements at the given indices.

Example
a = [3, 4, 5]
k = 2
queries = [1, 2]

Here k is the number of rotations on a, and queries holds the list of indices to report. First we perform the two rotations: 
[3, 4, 5] -> [5, 3, 4] -> [4, 5, 3]

Now return the values from the zero-based indices 1 and 2 as indicated in the queries array.
a[1] = 5
a[2] = 3

Function Description

Complete the circularArrayRotation function in the editor below.

circularArrayRotation has the following parameter(s):

int a[n]: the array to rotate
int k: the rotation count
int queries[1]: the indices to report

Returns
int[q]: the values in the rotated a as requested in m

Input Format

The first line contains 3 space-separated integers, n, k, and q, the number of elements in the integer array, the rotation count and the number of queries.
The second line contains n space-separated integers, where each integer i describes array element a[i] (where 0 <= i < n).
Each of the q subsequent lines contains a single integer, queries[i], an index of an element in a to return.

Constraints
1 <= n <= 105
1 <= a[i] <= 105
1 <= k <= 105
1 <= q <= 500
0 <= queries[i] < n
Sample Input 0

3 2 3
1 2 3
0
1
2

Sample Output 0
2
3
1

Explanation 
After the first rotation, the array is [3, 1, 2].
After the second (and final) rotation, the array is [2, 3, 1].

We will call this final state array b = [2, 3, 1]. For each query, we just have to get the value of b[queries[i]].

queries[0] = 0, b[0] = 2
queries[1] = 1, b[1] = 3
queries[2] = 2, b[2] = 1



Solution:-
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int index;
        
        for(int i = 0; i < n; i++)
        {
            list.add(in.nextInt()); 
        }
        
        while(k > 0)
        {
            int j = list.removeLast();
            list.push(j);
            k--;
        }
        
        while(q > 0)
        {
            index = in.nextInt();
            System.out.println(list.get(index));
            q--;
        }
        in.close();
    }

    
}
