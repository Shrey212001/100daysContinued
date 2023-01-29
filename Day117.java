/*
Topic:- Encryption

Link:- https://www.hackerrank.com/challenges/encryption/problem?isFullScreen=true

Problem:-

An English text needs to be encrypted using the following encryption scheme.
First, the spaces are removed from the text. Let L be the length of this text.
Then, characters are written into a grid, whose rows and columns have the following constraints:

[√L] <= row <= column <= [√L] , where [x] is the floor function and [x] is ceil function

Example


s = if man was meant to stay on the ground god would have given us roots

After removing spaces, the string is 54 characters long. √54 is between 7 and 8, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that rows x columns >= L
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows x columns.
The encoded message is obtained by displaying the characters of each column, with a space between column texts. The encoded message for the grid above is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau


Create a function to encode a message.

Function Description


Complete the encryption function in the editor below.


encryption has the following parameter(s):

string s: a string to encrypt
Returns

string: the encrypted string
Input Format
One line of text, the string s


Constraints
1 <= length of s <= 81
s contains characters in the range ascii[a-z] and space, ascii(32).
Sample Input 0

haveaniceday
Sample Output 0

hae and via ecy
Explanation 0

L = 12, √12 is between 3 and 4.
Rewritten with 3 rows and 4 columns:

have
anic
eday
Sample Input 1


feedthedog    
Sample Output 1

fto ehg ee dd
Explanation 1

L = 10, √10 is between 3 and 4.
Rewritten with 3 rows and 4 columns:

feed
thed
og
Sample Input 2

chillout
Sample Output 2


clu hlt io
Explanation 2

L = 8, √8 is between 2 and 3.
Rewritten with 3 columns and 3 rows (2 * 3 = 6 < 8 so we have to use 3 X 3.)




Solution:-
*/
import java.util.Scanner;


public class Solution {

    
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String s= scan.next();
        int wid,len;
        int l=s.length();
        double f=Math.sqrt(l);
        int test=(int)f;
        if(test*test==l){
            wid=test;
            len=test;
        }else{
        wid=test;
        len=test+1;
        if(wid*len<l)
            wid++;
        }
        int a=0;
        char arr[][] = new char[wid][len];
        for(int i=0;i<wid;i++){
            for(int j=0;j<len;j++){
                if(a==s.length())
                    arr[i][j]=' ';
                else
                arr[i][j]=s.charAt(a++);
                
            }
            if(a==s.length())
                break;
        }
        String temp="";
        boolean go=false;
        for(int i=0;i<len;i++){
            for(int j=0;j<wid;j++){
                if(!(arr[j][i]==' ')){
                temp=temp+arr[j][i];
                go=true;
                }
            }
            if(go)
                temp=temp+" ";
            go=false;
        }
        System.out.println(temp);
    }

}
