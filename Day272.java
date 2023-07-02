/*

Topic:- Wet Shark and Two Subsequences

Link:- https://www.hackerrank.com/challenges/wet-shark-and-two-subsequences/problem?isFullScreen=true

Problem:-

One day, Wet Shark was given an array X = {x1, x2, ..., xm}. As always, he started playing with its subsequences.

When you came to know about this habit, you presented him a task of finding all pairs of subsequences, (A,B), which satisfies all of the following constraints. We will represent a pair of subsequence as A = {xa1,xa2,...,xan} and B = {xb1,xb2,...,xbn}

 A and B must be of same length, i.e., |A| = |B|.
 Σ(xai + xbi) = r
 Σ(xai - xbi) = s
Please help Wet Shark determine how many possible subsequences A and B can exist. Because the number of choices may be big, output your answer modulo 10^9 + 7 =100000007.

Note:

Two segments are different if there's exists at least one index i such that element xi is present in exactly one of them.
Both subsequences can overlap each other.
Subsequences do not necessarily have to be distinct
Input Format

The first line consists of 3 space-separated integers m, r, s, where m denotes the length of the original array, X, and r and s are as defined above.
The next line contains m space-separated integers,  x1, x2,..., xm, representing the elements of X.

Constraints
1 <= m <= 100
0 <= r,s <=2000
1 <= xi <= 2000

Output Format

Output total number of pairs of subsequences, (A,B), satisfying the above conditions. As the number can be large, output it's modulo 10^9 + 7 =100000007.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
  private static InputReader in;
  private static PrintWriter out;
  public static int mod = 1000000007;

  public static void main(String[] args) throws IOException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out, true);
    
    int M = in.nextInt();
    int R = in.nextInt();
    int S = in.nextInt();
    if ((R+S) % 2 != 0 || S >= R) {
      out.println("0");
      out.close();
      System.exit(0);
    }
    
    int P = (R+S)/2, Q = (R-S)/2;
    
    long[][] nways = new long[M+1][P+1];
    nways[0][0] = 1;
    for (int i = 1; i <= M; i++) {
      int x = in.nextInt();
      for (int j = M; j >= 1; j--) {
        for (int k = P; k >= x; k--) {
          nways[j][k] += nways[j-1][k-x];
          if (nways[j][k] >= mod) nways[j][k] -= mod;
        }
      }
    }
    
    long total = 0;
    for (int i = 0; i <= M; i++) {
      total = (total + nways[i][P] * nways[i][Q]) % mod;
    }
    out.println(total);
    out.close();
    System.exit(0);
    
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}  
