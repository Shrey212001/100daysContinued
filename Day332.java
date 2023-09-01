/*

Topic:- Gridland Provinces

Link:- https://www.hackerrank.com/challenges/gridland-provinces/problem?isFullScreen=true

Problem:-

The Kingdom of Gridland contains  provinces. Each province is defined as a  grid where each cell in the grid represents a city. Every cell in the grid contains a single lowercase character denoting the first character of the city name corresponding to that cell.

From a city with the coordinates , it is possible to move to any of the following cells in  unit of time (provided that the destination cell is within the confines of the grid):

A knight wants to visit all the cities in Gridland. He can start his journey in any city and immediately stops his journey after having visited each city at least once. Moreover, he always plans his journey in such a way that the total time required to complete it is minimum.

After completing his tour of each province, the knight forms a string by concatenating the characters of all the cells in his path. How many distinct strings can he form in each province?

Input Format

The first line contains a single integer, , denoting the number of provinces. The  subsequent lines describe each province over the following three lines:
The first line contains an integer, , denoting the number of columns in the province.
Each of the next two lines contains a string, , of length  denoting the characters for the first and second row of the province.

Constraints

1  <=  P  <=  15
1  <=  N  <=  600
Si E { a - z }

Output Format

For each province, print the number of distinct strings the knight can form on a new line.

Sample Input

3
1
a
a
3
dab
abd
5
ababa
babab
Sample Output

1
8
2
Explanation

Province 0:
query 0

The knight can only form one string (aa), so we print  on a new line.

Province 1:
query 1

The knight can form eight different strings (abdbad, adabdb, badabd, bdbada, dababd, dabdba, dbabad, and dbadab), so we print  on a new line.

Province 2:
query 2

The knight can form two different strings (ababababab and bababababa), so we print  on a new line.




Solution:-
*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {
private final static Scanner scanner = 
new Scanner(System.in);
private final static long mod1 = 2147483607,
 f1 = 107, f2 = 101;
private final static long[] arr1 = new long[10000], 
arr2 = new long[10000]; 
private final static Set<Long> result = new HashSet<>();
public static void main(String[] args) {
for (int i = 0; i < arr1.length; ++i) {
arr1[i] = i > 0 ? arr1[i - 1] * f1 % mod1 : 1;
arr2[i] = i > 0 ? arr2[i - 1] * f2 % mod1 : 1;
}

for (int t = scanner.nextInt(); t > 0; --t) {
result.clear();
scanner.nextInt();
char[] c1 = scanner.next().toCharArray();
char[] c2 = scanner.next().toCharArray();

for (int i = 0; i < c1.length; ++i) {
process(c1, c2, i, false);
process(c2, c1, i, false); 
process(c1, c2, i, true);
process(c2, c1, i, true);
}
reverse(c1);
reverse(c2);
for (int i = 0; i < c1.length; ++i) {
process(c1, c2, i, false);
process(c2, c1, i, false); 
process(c1, c2, i, true);
process(c2, c1, i, true);
}
System.out.println(result.size());
}
}

static void process(char[] s1, char[] s2, int k, boolean b) {
long p1 = 0, p2 = 0, p3 = 0, p4 = 0;
for (int i = 0; i < k; ++i) {
p1 = (p1 + s1[i] * arr1[k - 1 - i]) % mod1;
p1 = (p1 + s2[i] * arr1[k + i]) % mod1;
p3 = (p3 + s1[i] * arr2[k - 1 - i]) % mod1;
p3 = (p3 + s2[i] * arr2[k + i]) % mod1;
}
if (b) {
p1 = (p1 + s2[k] * arr1[k * 2]) % mod1;
p1 = (p1 + s1[k] * arr1[k * 2 + 1]) % mod1;
p3 = (p3 + s2[k] * arr2[k * 2]) % mod1;
p3 = (p3 + s1[k] * arr2[k * 2 + 1]) % mod1;
char[] s = s1; s1 = s2; s2 = s;
++k;
}
for (int i = k; i < s1.length; ++i) {
p2 = (p2 + s1[i] * arr1[s1.length * 2 + k - 1 - i]) % mod1;
p2 = (p2 + s2[i] * arr1[i + k]) % mod1;
p4 = (p4 + s1[i] * arr2[s1.length * 2 + k - 1 - i]) % mod1;
p4 = (p4 + s2[i] * arr2[i + k]) % mod1;
}
result.add(((p1 + p2) % mod1) * mod1 + (p3 + p4) % mod1);

for (int i = k; i < s1.length - 1; i += 2) {
p1 = (p1 + s2[i] * arr1[i * 2]) % mod1;
p1 = (p1 + s1[i] * arr1[i * 2 + 1]) % mod1;
p1 = (p1 + s1[i + 1] * arr1[i * 2 + 2]) % mod1;
p1 = (p1 + s2[i + 1] * arr1[i * 2 + 3]) % mod1;
p2 = (p2 + s2[i] * (mod1 - arr1[i * 2])) % mod1;
p2 = (p2 + s2[i+1] * (mod1 - arr1[i * 2 + 1])) % mod1;
p2 = (p2 + s1[i] * (mod1 - arr1[s1.length * 2 - 1])) % mod1;
p2 = (p2 + s1[i+1] * (mod1 - arr1[s1.length * 2 - 2])) % mod1;
p2 = (p2 * f1 * f1) % mod1;

p3 = (p3 + s2[i] * arr2[i * 2]) % mod1;
p3 = (p3 + s1[i] * arr2[i * 2 + 1]) % mod1;
p3 = (p3 + s1[i + 1] * arr2[i * 2 + 2]) % mod1;
p3 = (p3 + s2[i + 1] * arr2[i * 2 + 3]) % mod1;
p4 = (p4 + s2[i] * (mod1 - arr2[i * 2])) % mod1;
p4 = (p4 + s2[i+1] * (mod1 - arr2[i * 2 + 1])) % mod1;
p4 = (p4 + s1[i] * (mod1 - arr2[s1.length * 2 - 1])) % mod1;
p4 = (p4 + s1[i+1] * (mod1 - arr2[s1.length * 2 - 2])) % mod1;
p4 = (p4 * f2 * f2) % mod1;

result.add(((p1 + p2) % mod1) * mod1 + (p3 + p4) % mod1);
}
}

private static void reverse(char[] str) {
for (int i = str.length / 2 - 1; i >= 0; --i) {
char t = str[i];
str[i] = str[str.length - 1 - i];
str[str.length - 1 - i] = t;
}
}

}
