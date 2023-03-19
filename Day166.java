/*

Topic:- The Love-Letter Mystery

Link:- https://www.hackerrank.com/challenges/the-love-letter-mystery/problem?isFullScreen=true

Problem:-

James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

To do this, he follows two rules:

1. He can only reduce the value of a letter by 1, i.e. he can change d to c, but he cannot change c to d or d to b.
2. The letter  a may not be reduced any further.

Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.


Function Description

Complete the theLoveLetterMystery function in the editor below.

theLoveLetterMystery has the following parameter(s):

string s: the text of the letter

Returns

int: the minimum number of operations


Input Format

The first line contains an integer q, the number of queries.
The next q  lines will each contain a string s.


Constraints

1  <=  q  <=  10

1  <=   | s |   <=  10^4
All strings are composed of lower case English letters, ascii[a-z], with no spaces.





Solution:-
*/
import java.util.Scanner;


public class Solution {


	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();scan.nextLine();
		
		for(int i=0;i<T;i++)
		{
			String s = scan.nextLine();
			int count=0;
			for(int j=0;j<s.length()/2;j++)
				count+=Math.abs(s.charAt(j)-s.charAt(s.length()-1-j));
			System.out.println(count);
		}
	}
}
