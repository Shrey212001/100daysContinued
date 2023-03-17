/*

Topic:- Beautiful Binary String

Link:- https://www.hackerrank.com/challenges/beautiful-binary-string/problem?isFullScreen=true

Problem:-

Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".

In one step, Alice can change a  0 to a 1 or vice versa. Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Example

b =  010

She can change any one element and have a beautiful string.

Function Description

Complete the beautifulBinaryString function in the editor below.

beautifulBinaryString has the following parameter(s):

string b: a string of binary digits

Returns

int: the minimum moves required

Input Format

The first line contains an integer n, the length of binary string.
The second line contains a single binary string b.

Constraints

1  <=  n  <=  100
b[ i ]  e  {0, 1 }

Output Format

Print the minimum number of steps needed to make the string beautiful.



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
        String B = in.next();
        
        int i = 0;
        int total = 0;
        while (i < B.length()-2) {
            if (B.substring(i,i+3).equals("010")) {
                total++;
                i+=3;
            } else {
                i++;
            }
        }
        System.out.println(total);
    }
}
