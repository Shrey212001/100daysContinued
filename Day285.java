/*

Topic:- The Indian Job

Link:- https://www.hackerrank.com/challenges/the-indian-job/problem?isFullScreen=true

Problem:-

It is the Indian version of the famous heist “The Italian Job”. N robbers have already broken into the National Museum and are just about to get inside the main vault which is full of jewels. They were lucky that just as they broke into the museum, the guard was leaving the museum for exactly G minutes. But there are other problems too. The main vault has heat sensors that if at any moment of time there are more than two people present in the vault, the alarm goes off.

To collect the jewels, the ith robber needs to be inside the vault for exactly A[i] minutes, 0 <= i < N, in one continuous stretch. As guard will return after G minutes, they have to finish their tasks within G minutes. The robbers want to know if there exists any arrangement such that demands of each robber is satisfied and also they are not caught?

Gotchas
If a robber goes inside the vault at a time "X" and at the same time another robber comes out, it's equivalent to saying they were never in the vault at the same time.
Similarly, when the guard gets inside vault at time G and a robber comes out exactly at time G, the guard will not be able see the robber.

Input Format

The first line contains an integer T denoting the number of testcases. T testcases follow. Each testcase consists of two lines. First line contains two space separated integers denoting N and G denoting the number of thieves and duration for which guard leaves the museum.
The next line contains N space separated numbers where the ith integer, A[i] represents the time the ith robber needs to be in the vault.

Constraints

1 <= T <= 20
1 <= N <= 100
0 <= G <= 1000000 (106)
0 <= A[i] <= 100

Output Format

For each testcase print YES if there exists such an arrangement or NO otherwise in a newline.

Sample Input

2
3 4
2 4 2
3 2
2 4 2
Sample Output

YES
NO
Explanation

Test case #00: In first testcase, one possible arrangement is:
at t=0, robber1 goes inside and comes out at t=2
at t=0, robber2 goes inside and comes out at t=4
at t=2, robber3 goes inside and comes out at t=4

Test case #01: No possible arrangement is possible in second testcase.




Solution:-
*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static String indianJob(int g, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][g+1];
        
    int sum = 0;
    for (int i=0; i<n; i++ )
    {
        sum += arr[i];
    }
 
   
    for (int i=1; i<=n; i++)
        for (int j=1; j<=g; j++)
            if (arr[i-1] <= j)
                dp[i][j] = Math.max(dp[i-1][j],
                        arr[i-1] + dp[i-1][j-arr[i-1]]);
            else
                dp[i][j] = dp[i-1][j];
 
    if(sum-dp[n][g] <= g) {
        return "YES";
    } else {
        return "NO";
    }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ng = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ng[0].trim());

            int g = Integer.parseInt(ng[1].trim());

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");

            for (int arrItr = 0; arrItr < n; arrItr++) {
                int arrItem = Integer.parseInt(arrItems[arrItr].trim());
                arr[arrItr] = arrItem;
            }

            String result = indianJob(g, arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
