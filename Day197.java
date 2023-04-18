/*

Topic:- A Chessboard Game

Link:- https://www.hackerrank.com/challenges/a-chessboard-game-1/problem?isFullScreen=true

Problem:-

Two players are playing a game on a  chessboard. The rules of the game are as follows:

The game starts with a single coin located at some  coordinates. The coordinates of the upper left cell are , and of the lower right cell are .

In each move, a player must move the coin from cell  to one of the following locations:

Note: The coin must remain inside the confines of the board.

Beginning with player 1, the players alternate turns. The first player who is unable to make a move loses the game.

The figure below shows all four possible moves using an  board for illustration:

Function Description

Complete the chessboardGame function in the editor below. It should return a string, either First or Second.

chessboardGame has the following parameter(s):

x: an integer that represents the starting column position
y: an integer that represents the starting row position

Input Format

The first line contains an integer , the number of test cases.
Each of the next  lines contains  space-separated integers  and .




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static void pasteTessalation(boolean[][] board, int r, int c) {
        board[r][c] = true;
        board[r][c+1] = true;
        board[r+1][c] = true;
        board[r+1][c+1] = true;
    }

    public static void main(String[] args) {
        boolean[][] loss = new boolean[16][16];
        for (int i=0; i<16; i+=4) {
            for (int j=0; j<16; j+=4) {
                pasteTessalation(loss,i,j);
            }
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            if (loss[r][c]) {
                System.out.println("Second");
            } else {
                System.out.println("First");
            }
        }
        
    }
    
}
