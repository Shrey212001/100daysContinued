/*

Topic:- Grid Walking

Link:- https://www.hackerrank.com/challenges/grid-walking/problem?isFullScreen=true

Problem:-

You are situated in an n dimensional grid at position (x[1],x[2],...,x[n]). The dimensions of the grid are D[1],D[2],...,D[n]). In one step, you can walk one step ahead or behind in any one of the n dimensions. This implies that there are always 2*n possible moves if movements are unconstrained by grid boundaries. How many ways can you take m steps without leaving the grid at any point? You leave the grid if at any point x[i], either x[i] <= 0 or x[i] >D[i].

For example, you start off in a 3 dimensional grid at position x = [2,2,2]. The dimensions of the grid are D = [3,3,3], so each of your axes will be numbered from 1 to 3. If you want to move m =1 step, you can move to the following coordinates: {[1,2,2],[2,1,2],[2,2,1],[3,2,2],[2,3,2],[2,2,3]}.

image
If we started at x=[1,1,1] in the same grid, our new paths would lead to {[1,1,2],[1,2,1],[2,1,1]}. Other moves are constrained by x[i] !<= 0.

Function Description

Complete the gridWalking function in the editor below. It should return an integer that represents the number of possible moves, modulo (10^9+7).

gridWalking has the following parameter(s):

m: an integer that represents the number of steps
x: an integer array where each x[i] represents a coordinate in the ith dimension where 1 <= i <=n
D: an integer array where each D[i] represents the upper limit of the axis in the ith dimension
Input Format 

The first line contains an integer t, the number of test cases.

Each of the next t sets of lines is as follows:

The first line contains two space-separated integers, n and m.
The next line contains n space-separated integers x[i].
The third line of each test contains n space-separated integers D[i].

Constraints
1 <= t <= 10
1 <= n <= 10
1 <= m <= 300
1 <= D[i] <=100
1 <= x[i] <=D[i]

Output Format

Output one line for each test case. Since the answer can be really huge, output it modulo 10^9 + 7.




Solution:-
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static final int MOD = 1000000007;
    public static final int MAXSTEPS = 310;
    
    public static void main(String[] args) throws IOException{
        long[][] pascals = new long[MAXSTEPS][];
        for (int i=0; i<MAXSTEPS; i++){
            pascals[i] = new long[i+1];
            pascals[i][0] = 1;
            for (int j=1; j<pascals[i].length; j++){
                pascals[i][j] = pascals[i-1][j-1];
                if (j<pascals[i-1].length)
                    pascals[i][j] += pascals[i-1][j];
                pascals[i][j] %= MOD;
            }
        }
        
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int cases = Integer.parseInt(in.readLine());
    for (int test = 0; test<cases; test++){
        StringTokenizer st = new StringTokenizer(in.readLine());
        int dims = Integer.parseInt(st.nextToken());
        int steps = Integer.parseInt(st.nextToken());
        int[] starts = new int[dims];
        st = new StringTokenizer(in.readLine());
        for (int i=0; i<dims; i++)
            starts[i] = Integer.parseInt(st.nextToken());
        int[] bounds = new int[dims];
        st = new StringTokenizer(in.readLine());
        for (int i=0; i<dims; i++)
            bounds[i] = Integer.parseInt(st.nextToken());
    
        long[] numWays = new long[steps+1];
        numWays[0] = 1;
        for (int i=0; i<dims; i++){
            long[] tempWays = new long[numWays.length];
            long[] nextDimWays = numPossSteps(starts[i], bounds[i], steps);

            for (int j=0; j<tempWays.length; j++){
                for (int k=0; k<=j; k++){
                    long toAdd = (numWays[k]*nextDimWays[j-k])%MOD;
                    toAdd *= pascals[j][k];
                    tempWays[j] += toAdd%MOD;
                    tempWays[j] %= MOD;
                }
            }
            numWays = tempWays;
        }
            
        System.out.println(numWays[steps]);
    }
}
    
    public static long[] numPossSteps(int start, int bound, int steps){
        long[] ret = new long[steps+1];
        ret[0] = 1;
        long[] trackLoc = new long[bound];
        trackLoc[start-1] = 1;
        for (int i=1; i<ret.length; i++){
            long[] nextTrack = new long[trackLoc.length];
            for (int j=0; j<trackLoc.length; j++){
                if (j>0)
                    nextTrack[j] += trackLoc[j-1];
                if (j+1<bound)
                    nextTrack[j] += trackLoc[j+1];
                nextTrack[j] %= MOD;
            }
            trackLoc = nextTrack;
            ret[i] = sum(trackLoc);
        }
        return ret;
    }
    
    public static long sum(long[] array){
        long sum = 0;
        for (int i=0; i<array.length; i++){
            sum+=array[i];
            sum %= MOD;
        }
        return sum;
    }
}
