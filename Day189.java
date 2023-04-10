/*

Topic:- Jim and the Orders

Link:- https://www.hackerrank.com/challenges/jim-and-the-orders/problem?isFullScreen=true

Problem:-

Jim's Burgers has a line of hungry customers. Orders vary in the time it takes to prepare them. Determine the order the customers receive their orders. Start by numbering each of the customers from  to , front of the line to the back. You will then be given an order number and a preparation time for each customer.

The time of delivery is calculated as the sum of the order number and the preparation time. If two orders are delivered at the same time, assume they are delivered in ascending customer number order.

For example, there are  customers in line. They each receive an order number  and a preparation time .:

Customer	1	2	3	4	5
Order #		8	5	6	2	4
Prep time	3	6	2	3	3
Calculate:
Serve time	11	11	8	5	7
We see that the orders are delivered to customers in the following order:

Order by:
Serve time	5	7	8	11	11
Customer	4	5	3	1	2
Function Description

Complete the jimOrders function in the editor below. It should return an array of integers that represent the order that customers' orders are delivered.

jimOrders has the following parameter(s):

orders: a 2D integer array where each  is in the form .

Input Format

The first line contains an integer , the number of customers.
Each of the next  lines contains two space-separated integers, an order number and prep time for .

Output Format

Print a single line of  space-separated customer numbers (recall that customers are numbered from  to ) that describes the sequence in which the customers receive their burgers. If two or more customers receive their burgers at the same time, print their numbers in ascending order.





Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] o=new int[n];
        boolean[]oo=new boolean[n];
        int[] sol=new int[n];
        for(int i=0;i<n;i++)
            {
            o[i]=(in.nextInt()+in.nextInt());
            oo[i]=false;
        }
        for(int c=0;c<n;c++)
            {
           int best=o[c];
            int r=1;
        for(int i=0;i<n;i++)
            {
            
            if(c!=i&&o[c]>o[i])
                {
                r++;
            }
        }
            if(oo[r-1])
                {
                r++;
            }else{
                oo[r-1]=true;
            }
            sol[r-1]=c+1;
        }
        for(int c=0;c<n;c++)
            {
            System.out.print(sol[c]+" "); 
        }
        
        
    }
}
