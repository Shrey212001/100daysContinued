/*

Topic:- Minimum Loss

Link:- https://www.hackerrank.com/challenges/minimum-loss/problem?isFullScreen=true

Problem:-

Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss.

Function Description

Complete the minimumLoss function in the editor below.

minimumLoss has the following parameter(s):

int price[n]: home prices at each year
Returns

int: the minimum loss possible

Input Format

The first line contains an integer n, the number of years of house data.
The second line contains n space-separated long integers that describe each price[i].




Solution:-
*/
import java.util.*;
public class Main{

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);


		int n=input.nextInt();
		
		ArrayList<Long> p=new ArrayList();
		
		for(int i=1;i<=n;i++)
			p.add(input.nextLong());
		
		
		long minLoss=Integer.MAX_VALUE;
		
		ArrayList<Long> p2=(ArrayList<Long>)p.clone();
		
		Collections.sort(p2);

		
		for(int i=n-1;i>0;i--){
			long a=p2.get(i);
			long b=p2.get(i-1);
			if(a-b<minLoss && p.indexOf(a)<p.indexOf(b))
				minLoss=a-b;
		}
		
		System.out.println(minLoss);
			
	}
}
