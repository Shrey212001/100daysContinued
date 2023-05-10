/*

Topic:- Count Luck

Link:- https://www.hackerrank.com/challenges/count-luck/problem?isFullScreen=true

Problem:-

Ron and Hermione are deep in the Forbidden Forest collecting potion ingredients, and they've managed to lose their way. The path out of the forest is blocked, so they must make their way to a portkey that will transport them back to Hogwarts.

Consider the forest as an  grid. Each cell is either empty (represented by .) or blocked by a tree (represented by ). Ron and Hermione can move (together inside a single cell) LEFT, RIGHT, UP, and DOWN through empty cells, but they cannot travel through a tree cell. Their starting cell is marked with the character , and the cell with the portkey is marked with a . The upper-left corner is indexed as .

.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
In example above, Ron and Hermione are located at index  and the portkey is at . Each cell is indexed according to Matrix Conventions.

Hermione decides it's time to find the portkey and leave. They start along the path and each time they have to choose a direction, she waves her wand and it points to the correct direction. Ron is betting that she will have to wave her wand exactly  times. Can you determine if Ron's guesses are correct?

The map from above has been redrawn with the path indicated as a series where  is the starting point (no decision in this case),  indicates a decision point and  is just a step on the path:

.X.X.10000X
.X*0X0XXX0X
.XX0X0XM01.
...100XXXX.
There are three instances marked with  where Hermione must use her wand.

Note: It is guaranteed that there is only one path from the starting location to the portkey.

Function Description

Complete the countLuck function in the editor below. It should return a string, either  if Ron is correct or  if he is not.

countLuck has the following parameters:

matrix: a list of strings, each one represents a row of the matrix
k: an integer that represents Ron's guess
Input Format

The first line contains an integer , the number of test cases.

Each test case is described as follows:
The first line contains  space-separated integers  and , the number of forest matrix rows and columns.
Each of the next  lines contains a string of length  describing a row of the forest matrix.
The last line contains an integer , Ron's guess as to how many times Hermione will wave her wand.

Constraints

There will be exactly one  and one  in the forest.
Exactly one path exists between  and .
Output Format

On a new line for each test case, print  if Ron impresses Hermione by guessing correctly. Otherwise, print .Oops!.




Solution :-
*/
import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.*;

public class Solution {
    private static final int mod = (int)1e9+7;

    final Random random = new Random(0);
    final IOFast io = new IOFast();
  int w, h;
    char[][] cs;
    int[] dx = new int[] { 1, 0, -1, 0, };
    int[] dy = new int[] { 0, -1, 0, 1, };
    int dfs(int v, int p) {
        if(cs[v/w][v%w] == '*') return 0;
        int ret = -1;
        int move = 0;
        for(int i = 0; i < 4; i++) {
            final int y = v / w + dy[i];
            final int x = v % w + dx[i];
            if(x < 0 || y < 0 || x >= w || y >= h || cs[y][x] == 'X' || y*w+x == p) continue;
            move++;
            ret = Math.max(ret, dfs(y*w+x, v));
        }
        if(ret == -1) return -1;
        return ret + (move>1?1:0);
    }
    public void run() throws IOException {
        int TEST_CASE = Integer.parseInt(new String(io.nextLine()).trim());
        while(TEST_CASE-- != 0) {
            h = io.nextInt();
            w = io.nextInt();
            cs = new char[h][];
            int cur = -1;
            for(int i = 0; i < h; i++) {
                cs[i] = io.next();
                for(int j = 0; j < w; j++) {
                    if(cs[i][j] == 'M') cur = i*w+j;
                }
            }
            int K = io.nextInt();
            
            io.out.println(K == dfs(cur, -1) ? "Impressed" : "Oops!");
        }
    }
    
    static int gcd(int n, int r) { return r == 0 ? n : gcd(r, n%r); }
    static long gcd(long n, long r) { return r == 0 ? n : gcd(r, n%r); }
    
    static <T> void swap(T[] x, int i, int j) {
        T t = x[i];
        x[i] = x[j];
        x[j] = t;
    }
    
    static void swap(int[] x, int i, int j) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }
    

    static void radixSort(int[] xs) {
        int[] cnt = new int[(1<<16)+1];
        int[] ys = new int[xs.length];
        
        for(int j = 0; j <= 16; j += 16) {
            Arrays.fill(cnt, 0);
            for(int x : xs) { cnt[(x>>j&0xFFFF)+1]++; }
            for(int i = 1; i < cnt.length; i++) { cnt[i] += cnt[i-1]; }
            for(int x : xs) { ys[cnt[x>>j&0xFFFF]++] = x; }
            { final int[] t = xs; xs = ys; ys = t; }
        }
    }
    
    static void radixSort(long[] xs) {
        int[] cnt = new int[(1<<16)+1];
        long[] ys = new long[xs.length];
        
        for(int j = 0; j <= 48; j += 16) {
            Arrays.fill(cnt, 0);
            for(long x : xs) { cnt[(int)(x>>j&0xFFFF)+1]++; }
            for(int i = 1; i < cnt.length; i++) { cnt[i] += cnt[i-1]; }
            for(long x : xs) { ys[cnt[(int)(x>>j&0xFFFF)]++] = x; }
            { final long[] t = xs; xs = ys; ys = t; }
        }
    }
    

    static void arrayIntSort(int[][] x, int... keys) {
        Arrays.sort(x, new ArrayIntsComparator(keys));
    }
    
    static class ArrayIntsComparator implements Comparator<int[]> {
        final int[] KEY;
        
        public ArrayIntsComparator(int... key) {
            KEY = key;
        }
        
        @Override
        public int compare(int[] o1, int[] o2) {
            for(int k : KEY) if(o1[k] != o2[k]) return o1[k] - o2[k];
            return 0;
        }
    }
    
    static class ArrayIntComparator implements Comparator<int[]> {
        final int KEY;
        
        public ArrayIntComparator(int key) {
            KEY = key;
        }
        
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[KEY] - o2[KEY];
        }
    }
    
    
    void main() throws IOException {
      
        try {
            run();
        }
        catch (EndOfFileRuntimeException e) { }
        io.out.flush();
    }

    public static void main(String[] args) throws IOException {
        new Solution().main();
    }
    
    static class EndOfFileRuntimeException extends RuntimeException {
        private static final long serialVersionUID = -8565341110209207657L; }

    static
    public class IOFast {
        private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        private PrintWriter out = new PrintWriter(System.out);

        void setFileIO(String ins, String outs) throws IOException {
            out.flush();
            out.close();
            in.close();
            in = new BufferedReader(new FileReader(ins));
            out = new PrintWriter(new FileWriter(outs));
            System.err.println("reading from " + ins);
        }

      
        private static int pos, readLen;
        private static final char[] buffer = new char[1024 * 8];
        private static char[] str = new char[500*8*2];
        private static boolean[] isDigit = new boolean[256];
        private static boolean[] isSpace = new boolean[256];
        private static boolean[] isLineSep = new boolean[256];

        static {
            for(int i = 0; i < 10; i++) { isDigit['0' + i] = true; }
            isDigit['-'] = true;
            isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
            isLineSep['\r'] = isLineSep['\n'] = true;
        }

        public int read() throws IOException {
            if(pos >= readLen) {
                pos = 0;
                readLen = in.read(buffer);
                if(readLen <= 0) { throw new EndOfFileRuntimeException(); }
            }
            return buffer[pos++];
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }

        public char nextChar() throws IOException {
            while(true) {
                final int c = read();
                if(!isSpace[c]) { return (char)c; }
            }
        }
        
        int reads(int len, boolean[] accept) throws IOException {
            try {
                while(true) {
                    final int c = read();
                    if(accept[c]) { break; }
                    
                    if(str.length == len) {
                        char[] rep = new char[str.length * 3 / 2];
                        System.arraycopy(str, 0, rep, 0, str.length);
                        str = rep;
                    }
                    
                    str[len++] = (char)c;
                }
            }
            catch(EndOfFileRuntimeException e) { ; }
            
            return len;
        }
        
        int reads(char[] cs, int len, boolean[] accept) throws IOException {
            try {
                while(true) {
                    final int c = read();
                    if(accept[c]) { break; }
                    cs[len++] = (char)c;
                }
            }
            catch(EndOfFileRuntimeException e) { ; }
            
            return len;
        }

        public char[] nextLine() throws IOException {
            int len = 0;
            str[len++] = nextChar();
            len = reads(len, isLineSep);
            
            try {
                if(str[len-1] == '\r') { len--; read(); }
            }
            catch(EndOfFileRuntimeException e) { ; }
            
            return Arrays.copyOf(str, len);
        }

        public String nextString() throws IOException {
            return new String(next());
        }

        public char[] next() throws IOException {
            int len = 0;
            str[len++] = nextChar();
            len = reads(len, isSpace);
            return Arrays.copyOf(str, len);
        }

        public int next(char[] cs) throws IOException {
            int len = 0;
            cs[len++] = nextChar();
            len = reads(cs, len, isSpace);
            return len;
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextString());
        }

        public long[] nextLongArray(final int n) throws IOException {
            final long[] res = new long[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public int[] nextIntArray(final int n) throws IOException {
            final int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        public int[][] nextIntArray2D(final int n, final int k) throws IOException {
            final int[][] res = new int[n][];
            for(int i = 0; i < n; i++) {
                res[i] = nextIntArray(k);
            }
            return res;
        }

        public int[][] nextIntArray2DWithIndex(final int n, final int k) throws IOException {
            final int[][] res = new int[n][k+1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < k; j++) {
                    res[i][j] = nextInt();
                }
                res[i][k] = i;
            }
            return res;
        }

        public double[] nextDoubleArray(final int n) throws IOException {
            final double[] res = new double[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

    }

}
