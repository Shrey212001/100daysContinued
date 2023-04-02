/*

Topic:- Luck Balance
 
Link:- https://www.hackerrank.com/challenges/luck-balance/problem?isFullScreen=true

Problem:-

Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests. Initially, her luck balance is 0. She believes in "saving luck", and wants to check her theory. Each contest is described by two integers, L[ i ] and T[ i ]:

L[ i ] is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by ; if she loses it, her luck balance will increase by L[ i ].
T[ i ] denotes the contest's importance rating. It's equal to 1 if the contest is important, and it's equal to 0 if it's unimportant.

If Lena loses no more than k important contests, what is the maximum amount of luck she can have after competing in all the preliminary contests? This value may be negative.

Function Description

Complete the luckBalance function in the editor below.

luckBalance has the following parameter(s):

int k: the number of important contests Lena can lose
int contests[n][2]: a 2D array of integers where each contests[ i ] contains two integers that represent the luck balance and importance of the ith contest
Returns

int: the maximum luck balance achievable
Input Format

The first line contains two space-separated integers n and k, the number of preliminary contests and the maximum number of important contests Lena can lose.
Each of the next n lines contains two space-separated integers, L[ i ] and T[ i ], the contest's luck balance and its importance rating.


Sample Input

STDIN       Function
-----       --------
6 3         n = 6, k = 3
5 1         contests = [[5, 1], [2, 1], [1, 1], [8, 1], [10, 0], [5, 0]]
2 1
1 1
8 1
10 0
5 0
Sample Output

29



Solution:-
*/
import java.util.Arrays;
import java.util.Scanner;
public class LuckBalance {

    static class Contest implements Comparable<Contest> {
        int l,t;

        @Override
        public int compareTo(Contest o) {
            if(t == o.t) {
                return (this.l - o.l);
            }else {
                return -(this.t - o.t);
            }
        }
    }
    public static void main(String[] args) {
        int N, K;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        int total = 0;
        int t,l;
        Contest[] contests = new Contest[N];
        int importCnt = 0;
        for (int i = 0; i < N; i++) {

            l = scanner.nextInt();
            t = scanner.nextInt();
            total += l;
            if(t == 1) {
                importCnt++;
            }
            Contest contest = new Contest();
            contest.l = l;
            contest.t = t;

            contests[i] = contest;
        }

        Arrays.sort(contests);

        int winCnt = importCnt - K;
        if(winCnt <= 0) {
            System.out.println(total);
            return;
        }

        for (int i = 0; i < winCnt; i++) {
            total -= 2 * contests[i].l;
        }
        System.out.println(total);



    }
}
