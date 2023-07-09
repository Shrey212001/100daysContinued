/*

Topic:- Bricks Game

Link:- https://www.hackerrank.com/challenges/play-game/problem?isFullScreen=true

Problem:-

You and your friend decide to play a game using a stack consisting of N bricks. In this game, you can alternatively remove 1, 2 or 3 bricks from the top, and the numbers etched on the removed bricks are added to your score. You have to play so that you obtain the maximum possible score. It is given that your friend will also play optimally and you make the first move.

As an example, bricks are numbered arr = [1,2,3,4,5]. You can remove either [1]=1, [1,2]=3 or [1,2,3] = 6. For your friend, your moves would leave the options of 1 to 3 elements from [2,3,4] = 9 leaving  for you (total score = 6), [3,4,5] = 12 or [4,5] =  9. In this case, it will never be optimal for your friend to take fewer than the maximum available number of elements. Your maximum possible score is 6, achievable two ways: 1 first move and 5 the second, or [1,2,3] in your first move.

Function Description

Complete the bricksGame function in the editor below. It should return an integer that represents your maximum possible score.

bricksGame has the following parameter(s):

arr: an array of integers
Input Format

The first line will contain an integer t, the number of test cases.

Each of the next t pairs of lines are in the following format:
The first line contains an integer , the number of bricks in arr.
The next line contains n space-separated integers $arr[i].

Constraints

1 <= t <= 5
1 <= n <= 10^5
0 <= arr[i] <= 10^9

Output Format

For each test case, print a single line containing your maximum score.




Solution:-
*/
import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int a[] = new int[n];
            long[] b = new long[n];
            long c[] = new long[n + 1];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = -1;
            }
            c[n - 1] = a[n - 1];
            c[n] = 0;
            for (int i = n - 2; i >= 0; i--)
                c[i] = c[i + 1] + a[i];

            System.out.println(play(a, b, c, 0));
        }
    }
    private static long play(int[] a, long[] b, long[] c, int i) {
        int n = a.length;
        if (i == n)
            return 0;
        if (b[i] != -1)
            ;
        else if (i >= n - 3) {
            b[i] = 0;
            for (int j = i; j < n; j++)
                b[i] += a[j];
        } else {
            b[i] = a[i] + a[i + 1] + a[i + 2] + c[i + 3] - play(a, b, c, i + 3);
            b[i] = Math.max(a[i] + c[i + 1] - play(a, b, c, i + 1), b[i]);
            b[i] = Math.max(b[i], a[i] + a[i + 1] + c[i + 2] - play(a, b, c, i + 2));
        }
        return b[i];
    }
}
