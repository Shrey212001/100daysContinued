/*

Topic:- Chessboard Game, Again!

Link:-https://www.hackerrank.com/challenges/chessboard-game-again-1/problem?isFullScreen=true

Problem:-

Two players are playing a game on a  chessboard. The rules of the game are as follows:

The game starts with  coins located at one or more  coordinates on the board (a single cell may contain more than one coin). The coordinate of the upper left cell is , and the coordinate of the lower right cell is .
In each move, a player must move a single coin from some cell  to one of the following locations:
 
Note: The coin must remain inside the confines of the board.

The players move in alternating turns. The first player who is unable to make a move loses the game.

Note: While the figure shows a  board, this game is played on a  board.

Given the value of  and the initial coordinate(s) of  coins, determine which player will win the game. Assume both players always move optimally.

Input Format

The first line contains an integer, , denoting the number of test cases.
Each test case is defined as follows over the subsequent lines:

The first line contains an integer, , denoting the number of coins on the board.
Each line  (where ) of the  subsequent lines contains  space-separated integers describing the respective values of  and  of the coordinate where coin  is located.
Note: Recall that a cell can have more than one coin (i.e., any cell can have  to  coins in it at any given time).

Constraints

, where .
Output Format

On a new line for each test case, print  if the first player is the winner; otherwise, print .

Sample Input

2
3
5 4
5 8
8 2
6
7 1
7 2
7 3
7 4
7 4
7 4
Sample Output

First
Second




Solution:-
*/
import java.util.Scanner;

class Solution{
    static int[][] nimbers(final int side){
    int[][] nb=new int[side][side];
    for(int j=2;j<2*side-1;++j){
        int i=j<side?0:j-side+1;
        int k=j<side?j:side-1;
        while(i<=k){
        boolean[] seen=new boolean[4+1];
        if(i>1){
            seen[nb[i-2][k-1]]=true;
            if(k!=side-1) seen[nb[i-2][k+1]]=true;
        }
        if(k>1){
            if(i!=0) seen[nb[i-1][k-2]]=true;
            if(i!=side-1) seen[nb[i+1][k-2]]=true;
        }
        int l=0;
        while(seen[l]) ++l;
        nb[i][k]=l;
        nb[k][i]=l;
        ++i;
        --k;
        }
    }
    return nb;
    }
    static boolean win(int nCoin, Scanner sc, int[][] nb){
    int nimSum=0;
    while(nCoin-- != 0){
        int x=sc.nextInt(), y=sc.nextInt();
        nimSum ^= nb[x-1][y-1];
    }
    return nimSum!=0;
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int nCase=sc.nextInt(), side=15;
    int[][] nb=nimbers(side);
    while(nCase-- != 0){
        int nCoin=sc.nextInt();
        System.out.println(win(nCoin,sc,nb)?"First":"Second");
    }
    sc.close();
    }
}
