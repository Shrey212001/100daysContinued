/*

Topic:- Gena Playing Hanoi

Link:- https://www.hackerrank.com/challenges/gena/problem?isFullScreen=true

Problem:-

The Tower of Hanoi is a famous game consisting of  rods and a number of discs of incrementally different diameters. The puzzle starts with the discs neatly stacked on one rod, ordered by ascending size with the smallest disc at the top. The game's objective is to move the entire stack to another rod, obeying the following rules:

Only one disk can be moved at a time.
In one move, remove the topmost disk from one rod and move it to another rod.
No disk may be placed on top of a smaller disk.
Gena has a modified version of the Tower of Hanoi. This game of Hanoi has  rods and  disks ordered by ascending size. Gena has already made a few moves following the rules above. Given the state of Gena's Hanoi, determine the minimum number of moves needed to restore the tower to its original state with all disks on rod .

Note: Gena's rods are numbered from  to . The radius of a disk is its index in the input array, so disk  is the smallest disk with a radius of , and disk  is the largest with a radius of .

Function Description

Complete the hanoi function below.

hanoi has the following parameters:

int posts[n]:  is the location of the disk with radius 
Returns

int: the minimum moves to reset the game to its initial state
Input Format

The first line contains a single integer, , the number of disks.
The second line contains  space-separated integers, where the  integer is the index of the rod where the disk with diameter  is located.


Solution :

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] readIntArray3(Scanner in, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }



    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = 1;
        for (int testcase = 0; testcase < cases; testcase++) {
            int n = in.nextInt();
            int[] arr = readIntArray3(in, n);
            genahanoi(n, arr);
        }
    }

    public static void genahanoi(int n, int[] locs) {
        int[] powers = new int[]{1,4,16,64,256,1024,4096,16384,65536,262144};
        int score = 0;
        for (int i = 0; i < n; i++) {
            score += powers[i]*(locs[i]-1);
        }
        Set<Integer> allTests = new HashSet();
        Set<Integer> currentTests = new HashSet();
        currentTests.add(score);
        allTests.add(score);
        int currentMoves = 0;
        while (!currentTests.contains(0)) {
            Set<Integer> nextTests = new HashSet();
            for (int test : currentTests) {
                int[] tops = new int[]{-1,-1,-1,-1};
                for (int i = n-1; i >=0; i--) {
                    int loc = (test>>(2*i))%4;
                    tops[loc] = i;
                }
                for (int j = 0; j < 4; j++) {
                    if (tops[j] >= 0) {
                        for (int k = 0; k < 4; k++) {
                            if ( k != j) {
                                if (tops[k] == -1 || tops[k] > tops[j]) {
                                    int newTest = test - (j<<(2*tops[j])) + (k<<(2*tops[j]));
                                    if (!allTests.contains(newTest)) {
                                        nextTests.add(newTest);
                                    } else {

                                    }
                                }
                            }
                        }
                    }
                }
            }

            currentTests = nextTests;
            allTests.addAll(currentTests);
            currentMoves++;
        }
        System.out.println(currentMoves);
    }
}
