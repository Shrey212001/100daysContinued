/*

Topic:- Lena Sort

Link:- https://www.hackerrank.com/challenges/lena-sort/problem?isFullScreen=true

Problem:-

Lena developed a sorting algorithm described by the following pseudocode:

lena_sort(array nums) {
    if (nums.size <= 1) {
        return nums;
    }
    pivot = nums[0];
    array less;
    array more;
    for (i = 1; i < nums.size; ++i) {
    	// Comparison
        if (nums[i] < pivot) {
            less.append(nums[i]);
        }
        else {
            more.append(nums[i]);
        }
    }
    sorted_less = lena_sort(less);
    sorted_more = lena_sort(more);
    ans = sorted_less + pivot + sorted_more;
    
    return ans;
}
We consider a comparison to be any time some nums[i] is compared with pivot.

You must solve q queries where each query i consists of some len(i) and ci. For each query, construct an array of len(i) distinct elements in the inclusive range between 1 and 10^9 that will be sorted by lena_sort in exactly ci comparisons, then print each respective element of the unsorted array as a single line of leni space-separated integers; if no such array exists, print -1 instead.

Input Format

The first line contains a single integer denoting q (the number of queries).
Each line i of the q subsequent lines contains two space-separated integers describing the respective values of len(i) (the length of the array) and ci (the number of comparisons) for query i.

Constraints

1 <= q <= 10^5
1 <= len(i) <= 10^5
0 <= ci <= 10^9
1 <=  the sum of len(i) over all queries <= 10^6

Output Format

Print the answer to each query on a new line. For each query i, print len(i) space-separated integers describing each respective element in an unsorted array that Lena's algorithm will sort in exactly ci comparisons; if no such array exists, print -1 instead.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        long[] mins = new long[100001];
        long[] maxes = new long[100001];
        mins[2] = 1;
        maxes[2] = 1;
        for (int i = 3; i <= 100000; i++) {
            mins[i] = i-1+mins[(i-1)/2]+mins[(i-1)-(i-1)/2];
            maxes[i] = maxes[i-1]+i-1;
        }
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int len = in.nextInt();
            int c = in.nextInt();
            if (maxes[len]<c||mins[len]>c) {
                System.out.println(-1);
                continue;
            }
            System.out.println(portion(len, c, 1, mins, maxes, new StringBuilder()));
        }
    }
    
    public static StringBuilder portion(int len, long c, int offset, long[] mins, long[] maxes, StringBuilder ans) {
        if (len==0) {
            return ans;
        }
        if (len==1) {
            ans.append(offset+" ");
            return ans;
        }
        int pivot = 0;
        c -= len-1;
        while (mins[pivot]+mins[len-pivot-1]>c||maxes[pivot]+maxes[len-pivot-1]<c)
            pivot++;
        long newc = mins[pivot];
        while (mins[len-pivot-1]>c-newc||maxes[len-pivot-1]<c-newc)
            newc++;
        ans.append((pivot+offset)+" ");
        portion(pivot, newc, offset, mins, maxes, ans);
        portion(len-pivot-1, c-newc, offset+pivot+1, mins, maxes, ans);
        return ans;
    }
}
