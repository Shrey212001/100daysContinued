/*
Topic:- Ema's Supercomputer

Link:- https://www.hackerrank.com/challenges/two-pluses/problem?isFullScreen=true

Problem:-

Ema built a quantum computer! Help her test its capabilities by solving the problem below.

Given a grid of size n x m, each cell in the grid is either good or bad.

A valid plus is defined here as the crossing of two segments (horizontal and vertical) of equal lengths. These lengths must be odd, and the middle cell of its horizontal segment must cross the middle cell of its vertical segment.

In the diagram below, the blue pluses are valid and the orange ones are not valid.


Find the two largest valid pluses that can be drawn on good cells in the grid, and return an integer denoting the maximum product of their areas. In the above diagrams, our largest pluses have areas of 5 and 9. The product of their areas is 5 x 9 = 45.

Note: The two pluses cannot overlap, and the product of their areas should be maximal.

Function Description

Complete the twoPluses function in the editor below. It should return an integer that represents the area of the two largest pluses.


twoPluses has the following parameter(s):

grid: an array of strings where each string represents a row and each character of the string represents a column of that row
Input Format
The first line contains two space-separated integers, n and m.
Each of the next n lines contains a string of m characters where each character is either G (good) or B (bad). These strings represent the rows of the grid. If the yth character in the xth line is G, then (x, y) is a good cell. Otherwise it’s a bad cell.

Constraints
2 <= n <= 15
2 <= m <= 15
Output Format
Find 2 pluses that can be drawn on good cells of the grid, and return an integer denoting the maximum product of their areas.

Sample Input 0


5 6
GGGGGG
GBBBGB
GGGGGG
GGBBGB
GGGGGG
Sample Output 0

5
Sample Input 1

6 6
BGBBGB
GGGGGG
BGBBGB
GGGGGG
BGBBGB
BGBBGB
Sample Output 1

25
Explanation 1


Here are two possible solutions for Sample 0 (left) and Sample 1 (right):

Explanation Key:

Green: good cell
Red: bad cell
Blue: possible pluses.
For the explanation below, we will refer to a plus of length i as Pi.

Sample 0
There is enough good space to color one P3 plus and one P1 plus. Area(P3) = 5 units, and Area(P1) = 1 unit. The product of their areas is 5 x 1 = 5.


Sample 1
There is enough good space to color two P3 pluses. Area(P3) = 5 units. The product of the areas of our two P3 pluses is 5 x 5 = 25.



Solution:-
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class ValidPlus{

        public int area;
        public int length;
        public ArrayList<Cell> cells = new ArrayList<>();

        public ValidPlus() {
            area = 1;
            length = 1;        
        }

        public ValidPlus(ValidPlus anotherValidPlus) {
            this.area = anotherValidPlus.area;
            this.length = anotherValidPlus.length;
            this.cells = new ArrayList<Cell>(anotherValidPlus.cells);
        }

        public void addCell(Cell cell) {
            cells.add(cell);
        }

    }

    static class Cell {

        public int row;
        public int column;

        public Cell(int row, int column) {
            super();
            this.row = row;
            this.column = column;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + column;
            result = prime * result + row;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Cell other = (Cell) obj;
            if (column != other.column)
                return false;
            if (row != other.row)
                return false;
            return true;
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ValidPlus> validPluses = new ArrayList<>();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        sc.close();

        // We save all the valid pluses
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char currentCell = map[i][j];
                if (currentCell == 'G') {
                    boolean thereIsGoodCell = true;
                    // Everytime we find a good cell, we create a valid plus
                    // with length 1
                    ValidPlus validPlus = new ValidPlus();
                    int length = 1;
                    validPlus.addCell(new Cell(i, j));
                    validPluses.add(validPlus);
                    while (thereIsGoodCell) {
                        // We check if it's possible to extend the valid plus in
                        // all the four directions
                        if ((i - length >= 0 && map[i - length][j] == 'G')
                                && (i + length < n && map[i + length][j] == 'G')
                                && (j - length >= 0 && map[i][j - length] == 'G')
                                && (j + length < m && map[i][j + length] == 'G')) {
                            // If it's possible, we create a new valid plus
                            ValidPlus newValidPlus = new ValidPlus(validPlus);
                            newValidPlus.addCell(new Cell(i - length, j));
                            newValidPlus.addCell(new Cell(i + length, j));
                            newValidPlus.addCell(new Cell(i, j - length));
                            newValidPlus.addCell(new Cell(i, j + length));
                            length++;
                            newValidPlus.area = 1 + (4 * (length - 1));
                            newValidPlus.length = length;
                            validPluses.add(newValidPlus);
                            validPlus = new ValidPlus(newValidPlus);
                        } else {
                            thereIsGoodCell = false;
                        }
                    }

                }
            }
        }

        int maxArea = 0;

        // We compare all the valid pluses
        for (int i = 0; i < validPluses.size(); i++) {
            ValidPlus currentValidPlus = validPluses.get(i);
            for (int j = i + 1; j < validPluses.size(); j++) {
                ValidPlus otherValidPlus = validPluses.get(j);
                int currentArea = currentValidPlus.area * otherValidPlus.area;
                if (currentArea > maxArea) {
                    // If we have found a new max area, we have to check that
                    // the valid pluses don't overlap.
                    // To do this, we get the cells occupied by the two valid
                    // pluses
                    ArrayList<Cell> currentCells = currentValidPlus.cells;
                    ArrayList<Cell> otherCells = otherValidPlus.cells;
                    List<Cell> commonCells = new ArrayList<Cell>(currentCells);
                    commonCells.retainAll(otherCells);
                    // If the valid pluses don't have common cells, it's OK
                    if (commonCells.size() == 0) {
                        maxArea = currentArea;
                    }
                }

            }
        }

        System.out.println(maxArea);

    }

}
