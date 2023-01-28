/*
Topic:- Organizing Containers of Balls

Link:- https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem?isFullScreen=true

Problem:-

David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container. David wants to sort the balls using his sort method.

David wants to perform some number of swap operations such that:

Each container contains only balls of the same type.
No two balls of the same type are located in different containers.
Example
containers = [[1, 4], [2, 3]]

David has n = 2 containers and 2 different types of balls, both of which are numbered from 0 to n – 1 = 1.

In a single operation, David can swap two balls located in different containers.

In this case, there is no way to have all green balls in one container and all red in the other using only swap operations. Return Impossible.

You must perform q queries where each query is in the form of a matrix, M. For each query, print Possible on a new line if David can satisfy the conditions above for the given matrix. Otherwise, print Impossible.

Function Description

Complete the organizingContainers function in the editor below.

organizingContainers has the following parameter(s):

int containter[n][m]: a two dimensional array of integers that represent the number of balls of each color in each container
Returns

string: either Possible or Impossible
Input Format
The first line contains an integer q, the number of queries.

Each of the next q sets of lines is as follows:


The first line contains an integer n, the number of containers (rows) and ball types (columns).
Each of the next n lines contains n space-separated integers describing row containers[i].
Constraints
1 <= q <= 10
1 <= n <= 100
0 <= containers[i][j] <= 109
Scoring

For 33% of score, 1 <= n <= 10.
For 100% of score, 1 <= n <= 100.

Output Format

For each query, print Possible on a new line if David can satisfy the conditions above for the given matrix. Otherwise, print Impossible.

Sample Input 0

2
2
1 1
1 1
2
0 2
1 1

Sample Output 0

Possible
Impossible

Sample Input 1


2
3
1 3 1
2 1 2
3 3 3
3
0 2 1
1 1 1
2 0 0

Sample Output 1

Impossible
Possible


Solution:-
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container,int n) {
    int type[]=new int[n];
        int capa[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                type[j]+=container[i][j];
                capa[i]+=container[i][j];
            }
        }
        Arrays.sort(type);
        Arrays.sort(capa);
        for(int i=0;i<type.length;i++)
        {
            if(type[i]!=capa[i])
                return "Impossible";
        }
        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container,n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
