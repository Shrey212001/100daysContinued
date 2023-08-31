/*

Topic:- Build a String

Link:- https://www.hackerrank.com/challenges/build-a-string/problem?isFullScreen=true

Problem:-

Greg wants to build a string, S of length N. Starting with an empty string, he can perform 2 operations:

1. Add a character to the end of S for A dollars.
2. Copy any substring of S, and then add it to the end of S for B dollars.

Calculate minimum amount of money Greg needs to build S.

Input Format

The first line contains number of testcases T.

The 2 x T  subsequent lines each describe a test case over 2 lines:
The first contains 3 space-separated integers, , N , A and B, respectively.
The second contains  S (the string Greg wishes to build).

Constraints

1   <=   T  <=   3
1   <=   N  <=   3 x 10^4
1  <=   A,  B  <=  10000

S is composed of lowercase letters only.


Output Format

On a single line for each test case, print the minimum cost (as an integer) to build S.

Sample Input

2
9 4 5
aabaacaba
9 8 9
bacbacacb
Sample Output

26
42
Explanation

Test Case 0:
 "";  ""
Append "";  ""; cost is 
Append "";  ""; cost is 
Append "";  ""; cost is 
Copy and append "";  ""; cost is 
Append "";  ""; cost is 
Copy and append "";  ""; cost is 

Summing each cost, we get , so our output for Test Case 1 is .

Test Case 1:
 "";  ""
Append "";  ""; cost is 
Append "";  ""; cost is 
Append "";  ""; cost is 
Copy and append "";  ""; cost is 
Copy and append "";  ""; cost is 

Summing each cost, we get , so our output for Test Case 2 is .




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
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            String S = sc.next();
            System.out.println( buildStringCost(N,A,B,S) );
        }
    }
    
    public static int buildStringCost(int N, int A, int B, String S){
        int[] dp = new int[N];
        dp[0] = A;
        int lastL = 0;
        for(int k=1;k<N;++k){
            dp[k] = dp[k-1]+A;
            int L = lastL+1;
            while(L>0){
                String cur = S.substring(k-L+1, k+1);
                int idx = S.substring(0, k-L+1).indexOf(cur);
                if( -1==idx )
                    L--;
                else{
                    dp[k] = Math.min(dp[k], dp[k-L]+B);
                    break;
                }
            }
            lastL = L;
        }
        return dp[N-1];
    }
}
