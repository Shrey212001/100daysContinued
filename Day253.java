/*

Topic:- Bonetrousle

Link:- https://www.hackerrank.com/challenges/bonetrousle/problem?isFullScreen=true

Problem:-

Here's a humerus joke:

Why did Papyrus the skeleton go to the store by himself? Because he had no body to go with him!

Did you like it? Don't worry, I've got a ton more. A skele-ton.

Once upon a time, Papyrus the skeleton went to buy some pasta from the store. The store's inventory is bare-bones and they only sell one thing — boxes of uncooked spaghetti! The store always stocks exactly k boxes of pasta, and each box is numbered sequentially from 1 to k. This box number also corresponds to the number of sticks of spaghetti in the box, meaning the first box contains 1 stick, the second box contains 2 sticks, the third box contains 3 sticks, …, and the kth box contains k sticks. Because they only stock one box of each kind, the store has a tendon-cy to sell out of spaghetti.

During each trip to the store, Papyrus likes to buy exactly n sticks of spaghetti by purchasing exactly b boxes (no more, no less). Not sure which boxes to purchase, Papyrus calls Sherlock Bones for help but he's also stumped! Do you have the guts to solve this puzzle?

Given the values of n, k, and b for t trips to the store, determine which boxes Papyrus must purchase during each trip. For each trip, print a single line of b distinct space-separated integers denoting the box number for each box of spaghetti Papyrus purchases (recall that the store only has one box of each kind). If it's not possible to buy  sticks of spaghetti by purchasing  boxes, print -1 instead.

For example, Papyrus wants to purchase n =14 sticks of spaghetti in b = 3 boxes and the store has k=8 different box sizes. He can buy boxes of sizes [8,4,2], [7,5,2], [7,6,1] and other combinations. Any of the combinations will work.

Function Description

Complete the bonetrousle function in the editor below. It should return an array of integers.

bonetrousle has the following parameter(s):

n: the integer number of sticks to buy
k: the integer number of box sizes the store carries
b: the integer number of boxes to buy
Input Format

The first line contains a single integer t, the number of trips to the store.
Each of the next t lines contains three space-separated integers n, k and b, the number of sticks to buy, the number of boxes for sale and the number of boxes to buy on this trip to the store.

Constraints
1 <= t <= 20
1 <= b <= 10^5
1 <= n,k <= 10^18
b <= k




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
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            int b = sc.nextInt();
            long diff = k-b;
            long[] selected = new long[b];
            long sum = 0;
            for (int i = 0; i < b; i++) {
                selected[i] = i+1;
                sum += i+1;
            }
            if (sum > n) {
                System.out.println(-1);
                continue;
            }
            long next = k+1;
            for (int i = b-1; i >= 0; i--) {
                sum += diff;
                if (sum < n) {
                    selected[i] = --next;
                } else {
                    sum -= diff;
                    selected[i] = n-sum+selected[i];
                    sum = n;
                    break;
                }
            }
            if (sum < n) {
                System.out.println(-1);
                continue;
            }
            StringBuilder print = new StringBuilder();
            for (int i = 0; i < b; i++) {
                if (i > 0)
                    print.append(" ");
                print.append(selected[i]);
            }
            System.out.println(print);
        }
    }
}
