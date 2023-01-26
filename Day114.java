/*
Topic:- ACM ICPC Team

Link:- https://www.hackerrank.com/challenges/acm-icpc-team/problem?isFullScreen=true

Problem:-
There are a number of people who will be attending ACM-ICPC World Finals. Each of them may be well versed in a number of topics. Given a list of topics known by each attendee, presented as binary strings, determine the maximum number of topics a 2-person team can know. Each subject has a column in the binary string, and a ‘1’ means the subject is known while ‘0’ means it is not. Also determine the number of teams that know the maximum number of topics. Return an integer array with two elements. The first is the maximum number of topics known, and the second is the number of teams that know that number of topics.

Example
n = 3
topics = [‘10101’, ‘11110’, ‘00010’]

The attendee data is aligned for clarity below:
10101
11110
00010
These are all possible teams that can be formed:

Members Subjects
(1,2)   [1,2,3,4,5]
(1,3)   [1,3,4,5]
(2,3)   [1,2,3,4]

In this case, the first team will know all 5 subjects. They are the only team that can be created that knows that many subjects, so [5, 1] is returned.

Function Description

Complete the acmTeam function in the editor below.
acmTeam has the following parameter(s):
string topic: a string of binary digits

Returns

int[2]: the maximum topics and the number of teams that know that many topics

Input Format

The first line contains two space-separated integers n and m, where n is the number of attendees and m is the number of topics.
Each of the next n lines contains a binary string of length m.

Constraints

2 <= n <= 500
1 <= m <= 500

Sample Input

4 5
10101
11100
11010
00101

Sample Output

5
2

Explanation

Calculating topics known for all permutations of 2 attendees we get:

(1, 2) -> 4
(1, 3) -> 5
(1, 4) -> 3
(2, 3) -> 4
(2, 4) -> 4
(3, 4) -> 5

The 2 teams (1, 3) and (3, 4) know all 5 topics which is maximal.



Solution:-
*/
import java.io.*;
import java.util.*;
public class Solution{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] bin = new String[N];
        boolean[][] b = new boolean[N][M];
        for (int i=0; i < N; i++){
            bin[i] = br.readLine();
            for (int k=0; k < M; k++){
                if (bin[i].charAt(k) == '1')
                    b[i][k] = true;
                else
                    b[i][k] = false;
            }
        }
        int max = 0;
        for (int i=0; i < N; i++){
            for(int j=0; j < N; j++){
              
                int cnt = 0;
                if (i != j){
                    for (int k=0; k < M; k++){
                        if ((b[i][k] == true) || (b[j][k] == true)){
                            cnt++;
                        }
                    }
                    if (cnt > max){
                        max = cnt;
                    }
                }
                
            }
        }
        int res = 0;
        for (int i=0; i < N; i++){
            for(int j=0; j < N; j++){
               
                int cnt = 0;
                if (i != j){
                    for (int k=0; k < M; k++){
                        if ((b[i][k] == true) || (b[j][k] == true)){
                            cnt++;
                        }
                    }
                    if (cnt == max){
                        res++;
                    }
                }
                
            }
        }
        
        System.out.println(max);
        System.out.println(res/2);
        
    }
}
