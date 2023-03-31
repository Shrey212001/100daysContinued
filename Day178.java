/*

Topic:- Marc's Cakewalk

Link:- https://www.hackerrank.com/challenges/marcs-cakewalk/problem?isFullScreen=true

Problem:-

Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count, and Marc can walk a distance to expend those calories. If Marc has eaten  cupcakes so far, after eating a cupcake with  calories he must walk at least  miles to maintain his weight.

consumption. In this case, our minimum miles is calculated as .

Given the individual calorie counts for each of the cupcakes, determine the minimum number of miles Marc must walk to maintain his weight. Note that he can eat the cupcakes in any order.

Function Description

Complete the marcsCakewalk function in the editor below.

marcsCakewalk has the following parameter(s):

int calorie[n]: the calorie counts for each cupcake

Returns

long: the minimum miles necessary

Input Format

The first line contains an integer , the number of cupcakes in .
The second line contains  space-separated integers, .



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
        int[] calories = new int[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        Arrays.sort(calories);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long)calories[n-i-1])<<i;
        }
        System.out.println(ans);
    }
}
