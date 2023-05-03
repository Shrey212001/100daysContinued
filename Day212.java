/*

Topic:- Hackerland Radio Transmitters

Link:- https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem?isFullScreen=true

Problem:-

Hackerland is a one-dimensional city with houses aligned at integral locations along a road. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away.

Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house is within range of at least one transmitter. Each transmitter must be installed on top of an existing house.

Function Description

Complete the hackerlandRadioTransmitters function in the editor below.

hackerlandRadioTransmitters has the following parameter(s):

int x[n]: the locations of houses
int k: the effective range of a transmitter
Returns

int: the minimum number of transmitters to install

Input Format

The first line contains two space-separated integers n and k, the number of houses in Hackerland and the range of each transmitter.
The second line contains n space-separated integers describing the respective locations of each house 
x[i] .


Output Format

Print a single integer denoting the minimum number of transmitters needed to cover all of the houses.


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
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        
        Arrays.sort(x);
        
        int left = 0,right,mid, ans = 0;
        int end;
        
        while(left < n) {
            right = left;
            mid = left;
            ans++;
            
            while(mid < n && x[mid] - x[left] <= k) {
                mid++; 
            }
            mid--;
            end = x[mid] + k;
            right = mid + 1;
            
            while(right < n && x[right] <= end) {
                right++;
            }
            left = right;
        }
        
        System.out.println(ans);
    }
}
