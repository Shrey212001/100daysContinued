/*

Topic:- Ashton and String

Link:- https://www.hackerrank.com/challenges/ashton-and-string/problem?isFullScreen=true

Problem:-

Ashton appeared for a job interview and is asked the following question. Arrange all the distinct substrings of a given string in lexicographical order and concatenate them. Print the  kth character of the concatenated string. It is assured that given value of k will be valid i.e. there will be a kth character. Can you help Ashton out with this?

Note We have distinct substrings here, i.e. if string is aa, it's distinct substrings are a and aa.

Function Description

Complete the ashtonString function in the editor below. It should return the kth character from the concatenated string, 1-based indexing.

ashtonString has the following parameters:
- s: a string
- k: an integer

Input Format

The first line will contain an integer t, the number of test cases.

Each of the subsequent t pairs of lines is as follows:
- The first line of each test case contains a string, s.
- The second line contains an integer, k.

Constraints

1  <=  t  <=  5
1  <=  | s | <=  10^5
k will be an appropriate integer.

Output Format

Print the kth character (1-based index) of the concatenation of the ordered distinct substrings of s.
  Sample Input

1
dbac
3
Sample Output

c
Explanation

The substrings when arranged in lexicographic order are as follows

a, ac, b, ba, bac, c, d, db, dba, dbac
On concatenating them, we get

aacbbabaccddbdbadbac
The third character in this string is c.Sample Input

1
dbac
3
Sample Output

c
Explanation

The substrings when arranged in lexicographic order are as follows

a, ac, b, ba, bac, c, d, db, dba, dbac
On concatenating them, we get

aacbbabaccddbdbadbac
The third character in this string is c.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.valueOf(in.next());
        for (int i = 0; i < testCases; i++) {
            String str = in.next();
            int k = Integer.valueOf(in.next());

            System.out.println(findSubstrings(str, k));
        }   
    }
    
     public static char findSubstrings(String string, int k) {
        char[] arr = string.toCharArray();
        Set<String> fastSet = new HashSet<>(100000);
        Object[] letters = new Object[26];

        for (int i = 0; i < arr.length; i++) {
            Bucket bucket = (Bucket) letters[(arr[i]) - 97];
            if (bucket == null) {
                bucket = new Bucket(String.valueOf(arr[i]));
                letters[(arr[i]) - 97] = bucket;
            }

            bucket.positions.add(i);
        }

        Stack<Bucket> bucketStack = new Stack<>();

        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] != null) {
                bucketStack.push((Bucket) letters[i]);
                letters[i] = null;
            }
        }

        int count = 0;
        while (!bucketStack.isEmpty()) {
            Bucket b = bucketStack.pop();
                if (count + b.str.length() >= k) {
                    return b.str.charAt(k - count - 1);
                } else {
                    count += b.str.length();
                }
            for (int position : b.positions) {
                if (arr.length > position + b.str.length()) {

                    int newCharPosition = position + b.str.length();
                    Bucket bucket = (Bucket) letters[(arr[newCharPosition]) - 97];
                    if (bucket == null) {
                        String currStr = b.str + arr[newCharPosition];
                        bucket = new Bucket(currStr);
                        letters[(arr[newCharPosition]) - 97] = bucket;
                    }

                    bucket.positions.add(position);
                }
            }

            for (int i = letters.length - 1; i >= 0; i--) {
                if (letters[i] != null) {
                    bucketStack.push((Bucket) letters[i]);
                    letters[i] = null;
                }
            }
        }

        return '-';
    }

    public static class Bucket implements Comparable<Bucket> {

        String str;
        List<Integer> positions = new ArrayList<>();

        public Bucket(final String str) {
            this.str = str;
        }

        @Override
        public int compareTo(final Bucket o) {
            return -str.compareTo(o.str);
        }

        @Override
        public int hashCode() {
            return str.hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            return str.equals(((Bucket) obj).str);
        }
    }
}
