/*

Topic:- Interval Selection

Link:- https://www.hackerrank.com/challenges/interval-selection/problem?isFullScreen=true

Problem:-

Given a set of n intervals, find the size of its largest possible subset of intervals such that no three intervals in the subset share a common point.

Input Format

The first line contains an integer, s, denoting the number of interval sets you must find answers for. The s.(n+1) subsequent lines describe each of the s interval sets as follows:

1.The first line contains an integer, n, denoting the number of intervals in the list.
Each line i of the n subsequent lines contains two space-separated integers describing the respective starting (ai) and ending (bi) boundaries of an interval.
Constraints
1 <= s <= 100
2 <= n <= 1000
1 <=  ai <= bi <= 10^9
Output Format

For each of the s interval sets, print an integer denoting the size of the largest possible subset of intervals in the given set such that no three points in the subset overlap.




Solution:-
*/
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    static class Foo53 {
        void main() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine().trim());
                for (int i = 0; i < T; i++) {
                    int N = Integer.parseInt(br.readLine().trim());
                    int[][] arr = new int[N][2];
                    for (int j = 0; j < N; j++) {
                        String[] s = br.readLine().trim().split("\\s+");
                        arr[j][0] = Integer.parseInt(s[0].trim());
                        arr[j][1] = Integer.parseInt(s[1].trim());
                    }
                    int res = foo(arr);
                    System.out.println(res);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try { br.close(); } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }
        
        Deque<Integer> deque;
        int foo(int[][] arr) {
            int res = 0;
            int n = arr.length;
            deque = new LinkedList<Integer>();
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            for (int[] a : arr) {
                int left = a[0], right = a[1];
                while (!deque.isEmpty() && deque.getFirst() < left)
                    deque.removeFirst();
                if (deque.size() < 2) {
                    res++;
                    add(right);
                } else {
                    if (deque.getLast() > right) {
                        deque.removeLast();
                        add(right);
                    }
                }
            }
            return res;
        }
        void add(int val) {
            if (!deque.isEmpty() && deque.getLast() > val) {
                deque.addFirst(val);
            } else {
                deque.addLast(val);
            }
        }
    }
    
    public static void main(String[] args) {
        Foo53 foo = new Foo53();
        foo.main();
    }
}
