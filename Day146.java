/*

Topic:- Strong Password

Link:- https://www.hackerrank.com/challenges/strong-password/problem?isFullScreen=true

Problem:-

Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password. However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:

Its length is at least 6.
It contains at least one digit.
It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+


She typed a random string of length n in the password field but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters she must add to make her password strong?

Note: Here's the set of types of characters in a form you can paste in your solution:

numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"



Function Description

Complete the minimumNumber function in the editor below.

minimumNumber has the following parameters:

int n: the length of the password
string password: the password to test


Returns

int: the minimum number of characters to add


Input Format

The first line contains an integer n, the length of the password.

The second line contains the password string. Each character is either a lowercase/uppercase English alphabet, a digit, or a special character.


Constraints

1  <=   n  <=   100



Solution:-
*/
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        Matcher num,low,up,spec;
        num = Pattern.compile("[0123456789]").matcher(s);
        low = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]").matcher(s);
        up = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]").matcher(s);
        spec = Pattern.compile("[!@#$%^&*()-/+]").matcher(s);
        int count = 0;
        if(!num.find())
            count++;
        if(!low.find())
            count++;
        if(!up.find())
            count++;
        if(!spec.find())
            count++;
        if(n+count<6){
            count+=6-n-count;
        }
        System.out.println(count);
    }
}
