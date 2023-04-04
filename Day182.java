/*

Topic:- Beautiful Pairs

Link:- https://www.hackerrank.com/challenges/beautiful-pairs/problem?isFullScreen=true

Problem:-

You are given two arrays,  and , both containing  integers.

A pair of indices  is beautiful if the  element of array  is equal to the  element of array . In other words, pair  is beautiful if and only if . A set containing beautiful pairs is called a beautiful set.

A beautiful set is called pairwise disjoint if for every pair  belonging to the set there is no repetition of either  or  values. For instance, if  and  the beautiful set  is not pairwise disjoint as there is a repetition of , that is .

Your task is to change exactly  element in  so that the size of the pairwise disjoint beautiful set is maximum

You are given two arrays,  and , both containing  integers.

A pair of indices  is beautiful if the  element of array  is equal to the  element of array . In other words, pair  is beautiful if and only if . A set containing beautiful pairs is called a beautiful set.

Output Format

Determine and print the maximum possible number of pairwise disjoint beautiful pairs.

Note: You must first change  element in , and your choice of element must be optimal.

A beautiful set is called pairwise disjoint if for every pair  belonging to the set there is no repetition of either  or  values. For instance, if  and  the beautiful set  is not pairwise disjoint as there is a repetition of , that is .

Your task is to change exactly  element in  so that the size of the pairwise disjoint beautiful set is maximum




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int len=s.nextInt();
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++)
            {
            int current=s.nextInt();
            if(!hmap.containsKey(current))
                {
                
                hmap.put(current,1);
            }
            else
                {
                int temp=hmap.get(current);
                hmap.put(current,++temp);
            }
        }
        int counter=0;
        for(int i=0;i<len;i++)
            {
            int current=s.nextInt();
            if(hmap.containsKey(current))
            {
                int temp=hmap.get(current);
                if(temp>0)
                {
                    hmap.put(current,--temp);
                    counter++;
                }
                else
                    {
                    hmap.remove(current);
                }
                
            }
        }
        if(counter==len)
            System.out.println(counter-1);
        else if(counter<len)
            System.out.println(counter+1);
        else
            System.out.println(counter);
    }
}
