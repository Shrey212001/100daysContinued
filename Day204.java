/*
 
Topic:- Fraudulent Activity Notifications

Link:- https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?isFullScreen=true

Problem:-

HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to 2 x the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.

Given the number of trailing days d and a client's total daily expenditures for a period of n days, find and print the number of times the client will receive a notification over all  days.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. (Wikipedia)

Function Description

Complete the function activityNotifications in the editor below. It must return an integer representing the number of client notifications.

activityNotifications has the following parameter(s):

expenditure: an array of integers representing daily expenditures
d: an integer, the lookback days for median spending

Input Format

The first line contains two space-separated integers n and d, the number of days of transaction data, and the number of trailing days' data used to calculate median spending.
The second line contains n space-separated non-negative integers where each integer i denotes expenditure[ i ].

Constraints

1   <=  n  <= 2* 10^5
1    <=  d  <=  n
0  <=   expenditure[ i ]  <=  200

Output Format

Print an integer denoting the total number of times the client receives a notification over a period of  n days.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static double median(int[]b){

        int mid=(int)b.length/2;
        if(b.length%2==1){
            return b[mid];
        }
        else{
            return (b[mid-1]+b[mid])/2.0;
        }
    }
    
    public static int BS(int[] arr,int in, int start,int end){
        
         if(start>end){
                return -1;
                }
        
            int mid=start+(end-start)/2;
            if(arr[mid]==in){
        return mid;
            }
            
            else if(arr[mid]<in){
                return BS(arr,in,mid+1,end);
            }
            else {
                return BS(arr,in,start,mid-1);
            }    
        }
    public static void replace(int[]b,int x, int y){
        int ind=BS(b,x,0,b.length-1);
        b[ind]=y;
        if((ind==0&&b[ind]<=b[ind+1])||(ind==b.length-1&&b[ind]>=b[ind-1])){
            return;
        }
        else if(b[ind]>b[ind+1]){
            int temp=0;
            while(b[ind]>b[ind+1]){

                temp=b[ind];
                b[ind]=b[ind+1];
                b[ind+1]=temp;
                if(ind==b.length-2){
                    
                    break;
                }
                ind++;
            }
        }
        else if(b[ind]<b[ind-1]){
            int temp=0;
            while(b[ind]<b[ind-1]){
                if(ind==1){
                    break;
                }
                temp=b[ind];
                b[ind]=b[ind-1];
                b[ind-1]=temp;
                if(ind==1){
                    break;
                }
                ind--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
         Scanner scan=new Scanner(System.in);
         int n=scan.nextInt();
         int d=scan.nextInt();
        int a[]=new int[n];
        
for(int i=0;i<n;i++){
    a[i]=scan.nextInt();
}
int b[]=new int[d];
int not=0;

for(int i=0;i<d;i++){
    b[i]=a[i];
} 
Arrays.sort(b);
for(int i=d;i<n;i++){
if(a[i]>=2*median(b)){

    not=not+1;
}
replace(b,a[i-d],a[i]);
}

System.out.println(not);

    }
}
