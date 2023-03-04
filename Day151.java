/*

Topic:- Mars Exploration

Link:- https://www.hackerrank.com/challenges/mars-exploration/problem?isFullScreen=true

Problem:-

A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.

Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.

Example

s = 'SOSTOT'

The original message was SOSSOS. Two of the message's characters were changed in transit.

Function Description

Complete the marsExploration function in the editor below.

marsExploration has the following parameter(s):

string s: the string as received on Earth

Returns

int: the number of letters changed during transmission

Input Format

There is one line of input: a single string, s.

Constraints

1  <=   length of s  <=  99
length of s modulo 3 = 0
s will contain only uppercase English letters, ascii[A-Z].




Solution:-
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int numChanged = 0;
        
        for(int i = 0; i < S.length(); i++)
        {
            if(i % 3 == 1)
            {
                if(S.charAt(i) != 'O')
                {
                    numChanged++;
                }
            }
            else
            {
                if(S.charAt(i) != 'S')
                {
                    numChanged++;
                }
            }
        }
        
        System.out.println(numChanged);
    }
}
