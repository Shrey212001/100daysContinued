/*

Topic:- What's Next?

Link:- https://www.hackerrank.com/challenges/whats-next/problem?isFullScreen=true 

Problem:-

Johnny is playing with a large binary number, . The number is so large that it needs to be compressed into an array of integers, , where the values in even indices () represent some number of consecutive  bits and the values in odd indices () represent some number of consecutive  bits in alternating substrings of .

For example, suppose we have array .  represents ,  represents ,  represents ,  represents , and  represents . The number of consecutive binary characters in the  substring of  corresponds to integer , as shown in this diagram:

When we assemble the sequential alternating sequences of 's and 's, we get .

We define setCount() to be the number of 's in a binary number, . Johnny wants to find a binary number, , that is the smallest binary number  where setCount() = setCount(). He then wants to compress  into an array of integers,  (in the same way that integer array  contains the compressed form of binary string ).

Johnny isn't sure how to solve the problem. Given array , find integer array  and print its length on a new line. Then print the elements of array  as a single line of space-separated integers.

Input Format

The first line contains a single positive integer, , denoting the number of test cases. Each of the  subsequent lines describes a test case over  lines:

The first line contains a single positive integer, , denoting the length of array .
The second line contains  positive space-separated integers describing the respective elements in integer array  (i.e., ).

Output Format

For each test case, print the following  lines:

Print the length of integer array  (the array representing the compressed form of binary integer ) on a new line.
Print each element of  as a single line of space-separated integers.
It is guaranteed that a solution exists.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextLong();
            }
            if (n==1) {
                if (a[0]==1) {
                    System.out.println(2);
                    System.out.println("1 1");
                } else {
                    System.out.println(3);
                    System.out.println("1 1 "+(a[0]-1));
                }
                continue;
            } else if (n==2) {
                if (a[0]==1) {
                    System.out.println(2);
                    System.out.println("1 "+(a[1]+1));
                } else {
                    System.out.println(3);
                    System.out.println("1 "+(a[1]+1)+" "+(a[0]-1));
                }
                continue;
            }
            int last = (n-1)/2*2;
            ArrayList<Long> al = new ArrayList<Long>();
            for (int j = 0; j < last-1; j++) {
                al.add(a[j]);
            }
            al.add(a[last-1]-1);
            al.add(1l);
            if (last < n-1)
                al.add(1l+a[n-1]);
            else
                al.add(1l);
            al.add(a[last]-1);
            for (int j = 0; j < al.size(); j++) {
                if (al.get(j)==0) {
                    long repnum = al.remove(j-1);
                    al.remove(j-1);
                    if (j-1<al.size())
                        repnum += al.remove(j-1);
                    al.add(j-1,repnum);
                }
            }
            System.out.println(al.size());
            for (int j = 0; j < al.size(); j++) {
                if (j > 0)
                    System.out.print(" ");
                System.out.print(al.get(j));
            }
            System.out.println();
        }
    }
}  
