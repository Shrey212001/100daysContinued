/*

Topic:- The Power Sum

Link:- https://www.hackerrank.com/challenges/the-power-sum/problem?isFullScreen=true

Problem:-

Find the number of ways that a given integer, X , can be expressed as the sum of the  Nth powers of unique, natural numbers.

For example, if X =  13 and N =  2 , we have to find all combinations of unique squares adding up to 13. The only solution is 2^2 + 3^2.

Function Description

Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.

powerSum has the following parameter(s):

X: the integer to sum to
N: the integer power to raise numbers to

Input Format

The first line contains an integer X.
The second line contains an integer N.

Constraints

1  <=   X  <=  1000
2  <=   N   <=   10

Output Format

Output a single integer, the number of possible combinations caclulated.




Solution:-
*/
import java.util.Scanner;
public class PowerSum {
    int count=0;
    int sum;
    int pow;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        int n=in.nextInt();
        PowerSum p=new PowerSum();
        p.sum=x;
        p.pow=n;
        int N=(int)Math.pow(x, (1.0/n));
        p.getcount(p.sum,N,true);
        p.getcount(p.sum,N,false);
        System.out.println(p.count);
        in.close();
    }
    void getcount(int sum1,int n,boolean lenyani){
        
        if(lenyani==true){
            sum1=sum1-(int)Math.pow(n, pow);
        
        }
        if(sum1<0) return;
        if(sum1==0){
            count++;
            return;
        }
        if(n==1) return;
        getcount(sum1,n-1,true);
        getcount(sum1,n-1,false);
    }
 
}
