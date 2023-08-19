/*

Topic:- Permutation game

Link:- https://www.hackerrank.com/challenges/permutation-game/problem?isFullScreen=true

Problem:-

Alice and Bob play the following game:

They choose a permutation of the numbers  to .
Alice plays first and they alternate.
In a turn, they can remove any one remaining number from the permutation.
The game ends when the remaining numbers form an increasing sequence of  or more numbers. The person who played the turn that leaves an increasing sequence wins the game.
Assuming both play optimally, who wins the game? Return Alice or Bob.

Example 

This is the starting permutation to analyze, . First, Alice chooses  or . For the example, Alice chooses  and leaves . Since this is a decreasing sequence, Bob can remove any number for optimum play. He will lose regardless. Alice then removes any number leaving an array of only one element. Since Alice removed the last element to create an increasing sequence, Alice wins.

Function Description

Complete the permutationGame function in the editor below.

permutationGame has the following parameter:
- int arr[n]: the starting permutation

Returns

string: either Alice or Bob
Input Format

The first line contains the number of test cases .

Each of the next  pairs of lines is in the following format:
- The first line contains an integer , the size of the array 
- The second line contains  space-separated integers,  where 

Constraints

The permutation will not be an increasing sequence initially.
Sample Input

STDIN       Function
-----       --------
2           t = 2
3           arr[] size n = 3
1 3 2       arr = [1, 3, 2]
5           n = 5
5 3 2 1 4   arr = [5, 3, 2, 1, 4]
Sample Output

Alice
Bob
Explanation

For the first test, Alice can remove  or  to leave an increasing sequence and win the game.

For the second test, if  is removed then the only way to have an increasing sequence is to only have  number left. This takes a total of  moves, and Bob wins.

If Alice removes the  on the first move, it will take  more moves to create an increasing sequence. Bob wins. If Alice removes something else, Bob can remove  on his next turn to create the same game state. It is a decreasing sequence with  numbers left.




Solution:-
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static HashMap cache=new HashMap<ArrayList<Integer>, Boolean>();

    private static boolean isSorted(ArrayList<Integer> list){
        int l=list.size();
        for(int i=0;i<l-1;i++){
            if(list.get(i)>list.get(i+1))return false;
        }
        return true;
    }
    private static boolean isWinning(ArrayList<Integer> list){
        if(cache.containsKey(list)){
            return (boolean) cache.get(list);
        }
        int l=list.size();
        int val;
        for(int i=0;i<l;i++){
            val=list.get(i);
            list.remove(i);
            if(isSorted(list)){
                list.add(i, val);
                cache.put(list,Boolean.TRUE);
                return true;
            }
            if(!isWinning(list)){
                list.add(i,val);
                cache.put(list,Boolean.TRUE);
                return true;
            }
            list.add(i,val);
        }
        cache.put(list,Boolean.FALSE);
        return false;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt(),N;
        ArrayList<Integer> list;
        ArrayList<String> result=new ArrayList<String>();
        for(int t=0;t<T;t++){
            N=sc.nextInt();
            sc.nextLine();
            list=new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                list.add(sc.nextInt());
            }
            if(isWinning(list)){
                result.add("Alice");
            }else {
                result.add("Bob");
            }
        }
        for(String s:result){
            System.out.println(s);
        }
    }
}
