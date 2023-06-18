/*

Topic:- Prime XOR

Link:- https://www.hackerrank.com/challenges/prime-xor/problem?isFullScreen=true

Problem:-

Penny has an array of n integers, [a0,a1, a2, ...., an-1]. She wants to find the number of unique multisets she can form using elements from the array such that the bitwise XOR of all the elements of the multiset is a prime number. Recall that a multiset is a set which can contain duplicate elements.

Given q queries where each query consists of an array of integers, can you help Penny find and print the number of valid multisets for each array? As these values can be quite large, modulo each answer by  10^9 + 7 before printing it on a new line.

Input Format

The first line contains a single integer, q, denoting the number of queries. The 2.q subsequent lines describe each query in the following format:

1.The first line contains a single integer, n, denoting the number of integers in the array.
2.The second line contains n space-separated integers describing the respective values of a0, a1,...,an-1.
Constraints

1 <= q <= 10
1 <= n <= 100000
3500 <= ai <= 4500
Output Format

On a new line for each query, print a single integer denoting the number of unique multisets Penny can construct using numbers from the array such that the bitwise XOR of all the multiset's elements is prime. As this value is quite large, your answer must be modulo 10^9 + 7.




Solution:-
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int mod = 1000000007;
    public static boolean[] prime = new boolean[ 10000 ];
    public static long[] dp = new long[ 1 << 13 ];
    public static long[] dpp = new long[ 1 << 13 ];
    public static long[] val = new long[ 5000 ];
    public static ArrayList< Integer > list = new ArrayList< Integer >();;
    public static void makeArray()
    {
        for( int i = 0; i < 10000; i++ )
            prime[ i ] = true;
        prime[ 0 ] = prime[ 1 ] = false;
        for( int i = 2; i < 10000; i++ )
        {
           if( !prime[ i ] )
            continue;
            for( int j = 2 * i; j < 10000; j += i)
                prime[ j ] = false; 
        }   
    }
    
    public static void check()
    {
        for( int i = 0; i < ( 1 << 13 ); i++ )
        {
            dp[ i ] = dpp[ i ] = 0;
            if( i < 4999 )
                val[ i ] = 0;
        }
        list.clear();
    }
    public static void main(String[] args) {
       
        Scanner input = new Scanner( System.in );
        makeArray();
        int q = input.nextInt();
        while( q > 0 )
        {
            check();
            int n = input.nextInt();
            long ans = 0l;
            for( int i = 0;  i < n; i++ )
            {
                int x = input.nextInt();
                if( val[ x ] == 0 )
                    list.add( x );
                val[ x ]++;
            }
            
            n = list.size();
            
            for( int i = 0; i < n; i++ )
            {
                for( int j = 0; j < ( 1 << 13 ); j++ )
                {
                    long free = val[ list.get( i ) ];
                    long odd = free / 2;
                    
                    odd = ( free % 2 == 0 ) ? odd : odd + 1;
                    long even = 1 + free / 2;
                    
                    if( i != 0 )
                        dp[ j ] = dpp[ j ] * even + dpp[ j ^ list.get( i ) ] * odd;
                    else
                    {
                        dp[ list.get( i ) ] = odd;
                        dp[ 0 ] = even;
                        break;
                    }
                    if( dp[ j ] >= mod )
                        dp[ j ] %= mod;
                }
                
                for( int j = 0; j < ( 1 << 13 ); j++ )
                {
                    if( ( i == n - 1 ) && prime[ j ] )
                    {
                        ans += dp[ j ];
                        if( ans >= mod )
                            ans %= mod;
                    }
                    dpp[ j ] = dp[ j ];
                    dp[ j ] = 0;
                }
            }
            System.out.println( ans );
            q--;
        }
    }
}
