/*

Topic:- Cut the Tree

Link:- https://www.hackerrank.com/challenges/cut-the-tree/problem?isFullScreen=true

Problem:-

There is an undirected tree where each vertex is numbered from 1 to n, and each contains a data value. The sum of a tree is the sum of all its nodes' data values. If an edge is cut, two smaller trees are formed. The difference between two trees is the absolute value of the difference in their sums.

Given a tree, determine which edge to cut so that the resulting trees have a minimal difference between them, then return that difference.

The minimum absolute difference is .

Note: The given tree is always rooted at vertex .

Function Description

Complete the cutTheTree function in the editor below.

cutTheTree has the following parameter(s):

int data[n]: an array of integers that represent node values
int edges[n-1][2]: an 2 dimensional array of integer pairs where each pair represents nodes connected by the edge
Returns

int: the minimum achievable absolute difference of tree sums
Input Format

The first line contains an integer , the number of vertices in the tree.
The second line contains  space-separated integers, where each integer  denotes the  data value, .
Each of the  subsequent lines contains two space-separated integers  and  that describe edge  in tree .




Solution:-
*/
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";
    
    static void solve()
    {
        int n = ni();
        int[] a = na(n);
        int[] from = new int[n-1];
        int[] to = new int[n-1];
        for(int i = 0;i < n-1;i++){
            from[i] = ni()-1;
            to[i] = ni()-1;
        }
        int[][] g = packU(n, from, to);
        int[][] pars = parents3(g, 0);
        int[] par = pars[0], ord = pars[1];
        int[] dp = new int[n];
        for(int i = n-1;i >= 0;i--){
            int cur = ord[i];
            dp[cur] = a[cur];
            for(int e : g[cur]){
                if(par[cur] != e){
                    dp[cur] += dp[e];
                }
            }
        }
        
        int ret = 999999999;
        for(int i = 1;i < n;i++){
            ret = Math.min(ret, Math.abs(dp[i]-(dp[0]-dp[i])));
        }
        out.println(ret);
    }
    
    public static int[][] parents3(int[][] g, int root) {
        int n = g.length;
        int[] par = new int[n];
        Arrays.fill(par, -1);

        int[] depth = new int[n];
        depth[0] = 0;

        int[] q = new int[n];
        q[0] = root;
        for(int p = 0, r = 1;p < r;p++){
            int cur = q[p];
            for(int nex : g[cur]){
                if(par[cur] != nex){
                    q[r++] = nex;
                    par[nex] = cur;
                    depth[nex] = depth[cur] + 1;
                }
            }
        }
        return new int[][] { par, q, depth };
    }
    
    static int[][] packU(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for(int f : from)
            p[f]++;
        for(int t : to)
            p[t]++;
        for(int i = 0;i < n;i++)
            g[i] = new int[p[i]];
        for(int i = 0;i < from.length;i++){
            g[from[i]][--p[from[i]]] = to[i];
            g[to[i]][--p[to[i]]] = from[i];
        }
        return g;
    }
    
    public static void main(String[] args) throws Exception
    {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        
        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G-S+"ms");
    }
    
    private static boolean eof()
    {
        if(lenbuf == -1)return true;
        int lptr = ptrbuf;
        while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;
        
        try {
            is.mark(1000);
            while(true){
                int b = is.read();
                if(b == -1){
                    is.reset();
                    return true;
                }else if(!isSpaceChar(b)){
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }
    
    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;
    
    private static int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    
    private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    
    private static double nd() { return Double.parseDouble(ns()); }
    private static char nc() { return (char)skip(); }
    
    private static String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private static char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private static char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    
    private static int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    
    private static int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private static long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
