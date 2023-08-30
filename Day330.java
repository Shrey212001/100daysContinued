/*

Topic:- Build a Palindrome

Link:- https://www.hackerrank.com/challenges/challenging-palindromes/problem?isFullScreen=true

Problem:-

You have two strings,  and . Find a string, , such that:

 can be expressed as  where  is a non-empty substring of  and  is a non-empty substring of .
 is a palindromic string.
The length of  is as long as possible.
For each of the  pairs of strings ( and ) received as input, find and print string  on a new line. If you're able to form more than one valid string , print whichever one comes first alphabetically. If there is no valid answer, print  instead.

Input Format

The first line contains a single integer, , denoting the number of queries. The subsequent lines describe each query over two lines:

The first line contains a single string denoting .
The second line contains a single string denoting .
Constraints

 and  contain only lowercase English letters.
Sum of |a| over all queries does not exceed 
Sum of |b| over all queries does not exceed 
Output Format

For each pair of strings ( and ), find some  satisfying the conditions above and print it on a new line. If there is no such string, print  instead.

Sample Input

3
bac
bac
abc
def
jdfh
fds
Sample Output

aba
-1
dfhfd
Explanation

We perform the following three queries:

Concatenate  with  to create .
We're given  and ; because both strings are composed of unique characters, we cannot use them to form a palindromic string. Thus, we print .
Concatenate  with  to create . Note that we chose these particular substrings because the length of string  must be maximal.




Solution:-
*/
import java.util.*;

public class PalindromeBuilder {
public static class State {
int length;
int link;
int[] next = new int[128];
int endpos;
final List<Integer> ilink;

public State()
{
Arrays.fill(next, -1);
ilink = new ArrayList<>();
}
}

public static State[] buildSuffixAutomaton(String s) {
int n = s.length();
State[] st = new State[Math.max(2, 2 * n - 1)];
st[0] = new State();
st[0].link = -1;
st[0].endpos = -1;
int last = 0;
int size = 1;
for (char c : s.toCharArray()) {
int cur = size++;
st[cur] = new State();
st[cur].length = st[last].length + 1;
st[cur].endpos = st[last].length;

int p = go(st, last, -1, c, cur);
if (p == -1) {
st[cur].link = 0;
} else {
int q = st[p].next[c];
if (st[p].length + 1 == st[q].length)
st[cur].link = q;
else {
int clone = size++;
st[clone] = new State();
st[clone].length = st[p].length + 1;
st[clone].next = st[q].next.clone();
st[clone].link = st[q].link;
go(st, p, q, c, clone);
st[q].link = clone;
st[cur].link = clone;
st[clone].endpos = -1;
}
}
last = cur;
}
for (int i = 1; i < size; i++) {
st[st[i].link].ilink.add(i);
}
return Arrays.copyOf(st, size);
}

private static int go(State[] st, 
int p, int q, char c, int ns) {
while (p != -1 && st[p].next[c] == q) {
st[p].next[c] = ns;
p = st[p].link;
}
return p;
}

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
for (int i = 0; i < n; ++i) {
String a = sc.next();
String b = sc.next();
System.out.println(solve(a, b));
}
}

static String candidate(String a, String b) {
State[] as = buildSuffixAutomaton(a);
int[] l = buildPalindromeLookup(b);

int len = 0;

int bestHalf = 0;
int bestMid = 0;
int bestTotal = 0;
int start = -1;
for (int i = 0, aPos = 0; i < b.length(); ++i) {
char c = b.charAt(i);
if (as[aPos].next[c] == -1) {
while (aPos != -1 && as[aPos].next[c] == -1) {
aPos = as[aPos].link;
}
if (aPos == -1) {
aPos = 0;
len = 0;
continue;
}
len = as[aPos].length;
}
++len;
aPos = as[aPos].next[c];

int nStart = i - len + 1;
int nMid = 0;
if (i + 1 < b.length()) {
nMid = l[i + 1];
}
int nTotal = 2*len + nMid;

if (bestTotal < nTotal || (
bestTotal == nTotal && gt(
b, start, nStart, len + nMid))) {
bestHalf = len;
bestMid = nMid;
bestTotal = nTotal;
start = nStart;
}
}
StringBuilder sb = new StringBuilder();
for (int i = 0; i < bestHalf + bestMid; ++i) {
sb.append(b.charAt(start + i));
}
for (int i = bestHalf - 1; i >= 0; --i) {
sb.append(sb.charAt(i));
}
return sb.toString();
}

static String solve(String a, String b) {
String rb = rev(b);
String res = candidate(a, rb);
String c1 = candidate(rb, a);
if (c1.length() > res.length() || (
c1.length() == res.length() && c1.compareTo(res) < 0)) {
res = c1;
}
if (res.length() == 0) {
res = "-1";
}
return res;
}

static String rev(String s) {
StringBuilder sb = new StringBuilder();
for (int i = s.length() - 1; i >= 0; --i) {
sb.append(s.charAt(i));
}
return sb.toString();
}

static boolean gt(String s, 
int start, int nStart, int size) {
int cmp = 0;
for (int i = 0; i < size; ++i) {
cmp = Character.compare(
    s.charAt(start + i), s.charAt(nStart + i));
if (cmp != 0) {
break;
}
}
return cmp > 0;
}

static int[] buildPalindromeLookup(String s) {
char[] s2 = addBoundaries(s.toCharArray());
int[] p = new int[s2.length];
int c = 0, r = 0;
int m = 0, n = 0;
for (int i = 1; i < s2.length; i++) {
if (i > r) {
p[i] = 0;
m = i - 1;
n = i + 1;
} else {
int i2 = c * 2 - i;
if (p[i2] < (r-i)) {
p[i] = p[i2];
m = -1;
} else {
p[i] = r - i;
n = r + 1;
m = i * 2 - n;
}
}
while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
p[i]++;
m--;
n++;
}
if ((i + p[i]) > r) {
c = i;
r = i + p[i];
}
}
int[] res = new int[s.length()];
for (int i = 1; i < s2.length - 1; i++) {
int idx = (i - p[i])/2;
res[idx] = Math.max(res[idx], p[i]);
}
return res;
}

private static char[] addBoundaries(char[] cs) {
if (cs == null || cs.length == 0)
return "||".toCharArray();

char[] cs2 = new char[cs.length * 2 + 1];
for (int i = 0; i < cs2.length - 1; i += 2) {
cs2[i] = '|';
cs2[i + 1] = cs[i / 2];
}
cs2[cs2.length - 1] = '|';
return cs2;
}
}  
