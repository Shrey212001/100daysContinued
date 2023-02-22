/*
Topic:- Big Sorting

Link:- hackerrank.com/challenges/big-sorting/problem?isFullScreen=true

Problem:-

Consider an array of numeric strings where each string is a positive number with anywhere from 1 to 106 digits. Sort the array’s elements in non-decreasing, or ascending order of their integer values and return the sorted array.

Example

unsorted = [‘1’, ‘200’, ‘150’, ‘3’]

Return the array [‘1’, ‘3’, ‘150’, ‘200’].


Function Description

Complete the bigSorting function in the editor below.

bigSorting has the following parameter(s):

string unsorted[n]: an unsorted array of integers as strings
Returns


string[n]: the array sorted in numerical order
Input Format
The first line contains an integer, n, the number of strings in unsorted.
Each of the n subsequent lines contains an integer string, unsorted[i].

Constraints
1 <= n <= 2 x 105
Each string is guaranteed to represent a positive integer.
There will be no leading zeros.
The total number of digits across all strings in unsorted is between 1 and 106 (inclusive).
Sample Input 0

6
31415926535897932384626433832795
1
3
10
3
5

Sample Output 0

1
3
3
5
10
31415926535897932384626433832795

Explanation 0


The initial array of strings is unsorted = [13351031415926535897932384626433832795]. When we order each string by the real-world integer value it represents, we get:

1 <= 3 <= 3 <= 5 <= 10 <= 31415926535897932384626433832795

We then print each value on a new line, from smallest to largest.

Sample Input 1


8
1
2
100
12303479849857341718340192371
3084193741082937
3084193741082938
111
200

Sample Output 1

1
2
100
111
200
3084193741082937
3084193741082938
12303479849857341718340192371




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
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int i = 0; i < n; i++) unsorted[i] = in.next();

        Arrays.sort(unsorted,new Comparator<String>() {
            @Override
            public int compare(String a, String b) 
            {
                return StringAsIntegerCompare(a,b);
            }
        });
        
        StringBuilder output = new StringBuilder("");
        for(String num : unsorted)
            output.append(num+"\n");
        System.out.println(output);
    }
    
    //0 means s1=s2, 1 means s1>s2, -1 means s1<s2 
    static int StringAsIntegerCompare(String s1, String s2)
    {
        if(s1.length() > s2.length()) return 1;
        if(s1.length() < s2.length()) return -1;
        for(int i = 0; i < s1.length(); i++)
        {
            if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
            if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
        }
        return 0;
    }
}
