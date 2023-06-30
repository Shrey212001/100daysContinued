/*

Topic:- Two Robots

Link:- https://www.hackerrank.com/challenges/two-robots/problem?isFullScreen=true

Problem:-

You have a warehouse with M containers filled with an infinite number of candies. The containers are arranged in a single row, equally spaced to be 1 meter apart. You also have 2 robots that can pick up 1 piece of candy and transport it between any two containers.

The robots take instructions in the form of queries consisting of two integers, Ma and Mb, respectively. To execute a query, a robot travels to container Ma, picks up 1 candy, transports it to container Mb, and then stops at Mb until it receives another query.

Calculate the minimum total distance the robots must travel to execute N queries in order.

Note: You choose which robot executes each query.

Input Format

The first line contains a single integer, T (the number of test cases); each of the T test cases is described over N+1 lines.

The first line of a test case has two space-separated integers, M (the number of containers) and N (the number of queries).
The N subsequent lines each contain two space-separated integers, Ma and Mb, respectively; each line Ni describes the ith query.

Constraints
1 <= T <= 50
1 < M <= 1000
1 <= N <= 1000
1 <= a,b <= M
Ma != Mb

Output Format

On a new line for each test case, print an integer denoting the minimum total distance that the robots must travel to execute the queries in order.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args){
        int t = ni();
        for(int i=0; i<t; i++){
            solve();
        }
    }
    
    static void solve(){
        int m = ni(); int n = ni();
        long[] mindis = new long[m+1];
        long[] temp2;
        long[] temp = new long[m+1];
        Arrays.fill(mindis, Long.MAX_VALUE);
        int curpos = 0;//current position
        
        int ma, mb;
        long d;
        mindis[0] = 0;
        
        for(int i=0; i<n; i++){
            ma = ni(); mb = ni();
            
            Arrays.fill(temp, Long.MAX_VALUE);
            for(int j=0; j<=m; j++){
                if(mindis[j] == Long.MAX_VALUE) continue;
                d = mindis[j] + Math.abs(mb-ma);
                if(j == 0) 
                    temp[curpos] = Math.min( d , temp[curpos]);
                else
                    temp[curpos] = Math.min( d + Math.abs(ma-j), temp[curpos]);
                
                if(curpos == 0) 
                    temp[j] = Math.min( d, temp[j]);
                else
                    temp[j] = Math.min( d + Math.abs(ma-curpos) , temp[j]);
            }
            curpos = mb;
            temp2 = mindis;
            mindis = temp;
            temp = temp2;
        }
        
        long min = mindis[0];
        for(int i=0; i<=m; i++) min = Math.min(min, mindis[i]);
        System.out.println(min);
    }
    static Scanner sc = new Scanner(System.in);
    static int ni() { return sc.nextInt(); }
    
    static void print(Object... objs){
        System.out.println(Arrays.deepToString(objs));
    }
}
