/*

Topic:- Determining DNA Health

Link:- https://www.hackerrank.com/challenges/determining-dna-health/problem?isFullScreen=true

Problem:-

DNA is a nucleic acid present in the bodies of living things. Each piece of DNA contains a number of genes, some of which are beneficial and increase the DNA's total health. Each gene has a health value, and the total health of a DNA is the sum of the health values of all the beneficial genes that occur as a substring in the DNA. We represent genes and DNA as non-empty strings of lowercase English alphabetic letters, and the same gene may appear multiple times as a susbtring of a DNA.

Given the following:

An array of beneficial gene strings, . Note that these gene sequences are not guaranteed to be distinct.
An array of gene health values, , where each  is the health value for gene .
A set of  DNA strands where the definition of each strand has three components, , , and , where string  is a DNA for which genes  are healthy.
Find and print the respective total healths of the unhealthiest (minimum total health) and healthiest (maximum total health) strands of DNA as two space-separated values on a single line.

Input Format

The first line contains an integer, , denoting the total number of genes.
The second line contains  space-separated strings describing the respective values of  (i.e., the elements of ).
The third line contains  space-separated integers describing the respective values of  (i.e., the elements of ).
The fourth line contains an integer, , denoting the number of strands of DNA to process.
Each of the  subsequent lines describes a DNA strand in the form start end d, denoting that the healthy genes for DNA strand  are  and their respective correlated health values are .


Output Format

Print two space-separated integers describing the respective total health of the unhealthiest and the healthiest strands of DNA.




Solution:-
*/

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Queue;

public class C3 {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		char[][] ss = new char[n][];
		for(int i = 0;i < n;i++){
			ss[i] = ns().toCharArray();
		}
		int[] h = na(n);
		
		int Q = ni();
		char[][] qs = new char[Q][];
		long[] es = new long[2*Q];
		for(int i = 0;i < Q;i++){
			int s = ni(), t = ni();
			qs[i] = ns().toCharArray();
			es[i] = (long)s<<32|(long)i<<1|0;
			es[i+Q] = (long)t+1<<32|(long)i<<1|1;
		}
		Arrays.sort(es);
		long[] rets = new long[Q];
		TrieByLink[] tries = new TrieByLink[18];
		int p = 0;
		for(long e : es){
			long x = e>>>32;
			int ind = ((int)e)>>>1;
			int pm = (e&1) == 0 ? -1 : 1;
			while(p < n && p <= x-1){
				int d = Integer.numberOfTrailingZeros(p+1);
				tries[d] = new TrieByLink();
				for(int k = p-(1<<d)+1;k <= p;k++){
					tries[d].add(ss[k], h[k]);
				}
				tries[d].buildFailure();
				p++;
			}
			long lhit = 0;
			for(int d = 0;d < 18;d++){
				if(p<<~d<0){
					lhit += tries[d].countHit(qs[ind]);
				}
			}
			rets[ind] += lhit*pm;
		}
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for(long r : rets)min = Math.min(min, r);
		for(long r : rets)max = Math.max(max, r);
		
		out.println(min + " " + max);
	}
	
	public static class TrieByLink {
		public Node root = new Node((char)0, 0);
		public int gen = 1;
		public static final char[] atoz = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		public static class Node
		{
			public int id;
			public char c;
			public Node next, firstChild;
			public long hit = 0;
			
			public Node fail;
			
			public Node(char c, int id)
			{
				this.id = id;
				this.c = c;
			}
			
			public String toString(String indent)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(indent + id + ":" + c);
				if(hit != 0)sb.append(" H:" + hit);
				if(fail != null)sb.append(" F:" + fail.id);
				sb.append("\n");
				for(Node c = firstChild;c != null; c = c.next){
					sb.append(c.toString(indent + "  "));
				}
				return sb.toString();
			}
		}
		
		public void add(char[] s, long hit)
		{
			Node cur = root;
			Node pre = null;
			for(char c : s){
				pre = cur; cur = cur.firstChild;
				if(cur == null){
					cur = pre.firstChild = new Node(c, gen++);
				}else{
					for(;cur != null && cur.c != c;pre = cur, cur = cur.next);
					if(cur == null)cur = pre.next = new Node(c, gen++);
				}
			}
			cur.hit += hit;
		}
		
		public void buildFailure()
		{
			root.fail = null;
			Queue<Node> q = new ArrayDeque<Node>();
			q.add(root);
			while(!q.isEmpty()){
				Node cur = q.poll();
				inner:
				for(Node ch = cur.firstChild;ch != null; ch = ch.next){
					q.add(ch);
					for(Node to = cur.fail; to != null; to = to.fail){
						for(Node lch = to.firstChild;lch != null; lch = lch.next){
							if(lch.c == ch.c){
								ch.fail = lch;
								ch.hit += lch.hit; // propagation of hit
								continue inner;
							}
						}
					}
					ch.fail = root;
				}
			}
		}
		
		public Node next(Node cur, char c)
		{
			for(;cur != null;cur = cur.fail){
				for(Node ch = cur.firstChild;ch != null; ch = ch.next){
					if(ch.c == c)return ch;
				}
			}
			return root;
		}
		
		public int[][] ngMatrix(char[] cs)
		{
			int[] map = new int[128];
			Arrays.fill(map, -1);
			for(int i = 0;i < cs.length;i++)map[cs[i]] = i;
			
			int[][] a = new int[gen+1][gen+1];
			Node[] nodes = toArray();
			for(int i = 0;i < gen;i++){
				if(nodes[i].hit > 0)continue;
				int nohit = cs.length;
				boolean[] ved = new boolean[cs.length];
				for(Node cur = nodes[i];cur != null;cur = cur.fail){
					for(Node ch = cur.firstChild;ch != null; ch = ch.next){
						if(map[ch.c] >= 0 && !ved[map[ch.c]]){
							ved[map[ch.c]] = true;
							if(ch.hit == 0)a[ch.id][i]++;
							nohit--;
						}
					}
				}
				a[0][i] += nohit;
			}
			Arrays.fill(a[gen], 1);
			return a;
		}
		
		public int[][] okMatrix(char[] cs)
		{
			int[] map = new int[128];
			Arrays.fill(map, -1);
			for(int i = 0;i < cs.length;i++)map[cs[i]] = i;
			
			int[][] a = new int[gen+1][gen+1];
			Node[] nodes = toArray();
			for(int i = 0;i < gen;i++){
				if(nodes[i].hit > 0)continue;
				int nohit = cs.length;
				boolean[] ved = new boolean[cs.length];
				for(Node cur = nodes[i];cur != null;cur = cur.fail){
					for(Node ch = cur.firstChild;ch != null; ch = ch.next){
						if(map[ch.c] >= 0 && !ved[map[ch.c]]){
							ved[map[ch.c]] = true;
							if(ch.hit > 0){
								a[gen][i]++;
							}else{
								a[ch.id][i]++;
							}
							nohit--;
						}
					}
				}
				a[0][i] += nohit;
			}
			a[gen][gen]++;
			return a;
		}
		
		public void search(char[] q)
		{
			Node cur = root;
			outer:
			for(char c : q){
				for(;cur != null;cur = cur.fail){
					for(Node ch = cur.firstChild;ch != null; ch = ch.next){
						if(ch.c == c){
							// ch.hit
							cur = ch;
							continue outer;
						}
					}
				}
				cur = root;
			}
		}
		
		public long countHit(char[] q)
		{
			Node cur = root;
			long hit = 0;
			outer:
			for(char c : q){
				for(;cur != null;cur = cur.fail){
					for(Node ch = cur.firstChild;ch != null; ch = ch.next){
						if(ch.c == c){
							hit += ch.hit; // add hit
							cur = ch;
							continue outer;
						}
					}
				}
				cur = root;
			}
			return hit;
		}
		
		public Node[] toArray()
		{
			Node[] ret = new Node[gen];
			ret[0] = root;
			for(int i = 0;i < gen;i++){
				Node cur = ret[i];
				if(cur.next != null)ret[cur.next.id] = cur.next;
				if(cur.firstChild != null)ret[cur.firstChild.id] = cur.firstChild;
			}
			return ret;
		}
		
		public String toString()
		{
			return root.toString("");
		}
	}
	
	void run() throws Exception
	{
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new C3().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
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
	
	private long nl()
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
	
	private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}
