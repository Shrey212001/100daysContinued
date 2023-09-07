/*

Topic:-Similar Strings

Link:- https://www.hackerrank.com/challenges/similar-strings/problem?isFullScreen=true

Problem:-

Jimmy loves playing with strings. He thinks string  A is similar to string B if the following conditions are satisfied:

Both strings have the same length (i.e.,  and ).
For each valid pair of indices, , in the strings,  and  or  and .
For example, string  and  are similar as for ,  and  and for all other  pairs  as well as .

He has a string, , of size  and gives you  queries to answer where each query is in the form of a pair of integers . For each substring , find the number of substrings  where substring  is similar to substring  and print this number on a new line.

Note: Substring  is the contiguous sequence of characters from index  to index . For example, if  abcdefgh, then  cdef.

Input Format

The first line contains two space-separated integers describing the respective values of  and .
The second line contains string .
Each line  of the  subsequent lines contains two space-separated integers describing the respective values of  and  for query .

Output Format

For each query, print the number of similar substrings on a new line.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.HashMap;
public class Solution {
static class InputReader {
private InputStream stream;
private byte[] buf = new byte[4096];
private int curChar;
private int numChars;
private SpaceCharFilter filter;
public InputReader(InputStream stream) {
this.stream = stream;
}
public int read() {
if (numChars == -1)
throw new InputMismatchException();
if (curChar >= numChars) {
curChar = 0;
try {
numChars = stream.read(buf);
} catch (IOException e) {
throw new InputMismatchException();
}
if (numChars <= 0)
return -1;
}
return buf[curChar++];
}
public int readInt() {
int c = read();
while (isSpaceChar(c))
c = read();
int sgn = 1;
if (c == '-') {
sgn = -1;
c = read();
}
int res = 0;
do {
if (c < '0' || c > '9')
throw new InputMismatchException();
res *= 10;
res += c - '0';
c = read();
} while (!isSpaceChar(c));
return res * sgn;
}
public String readString() {
int c = read();
while (isSpaceChar(c))
c = read();
StringBuilder res = new StringBuilder();
do {
res.appendCodePoint(c);
c = read();
} while (!isSpaceChar(c));
return res.toString();
}
void readCharArray(char[] ar, int len) {
for(int i=0; i<len; i++)
ar[i] = (char) read();
}
public boolean isSpaceChar(int c) {
if (filter != null)
return filter.isSpaceChar(c);
return c == ' ' || c == '\n' || 
c == '\r' || c == '\t' || c == -1;
}
public String next() {
return readString();
}
public interface SpaceCharFilter {
public boolean isSpaceChar(int ch);
}
}
static class OutputWriter {
private final PrintWriter writer;
public OutputWriter(OutputStream outputStream) {
writer = new PrintWriter(
    new BufferedWriter(
        new OutputStreamWriter(outputStream)));
}
public OutputWriter(Writer writer) {
this.writer = new PrintWriter(writer);
}
public void print(Object...objects) {
for (int i = 0; i < objects.length; i++) {
writer.print(objects[i]);
}
}
public void printLine(Object...objects) {
print(objects);
writer.println();
}
public void close() {
writer.close();
}
public void flush() {
writer.flush();
}
}
static class IOUtils {
public static int[] readIntArray(InputReader in,
 int size) {
int[] array = new int[size];
for (int i = 0; i < size; i++)
array[i] = in.readInt();
return array;
}
}
static final int MAX_CHARS = 'k'; 
static int LEN;
static char[] str;
static long[] mask;
static int[] lcp;
static HashMap<Long, ArrayList<Integer> > prefix_match;
public static void main(String[] args) {
OutputWriter writer = null;
try{
writer = new OutputWriter(System.out);
InputReader ri = new InputReader(System.in);
LEN = ri.readInt();
int q = ri.readInt();
str = new char[LEN];
ri.readCharArray(str, LEN);
prefix_match = new HashMap<>();
countPrefixMask();
createIsomorphicLCP();
int l;
int r;
int count;
for(int i=0; i<q; i++){
l = ri.readInt()-1;
r = ri.readInt();
count = countIsomorphic(l, r);
writer.print(Integer.toString(count), '\n');
}
}catch(Exception ex){
} finally{
if(writer!=null){
writer.close();
}
}
}
static int countIsomorphic(int pb, int pe){
if(pe-pb>=MASK_LEN)
return countIsomorphicShort(pb, pe); 
else
return countIsomorphicLong(pb, pe); 
}
static int countIsomorphicShort(int pb, int pe){
ArrayList<Integer> node = prefix_match.get(mask[pb]);
int m = pe-pb;
int count = 1; 
int last = LEN-m;
int j;
for(Integer ind : node){
j = ind; 
if(j==pb){ 
continue;
}
if(j>last)
break; 
if(countIsomorphicLength(j, pb, pe)==m){
count++;
}
}
return count;        
}
static int countIsomorphicLong(int pb, int pe){
int m = pe-pb;
int count = 1; 
boolean match = false;
int last = LEN-m;
for(int j=0; j<=last; j++){
if(j==pb){ 
continue;
}
if(match){ 
if(lcp[j-1]>=m){
count++;
continue;
}
}
if(!testMask(mask[pb], j, m)){
match = false;
continue;
}else if(m<=MASK_LEN){
count++;
continue;
}
if(countIsomorphicLength(j, pb, pe)==m){
count++;
match = true;
}else{
match = false;
}
}
return count;
}
static void createIsomorphicLCP(){
lcp = new int[LEN];
for(int i=0; i<LEN-1; i++){ 
lcp[i] = countIsomorphicLength(i, i+1, LEN);
while(lcp[i]>1){
lcp[i+1] = lcp[i++]-1;
}
}
}
static final int MASK_LEN = 16;
static final int MASK_SHIFT = 2; 
static void countPrefixMask(){
mask = new long[LEN]; 
long[] charmap = new long[MAX_CHARS];
long current; 
char ch;
long cur_mask;
for(int i=0; i<LEN; i++){ 
Arrays.fill(charmap, 0L);
current = 0L;
cur_mask = 0L; 
for(int j=0; j<MASK_LEN && j+i<LEN; j++){ 
ch=str[i+j];
if(charmap[ch]==0L){
charmap[ch] = ++current;
}
cur_mask |= charmap[ch]<<(j<<MASK_SHIFT);
}
mask[i] = cur_mask;
if(LEN-i>=MASK_LEN){
ArrayList<Integer> node = prefix_match.get(cur_mask);
if(node==null){
node = new ArrayList<>();
prefix_match.put(cur_mask, node);
}
node.add(i);
}
}
}
static long filter;
static boolean testMask(long target, int index, int len){
if(MASK_LEN<=len){
return target == mask[index];
}
filter = -1L>>>( (MASK_LEN-len)<<MASK_SHIFT );
return (target & filter) == (mask[index] & filter );
}
static long countcalls = 0; 
static boolean[] mapped = new boolean[MAX_CHARS];
static char[] map = new char[MAX_CHARS];
static int countIsomorphicLength(int start, 
int pb, int pe){
countcalls++;
char c;
char p;
int comp_len = pe-pb;
Arrays.fill(mapped, false);
Arrays.fill(map, '\0');
for(int i=0; i<comp_len; i++){
c = str[start+i];
p = str[pb+i];
if(map[c]=='\0'){
if(mapped[p])
return i;
mapped[p] = true;
map[c] = p;
}else{
if(map[c]!=p)
return i;
}
}
return comp_len;
}
}
