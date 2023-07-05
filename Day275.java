/*

Topic:- Red John is Back

Link:- https://www.hackerrank.com/challenges/red-john-is-back/problem?isFullScreen=true

Problem:-

Red John has committed another murder. This time, he doesn't leave a red smiley behind. Instead he leaves a puzzle for Patrick Jane to solve. He also texts Teresa Lisbon that if Patrick is successful, he will turn himself in. The puzzle begins as follows.

There is a wall of size 4xn in the victim's house. The victim has an infinite supply of bricks of size 4x1 and 1x4 in her house. There is a hidden safe which can only be opened by a particular configuration of bricks. First we must calculate the total number of ways in which the bricks can be arranged so that the entire wall is covered. The following diagram shows how bricks might be arranged to cover walls where 1 <= n <= 4:

There is one more step to the puzzle. Call the number of possible arrangements M. Patrick must calculate the number of prime numbers P in the inclusive range 0-M.

As an example, assume n=3. From the diagram above, we determine that there is only one configuration that will cover the wall properly. 1 is not a prime number, so P=0.

A more complex example is n = 5. The bricks can be oriented in  total configurations that cover the wall. The two primes 2 and 3 are less than or equal to 3, so P =2.

Function Description

Complete the redJohn function in the editor below. It should return the number of primes determined, as an integer.

redJohn has the following parameter(s):

n: an integer that denotes the length of the wall

Input Format

The first line contains the integer t, the number of test cases.
Each of the next t lines contains an integer n, the length of the 4*n wall.

Constraints
1 <= t <= 20
1 <= n <= 40

Output Format

Print the integer P on a separate line for each test case.




Solution:-
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
    static long dp[];
    static HashSet<Integer> hs;
    public static void main(String arg[]){
        hs=new HashSet<Integer>();
        dp=new long[41];
        Arrays.fill(dp,-1);
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        setPrime();
        for (int j=0;j<N;j++){
            int val=sc.nextInt();
            int x=(int)(new Solution().get(val));
            int ans=0;
            for (int i=2;i<=x;i++){
                if(hs.contains(i))
                    ans++;
            }
            System.out.println(ans);
        }
    }
    public long get(int N){
        if(dp[N]!=-1)
            return dp[N];
        long ans=1;
        if(N<=3)
            ans=1;
        else {
            ans=get(N-1)+get(N-4);
        }
        dp[N]=ans;
        return ans;
    }
    static boolean isPrime(int a){
        for (int i=2;i*i<=a;i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
    static void setPrime(){
        for (int i=2;i<=217286;i++){
            if(isPrime(i))
                hs.add(i);
        }

    }

}
