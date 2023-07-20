/*

Topic:- Counter game

Link:- https://www.hackerrank.com/challenges/counter-game/problem?isFullScreen=true

Problem:-

Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of 2. If it is, they divide it by 2. If not, they reduce it by the next lower number which is a power of 2. Whoever reduces the number to 1 wins the game. Louise always starts.

Given an initial value, determine who wins the game.

Example
n = 132
It's Louise's turn first. She determines that 132 is not a power of 2. The next lower power of 2 is 128, so she subtracts that from 132 and passes 4 to Richard. 4 is a power of 2, so Richard divides it by 2 and passes 2 to Louise. Likewise, 2 is a power so she divides it by 2 and reaches 1. She wins the game.

Update If they initially set counter to 1, Richard wins. Louise cannot make a move so she loses.

Function Description

Complete the counterGame function in the editor below.

counterGame has the following parameter(s):

int n: the initial game counter value
Returns

string: either Richard or Louise
Input Format

The first line contains an integer t, the number of testcases.
Each of the next t lines contains an integer n, the initial value for each game.

Constraints
1 <= t <= 10
1 <= n <= 2^64-1




Solution:-
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    static BufferedReader reader;
    static StringTokenizer tokenizer = null;
    static PrintWriter writer;

    static String nextToken() throws IOException {
        while (tokenizer == null || (!tokenizer.hasMoreTokens())) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    static double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    static long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        cherry();
        reader.close();
        writer.close();
    }

    static BigInteger two = new BigInteger("2");

    static boolean isWin(BigInteger bi) {
        if (bi.equals(BigInteger.ONE)) {
            return false;
        }
        if (bi.bitCount() == 1) {
            return !isWin(bi.divide(two));
        } else {
            return !isWin(bi.clearBit(bi.bitLength() - 1));
        }
    }

    static void cherry() throws NumberFormatException, IOException {
        int T = nextInt();
        for (int t = 0; t < T; t++) {
            BigInteger bi = new BigInteger(nextToken());
            writer.println(isWin(bi) ? "Louise" : "Richard");
        }
    }
}
