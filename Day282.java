/*

Topic:- Play with words

Link:- https://www.hackerrank.com/challenges/strplay/problem?isFullScreen=true

Problem:-

Shaka and his brother have created a boring game which is played like this:

They take a word composed of lowercase English letters and try to get the maximum possible score by building exactly 2 palindromic subsequences. The score obtained is the product of the length of these 2 subsequences.

Let's say A and B are two subsequences from the initial string. If Ai & Aj are the smallest and the largest positions (from the initial word) respectively in A; and Bi & Bj are the smallest and the largest positions (from the initial word) respectively in B, then the following statements hold true:
Ai <= Aj,
Bi <= Bj, &
Aj < Bi.
i.e., the positions of the subsequences should not cross over each other.

Hence the score obtained is the product of lengths of subsequences A & B. Such subsequences can be numerous for a larger initial word, and hence it becomes harder to find out the maximum possible score. Can you help Shaka and his brother find this out?

Input Format

Input contains a word S composed of lowercase English letters in a single line.

Constraints
1 < |S| <= 3000

each character will be a lower case english alphabet.

Output Format

Output the maximum score the boys can get from S.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Dec101_C {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[][] L = new int[n][n];
        for (int i = 0; i < n; i++)
            L[i][i] = 1;

        int i = 0;
        int j = 0;
        int cl = 0;
        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (str.charAt(i) == str.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }
        }
        int res = 0;
        for(i = 1; i < n; i++){
            int v1 = L[0][i - 1];
            int v2 = L[i][n - 1];
            res = Math.max(res, v1 * v2);

        }
        System.out.println(res);
    }
}
