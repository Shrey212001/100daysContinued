/*

Topic:- Super Reduced String

Link:- https://www.hackerrank.com/challenges/reduced-string/problem?isFullScreen=true

Problem:-

Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations. In each operation, select a pair of adjacent letters that match, and delete them.

Delete as many characters as possible using this method and return the resulting string. If the final string is empty, return Empty String

Example.

s = ‘aab’


aab shortens to b in one operation: remove the adjacent a characters.

s = ‘abba’

Remove the two ‘b’ characters leaving ‘aa’. Remove the two ‘a’ characters to leave ”. Return ‘Empty String’.

Function Description


Complete the superReducedString function in the editor below.

superReducedString has the following parameter(s):

string s: a string to reduce
Returns

string: the reduced string or Empty String
Input Format
A single string, s.


Constraints
1 <= length of s <= 100
Sample Input 0

aaabccddd
Sample Output 0

abd
Explanation 0

Perform the following sequence of operations to get the final string:


aaabccddd → abccddd → abddd → abd
Sample Input 1

aa
Sample Output 1

Empty String
Explanation 1

aa → Empty String
Sample Input 2


baab
Sample Output 2

Empty String
Explanation 2

baab → bb → Empty String



Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static String super_reduced_string(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek()==ch)
                stack.pop();
            else
                stack.push(ch);
        }
        if(stack.isEmpty())
            return "Empty String";
        else
        {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty())
            {
                sb.append(stack.peek());
                stack.pop();
            }
            sb.reverse();
            String result = String.valueOf(sb);
            return result;
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
