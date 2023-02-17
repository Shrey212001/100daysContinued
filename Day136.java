/*
Topic:- The Bomberman Game

Link:- https://www.hackerrank.com/challenges/bomber-man/problem?isFullScreen=true

Problem:-

Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.

Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb detonates, it’s destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell i,j, any valid cells (i+1,j)and (i,j+1) are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there’s no chain reaction.

Bomberman is immune to bombs, so he can move freely throughout the grid. Here’s what he does:
Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
After one second, Bomberman does nothing.
After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs. No bombs detonate at this point.
After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same moment), and any bombs planted at the same time will detonate at the same time.

Given the initial configuration of the grid with the locations of Bomberman’s first batch of planted bombs, determine the state of the grid after N seconds.

For example, if the initial grid looks like:

...
.O.
...
it looks the same after the first second. After the second second, Bomberman has placed all his charges:

OOO
OOO
OOO
At the third second, the bomb in the middle blows up, emptying all surrounding cells:

...
...
...
Function Description

Complete the bomberMan function in the editory below. It should return an array of strings that represent the grid in its final state.

bomberMan has the following parameter(s):

n: an integer, the number of seconds to simulate
grid: an array of strings that represents the grid

Input Format

The first line contains three space-separated integers r, c, and n, The number of rows, columns and seconds to simulate.
Each of the next r lines contains a row of the matrix as a single string of c characters. The . character denotes an empty cell, and the O character (ascii 79) denotes a bomb.

Output Format

Print the grid’s final state. This means R lines where each line contains C characters, and each character is either a . or an O (ascii 79). This grid must represent the state of the grid after n seconds.

Sample Input

6 7 3
.......
...O...
....O..
.......
OO.....
OO.....
Sample Output


OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
Explanation

The initial state of the grid is:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman spends the first second doing nothing, so this is the state after 1 second:


.......
...O...
....O..
.......
OO.....
OO.....
Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate. This is the final state after  seconds:


OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO




Solution:-
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.text.*; 
import java.util.*;
import java.util.regex.*;



public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int qq = 1;
        //int qq = Integer.MAX_VALUE;
        //int qq = readInt();
        for(int casenum = 1; casenum <= qq; casenum++) {
            int r = readInt();
            int c = readInt();
            int n = readInt();
            n--;
            int[][] bomb = new int[r][c];
            for(int i = 0; i < r; i++) {
                String s = nextToken();
                for(int j = 0; j < c; j++) {
                    if(s.charAt(j) == 'O') {
                        bomb[i][j] = 2;
                    }
                }
            }
            n %= 100;
            int[] dx = new int[]{-1,1,0,0};
            int[] dy = new int[]{0,0,-1,1};
            for(int i = 1; i <= n; i++) {
                if(i%2 == 1) {
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(bomb[a][b] == 0) {
                                bomb[a][b] = 3;
                            }
                            else if(bomb[a][b] > 0) {
                                bomb[a][b]--;
                            }
                        }
                    }
                }
                else {
                    boolean[][] dead = new boolean[r][c];
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(bomb[a][b] == 1) { 
                                dead[a][b] = true;
                                for(int k = 0; k < dx.length; k++) {
                                    int nx = a + dx[k];
                                    int ny = b + dy[k];
                                    if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                                        dead[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(dead[a][b])
                                bomb[a][b] = 0;
                            else if(bomb[a][b] > 0) {
                                bomb[a][b]--;
                            }
                        }
                    }
                }
            }
            for(int[] out: bomb) {
                for(int out2: out) {
                    if(out2 > 0) {
                        pw.print('O');
                    }
                    else {
                        pw.print('.');
                    }
                }
                pw.println();
            }
        }
        exitImmediately();
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }

    private static long readLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException  {
        if(!br.ready()) {
            exitImmediately();
        }
        st = null;
        return br.readLine();
    }

    private static String nextToken() throws IOException  {
        while(st == null || !st.hasMoreTokens())  {
            if(!br.ready()) {
                exitImmediately();
            }
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
