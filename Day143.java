/*

Topic:- Intro to Tutorial Challenges

Link:- https://www.hackerrank.com/challenges/tutorial-intro/problem?isFullScreen=true

Problem:-

This is a simple challenge to get things started. Given a sorted array () and a number (), can you print the index location of  in the array?

Example

Return  for a zero-based index array.

If you are going to use the provided code for I/O, this next section is for you.

Function Description

Complete the introTutorial function in the editor below. It must return an integer representing the zero-based index of .

introTutorial has the following parameter(s):

int arr[n]: a sorted array of integers
int V: an integer to search for
Returns

int: the index of  in 
The next section describes the input format. You can often skip it, if you are using included methods or code stubs.

Input Format

The first line contains an integer, , a value to search for.
The next line contains an integer, , the size of . The last line contains  space-separated integers, each a value of  where .

The next section describes the constraints and ranges of the input. You should check this section to know the range of the input.



Solution:-

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int cas = sc.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int i = 0;i<cas; i++)
        {
            ar.add(sc.nextInt());
        }
        
        for(int n = 0; n < ar.size();n++)
        {
            if(ar.get(n) == value)
                System.out.println(n);
        }
    }
}
