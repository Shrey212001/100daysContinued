/*

Topic:- Lego Blocks
 
Link:- https://www.hackerrank.com/challenges/lego-blocks/problem?isFullScreen=true

Problem:-

You have an infinite number of 4 types of lego blocks of sizes given as (depth x height x width):

d    h    w
1    1    1
1    1    2
1    1    3
1    1    4
Using these blocks, you want to make a wall of height n and width m. Features of the wall are:

- The wall should not have any holes in it.
- The wall you build should be one solid structure, so there should not be a straight vertical break across all rows of bricks.
- The bricks must be laid horizontally.

How many ways can the wall be built?

Example
n = 2
m = 3 

The height is 2 and the width is 3. Here are some configurations:

These are not all of the valid permutations. There are 9 valid permutations in all.

Function Description

Complete the legoBlocks function in the editor below.

legoBlocks has the following parameter(s):

int n: the height of the wall
int m: the width of the wall
Returns
- int: the number of valid wall formations modulo (10^9 + 7)

Input Format

The first line contains the number of test cases t.

Each of the next t lines contains two space-separated integers n and m.

Constraints

1 <= t <= 100
1 <= n,m <= 1000

Sample Input

STDIN   Function
-----   --------
4       t = 4
2 2     n = 2, m = 2
3 2     n = 3, m = 2
2 3     n = 2, m = 3
4 4     n = 4, m = 4
Sample Output

3  
7  
9  
3375
Explanation

For the first case, we can have:

3 mod (10^9+7)=3

For the second case, each row of the wall can contain either two blocks of width 1, or one block of width 2. However, the wall where all rows contain two blocks of width 1 is not a solid one as it can be divided vertically. Thus, the number of ways is

2x2x2-1=7 and 7 mod (10^9+7)=7




Solution:-
*/
import java.util.*;

public class Solution {
    int md=1000000007;
    int[][] ways = new int[1001][1001];
    int[][] waysRestrict = new int[1001][1001];
    public Solution(){
        for(int[] w : ways) Arrays.fill(w, -1);
        for(int[] w : waysRestrict) Arrays.fill(w, -1);
    }
    public int solve(int n, int m)
    {
        if (ways[n][m] != -1) return ways[n][m];
        long ans;
        if (m==1) ans = 1;
        else if (n==1){
            if (m<=4) {
                ans = 2*solve(1,m-1);
            }
            else {
                ans = solve(1,m-1);
                ans = (ans + solve(1,m-2))%md;
                ans = (ans + solve(1,m-3))%md;
                ans = (ans + solve(1,m-4))%md;
            }
        }
        else{
            ans = 1; int one = solve(1,m);
            for (int i=0; i<n; i++) ans = (ans * one)%md;
        }
        ways[n][m] = (int)ans;
        return ways[n][m];
    }
    public int solveRestrict(int n, int m)
    {
        if (waysRestrict[n][m] != -1) return waysRestrict[n][m];
        long ans;
        if (m==1) ans = 1;
        else {
            ans = solve(n,m);
            for (int i=1; i<m; i++) {
                long a = solve(n,i);
                a = (a*solveRestrict(n,m-i))%md;
                ans -= a;
                if (ans<0) ans+=md;
            }
        }
        waysRestrict[n][m] = (int)ans;
        return waysRestrict[n][m];
    }
    public static void main (String[] args) {
        Solution o = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int a, b;
            a = sc.nextInt(); b = sc.nextInt();
            System.out.println(o.solveRestrict(a,b));
        }
        sc.close();
    }
}
