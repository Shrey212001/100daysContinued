/*

Topic:- Running Time of Algorithms

Link:-https://www.hackerrank.com/challenges/runningtime/problem?isFullScreen=true

Problem:-

In a previous challenge you implemented the Insertion Sort algorithm. It is a simple sorting algorithm that works well with small or mostly sorted data. However, it takes a long time to sort large unsorted data. To see why, we will analyze its running time.

Running Time of Algorithms

The running time of an algorithm for a specific input depends on the number of operations executed. The greater the number of operations, the longer the running time of an algorithm. We usually want to know how many operations an algorithm will execute in proportion to the size of its input, which we will call .

What is the ratio of the running time of Insertion Sort to the size of the input? To answer this question, we need to examine the algorithm.

Analysis of Insertion Sort

For each element  in an array of  numbers, Insertion Sort compares the number to those to its left until it reaches a lower value element or the start. At that point it shifts everything to the right up one and inserts  into the array.

How long does all that shifting take?

In the best case, where the array was already sorted, no element will need to be moved, so the algorithm will just run through the array once and return the sorted array. The running time would be directly proportional to the size of the input, so we can say it will take  time.

However, we usually focus on the worst-case running time (computer scientists are pretty pessimistic). The worst case for Insertion Sort occurs when the array is in reverse order. To insert each number, the algorithm will have to shift over that number to the beginning of the array. Sorting the entire array of  numbers will therefore take  operations, which is  (almost ). Computer scientists just round that up (pick the dominant term) to  and say that Insertion Sort is an " time" algorithm.


Challenge
Can you modify your previous Insertion Sort implementation to keep track of the number of shifts it makes while sorting? The only thing you should print is the number of shifts made by the algorithm to completely sort the array. A shift occurs when an element's position changes in the array. Do not shift an element if it is not necessary.

Function Description

Complete the runningTime function in the editor below.

runningTime has the following parameter(s):

int arr[n]: an array of integers


Returns

int: the number of shifts it will take to sort the array

Input Format

The first line contains the integer n, the number of elements to be sorted.
The next line contains n integers of arr[ arr[0] . . .arr[ n - 1 ] ] .



Solution:-
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  public static int runningTime(List<Integer> arr) {
        
        int n = arr.size();
        int swaps = 0;
            
        for(int i = 0; i < n; i++) {
            
            for(int j = 0; j < n - i - 1; j++) {
                Integer e1 = arr.get(j);
                Integer e2 = arr.get(j + 1);
                
                if(e1 > e2) {
                    
                    //swap
                    arr.set(j, e2);
                    arr.set(j + 1, e1);
                    swaps++;
                }
                
            }
        }
        
        return swaps;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
