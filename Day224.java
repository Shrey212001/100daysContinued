/*

Topic:- Roads and Libraries

Link:- https://www.hackerrank.com/challenges/torque-and-development/problem?isFullScreen=true

Problem:-

Determine the minimum cost to provide library access to all citizens of HackerLand. There are n cities numbered from 1 to n. Currently there are no libraries and the cities are not connected. Bidirectional roads may be built between any city pair listed in cities. A citizen has access to a library if:

1. Their city contains a library.
2. They can travel by road from their city to a city containing a library.


unction Description

Complete the function roadsAndLibraries in the editor below.
roadsAndLibraries has the following parameters:

int n: integer, the number of cities
int c_lib: integer, the cost to build a library
int c_road: integer, the cost to repair a road
int cities[m][2]: each cities[ i ] contains two integers that represent cities that can be connected by a new road
Returns
- int: the minimal cost

Input Format

The first line contains a single integer q, that denotes the number of queries.

The subsequent lines describe each query in the following format:
- The first line contains four space-separated integers that describe the respective values of n , m , c_lib and c_road, the number of cities, number of roads, cost of a library and cost of a road.
- Each of the next m lines contains two space-separated integers, u[ i ] and v[ i ] , that describe a bidirectional road that can be built to connect cities c[ i ] and v[ i ].

Sample Input

STDIN       Function
-----       --------
2           q = 2
3 3 2 1     n = 3, cities[] size m = 3, c_lib = 2, c_road = 1
1 2         cities = [[1, 2], [3, 1], [2, 3]]
3 1
2 3
6 6 2 5     n = 6, cities[] size m = 6, c_lib = 2, c_road = 5
1 3         cities = [[1, 3], [3, 4],...]
3 4
2 4
1 2
2 3
5 6

Sample Output
4
12




Solution :-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            List<List<Integer>> groups = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++){
                List<Integer> group = new ArrayList<Integer>();
                group.add(i);
                groups.add(group);
            }
            boolean[] enabled = new boolean[n];
            for (int i = 0; i < n; i++)
                enabled[i] = true;
            int[] pointers = new int[n];
            for (int i = 0; i < n; i++)
                pointers[i] = i;
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt() - 1;
                int city_2 = in.nextInt() - 1;
                int p1 = pointers[city_1];
                int p2 = pointers[city_2];
                if (p1 != p2){
                    for (int i : groups.get(p2)){
                        pointers[i] = p1;
                        groups.get(p1).add(i);
                    }
                    enabled[p2] = false;
                }
            }
            long total = 0;
            for (int i = 0; i < n; i++){
                if (enabled[i]){
                    int size = groups.get(i).size();
                    total += Math.min(size * x, x + (size - 1) * y);
                }
            }
            System.out.println(total);
        }
    }
}
