/*

Topic:- Vertical Rooks

Link:- https://www.hackerrank.com/challenges/vertical-rooks/problem?isFullScreen=true

Problem:-

HackerChess is a variant of chess played at HackerRank. It is a game played between two players who make moves in turns until one of them cannot make any move. The player who cannot make a move loses the game and the other player is declared the winner. The game is played on a board with  rows and  columns. The only pieces used in the game are rooks. A rook in HackerChess moves only vertically, which means that in never leaves a column to which it belongs. Moreover, in a single move, a rook moves through any number of unoccupied cells. Notice that there are no captures in HackerChess, two rooks cannot occupy the same cell, and a rook cannot jump over another rook. Each player has exactly one rook in each of the  columns of the board.

Given the initial position of the rooks and knowing that the second player makes the first move, decide who will win the game if both players play optimally.

Input Format

In the first line, there is a single integer  denoting the number of games to be played. After that, descriptions of  games follow:

In the first line, there is a single integer  denoting the size of the board. Next,  lines follow. In the -th of them there is a single integer  denoting the row of the rook belonging to the first player placed in the -th column. After that, another  lines follow. In the -th of them there is a single integer  denoting the row of the rook belonging to the second player placed in the -th column.

Constraints

Output Format

Print exactly  lines. In the -th of them, print player-1 if the first player will win the -th game. Otherwise, print player-2 in this line.

Sample Input 0

1
3
1
2
2
3
1
1
Sample Output 0

player-2
Explanation 0

There is only one game player in the sample input. The game is played on the board with  rows and  columns. Let's denote the first player's rooks as red rooks and the second player's rooks as green ones. Then the initial position of the game looks like this:

The second player moves first and he can move his rook in the first column to the second row. After this move, the position looks as follows:

Next, it is the first player's turn. He cannot make any move with his rook in the first column, so he has to make a move in the second or the third column. Without the loss of generality, let's assume that he makes a move in the second column. He can only make one such move, i.e. move the rook from the second to the third row. This results in the following position:

After that, the best move for the second player is to move his rook in the second column from the first to the second row. After this move, the position looks like this:

Next, it is again the first player's move. The only move he can make is to move his rook in the third column from the second to the third row. It results in the following position:

Then, the best move for the second player is to move his rook in the third column from the first to the second row. After that, the position looks as follows:

Next, it is the first player's move, but since he is unable to make any valid move, he loses and the second player is declared a winner.

It shows that regardless of the first player's moves, the second player has a strategy leading to his victory.

Sample Input 1

1
4
3
3
3
3
4
4
4
4
Sample Output 1

player-1
Explanation 1

Second player cannot make a move so  is the winner.




Solution:-
*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int T = scanner.nextInt();
            while(T-- > 0) {
                int n = scanner.nextInt();
                int[] one = new int[n];
                for(int i=0; i<n; i++) {
                    one[i] = scanner.nextInt();
                }
                int[] two = new int[n];
                for(int i=0; i<n; i++) {
                    two[i] = scanner.nextInt();
                }
                int xor = 0;
                for(int i=0; i<n; i++) {
                    xor ^= (Math.abs(one[i] - two[i]) - 1);
                }
                if(xor != 0) {
                    System.out.println("player-2");
                }
                else {
                    System.out.println("player-1");
                }
            }
        }
        scanner.close();
    }
}
