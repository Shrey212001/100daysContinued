/*

Topic:- Alice and Bob's Silly Game

Link:- https://www.hackerrank.com/challenges/alice-and-bobs-silly-game/problem?isFullScreen=true

Problem:-

Alice and Bob invented the following silly game:

The game starts with an integer, , that's used to build a  of  distinct integers in the inclusive range from  to  (i.e., ).
Alice always plays first, and the two players move in alternating turns.
During each move, the current player chooses a prime number, , from . The player then removes  and all of its multiples from .
The first player to be unable to make a move loses the game.
Alice and Bob play  games. Given the value of  for each game, print the name of the game's winner on a new line. If Alice wins, print Alice; otherwise, print Bob.

Note: Each player always plays optimally, meaning they will not make a move that causes them to lose the game if some better, winning move exists.

Input Format

The first line contains an integer, , denoting the number of games Alice and Bob play.
Each line  of the  subsequent lines contains a single integer, , describing a game.

Output Format

For each game, print the name of the winner on a new line. If Alice wins, print Alice; otherwise, print Bob.




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
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= 100000; i+=2) {
            int sqrt = (int)Math.sqrt(i);
            boolean prime = true;
            for (int p : primes) {
                if (p > sqrt)
                    break;
                if (i%p==0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                primes.add(i);
        }
        int[] counts = new int[100001];
        int currIndex = 0;
        for (int i = 0; i <= 100000; i++) {
            if (currIndex < primes.size() && primes.get(currIndex) == i)
                currIndex++;
            counts[i] = currIndex;
        }
        int g = sc.nextInt();
        for (int i = 0; i < g; i++) {
            System.out.println(counts[sc.nextInt()]%2==0?"Bob":"Alice");
        }
    }
}
