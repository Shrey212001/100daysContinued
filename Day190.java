/*

Topic:- Permuting Two Arrays

Link:- https://www.hackerrank.com/challenges/two-arrays/problem?isFullScreen=true

Problem:-

There are two -element arrays of integers,  and . Permute them into some  and  such that the relation  holds for all  where .

There will be  queries consisting of , , and . For each query, return YES if some permutation ,  satisfying the relation exists. Otherwise, return NO.

A valid  is  and :  and . Return YES.

Function Description

Complete the twoArrays function in the editor below. It should return a string, either YES or NO.

twoArrays has the following parameter(s):

int k: an integer
int A[n]: an array of integers
int B[n]: an array of integers
Returns
- string: either YES or NO

Input Format

The first line contains an integer , the number of queries.

The next  sets of  lines are as follows:

The first line contains two space-separated integers  and , the size of both arrays  and , and the relation variable.
The second line contains  space-separated integers .
The third line contains  space-separated integers .




Solution:-
*/
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.util.Arrays.*;

public class Solution {
	private static final int mod = (int)1e9+7;
	
	final Random random = new Random(1);
	final IOFast io = new IOFast();
	
	public void run() throws IOException {
		int T = io.nextInt();
		LOOP: while(T-- != 0) {
			int n = io.nextInt();
			int k = io.nextInt();
			int[] A = new int[n];
			int[] B = new int[n];
			for(int i = 0; i < A.length; i++) {
				A[i] = io.nextInt();
			}
			for(int i = 0; i < A.length; i++) {
				B[i] = io.nextInt();
			}
			sort(A);
			sort(B);
			for(int i = 0; i < A.length; i++) {
				if(A[i] + B[n-1-i] < k) {
					io.out.println("NO");
					continue LOOP;
				}
			}
			io.out.println("YES");
		}
	}
	
	void main() throws IOException {
		//		IOFast.setFileIO("rle-size.in", "rle-size.out");
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
			in = new BufferedReader(new FileReader(ins));
			out = new PrintWriter(new FileWriter(outs));
		}

		//		private static final int BUFFER_SIZE = 50 * 200000;
		private static int pos, readLen;
		private static final char[] buffer = new char[1024 * 8];
		private static final char[] str = new char[500000*8*2];
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
		
		int reads(char[] cs, int len, boolean[] accept) throws IOException {
			try {
				while(true) {
					final int c = read();
					if(accept[c]) { break; }
					str[len++] = (char)c;
				}
			}
			catch(EndOfFileRuntimeException e) { ; }
			
			return len;
		}

		public char[] nextLine() throws IOException {
			int len = 0;
			str[len++] = nextChar();
			len = reads(str, len, isLineSep);
			
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
			len = reads(str, len, isSpace);
			return Arrays.copyOf(str, len);
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(nextString());
		}

	}

}
