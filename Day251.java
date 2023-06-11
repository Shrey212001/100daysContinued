/*

Topic:- New Year Chaos

Link:- https://www.hackerrank.com/challenges/new-year-chaos/problem?isFullScreen=true

Problem:-

It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from 1 to n. Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.

Example

q = [1,2,3,5,4,6,7,8]
If person 5 bribes person 4, the queue will look like this: 1,2,3,5,4,6,7,8. Only 1 bribe is required. Print 1.
q = [4,1,2,3]

Person 4 had to bribe 3 people to get to the current position. Print Too chaotic.

Function Description

Complete the function minimumBribes in the editor below.

minimumBribes has the following parameter(s):

int q[n]: the positions of the people after all bribes

Returns

No value is returned. Print the minimum number of bribes necessary or Too chaotic if someone has bribed more than 2 people.

Input Format

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines are as follows:
- The first line contains an integer t, the number of people in the queue
- The second line has n space-separated integers describing the final state of the queue.

Constraints

1 <= t <= 10
1 <= n <= 10^5




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
        int T = in.nextInt();
        int a,c;
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n], q2[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt()-1;
                q2[q_i] = q_i;
            }
            c=0;
            for(int i=0;i<n;i++) {
                if (q[i]==q2[i]) {
                    
                } else if (q[i]==q2[i+1]) {
                    a=q2[i];
                    q2[i]=q2[i+1];
                    q2[i+1]=a;
                    c++;
                } else if (q[i]==q2[i+2]) {
                    a=q2[i+1];
                    q2[i+1]=q2[i+2];
                    q2[i+2]=a;
                    a=q2[i];
                    q2[i]=q2[i+1];
                    q2[i+1]=a;
                    c+=2;
                } else {
                    System.out.println("Too chaotic");
                    i=n;
                }
                if (i==n-1) {
                    System.out.println(c);
                }
            }
        }
    }
}
