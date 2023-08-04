/*

Topic:- Password Cracker

Link:- https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true

Problem:-

There are n users registered on a website CuteKittens.com. Each of them has a unique password represented by pass[1], pass[2], ..., pass[N]. As this a very lovely site, many people want to access those awesomely cute pics of the kittens. But the adamant admin does not want the site to be available to the general public, so only those people who have passwords can access it.

Yu, being an awesome hacker finds a loophole in the password verification system. A string which is a concatenation of one or more passwords, in any order, is also accepted by the password verification system. Any password can appear  or more times in that string. Given access to each of the  passwords, and also have a string , determine whether this string be accepted by the password verification system of the website. If all of the  string can be created by concatenating password strings, it is accepted. In this case, return the passwords in the order they must be concatenated, each separated by a single space on one line. If the password attempt will not be accepted, return 'WRONG PWASSWORD'.

Concatenate the passwords in index order  to match 'abba',  to match 'baab',  to match 'abab' or  to match $baba'. No combination of 1 or more passwords can be concatenated to match 'aba'. Return 'WRONG PASSWORD'.

Function Description

Complete the passwordCracker function in the editor below.

passwordCracker has the following parameters:
- string passwords[n]: a list of password strings
- string loginAttempt: the string to attempt to create

Returns
- string: Return the passwords as a single string in the order required for the password to be accepted, each separated by a space. If it is not possible to form the string, return the string WRONG PASSWORD.

Input Format

The first line contains an integer t, the total number of test cases.

Each of the next  sets of three lines is as follows:
- The first line of each test case contains n, the number of users with passwords.
- The second line contains n space-separated strings, passwords[i], that represent the passwords of each user.
- The third line contains a string, loginAttempt, which Yu must test for acceptance.




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int cnt = sc.nextInt();
            Set<String> dict = new HashSet<String>();
            Map<String,Boolean> map = new HashMap<String,Boolean>();
            for(int j = 0; j < cnt; j++){
                dict.add(sc.next());
            }
            String s = sc.next();
            boolean res = dfs(s,dict,"",map);
            if (!res){
                System.out.println("WRONG PASSWORD");
            }
        }
    }
    
    private static boolean dfs(String s, Set<String> dict, String path,Map<String,Boolean> map){
        
        if (s == null || s.length() == 0){
            System.out.println(path.trim());
            return true;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        for(String word : dict){
            if (!s.startsWith(word)) continue;
            if (dfs(s.substring(word.length()),dict,path + word + " ",map)){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
