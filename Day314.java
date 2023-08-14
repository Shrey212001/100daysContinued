/*

Topic:- Kitty and Katty

Link:- https://www.hackerrank.com/challenges/kitty-and-katty/problem?isFullScreen=true

Problem:-

Kitty and Katty have  plastic blocks. They label the blocks with sequential numbers from  to  and begin playing a game in turns, with Kitty always taking the first turn. The game's rules are as follows:

For each turn, the player removes  blocks,  and , from the set. They calculate , write the result on a new block, and insert the new block into the set.
The game ends when only  block is left. The winner is determined by the value written on the final block, :
If , then Kitty wins.
If , then Katty wins.
If , then the player who moved last wins.
Recall that  is the Modulo Operation.

Given the value of , can you find and print the name of the winner? Assume that both play optimally.

Note: The selection order for  and  matters, as sometimes . The diagram below shows an initial set of blocks where . If  and , then the newly inserted block is labeled ; alternatively, if  and , the newly inserted block is labeled .

all.png

Input Format

The first line contains a single positive integer,  (the number of test cases or games).
The  subsequent lines each contain an integer,  (the number of blocks for that test case).

Constraints

Output Format

For each test case, print the name of the winner (i.e.: either Kitty or Katty) on a new line.

Sample Input

2
2
3
Sample Output

Kitty
Katty
Explanation

Test Case 0:
 so there are two blocks labeled  and . Kitty chooses  and , then inserts a new block with the label  (the result of ). The game ends, as there is now only  block in the set. The label on the last block, , is , so we calculate . Because , Kitty wins and we print Kitty on a new line.

Test Case 1:
, so there are three blocks labeled , , and . No matter how Kitty makes the first move, Katty will win. If Kitty chooses  and  on the first move and inserts a block labeled  (the result of ), the set of blocks becomes . Katty then must choose  and  and insert a new block labeled  (the result of ). The game ends, as there is now only  block in the set. The label on the last block, , is , so we calculate . Because  and Katty made the last move, Katty wins and we print Katty on a new line.




Solution:-
*/
import java.io.*;
import java.util.*;

public class KittyAndKatty {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    void solve() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            out.println((n > 1 && n % 2 == 1) ? "Katty" : "Kitty");
        }
    }

    KittyAndKatty() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new KittyAndKatty();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
