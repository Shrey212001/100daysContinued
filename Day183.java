/*

Topic:- Sherlock and The Beast

Link:- https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem?isFullScreen=true

Problem:-

Sherlock Holmes suspects his archenemy Professor Moriarty is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.

Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus. He also gives him a clue: an integer. Sherlock determines the key to removing the virus is to find the largest Decent Number having that number of digits.

A Decent Number has the following properties:

Its digits can only be 3's and/or 5's.
The number of 3's it contains is divisible by 5.
The number of 5's it contains is divisible by 3.
It is the largest such number for its length.
Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!


Function Description

Complete the decentNumber function in the editor below.

decentNumber has the following parameter(s):

int n: the length of the decent number to create
Prints

Print the decent number for the given length, or  if a decent number of that length cannot be formed. No return value is expected.

Input Format

The first line is an integer, , the number of test cases.

The next  lines each contain an integer , the number of digits in the number to create.




Solution:-
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static StringBuilder out = new StringBuilder();
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		int numCases = Integer.parseInt(in.readLine());
		for(int t = 0; t < numCases; t ++)
		{
			int k = Integer.parseInt(in.readLine());
			int numFives = (k / 3) * 3;
			int numThrees = 0;
			if(k-numFives == 2)
			{
				numFives -= 3;
				numThrees += 5;
			}
			else if(k-numFives == 1)
			{
				numFives -= 9;
				numThrees += 10;
			}
			
			if(numFives >= 0)
			{
				for(int i = 0; i < numFives; i ++)
				{
					out.append(5);
				}
				for(int i = 0; i < numThrees; i ++)
				{
					out.append(3);
				}
				out.append("\n");
			}
			else
			{
				out.append("-1\n");
			}
		}

		System.out.print(out);
	}
}
