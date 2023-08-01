/*

Topic:- Crossword Puzzle

Link:- https://www.hackerrank.com/challenges/crossword-puzzle/problem?isFullScreen=true

Problem:-

A 10 x 10  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid. Cells are marked either + or -. Cells marked with a - are to be filled with the word list.

The following shows an example crossword from the input crossword grid and the list of words to fit,

Function Description

Complete the crosswordPuzzle function in the editor below. It should return an array of strings, each representing a row of the finished puzzle.

crosswordPuzzle has the following parameter(s):

crossword: an array of 10 strings of length 10 representing the empty grid
words: a string consisting of semicolon delimited strings to fit into crossword.
 
Input Format

Each of the first 10 lines represents crossword[ i ], each of which has 10 characters, crossword[ i ][ j ].

The last line contains a string consisting of semicolon delimited word[ i ]  to fit.

Output Format

Position the words appropriately in the 10 x 10  grid, then return your array of strings for printing.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution { 
    class Point {
        boolean isVertical;
        int length;
        int x;
        int y;
        Point(boolean v, int l, int i, int j) {
            isVertical = v;
            length = l;
            x = i;
            y = j;
        }
        public String toString() {
            return "v="+isVertical+",l="+length+",x="+x+",y="+y;
        }
    };
    public static boolean isBorder(char board[][], int i, int j) {
        if (i<0 || i >= 10)
            return true;
        if (j<0 || j >= 10)
            return true;
        char c = board[i][j];
        if(c == '+')
            return true;
        else return false;
    }
    public boolean canInsert(char board[][], Point p, String word, boolean insert) {
        if (p.length != word.length())
            return false;
        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            int x = p.x;
            int y = p.y;
            if(p.isVertical)
                x = x+i;
            else
                y = y+i;
            if(board[x][y] != '-' && board[x][y] != c)
                return false;
            else {
                if(insert)
                    board[x][y] = c;
            }
        }
        return true;        
    }
    public void showBoard(char board[][]) {
        for (int i=0; i < 10; i++) {
            for (int j=0; j < 10; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public char[][] copyBoard(char board[][]) {
        char[][] newBoard = new char[10][10];
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
    public boolean solve(char board[][], LinkedList<Point> points, LinkedList<String> wordList) {
        if(points.size() == 0 && wordList.size() == 0) {
            showBoard(board);
            return true;
        }   
        if(points.size() == 0 && wordList.size() > 0) {
            return false;
        }
        LinkedList<String> triedWords = new LinkedList<String>();        
        Point p = points.removeFirst();        
        Iterator<String> iter = wordList.iterator();
        while(iter.hasNext()) {
            String word = iter.next();             
            if(canInsert(board, p, word, false)) {
                char[][] newBoard = copyBoard(board);
                canInsert(newBoard, p, word, true);
                iter.remove();
                LinkedList<String> both = new LinkedList<String>();
                both.addAll(wordList);
                both.addAll(triedWords);
                boolean sts = solve(newBoard, points, both);
                if (sts)
                    return true;
                else {
                    triedWords.push(word); 
                }
            } else {
            }   
        }
        points.addFirst(p);        
        return false;
    }
    public LinkedList<Point> getStarts(char board[][]) {
        LinkedList<Point> plist = new LinkedList<Point>();
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                char c = board[i][j];
                if(c == '-') {
                    if(isBorder(board, i-1, j) && !isBorder(board, i+1, j)) {
                        int l=0;
                        while(!isBorder(board, i+l, j))
                            l++;
                        Point p = new Point(true, l, i, j);
                        plist.add(p);
                    }
                    if(isBorder(board, i, j-1) && !isBorder(board, i, j+1)) {
                        int l=0;
                        while(!isBorder(board, i, j+l))
                            l++;
                        Point p = new Point(false, l, i, j);
                        plist.add(p);
                    }
                }
            }
        }
        return plist;
    }
    public void myMain(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char board[][] = new char[10][10];
        for (int i=0; i < 10; i++) {
            String line = scanner.nextLine();
            for (int j=0; j < 10; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        String wordLine = scanner.nextLine();
        String words[] = wordLine.split(";");
        LinkedList<String> wordList = new LinkedList<String>();
        for (int i=0; i < words.length; i++) {
            wordList.add(words[i]);
        }
        LinkedList<Point> starts = getStarts(board);
        solve(board, starts, wordList);    
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.myMain(args);
    }
}
