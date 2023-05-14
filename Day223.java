/*

Topic:- Red Knight's Shortest Path

Link:-  https://www.hackerrank.com/challenges/red-knights-shortest-path/problem?isFullScreen=true

Problem:-

In ordinary chess, the pieces are only of two colors, black and white. In our version of chess, we are including new pieces with unique movements. One of the most powerful pieces in this version is the red knight.

The red knight can move to six different positions based on its current position (UpperLeft, UpperRight, Right, LowerRight, LowerLeft, Left) as shown in the figure below.

The board is a grid of size . Each cell is identified with a pair of coordinates , where  is the row number and  is the column number, both zero-indexed. Thus,  is the upper-left corner and  is the bottom-right corner.

Complete the function printShortestPath, which takes as input the grid size , and the coordinates of the starting and ending position  and  respectively, as input. The function does not return anything.

Given the coordinates of the starting position of the red knight and the coordinates of the destination, print the minimum number of moves that the red knight has to make in order to reach the destination and after that, print the order of the moves that must be followed to reach the destination in the shortest way. If the destination cannot be reached, print only the word "Impossible".

Note: There may be multiple shortest paths leading to the destination. Hence, assume that the red knight considers its possible neighbor locations in the following order of priority: UL, UR, R, LR, LL, L. In other words, if there are multiple possible options, the red knight prioritizes the first move in this list, as long as the shortest path is still achievable. Check sample input  for an illustration.

Input Format

The first line of input contains a single integer . The second line contains four space-separated integers .  denotes the coordinates of the starting position and  denotes the coordinates of the final position.

Constraints

the starting and the ending positions are different

Output Format

If the destination can be reached, print two lines. In the first line, print a single integer denoting the minimum number of moves that the red knight has to make in order to reach the destination. In the second line, print the space-separated sequence of moves.

If the destination cannot be reached, print a single line containing only the word Impossible.




Solution :-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Node {
        int i, j;
        List<String> movesSoFar = new LinkedList<>();
        
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        Node(int i, int j, Node a, String moveTo) {
            this.i = i;
            this.j = j;
            this.movesSoFar.addAll(a.movesSoFar);
            this.movesSoFar.add(moveTo);
        }
    }
    
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        boolean[][] visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(i_start, j_start);
        queue.add(start);
        visited[start.i][start.j] = true;
        List<String> path = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.i == i_end && current.j == j_end) {
                path = current.movesSoFar;
                break;
            }
            
            if (current.j - 1 >= 0 && current.i - 2 >= 0 && !visited[current.i-2][current.j-1]) {
                // UL
                queue.offer(new Node(current.i-2, current.j-1, current, "UL"));
                visited[current.i-2][current.j-1] = true;
            }
            if (current.j + 1 < n && current.i - 2 >= 0 && !visited[current.i-2][current.j+1]) {
                queue.offer(new Node(current.i-2, current.j+1, current, "UR"));
                visited[current.i-2][current.j+1] = true;
            }
            if (current.j + 2 < n && !visited[current.i][current.j+2]) {
                queue.offer(new Node(current.i, current.j+2, current, "R"));
                visited[current.i][current.j+2] = true;
            }
            if (current.i+2 < n && current.j+1 < n && !visited[current.i+2][current.j+1]) {
                queue.offer(new Node(current.i+2, current.j+1, current, "LR"));
                visited[current.i+2][current.j+1] = true;
            }
            if (current.i+2 < n && current.j-1 >= 0 && !visited[current.i+2][current.j-1]) {
                queue.offer(new Node(current.i+2, current.j-1, current, "LL"));
                visited[current.i+2][current.j-1] = true;
            }
            if (current.j-2 >= 0 && !visited[current.i][current.j-2]) {
                queue.offer(new Node(current.i, current.j-2, current, "L"));
                visited[current.i][current.j-2] = true;
            }
        }
        
        if (path != null) {
            System.out.println(path.size());
            boolean first = true;
            for (String item : path) {
                if (!first) {
                    System.out.print(" ");
                }
                System.out.print(item);
                first = false;
            }
            System.out.println();
        } else {
            System.out.println("Impossible");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
