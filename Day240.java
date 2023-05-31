/*

Topic:- Candies

Link:- https://www.hackerrank.com/challenges/candies/problem?isFullScreen=true

Problem:-

Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.

Example

arr =  [ 4, 6, 4, 5 , 6 , 2 ]

She gives the students candy in the following minimal amounts: [ 1, 2, 1, 2,  3, 1 ] . She must buy a minimum of 10 candies.

Function Description

Complete the candies function in the editor below.

candies has the following parameter(s):

int n: the number of children in the class
int arr[n]: the ratings of each student
Returns

int: the minimum number of candies Alice must buy
Input Format

The first line contains an integer, n , the size of arr.
Each of the next n lines contains an integer arr[ i ] indicating the rating of the student at position i.

Constraints

1  <=   n  <=  10^5
1  <=  arr[ i ]  <=  10^5

Sample Input 0

3
1
2
2

Sample Output 0

4




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
    static long candies(int n, int[] arr) {

  int[] candies = new int[n];
  candies[0] = 1;
  for (int i = 1; i < n; i++) {
    if (arr[i] > arr[i - 1]) {
      candies[i] = candies[i - 1] + 1;
    } else {
      candies[i] = 1;
    }
  }

  for (int i = n - 2; i >= 0; i--) {
    if (arr[i] > arr[i + 1] && candies[i] <= candies[i + 1]) {
      candies[i] = candies[i + 1] + 1;
    }
  }

  long sum = 0;
  for (int c : candies) {
    sum += c;
  }
  return sum;
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
