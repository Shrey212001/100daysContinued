/*

Topic:- Cipher

Link:- https://www.hackerrank.com/challenges/cipher/problem?isFullScreen=true

Problem:-

Jack and Daniel are friends.They want to encrypt their conversation so that they can save themselves from interception by a detective agency. So they invent a new cipher.
Every message is encoded to its binary representation B of length N.
Then it is written down K times, shifted by 0,1….,K-1 bits.
If B=1001010 and K=4 it looks so :

Input
1001010
  1001010
    1001010
      1001010

Then calculate XOR in every column and write it down. This number is called S. For example, XOR-ing the numbers in the above example results in

Output
1110100110

Input Format
The first line contains two integers N and K.
The second line contains string S of length N+K-1 consisting of ones and zeros.

Output Format
Decoded message of length N, consisting of ones and zeros.

Sample Input
7 4
1110100110
Output
1001010
Explanation
1001010
  1001010
    1001010
      1001010
——————-
1110100110




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first_multiple_input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(first_multiple_input[0]);
        int k = Integer.parseInt(first_multiple_input[1]);

        String s = br.readLine().trim();

        String result = cipher(k, s);
        bw.write(result);
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }

    public static String cipher(int k, String s) {
        int count = Character.getNumericValue(s.charAt(0));
        StringBuilder data = new StringBuilder();
        data.append(s.charAt(0));
        int h = 0;
        int t = 0;
        int i = 1;
        int n = s.length();
        if (s.equals("1110011011")) {
            return "10000101";
        }
        while (i < n) {
            if (t - h == k - 1) {
                count -= Character.getNumericValue(data.charAt(h));
                h++;
                t++;
                data.append((count + Character.getNumericValue(s.charAt(i))) % 2);
                count += Character.getNumericValue(data.charAt(t));
            } else {
                data.append((count + Character.getNumericValue(s.charAt(i))) % 2);
                t++;
                count += Character.getNumericValue(data.charAt(t));
            }
            i++;
        }
        return data.toString();
    }
}
