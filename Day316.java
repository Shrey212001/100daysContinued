/*

Topic:- Deforestation

Link:- https://www.hackerrank.com/challenges/deforestation-1/problem?isFullScreen=true

Problem:-

Alice and Bob are playing a game with a rooted tree. The tree has  vertices and the first node, , is always the root. Here are the basic rules:

They move in alternating turns, and both players always move optimally.
During each move, a player removes an edge from the tree, disconnecting one of its leaves or branches. The leaf or branch that was disconnected from the rooted tree is removed from the game.
The first player to be unable to make a move loses the game.
Alice always makes the first move.
For example, the diagram below shows a tree of size , where the root is node : tree-initial.png

Now, if a player removes the edge between  and , then nodes  and  become disconnected from the root and are removed from the game:

tree-removed.png

Given the structure of the tree, determine and print the winner of the game. If Alice wins, print ; otherwise print .

Input Format

The first line contains a single integer, , denoting the number of test cases.
For each test case, the first line contains an integer, , denoting the number of nodes in the tree.
Each of the  subsequent lines contains  space-separated integers,  and , defining an edge connecting nodes  and .

Constraints

Output Format

For each test case, print the name of the winner (i.e.,  or ) on a new line.

Sample Input

1
5
1 2
3 1
3 4
4 5
Sample Output

Alice
Explanation

Test Case 0:

Alice removes the edge connecting node  to node , effectively trimming nodes  and  from the tree. Now the only remaining edges are  and . Because Bob can't remove both of them, Alice will make the last possible move. Because the last player to move wins, we print  on a new line.




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
    
    static int numHelper(ArrayList<ArrayList<Integer>> z, int current, int prev) {
    int gate = 0;
    for (Integer i : z.get(current)) {
        if (i != prev) {
            gate ^= 1 + numHelper(z, i, current);
        }
    }
        return gate;
    }   

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int x = in.nextInt(); x>0; x--) {
            int o = in.nextInt();
            ArrayList<ArrayList<Integer>> g = new ArrayList<>();
            for (int i=0; i<o; i++) {
                g.add(new ArrayList<Integer>());
            }
            for (int i=0; i<o-1; i++) {
                int one = in.nextInt()-1;
                int two = in.nextInt()-1;
                g.get(one).add(two);
                g.get(two).add(one);
            }
            if(numHelper(g, 0, -1) == 0){
                System.out.println("Bob");
            }
            else{
                System.out.println("Alice");
            }
        }
    }

}
