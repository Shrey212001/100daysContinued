/*

Topic:- Xor and Sum

Link:- https://www.hackerrank.com/challenges/xor-and-sum/problem?isFullScreen=true

Problem:-

You are given two positive integers a and b in binary representation. You should find the following sum modulo 10^9 + 7:

where operation xor means exclusive OR operation, operation shl means binary shift to the left.

Please note, that we consider ideal model of binary integers. That is there is infinite number of bits in each number, and there are no disappearings (or cyclic shifts) of bits.

Input Format

The first line contains number a (1 <= a <2^10^5)  in binary representation. The second line contains number b (1 < = b < 2^10^5)  in the same format. All the numbers do not contain leading zeros.

Output Format

Output a single integer - the required sum modulo 10^9 + 7.




Solution:-
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final int n = 314159; 
        final int maxlen = 1000000;
        final int mod = 1000000007;
        Scanner in = new Scanner(System.in);
        char a[] = in.nextLine().toCharArray();
        char b[] = in.nextLine().toCharArray();
        int bina[] = new int[maxlen];
        int binb[] = new int[maxlen];
        int bone[] = new int[maxlen];
        for(int i=0;i<a.length;i++){
            bina[i]=a[a.length-1-i]-'0';
        }
        for(int i=a.length;i<maxlen;i++){
            bina[i]=0;
        }
        for(int i=0;i<b.length;i++){
            binb[i]=b[b.length-1-i]-'0';
        }
        for(int i=b.length;i<maxlen;i++){
            binb[i]=0;
        }
        bone[0]=binb[0];
        for(int i = 1;i <= n;i++){
            bone[i]=bone[i-1]+binb[i];
        }
        for(int i=n+1;i<1000000;i++){
            bone[i]=bone[i-1]+binb[i]-binb[i-n-1];
        }
        long sum = 0;
        long mul = 1;
        for(int i=0;i<maxlen;i++){
            if(bina[i]==1){
                sum = (sum + (mul*(n+1-bone[i]))%mod)%mod;    
            } else if(bina[i]==0){
                sum = (sum + (mul*(bone[i]))%mod)%mod;
            }
            mul=(mul*2)%mod;
        }
        System.out.println(sum);
    }
}
