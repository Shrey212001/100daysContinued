/*

Topic:- Fair Cut

Link:- https://www.hackerrank.com/challenges/fair-cut/problem?isFullScreen=true

Problem:-

Li and Lu have n integers, a1,a2, ...,an, that they want to divide fairly between the two of them. They decide that if Li gets integers with indices I = {i1, i2, ...,  ik} (which implies that Lu gets integers with indices J = {1, 2, ...,n}\I), then the measure of unfairness of this division is:
    f(I) =  Σ(i∈I) Σ(j∈J)|ai-aj|
Find the minimum measure of unfairness that can be obtained with some division of the set of integers where Li gets exactly k integers.

Note A\B means Set complement

Input Format

The first line contains two space-separated integers denoting the respective values of  n(the number of integers Li and Lu have) and k (the number of integers Li wants).
The second line contains n space-separated integers describing the respective values of a1, a2, ..., an.

Constraints

1 <= k < n < =3000
1 <= ai <= 10^9
For 15% of the test cases, n <=20.
For 45% of the test cases, n <=40.
Output Format

Print a single integer denoting the minimum measure of unfairness of some division where Li gets k integers.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  private static long[] DIFF;
  private static long[] DATA;
  private static int COUNT;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         COUNT = sc.nextInt();
        DATA = new long[n];
        for(int i = 0 ; i < n ; i++) {
            DATA[i] = sc.nextLong();
        }    
      COUNT = Math.min(DATA.length - COUNT, COUNT);
     DIFF = new long[DATA.length];
     System.out.println(calc2());
    }
         private static long calc2() {
    Arrays.sort(DATA);
    long[] sum = new long[DATA.length + 1];
    for (int i = 1; i <= DATA.length; i++) {
      sum[i] = sum[i - 1] + DATA[i - 1];
    }
    for (int i = 0; i < DATA.length; i++) {
      for (long aT : DATA) {
        DIFF[i] += Math.abs(DATA[i] - aT);
      }
    }
    return Math.min(clc(0), clc(1));
  }
  private static long clc(int i) {
    long chSum = 0;
    long summ0 = 0;
    for (int j = 0; j < DATA.length; j++) {
      if (!valid(j, i)) {
        continue;
      }
      chSum += DATA[j];
      for (int m = 0; m < DATA.length; m++) {
        if (!valid(m, i)) {
          summ0 += Math.abs(DATA[j] - DATA[m]);
        }
      }
    }
    long min = summ0;
    int first = i;
    int next = 2 * COUNT + i;
    while (next < DATA.length) {
      chSum -= DATA[first];
     summ0 -= DIFF[first];
      summ0 += 2 * (chSum - DATA[first] * (COUNT - 1));
      summ0 += DIFF[next];
      summ0 -=  2 * (DATA[next] * (COUNT - 1) - chSum);
     chSum += DATA[next];
     min = Math.min(summ0, min);
      next += 2;
      first += 2;
    }
    return min;
  }
 private static boolean valid(int j, int i) {
    return j % 2 == i && j < COUNT * 2;
  }
}
