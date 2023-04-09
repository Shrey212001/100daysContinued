/*

Topic:- Mark and Toys

Link:- https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true

Problem:-

Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money. Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.

Function Description

Complete the function maximumToys in the editor below.

maximumToys has the following parameter(s):

int prices[n]: the toy prices
int k: Mark's budget

Returns

int: the maximum number of toys
Input Format

The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
The next line contains  space-separated integers




Solution:-
*/
import java.io.*;
import java.util.*;

public class Solution{		
		
		private BufferedReader in;	
		private StringTokenizer st;
		private PrintWriter out;
		
		
		
		
		void solve() throws IOException{
			
		
			int n = nextInt();
			int k = nextInt();
			int []x = new int[n];
			for (int i = 0; i < x.length; i++) {
				x[i] = nextInt();
			}
			Arrays.sort(x);
			long sum = 0;
			int ans = 0;
			for (int i = 0; i < x.length; i++) {
				sum += x[i];
				if(sum <= k){
					ans++;
				}
				else
					break;
			}
			out.println(ans);
					
		}
			

		Solution() throws IOException {
			in = new BufferedReader(new InputStreamReader(System.in));	
			out = new PrintWriter(System.out);
			eat("");
			solve();	
			out.close();
		}

		private void eat(String str) {
			st = new StringTokenizer(str);
		}

		String next() throws IOException {
			while (!st.hasMoreTokens()) {
				String line = in.readLine();				
				if (line == null) {					
					return null;
				}
				eat(line);
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public static void main(String[] args) throws IOException {
			new Solution();
		}

		int gcd(int a,int b){
			if(b>a) return gcd(b,a);
			if(b==0) return a;
			return gcd(b,a%b);
		}

}
