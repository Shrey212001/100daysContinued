/*

Topic:- Smart Number

Link:-https://www.hackerrank.com/challenges/smart-number/problem?isFullScreen=true

Problem:-

In this challenge, the task is to debug the existing code to successfully execute all provided test files.

A number is called a smart number if it has an odd number of factors. Given some numbers, find whether they are smart numbers or not.

Debug the given function is_smart_number to correctly check if a given number is a smart number.

Note: You can modify only one line in the given code and you cannot add or remove any new lines.

To restore the original code, click on the icon to the right of the language selector.

Input Format

The first line of the input contains t, the number of test cases.
The next  t lines contain one integer each.

Constraints

1   <=   t  <= 10^3
1   <=   ni   <=  10^4 , where ni is the ith  integer.

Output Format

The output should consist of t lines. In the ith line print YES if the ith  integer has an odd number of factors, else print NO.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);    
        if(num / (double) val == val)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for(int i = 0; i < test_cases; i++){
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if(ans){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
