/*

Topic:- HackerRank in a String!

Link:- https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem?isFullScreen=true

Problem:-

We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank. Remember that a subsequence maintains the order of characters selected from a sequence.

More formally, let p[0],p[1],…p[9] be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If p[0]<p[1]<p[2]<…p[9] is true, then s contains hackerrank.


For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.

Example

s=haacckkerrannkk


This contains a subsequence of all of the characters in the proper order. Answer YES

s=haacckkerannk

This is missing the second ‘r’. Answer NO.


s=hccaakkerrannkk

There is no ‘c’ after the first occurrence of an ‘a’, so answer NO.

Function Description

Complete the hackerrankInString function in the editor below.

hackerrankInString has the following parameter(s):

string s: a string
Returns

string: YES or NO
Input Format

The first line contains an integer , the number of queries.

Each of the next  lines contains a single query string .


Constraints

1<=q<=10^2
10<=length of s<=10^4
Sample Input 0

2

hereiamstackerrank

hackerworld


Sample Output 0

YES

NO
 

Explanation 0

We perform the following  queries:

s=hereiamstackerrank
The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we return YES.
s=hackerworld does not contain the last three characters of hackerrank, so we return NO.
Sample Input 1

2

hhaacckkekraraannk

rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
 

Sample Output 1

YES

NO




Solution:-
*/
import java.util.Scanner;

public class LCS {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int q = scan.nextInt();
        while (q-- > 0) {
            String s1 = scan.next();
            String s2 = "hackerrank";
            int m = s1.length();
            int n = s2.length();

            char a[] = s1.toCharArray();
            char b[] = s2.toCharArray();

            int c[][] = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (b[i - 1] == a[j - 1]) {
                        c[i][j] = c[i - 1][j - 1] + 1;
                    } else {
                        c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                    }
                }
            }
            int count = c[n][m];
            if(count == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
