/*

Topic:-  Stone Division, Revisited

Link:- https://www.hackerrank.com/challenges/stone-division-2/problem?isFullScreen=true

Problem:-

You have a pile of  stones that you want to split into multiple piles, as well as a set, , of  distinct integers. We define a move as follows:

First, choose a pile of stones. Let's say that the chosen pile contains  stones.
Next, look for some  such that  and  is divisible by  (i.e.,  is a factor of ); if such an  exists, you can split the pile into  equal smaller piles.
You are given  queries where each query consists of  and . For each query, calculate the maximum possible number of moves you can perform and print it on a new line

Input Format

The first line contains an integer, , denoting the number of queries. The  subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective values of  (the size of the initial pile in the query) and  (the size of the set in the query).
The second line contains  distinct space-separated integers describing the values in set .

Output Format

For each query, calculate the maximum possible number of moves you can perform and print it on a new line.




Solution:-
*/
import java.util.*;

public class Result {
    public static int solve(int n, int[] nums, int[] dp) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (n % v == 0 && n > v) {
                res = Math.max(res, 1 + dp[i] * (n / v));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int[] dp = new int[m];
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], 1 + dp[j] * (nums[i] / nums[j]));
                    }
                }
            }
            System.out.println(solve(n, nums, dp));
        }
    }
}
