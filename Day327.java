/*

Topic:- Insertion Sort Advanced Analysis

Link:- https://www.hackerrank.com/challenges/insertion-sort/problem?isFullScreen=true

Problem:-

Insertion Sort is a simple sorting technique which was covered in previous challenges. Sometimes, arrays may be too large for us to wait around for insertion sort to finish. Is there some other way we can calculate the number of shifts an insertion sort performs when sorting an array?
If k[i] is the number of elements over which the ¿th element of the array has to shift, then the total number of shifts will be k[1] + k[2]+ … + k[n].
Example
arr = [4, 3, 2, 1]

Array		Shifts
[4,3,2,1]	
[3,4,2,1]	1
[2,3,4,1]	2
[1,2,3,4]	3

Total shifts = 1 + 2 + 3 = 6
Function description

Complete the insertionSort function in the editor below.

insertionSort has the following parameter(s):

int arr[n]: an array of integers
Returns
– int: the number of shifts required to sort the array

Input Format
The first line contains a single integer t, the number of queries to perform.
The following t pairs of lines are as follows:

The first line contains an integer n, the length of arr.
The second line contains n space-separated integers arr[i].
Sample Input

2  
5  
1 1 1 2 2  
5  
2 1 3 1 2
Sample Output

0  
4   
Explanation

The first query is already sorted, so there is no need to shift any elements. In the second case, it will proceed in the following way.

Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
Moves:   -        1       -    2         -  1            = 4




Solution:-
*/
import java.util.*;

public class Main {

    static int[] arr = new int[10000001];

    public static int assign (int a, int[] arr, int i) {
        int j = read(arr, a);
        while (a <= 10000000) {
            arr[a]++;
            a += a&(-a);
        }
        return i - j;
    }

    public static int read (int[] arr, int a) {
        int x = 0;
        while (a > 0) {
            x = x + arr[a];
            a -= a&(-a);
        }
        return x;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        int numOfQueries = in.nextInt();

        while (numOfQueries > 0) {
            int arrayLength = in.nextInt();
            Arrays.fill(arr, 0);
            long ans = 0;

            for (int i = 0; i < arrayLength; i++) {
                ans = ans + assign(in.nextInt(), arr, i);
            }
            System.out.println(ans);
            numOfQueries--;
        }
    }
}
