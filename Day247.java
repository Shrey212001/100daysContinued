/*

Topic:- Equal

Link:- https://www.hackerrank.com/challenges/equal/problem?isFullScreen=true

Problem:-

Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. She is biased towards her friends and plans to give them more than the others. One of the program managers hears of this and tells her to make sure everyone gets the same number.

To make things difficult, she must equalize the number of chocolates in a series of operations. For each operation, she can give 1, 2 or 5 pieces to all but one colleague. Everyone who gets a piece in a round receives the same number of pieces.

Given a starting distribution, calculate the minimum number of operations needed so that every colleague has the same number of pieces.

Example
arr = [1, 1, 5]
arr represents the starting numbers of pieces for each colleague. She can give 2 pieces to the first two and the distribution is then [3, 3, 5]. On the next round, she gives the same two 2 pieces each, and everyone has the same number: [5, 5, 5]. Return the number of rounds, 2.

Function Description

Complete the equal function in the editor below.

equal has the following parameter(s):

  int arr[n]: the integers to equalize

Returns

  int: the minimum number of operations required

Input Format

The first line contains an integer t, the number of test cases.

Each test case has 2 lines.
- The first line contains an integer n, the number of colleagues and the size of arr.
- The second line contains n space-separated integers, arr[i], the numbers of pieces of chocolate each colleague has at the start.

Constraints

1 <= t <= 100
1 <= n <= 10000
The number of chocolates each colleague has initially < 1000.




Solution :-
*/

import java.io.BufferedInputStream;
import java.util.Scanner;


public class Solution {
    static int offset = 100;
    static Integer f[][] = new Integer[1111][1111];
    static int a[] = new int[11111];
    
    static Integer F(int i, int j) {
        if (i < j) return Integer.MAX_VALUE / 2;
        if (f[i + offset][j + offset] != null) return f[i + offset][j + offset];
        if (i == j) return 0;
        int ans = Integer.MAX_VALUE / 2;
        ans = Math.min(ans, F(i - 1, j) + 1);
        ans = Math.min(ans, F(i - 2, j) + 1);
        ans = Math.min(ans, F(i - 5, j) + 1);
        return f[i + offset][j + offset] = ans;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
    
        for (int T = cin.nextInt(); T!=0; T--) {
            int n = cin.nextInt();
            int min = Integer.MAX_VALUE;
            for (int i=0; i<n; i++) {
                a[i] = cin.nextInt();
                min = Math.min(min, a[i]);
            }
            int ans = Integer.MAX_VALUE;
            for (int i=min; i>=min-30; i--) {
                int tmp = 0;
                for (int j=0; j<n; j++) {
                    tmp += F(a[j], i);
                }
                ans = Math.min(ans, tmp);
            }
            System.out.println(ans);
        }
    }
}
