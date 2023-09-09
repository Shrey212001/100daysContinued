/*

Topic:- Save Humanity

Link:- https://www.hackerrank.com/challenges/save-humanity/problem?isFullScreen=true

Problem:-

Oh!! Mankind is in trouble again. This time, it's a deadly disease spreading at a rate never seen before. The need of the hour is to set up efficient virus detectors. You are the lead at Central Hospital and you need to find a fast and reliable way to detect the footprints of the virus DNA in that of the patient.

The DNA of the patient as well as of the virus consists of lowercase letters. Since the collected data is raw, there may be some errors. You will need to find all substrings in the patient DNA that either exactly match the virus DNA or have at most one mismatch, i.e., a difference in at most one location.

For example, "aa" and "aa" are matching, "ab" and "aa" are matching, while "abb" and "bab" are not.

Function Description

Complete the virusIndices function in the editor below. It should print a list of space-separated integers that represent the starting indices of matching substrings in increasing order, or No match!.

virusIndices has the following parameter(s):

p: a string that represents patient DNA
v: a string that represents virus DNA

Input Format

The first line contains an integer , the number of test cases.

. Each of the next  lines contains two space-separated strings  (the patient DNA) and  (the virus DNA).

Constraints

1  <=  t  <= 10
1  <=  | p |, | v |  <=  10^5

All characters in p  and v e ascii[ a - z ].


Output Format

For each test case, output a single line containing a space-delimited list of starting indices (0-indexed) of p substrings of  which are matching with v according to the condition mentioned above. The indices have to be in increasing order. If there is no matching substring, output No Match!.

Sample Input 0

3
abbab ba
hello world
banana nan
Sample Output 0

1 2
No Match!
0 2
Explanation 0

For the first case, the substrings of  starting at indices  and  are "bb" and "ba" and they are matching with the string  which is "ba".
For the second case, there are no matching substrings so the output is No Match!.
For the third case, the substrings of  starting at indices  and  are "ban" and "nan" and they are matching with the string  which is "nan".

Sample Input 1

3
cgatcg gc
atcgatcga cgg
aardvark ab
Sample Output 1

1 3
2 6
0 1 5
Explanation 1

For the first case, the substrings of  starting at indices  and  are "ga" and "gc" and they are matching with the string  which is "gc".
For the second case, the substrings of  starting at indices  and  are "cga" and "cga" and they are matching with the string  which is "cgg".
For the third case, the substrings of  starting at indices ,  and  are "aa", "ar" and "ar" and they are matching with the string  which is "ab".




Solution:-
*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

import java.util.stream.Collectors;

public class Solution {

    /*
     * Complete the virusIndices function below.
     */
    static List<Integer> virusIndices(String p, String v) {
        List<Integer> z = z_function(v + "#" + p);
        List<Integer> z_reversed = z_function(new StringBuilder(v).reverse().toString() + "#" + new StringBuilder(p).reverse().toString());
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= p.length() - v.length(); ++i) {
            if (z.get(i + v.length() + 1) + z_reversed.get(p.length() - i + 1) >= v.length() - 1) {
                answer.add(i);
            }
        }
        return answer;
    }

    private static List<Integer> z_function(String s) {
        List<Integer> z = new ArrayList(s.length());
        z.add(0);
        int l = 0;
        int r = 0;
        for (int i = 1; i < s.length(); ++i) {
            int z_i = 0;
            if (i <= r)
                z_i = r - i + 1 < z.get(i - l) ? r - i + 1 : z.get(i - l);
            while (i + z_i < s.length() && s.charAt(z_i) == s.charAt(i + z_i)) 
                ++z_i;
            if (i + z_i - 1 > r) {
                l = i;
                r = i + z_i - 1;
            }
            z.add(z_i);
        }
        return z;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] pv = scanner.nextLine().split(" ");

            String p = pv[0];

            String v = pv[1];

            List<Integer> answer = virusIndices(p, v);
            if (answer.size() == 0) {
                System.out.println("No Match!");
            } else {
                System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }
}
