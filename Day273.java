/*

Topic:- Nikita and the Game

Link:- https://www.hackerrank.com/challenges/array-splitting/problem?isFullScreen=true

Problem:-

Nikita just came up with a new array game. The rules are as follows:

Initially, Nikita has an array of integers.

In each move, Nikita must partition the array into 2 non-empty contiguous parts such that the sum of the elements in the left partition is equal to the sum of the elements in the right partition. If Nikita can make such a move, she gets 1 point; otherwise, the game ends.

After each successful move, Nikita discards either the left partition or the right partition and continues playing by using the remaining partition as array arr.

Nikita loves this game and wants your help getting the best score possible. Given arr, can you find and print the maximum number of points she can score?

For example, Nikita starts with the array arr = [1,2,3,6]. She first splits it into a1 = [1,2,3] and a2 = [6], then discards a2. arr = a1->a1 = [1,2], a2 = [3]. Discard a2 leaving arr = [1,2]. This cannot be further split, so Nikita scored 2.

Function Description

Complete the arraySplitting function in the editor below. It should return an integer that reperesents the number of times Nikita can split the array.

arraySplitting has the following parameter(s):

arr: an array of integers
Input Format

The first line contains an integer t, the number of test cases.

Each of the next t pairs of lines is as follows:

The first line contains an integer n, the size of array arr.
The next line contains n space-separated integers arr[i].

Constraints

1 <= t<= 10
1 <= n <= 2^14
0 <= arr[i] <=10^9




Solution:-
*/
import java.util.*;
import java.io.*;

public class B
{
   public static void main(String[] args) throws Exception
   {
      FastScanner in = new FastScanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      int T = in.nextInt();
      while (T-->0) new B(in, out);
      out.close();
   }
   int N;
   int[] vs;
   int go(int i, int j)
   {
      long sum = 0;
      for (int x=i; x<=j; x++)
         sum += vs[x];
      if (sum % 2 != 0) return 0;
      sum /= 2;

      long ss = 0;
      for (int x=i; x<j; x++)
      {
         ss += vs[x];
         if (ss == sum)
            return 1 + Math.max(go(i, x), go(x+1, j));
      }
      return 0;
   }

   public B(FastScanner in, PrintWriter out)
   {
      N = in.nextInt();
      vs = new int[N];
      for (int i=0; i<N; i++)
         vs[i] = in.nextInt();

      long res = go(0, N-1);
      out.println(res);
   }
}

class FastScanner{
   private InputStream stream;
   private byte[] buf = new byte[1024];
   private int curChar;
   private int numChars;

   public FastScanner(InputStream stream)
   {
      this.stream = stream;
   }

   int read()
   {
      if (numChars == -1)
         throw new InputMismatchException();
      if (curChar >= numChars){
         curChar = 0;
         try{
            numChars = stream.read(buf);
         } catch (IOException e) {
            throw new InputMismatchException();
         }
         if (numChars <= 0)
            return -1;
      }
      return buf[curChar++];
   }

   boolean isSpaceChar(int c)
   {
      return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
   }
   
   boolean isEndline(int c)
   {
      return c=='\n'||c=='\r'||c==-1;
   }

   int nextInt()
   {
      return Integer.parseInt(next());
   }
   
   long nextLong()
   {
      return Long.parseLong(next());
   }

   double nextDouble()
   {
      return Double.parseDouble(next());
   }

   String next(){
      int c = read();
      while (isSpaceChar(c))
         c = read();
      StringBuilder res = new StringBuilder();
      do{
         res.appendCodePoint(c);
         c = read();
      }while(!isSpaceChar(c));
      return res.toString();
   }
   
   String nextLine(){
      int c = read();
      while (isEndline(c))
         c = read();
      StringBuilder res = new StringBuilder();
      do{
         res.appendCodePoint(c);
         c = read();
      }while(!isEndline(c));
      return res.toString();
   }
}
