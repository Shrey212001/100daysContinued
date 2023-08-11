/*

Topic:- Digits Square Board

Link:- https://www.hackerrank.com/challenges/digits-square-board-1/problem?isFullScreen=true 

Problem:-

Two HackerRank staffers found a secret room with a mysterious  square board and decided to play a game with it. The game has the following rules:

At the beginning of the game, the players write a single digit (given as input) ranging from  to  in each  cell composing the  square board.
The players move in alternating turns. In each move, the current player performs the following actions:

Chooses a board that has at least one non-prime number written on it and has more than one cell (i.e., dimensions ).
Cuts the chosen board into  smaller boards by breaking it along any horizontal or vertical line at the edge of a cell.
Note: Although the game starts with one  board, that board is split in two during each move. At the beginning of the  move, a player can choose any one of the  pieces of the original board (as long as it can have a legal move performed on it).

The game ends when there are no more cuttable boards (i.e., there are  boards, or all boards have only prime numbers written on them). The first player who is unable to make a move loses.

Given the value of  and the respective numbers written in each  cell of the board, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Time Limit

Python: 18 seconds
Pypy2: 5 seconds
For other languages, the time limit is standard.

Input Format

The first line contains an integer, , denoting the number of test cases.
Each test case is defined as follows over the subsequent lines:

An integer, , denoting the length of each of the board's sides.
Each line  of the  subsequent lines contains  space-separated integers describing , where each  describes the number written in cell  of the board.
Constraints

Output Format

For each test case, print the name of the player with the winning strategy on a new line (i.e., either  or ).

Sample Input

2
3
2 7 5
2 7 5
7 7 7
2
4 3
1 2
Sample Output

Second
First
Explanation

We'll refer to the two players as  and .

Test Case 0:
All cells contain prime numbers, so there are no valid moves available to . As  wins by default, we print  on a new line.

Test Case 1:
In this test case, the two players perform the following sequence of moves:

 makes a horizontal cut, splitting the board into two  boards. This is demonstrated in the following diagram: square

 now chooses one of the two  rectangles and cuts it vertically, splitting it into two  squares.

 chooses remaining  rectangle and cuts it vertically, splitting it into two  squares.
After the above  moves take place, the board is split into four  squares and no more moves are available for  to make. Thus,  wins and we print  on a new line.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DigitsSquareBoard {
    static final int  max = 60;
    static final int  maxn = 30;
    static int[][]a;
    static int n;
    static int[][][][]g;
    
    public static void main(String[] args) throws IOException{
        new DigitsSquareBoard().run();
    }
    
    public void run() throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nexACtInt();
        int i,j,k,l,m;
        a = new int[maxn][maxn];
        g = new int[max][max][max][max];

        for(int tt =0;tt < t;tt++){
            n = in.nextInt();
            for(i=0;i<n;i++){
                Arrays.fill(a[i],-1);
            }
            for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    m = in.nextInt();
                    a[i][j]=(m==2||m==3||m==5||m==7)?0:1;//0 == black primes
                }
            }

            for(i=0;i<max;i++){
                for(j=0;j<max;j++){
                    for(k=0;k<max;k++){
                        for(l=0;l<max;l++){
                            g[i][j][k][l]=-1;
                        }
                    }
                }
            }
            int nimsum = grundy(0,0,n-1,n-1);

            if(nimsum>0) log.write("First\n");
            else log.write("Second\n");
        }
        log.flush();
    }
    
    public boolean prime(int x, int y, int z, int t){
        int i,j;
        for(i=x;i<=z;i++){
                for(j=y;j<=t;j++){
                    if(a[i][j]==1) return false;
                }
            }
        return true;
    }
              
    public int grundy(int x, int y, int z, int t){
        if (g[x][y][z][t]!=-1) return g[x][y][z][t];
        if (prime(x,y,z,t)) {
            g[x][y][z][t]=0;
            return 0;
        }

        ArrayList<Integer> min = new ArrayList<Integer>();
        int i,j,k;

        for(i=x+1;i<=z;i++){
            k = grundy(x,y,i-1,t)^grundy(i,y,z,t);
            if(!min.contains(k)) min.add(k);
        }

        for(i=y+1;i<=t;i++){
            k = grundy(x,y,z,i-1)^grundy(x,i,z,t);
            if(!min.contains(k)) min.add(k);
        }

        for(k=0;min.contains(k);k++);


        g[x][y][z][t]=k;
        return k;
    }
    
}
