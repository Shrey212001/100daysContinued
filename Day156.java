/*

Topic:- Weighted Uniform Strings

Link:- https://www.hackerrank.com/challenges/weighted-uniform-string/problem?isFullScreen=true

Problem:-

A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are 1 to 26  from  a to z  as shown below:

The weight of a string is the sum of the weights of its characters. For example:

A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not.

Function Description

Complete the weightedUniformStrings function in the editor below.

weightedUniformStrings has the following parameter(s):
- string s: a string
- int queries[n]: an array of integers

Returns
- string[n]: an array of strings that answer the queries

Input Format

The first line contains a string s, the original string.
The second line contains an integer n, the number of queries.
Each of the next s lines contains an integer queries[i], the weight of a uniform subtring of s that may or may not exist.

Constraints


1  <=  length of s,n  <=  10^5
1  <=   queries[i]  <=  10^7
s will only contain lowercase English letters, ascii[a-z].



Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len =  s.length();
        int n = in.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int i=0;
        while(i<len){
             int j=i;
             int sum =0;
             while( j<len && s.charAt(i)==s.charAt(j) ){
                 sum += (s.charAt(i)-'a') +1;
                 set.add(sum);
                 j++;
             }
            i = j;
        }
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if (set.contains(x)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
