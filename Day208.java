/*

Topic:- Maximum Palindromes

Link:- https://www.hackerrank.com/challenges/maximum-palindromes/problem?isFullScreen=true

Problem:-

Madam Hannah Otto, the CEO of Reviver Corp., is fond of palindromes, or words that read the same forwards or backwards. She thinks palindromic brand names are appealing to millennials.

As part of the marketing campaign for the company's new juicer called the Rotator™, Hannah decided to push the marketing team's palindrome-searching skills to a new level with a new challenge.

In this challenge, Hannah provides a string  consisting of lowercase English letters. Every day, for  days, she would select two integers  and , take the substring  (the substring of  from index  to index ), and ask the following question:

Consider all the palindromes that can be constructed from some of the letters from . You can reorder the letters as you need. Some of these palindromes have the maximum length among all these palindromes. How many maximum-length palindromes are there?

Input Format

The first line contains the string .

The second line contains a single integer .

The  of the next  lines contains two space-separated integers ,  denoting the  and  values Anna selected on the 


Output Format

For each query, print a single line containing a single integer denoting the answer.




Solution:-
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Maximum_Palindromes {
    static long fac[] = new long[(int)1e5+50], mod = (int)1e9+7;
    public static void main(String[] args)throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        fac[0] = 1;
        for(int i = 1; i <= 1_00_000; i++){
            fac[i] = (fac[i-1]*(long)i) % mod;
        }

        char [] s = (" "+in.next()).toCharArray();
        int n = s.length;
        N = (int)Math.sqrt(n);
        int q = in.nextInt();
        Node [] pair = new Node[q];

        for(int i = 0; i < q; i++){
            pair[i] = new Node(in.nextInt(), in.nextInt(), i);
        }
        Arrays.sort(pair);

        long [] ans = new long[q];
        int count[] = new int[26];

        int l = 1, r = 0, res = 0, x = 0;

        for(int i = 0; i < q; i++){
            while( r < pair[i].v){
                r++;x = s[r] - 'a';
                count[x]++;
            }

            while( r > pair[i].v){
                x = s[r] - 'a';
                count[x]--;
                r--;
            }


            while( l > pair[i].u){
                l--;x = s[l] - 'a';
                count[x]++;
            }

            while( l < pair[i].u) {
                x = s[l] - 'a';
                count[x]--;
                l++;
            }
      ans[pair[i].idx] = getRes(count) % mod;
        }

        for(long i: ans) pw.println(i);

        pw.close();
    }

    static long getRes(int [] count){
        int max = 0, cnt = 0;
        int length = 0;
        long mult = 1;
        for(int k : count){
            if(k % 2 == 1){
                cnt++;
            }
            length += k/2;
            mult = (mult * fac[k/2]) % mod;
        }
        for(int k : count){
            if(max > 0 && max == k) cnt++;
        }
        if(cnt == 0) cnt = 1;

        long inv = modInverse(mult, mod);
          return safeMultiply(fac[length], inv, cnt);
    }

    static long safeMultiply(long a, long b, long c){
        return ((BigInteger.valueOf(a).multiply(BigInteger.valueOf(b).multiply(BigInteger.valueOf(c)))).mod(BigInteger.valueOf(mod))).longValue();
    }

    public static long mod(long a, long m) {
        long A = (a % m);
        return A >= 0 ? A : A + m;
    }

    public static long modInverse(long a, long m) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(m)).longValue();
    }

    static int N;
    static class Node implements Comparable<Node>{
        public int u, v, idx;
        public Node(int uu, int vv, int i){
            u = uu; v = vv; idx = i;
        }
        public int compareTo(Node n){
            if(u/N != n.u/N) return u - n.u;
            else return v - n.v;
        }
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is){
            for(int i='0';i<='9';i++) ints[i]=i-'0';
            this.is = is;
        }

        public int readByte(){
            if(lenbuf == -1)throw new InputMismatchException();
            if(ptrbuf >= lenbuf){
                ptrbuf = 0;
                try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
                if(lenbuf <= 0)return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() {
            int b;
            while((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next(){
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt(){
            int num = 0, b;
            boolean minus = false;
            while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if(b == '-'){
                minus = true;
                b = readByte();
            }

            while(true){
                if(b >= '0' && b <= '9'){
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
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
                    num = (num<<3) + (num<<1) + ints[b];
                }else{
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public char[] next(int n){
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while(p < n && !(isSpaceChar(b))){
                buf[p++] = (char)b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

     
    }
}
