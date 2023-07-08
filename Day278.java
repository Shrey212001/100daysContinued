/*

Topic:- Knapsack

Link:- https://www.hackerrank.com/challenges/unbounded-knapsack/problem?isFullScreen=true

Problem:-

Given an array of integers and a target sum, determine the sum nearest to but not exceeding the target that can be created. To create the sum, use any element of your array zero or more times.

For example, if arr = [2,3,4] and your target sum is 10, you might select [2,2,2,2,2], [2,2,3,3] or [3,3,31]. In this case, you can arrive at exactly the target.

Function Description

Complete the unboundedKnapsack function in the editor below. It must return an integer that represents the sum nearest to without exceeding the target value.

unboundedKnapsack has the following parameter(s):

k: an integer
arr: an array of integers
Input Format

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines are as follows:
- The first line contains two integers n and k, the length of arr and the target sum.
- The second line contains n space separated integers arr[i].

Constraints

1 <= t <= 10
1 <= n,k,arr[i] <= 2000

Output Format

Print the maximum sum for each test case which is as near as possible, but not exceeding, to the target sum on a separate line.




Solution:-
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            HashSet<Integer> map = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                map.add(sc.nextInt());
            }
            System.out.println(getMultSum(map, k));
        }
    }
    private static int getMultSum(HashSet<Integer> map, int k) {
        Iterator<Integer> it = map.iterator();
        boolean[] sum = new boolean[k + 1];
        Arrays.fill(sum, false);
        sum[0] = true;
        int a = 0;
        for (int i = 0; i <= k; i++) {

            if (sum[i] == true) {
                it = map.iterator();
                while (it.hasNext()) {
                    a = it.next();
                    if ((i + a) <= k)
                        sum[i + a] = true;
                }
            }
        }
        for(int i=k;i>=0;i--){
            if(sum[i] == true){
                return i;
            }
        }
        return 0;
    }
}
