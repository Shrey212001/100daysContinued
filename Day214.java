/*

Topic:- KnightL on a Chessboard

Link:- https://www.hackerrank.com/challenges/knightl-on-chessboard/problem?isFullScreen=true

Problem:-

KnightL is a chess piece that moves in an L shape. We define the possible moves of  as any movement from some position  to some  satisfying either of the following:

Note that  and  allow for the same exact set of movements. For example, the diagram below depicts the possible locations that  or  can move to from its current location at the center of a  chessboard:

Observe that for each possible movement, the Knight moves  units in one direction (i.e., horizontal or vertical) and  unit in the perpendicular direction.

Input Format

A single integer denoting .

Constraints

Output Format

Print exactly  lines of output in which each line  (where ) contains  space-separated integers describing the minimum number of moves  must make for each respective  (where ). If some  cannot reach position , print -1 instead.


Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] results = new int[n-1][n-1];
        
        for(int i = 1; i < n; i++){ 
            for(int j = 1; j < n; j++){
                int[][] T = new int[n][n];
                Queue<Tupel> q = new LinkedList<Tupel>();
                q.add(new Tupel(0,0));
                while(!q.isEmpty()){
                    Tupel t = q.remove();
                    
                    if(t.x == 0 && t.y == 0){
                        T[0][0] = 1;
                        
                    }
                    
                    if(t.x-i >= 0 && t.y-j >= 0 && T[t.x-i][t.y-j] == 0){
                        T[t.x-i][t.y-j] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x-i, t.y-j));
                    }
                        
                    if(t.x-j >= 0 && t.y-i >= 0 && T[t.x-j][t.y-i] == 0){
                        T[t.x-j][t.y-i] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x-j, t.y-i));
                    }
                        
                    if(t.x-i >= 0 && t.y+j < n && T[t.x-i][t.y+j] == 0){
                        T[t.x-i][t.y+j] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x-i, t.y+j));
                    }    
                        
                    if(t.x-j >= 0 && t.y+i < n && T[t.x-j][t.y+i] == 0){
                        T[t.x-j][t.y+i] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x-j, t.y+i));
                    }
                        
                    if(t.x+i < n && t.y+j < n && T[t.x+i][t.y+j] == 0){
                        T[t.x+i][t.y+j] = T[t.x][t.y]+1;
                        if(t.x+i == n-1 && t.y+j == n-1){
                            break;
                        }
                        q.add(new Tupel(t.x+i, t.y+j));
                    }
                        
                    if(t.x+j < n && t.y+i < n && T[t.x+j][t.y+i] == 0){
                        T[t.x+j][t.y+i] = T[t.x][t.y]+1;
                        if(t.x+i == n-1 && t.y+j == n-1){
                            break;
                        }
                        q.add(new Tupel(t.x+j, t.y+i));
                    }
                        
                    if(t.x+i < n && t.y-j >= 0 && T[t.x+i][t.y-j] == 0){
                        T[t.x+i][t.y-j] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x+i, t.y-j));
                    }
                        
                    if(t.x+j < n && t.y-i >= 0 && T[t.x+j][t.y-i] == 0){
                        T[t.x+j][t.y-i] = T[t.x][t.y]+1;
                        q.add(new Tupel(t.x+j, t.y-i));
                    }
                       
                }
                
                results[i-1][j-1] = T[n-1][n-1]-1;
            }
        }
        
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

class Tupel{
    int x;
    int y;
    public Tupel(int x, int y){
        this.x = x;
        this.y = y;
    }
}
