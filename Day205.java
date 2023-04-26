/*

Topic:- Lily's Homework

Link:- https://www.hackerrank.com/challenges/lilys-homework/problem?isFullScreen=true

Problem:-

Whenever George asks Lily to hang out, she's busy doing homework. George wants to help her finish it faster, but he's in over his head! Can you help George understand Lily's homework so she can hang out with him?

Consider an array of  distinct integers, . George can swap any two elements of the array any number of times. An array is beautiful if the sum of  among  is minimal.

Given the array , determine and return the minimum number of swaps that should be performed in order to make the array beautiful.

Function Description

Complete the lilysHomework function in the editor below.

lilysHomework has the following parameter(s):

int arr[n]: an integer array
Returns

int: the minimum number of swaps required

Input Format

The first line contains a single integer, n, the number of elements in arr. The second line contains  n space-separated integers, arr[i].




Solution:-
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   public static int lilysHomework(List<Integer> arr) {
    List<Integer> copy = new ArrayList<>(arr);
    List<Integer> copy1 = new ArrayList<>(arr);
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    Collections.sort(copy);
    int count1 = 0, count2 = 0;
    for(int i=0;i<arr.size();i++){
        map.put(arr.get(i),i);
    }
    for(int i=0;i<copy.size();i++){
        if(arr.get(i)!=copy.get(i)){
            Integer tmp = arr.get(i);
            arr.set(i,arr.get(map.get(copy.get(i))));
            arr.set(map.get(copy.get(i)),tmp);
            map.put(tmp,map.get(copy.get(i)));
            count1++;
        }
    }
    Collections.sort(copy,Collections.reverseOrder());
    for(int i=0;i<arr.size();i++){
        map2.put(copy1.get(i),i);
    }
     for(int i=0;i<copy.size();i++){
        if(copy1.get(i)!=copy.get(i)){
            Integer tmp = copy1.get(i);
            copy1.set(i,copy1.get(map.get(copy.get(i))));
            copy1.set(map2.get(copy.get(i)),tmp);
            map2.put(tmp,map2.get(copy.get(i)));
            count2++;
        }
    }
    
    return Math.min(count1,count2);
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
