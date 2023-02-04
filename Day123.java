/*
Topic:- The Time in Words

Link:- https://www.hackerrank.com/challenges/the-time-in-words/problem?isFullScreen=true

Problem:-

Given the time in numerals we may convert it into words, as shown below:

5:00 -> five o’ clock
5:01 -> one minute past five
5:10 -> ten minute past five
5:15 -> quarter past five
5:30 -> half past five
5:40 -> twenty minutes to six
5:45 -> quarter to six
5:47 -> thirteen minutes to six
5:28 -> twenty eight minutes past five

At minutes = 0, use o’ clock. For 1 <= minutes <= 30, use past, and for 30 < minutes use to. Note the space between the apostrophe and clock in o’ clock. Write a program which prints the time in words for the input given in the format described.


Function Description

Complete the timeInWords function in the editor below.

timeInWords has the following parameter(s):

int h: the hour of the day
int m: the minutes after the hour
Returns


string: a time string as described
Input Format
The first line contains h, the hours portion The second line contains m, the minutes portion

Constraints
1 <= h <= 12
0 <= m < 60
Sample Input 0


5
47
Sample Output 0


thirteen minutes to six
Sample Input 1

3
00
Sample Output 1

three o' clock
Sample Input 2


7
15
Sample Output 2

quarter past seven



Solution:-
*/
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in .nextInt();
    int m = in .nextInt();
    String word[] = {
      "",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
      "ten",
      "eleven",
      "twelve",
      "thirteen",
      "fourteen",
      "fifteen",
      "sixteen",
      "seventeen",
      "eighteen",
      "nineteen",
      "twenty",
      "twenty one",
      "twenty two",
      "twenty three",
      "twenty four",
      "twenty five",
      "twenty six",
      "twenty seven",
      "twenty eight",
      "twenty nine"
    };
    String time = "";

    if (m == 0) {
      time = word[h] + " o' clock";
    } else if (m == 15) {
      time = "quarter past " + word[h];
    } else if (m == 30) {
      time = "half past " + word[h];
    } else if (m == 45) {
      time = "quarter to " + word[h + 1];
    } else if (m == 1) {
      time = word[m] + " minute past " + word[h];
    } else if (m < 30) {
      time = word[m] + " minutes past " + word[h];
    } else {
      time = word[60 - m] + " minutes to " + word[h + 1];
    }
    System.out.println(time);
  }
}
