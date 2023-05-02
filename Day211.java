/*

Topic:- Bear and Steady Gene

Link:- https://www.hackerrank.com/challenges/bear-and-steady-gene/problem?isFullScreen=true

Problem:-

A gene is represented as a string of length  (where  is divisible by ), composed of the letters , , , and . It is considered to be steady if each of the four letters occurs exactly  times. For example,  and  are both steady genes.

Bear Limak is a famous biotechnology scientist who specializes in modifying bear DNA to make it steady. Right now, he is examining a gene represented as a string . It is not necessarily steady. Fortunately, Limak can choose one (maybe empty) substring of  and replace it with any string of the same length.

Modifying a large substring of bear genes can be dangerous. Given a string , can you help Limak find the length of the smallest possible substring that he can replace to make  a steady gene?

Note: A substring of a string  is a subsequence made up of zero or more contiguous characters of .

As an example, consider . The substring  just before or after  can be replaced with  or . One selection would create .

Function Description

Complete the  function in the editor below. It should return an integer that represents the length of the smallest substring to replace.

steadyGene has the following parameter:

gene: a string
Input Format

The first line contains an interger  divisible by , that denotes the length of a string .
The second line contains a string  of length n.


Output Format

Print the length of the minimum length substring that can be replaced to make  gene stable.

Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int code(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        int j = n-1;
        int[] count = new int[4];
        while (true) {
            if (j == -1) {
                System.out.println("0");
                return;
            }
            if (count[code(str.charAt(j))] + 1 > n/4) {
                j++;
                break;
            }
            count[code(str.charAt(j))]++;
            j--;
        }
        int result = j;
        for (int i = 0; i < n; i++) {
            count[code(str.charAt(i))]++;
            while(count[code(str.charAt(i))] > n/4) {
                if (j == n) {
                    System.out.println(result);
                    return;
                }
                count[code(str.charAt(j))]--;
                j++;
            }
            result = Math.min(result, j - i - 1);
        }
        System.out.println(result);
    }
}
