/*
Topic:- Almost Sorted

Link:- https://www.hackerrank.com/challenges/almost-sorted/problem?isFullScreen=true

Problem:-

If an array can be sorted both ways, by using either swap or reverse, choose swap.

If the array cannot be sorted either way, output no on the first line.
Example


arr = [2, 3, 5, 4]

Either swap the 4 and 5 at indices 3 and 4, or reverse them to sort the array. As mentioned above, swap is preferred over reverse. Choose swap. On the first line, print yes. On the second line, print swap 3 4.

Function Description

Complete the almostSorted function in the editor below.


almostSorted has the following parameter(s):

int arr[n]: an array of integers
Prints

Print the results as described and return nothing.
Input Format
The first line contains a single integer n, the size of arr.
The next line contains n space-separated integers arr[i] where 1 <= i <= n.

Constraints
2 <= n <= 100000
0 <= arr[i] <= 1000000
All arr[i] are distinct.
Output Format
If the array is already sorted, output yes on the first line. You do not need to output anything else.
If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:
a. If elements can be swapped, d[l] and d[r], output swap l r in the second line. l and r are the indices of the elements to be swapped, assuming that the array is indexed from 1 to n.
b. Otherwise, when reversing the segment d[l . . . r], output reverse l r in the second line. l and r are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from 1 to n. 
d[l . . . r]represents the sub-sequence of the array, beginning at index l and ending at index r, both inclusive.
If an array can be sorted by either swapping or reversing, choose swap.


If you cannot sort the array either way, output no on the first line.
Sample Input 1

STDIN   Function
-----   --------
2       arr[] size n = 2
4 2     arr = [4, 2]
Sample Output 1

yes  
swap 1 2
Explanation 1

You can either swap(1, 2) or reverse(1, 2). You prefer swap.


Sample Input 2

3
3 1 2
Sample Output 2

no
Explanation 2

It is impossible to sort by one single operation.


Sample Input 3

6
1 5 4 3 2 6
Sample Output 3

yes
reverse 2 5
Explanation 3

You can reverse the sub-array d[2…5] = “5 4 3 2”, then the array becomes sorted.



Solution:-
*/
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Get input
    final int N = Integer.parseInt(br.readLine());
    final int[] arr = new int[N];
    String[] line = br.readLine().split(" ");
    for(int i = 0; i < N; ++i){
      arr[i] = Integer.parseInt(line[i]);
    }
    
    //Print output
    System.out.print(solve(arr, N));
  }
  
  private static String solve(final int[] A, final int N){
    int l = 0;
    int r = N - 1;
    
    //Check for out of place index from the left
    while(l < r && A[l] <= A[l+1]){
      ++l;
    }
    
    //Check if array already sorted
    if(l == r){
      return "yes";
    }
    
    //Check for out of place index from the right
    while(r > l && A[r] >= A[r-1]){
      --r;
    }
    
    //Check if swapping or reversing would NOT sort the array
    if((l > 0 && A[r] < A[l-1]) || (r < N-1 && A[l] > A[r+1])){
      return "no";
    }
        
    //Check if we're dealing with a reversal
    int m;
    for(m = l+1; m < r && A[m] >= A[m+1]; ++m){}
    if(m == r){
      return "yes\n" + ((r-l < 2) ? "swap " : "reverse ") + (l+1) + " " + (r+1);
    }
    
    //Check if we're NOT dealing with a swap
    if(m-l > 1 || A[l] < A[r-1] || A[r] > A[l+1]){
      return "no";
    }
    
    //Check if we're dealing with a swap
    for(int k = r-1; m < k && A[m] <= A[m+1]; ++m){}
    return (r-m > 1) ? "no" : "yes\nswap " + (l+1) + " " + (r+1);
  }
}
