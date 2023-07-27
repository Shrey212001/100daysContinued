/*

Topic:- Winning Lottery Ticket

Link:- https://www.hackerrank.com/challenges/winning-lottery-ticket/problem?isFullScreen=true

Problem:-

The SuperBowl Lottery is about to commence, and there are several lottery tickets being sold, and each ticket is identified with a ticket ID. In one of the many winning scenarios in the Superbowl lottery, a winning pair of tickets is:

Concatenation of the two ticket IDs in the pair, in any order, contains each digit from  to  at least once.
For example, if there are  distinct tickets with ticket ID  and ,  is a winning pair.

NOTE: The ticket IDs can be concantenated in any order. Digits in the ticket ID can occur in any order.

Your task is to find the number of winning pairs of distinct tickets, such that concatenation of their ticket IDs (in any order) makes for a winning scenario. Complete the function winningLotteryTicket which takes a string array of ticket IDs as input, and return the number of winning pairs.

Input Format

The first line contains  denoting the total number of lottery tickets in the super bowl.
Each of the next  lines contains a string, where string on a  line denotes the ticket id of the  ticket.

Output Format

Print the number of pairs in a new line.




Solution:-
*/
import java.util.Scanner;
public class Solution {
  private static int[] frequency = new int[1024];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfLotteryTickets = scanner.nextInt();

    while (numberOfLotteryTickets-- > 0) {
      String ticket_id = scanner.next();

      String binary = extractUniqueDigits_createBinaryForUniqueDigits(ticket_id);
      populate_frequencyArray(binary);
    }
    scanner.close();

    long result = calculate_total_winningPairsOfTickets();
    System.out.println(result);
  }
  private static String extractUniqueDigits_createBinaryForUniqueDigits(String ticket_id) {
    
    StringBuilder binary = new StringBuilder();
    for (int i = 0; i <= 9; i++) {
      String digit = Integer.toString(i);
      if (ticket_id.contains(digit)) {
        binary.append("1");
      } else {
        binary.append("0");
      }
    }
    return binary.toString();
  }

  private static void populate_frequencyArray(String binary) {
    int uniqueCombination = Integer.parseInt(binary, 2);
    frequency[uniqueCombination]++;
  }
 
  private static long calculate_total_winningPairsOfTickets() {
  
    long result = 0;
    for (int i = 1; i < frequency.length; i++) {
      if (frequency[i] == 0) {
        continue;
      }

      for (int j = i + 1; j < frequency.length; j++) {
        if ((i | j) == 1023) {
          result = result + (long) frequency[i] * frequency[j];
        }
      }
    }

    int freq_lastIndex = frequency[frequency.length - 1];
    result = result + ((long) freq_lastIndex * (freq_lastIndex - 1)) / 2;

    return result;
  }
}
