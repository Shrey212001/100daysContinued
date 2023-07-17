/*

Topic:-Candles Counting

Link:- https://www.hackerrank.com/challenges/candles-2/problem?isFullScreen=true

Problem:-

Tim is visiting his grandma for two days and is bored due to the lack of the electricity over there. That's why he starts to play with grandma's colorful candle collection.

He aligned the N candles from left to right. The ith candle from the left has the height Hi and the color Ci, an integer ranged from 1 to a given K, the number of colors.

Now he stares at the sequence of candles and wonders, how many strictly increasing ( in height ) colorful subsequences are there? A subsequence is considered as colorful if every of the K colors appears at least one times in the subsequence.

As the number of subsequences fulfilling the requirement can be large, print the result modulo 10^9+7.

Input Format

On the first line you will be given N and K, then N lines will follow. On the ith line you will be given two integers Hi and Ci.

Constraints
1 <= N <= 5.10^4
1 <= Ci <= K <= 7
1 <= Hi <= 5.10^4

Output Format

Print the number of strictly increasing colorful subsequences modulo 10^9+7.




Solution:-
*/
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class C2 {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		int n = ni(), K = ni();
		int[] h = new int[n];
		int[] c = new int[n];
		for(int i = 0;i < n;i++){
			h[i] = ni();
			c[i] = ni()-1;
		}
		int[][] fts = new int[1<<K][];
		for(int i = 0;i < 1<<K;i++){
			fts[i] = new int[50002];
		}
		addFenwick(fts[0], 0, 1);
		for(int i = 0;i < n;i++){
			for(int j = (1<<K)-1;j >= 0;j--){
				int sum = sumFenwick(fts[j], h[i]-1);
				addFenwick(fts[j|1<<c[i]], h[i], sum);
			}
		}
		out.println(sumFenwick(fts[(1<<K)-1], 50000));
	}
	
	static int mod = 1000000007;
	
	public static int sumFenwick(int[] ft, int i)
	{
		int sum = 0;
		for(i++;i > 0;i -= i&-i){
			sum += ft[i];
			if(sum >= mod)sum -= mod;
		}
		return sum;
	}
	
	public static void addFenwick(int[] ft, int i, int v)
	{
		if(v == 0 || i < 0)return;
		int n = ft.length;
		for(i++;i < n;i += i&-i){
			ft[i] += v;
			if(ft[i] >= mod)ft[i] -= mod;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
                INPUT.getBytes());
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
		while(lptr < lenbuf)
                if(!isSpaceChar(inbuf[lptr++]))return false;
		
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
			try { lenbuf = is.read(inbuf); } catch (IOException e) 
                       { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private static boolean isSpaceChar(int c) { 
         return !(c >= 33 && c <= 126); }
	private static int skip() { 
        int b; while((b = readByte()) != -1 && isSpaceChar(b)); 
        return b; }
	
	private static double nd() { 
        return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }
	
	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b)))
                { // when nextLine, (isSpaceChar(b) && b != ' ')
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
	
	private static void tr(Object... o) 
        { if(INPUT.length() != 0)
         System.out.println(Arrays.deepToString(o)); }
}
