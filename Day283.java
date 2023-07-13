/*

Topic:- Counting Special Sub-Cubes

Link:- https://www.hackerrank.com/challenges/counting-special-sub-cubes/problem?isFullScreen=true

Problem:-

Given an n*n*n cube, let f(x,y,z) (where 1 <= x,y,z <= n) denote the value stored in cell (x,y,z).

A k*k*k sub-cube (where 1 <= k <= n) of an n*n*n cube is considered to be special if the maximum value stored in any cell in the sub-cube is equal to k.

For each k in the inclusive range [1,n], calculate the number of special sub-cubes. Then print each (count)k as a single line of space-separated integers (i.e., count1,count2,...,countn).

Input Format

The first line contains an integer, q, denoting the number of queries. The 2.q subsequent lines describe each query over two lines:

1.The first line contains an integer, n, denoting the side length of the initial cube.
2.The second line contains n^3 space-separated integers describing an array of n^3 integers in the form a0,a1,...,a(n^3-1). The integer in some cell (x,y,z) is calculated using the formula a[(x-1).n^2 + (y-1).n + z].

Constraints
1 <= q <= 5
1 <= n <= 50
1 <= f(x,y,z) <=n where 1 <= x,y,z <=n
Output Format

For each query, print n space-separated integers where the ith integer denotes the number of special sub-cubes for k=i.




Solution:-
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws Exception {
        int q = input();
        for (int i = 0; i < q; i++) {
            int n = input();
            int ans[] = new int[n];
            int b = n * n * n, c = n * n;
            int arr[][][] = new int[50][50][50];
            int crr[][][] = new int[50][50][50];
            int ck[] = new int[b];
            input(ck, b);
            int count=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        arr[j][k][l] = ck[count++];
                        if (arr[j][k][l] == 1) {
                            ans[0]++;
                        }

                    }
                }
            }
            System.out.print(ans[0] + " ");
            for (int p = 1; p < n; p++) {
                for (int l = 0; l < n - p; l++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            if (arr[j][k][l + 1] > arr[j][k][l]) {
                                arr[j][k][l] = arr[j][k][l + 1];
                            }
                        }
                    }
                }
                for (int l = 0; l < n - p; l++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n-p; k++) {
                            if (arr[j][l + 1][k] > arr[j][l][k]) {
                                arr[j][l][k] = arr[j][l + 1][k];
                            }

                        }
                    }
                }
                for (int l = 0; l < n - p; l++) {
                    for (int j = 0; j < n-p; j++) {
                        for (int k = 0; k < n-p; k++) {
                            if (arr[l + 1][j][k] > arr[l][j][k]) {
                                arr[l][j][k] = arr[l + 1][j][k];
                            }
                        }
                    }
                }
                for (int l = 0; l < n - p; l++) {
                    for (int j = 0; j < n-p; j++) {
                        for (int k = 0; k < n-p; k++) {
                           if(arr[j][k][l]==p+1) 
                        ans[p]++;
                        }
                    }
                }
                System.out.print(ans[p] + " ");
            }
            System.out.println();
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    private static String s[], w;
    public static void input(int a[], int p) throws IOException {
        s = br.readLine().split(" ");
        int i;
        for (i = 0; i < p; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
    public static void input(long a[], int p) throws IOException {
        s = br.readLine().split(" ");
        int i;
        for (i = 0; i < p; i++) {
            a[i] = Long.parseLong(s[i]);
        }
    }
    public static void input(double a[], int p) throws IOException {
        s = br.readLine().split(" ");
        int i;
        for (i = 0; i < p; i++) {
            a[i] = Double.parseDouble(s[i]);
        }
    }
    public static int input() throws IOException {
        int a;
        a = Integer.parseInt(br.readLine());
        return a;
    }
}
