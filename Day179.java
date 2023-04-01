/*

Topic:- Grid Challenge

Link:- https://www.hackerrank.com/challenges/grid-challenge/problem?isFullScreen=true

Problem:-

Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.

Example

The grid is illustrated below.

a b c
a d e
e f g

The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.

Function Description

Complete the gridChallenge function in the editor below.

gridChallenge has the following parameter(s):

string grid[n]: an array of strings
Returns

string: either YES or NO

Input Format

The first line contains , the number of testcases.

Each of the next  sets of lines are described as follows:
- The first line contains , the number of rows and columns in the grid.
- The next  lines contains a string of length 

Output Format

For each test case, on a separate line print YES if it is possible to rearrange the grid alphabetically ascending in both its rows and columns, or NO otherwise.



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

    // Complete the gridChallenge function below.
    static void gridChallenge(String[] grid,int n) {
        char ll[] = new char[n];
        char b[] = new char[n];
        boolean xx=true;
        int i=0;
     while(xx && i<grid[0].length()){
         for(int j=0 ; j<n;j++ ){
            ll[j]=grid[j].charAt(i);
         }
           
            b=Arrays.copyOf(ll,n);
            Arrays.sort(ll);
            
            if(!(Arrays.equals(b,ll))){
                  xx=false; 
                  break;
            }          
         i++;
    }
       
            if(xx){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
     }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
    
        for (int j = 0; j < x; j++){
             int n = scanner.nextInt();
               String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String arrItem = scanner.next();
                    char xx[]=arrItem.toCharArray();
                        Arrays.sort(xx);  
                            String string = new String(xx);
                                arr[i] = string ;
            }
                    gridChallenge(arr,n);
         }    
    }
}
