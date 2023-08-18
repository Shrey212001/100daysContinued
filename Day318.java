/*

Topic:- Tower Breakers - The Final Battle

Link:- https://www.hackerrank.com/challenges/tower-breakers-the-final-battle-1/problem?isFullScreen=true

Problem:-

Our unsung tower-breaking heroes (players P1 and P2) only have one tower left,
and they've decided to break it for a special game commemorating the end of 5 days of Game Theory! 
The rules are as follows:

P1 always moves first, and both players always move optimally.
Initially, there is 1 tower of height N.

The players move in alternating turns. The moves performed by each player are different:
At each turn, P1 divides the current tower into some number of smaller towers.
If the turn starts with a tower of height H and P1 breaks it into smaller towers, the following condition must apply: H = h1 + h2 +...+ Hx,
where H1 denotes the height of the ith new tower.
At each turn, P2 chooses some tower K of the X new towers made by P1 (where 1 <= K <= X).
Then P1 must pay the square of K coins to P2. After that, P1 gets another turn with tower Hk and the game continues.
The game is over when no valid move can be made by P1, meaning that H = 1.
P1's goal is to pay as few coins as possible, and P2's goal is to earn as many coins as possible.
Can you predict the number of coins that P2 will earn?
  Input Format

The first line contains a single integer, , denoting the number of test cases.
Each of the  subsequent lines contains a single integer, , defining the initial tower height for a test case.

Constraints

Output Format

For each test case, print a single integer denoting the number of coins earned by  on a new line.

Sample Input

3
4
2
7

Sample Output

6
4
8





Solution:-
*/
import java.io.*;
import java.util.*;
public class Solution {
    private ArrayList<Long> maxN;   
    public static void main(String[] args) {
        Solution solver = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            long N = in.nextLong();
            System.out.println(solver.getAnswer(N));
        }
    }  
    private int getAnswer(long N) {
        if (maxN == null) {
            maxN = new ArrayList<>();
            maxN.add(1L);
        }
        while (maxN.get(maxN.size() - 1) < N) {
            findNextMaxN();
        }      
        int i = 0;
        while (N > maxN.get(i)) {
            ++i;
        }
        return i;
    }  
    private void findNextMaxN() {
        int cost = maxN.size();
        long L = maxN.get(cost - 1);
        long R = 2 * L + 100;
        while (L + 1 < R) {
            long M = (L + R) / 2;
            if (trySplit(M, cost)) {
                L = M;
            } else {
                R = M;
            }
        }
        maxN.add(L);
    }
    private boolean trySplit(long N, int cost) {
        long sum = N;
        int pos = 1;
        while (sum > 0) {
            if (pos * pos > cost) { return false; }
            long cur = maxN.get(cost - pos * pos);
            sum -= cur;
            pos++;
        }
        return true;
    }
}
