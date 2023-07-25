/*

Topic:- Sansa and XOR

Link:- https://www.hackerrank.com/challenges/sansa-and-xor/problem?isFullScreen=true

Problem:-

Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine this value.

Example

Subarray	Operation	Result
3		None		3
4		None		4
5		None		5
3,4		3 XOR 4		7
4,5		4 XOR 5		1
3,4,5		3 XOR 4 XOR 5	2
Now we take the resultant values and XOR them together:

. Return .

Function Description

Complete the sansaXor function in the editor below.

sansaXor has the following parameter(s):

int arr[n]: an array of integers
Returns

int: the result of calculations

Input Format

The first line contains an integer , the number of the test cases.

Each of the next  pairs of lines is as follows:
- The first line of each test case contains an integer , the number of elements in .
- The second line of each test case contains  space-separated integers .




  Solution:-
  */
  import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        
        for (int i = 0; i < num; i++) {
            String count = br.readLine();
            String[] ns = br.readLine().split(" ");
            sansaXor(ns, Integer.valueOf(count));
        }

    }
    
    public static void sansaXor(String[] strs, int count){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        long result = 0;
        for(int i = 0; i < count; i++){
            int numCount = (i + 1)*(count - i);
            int tmp = Integer.valueOf(strs[i]);
            if(map.containsKey(tmp)){
                map.put(tmp, numCount+map.get(tmp));
            }else{
                map.put(tmp, numCount);
            }
        }
        
        for(int k: map.keySet()){
            int value = map.get(k);
            if(value%2!=0){
                result = result^k;
            }
        }
        
        System.out.println(result);
    }
}
