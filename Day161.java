/*

Topic:- Gemstones

Link:- https://www.hackerrank.com/challenges/gem-stones/problem?isFullScreen=true

Problem:-


There is a collection of rocks where each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range ascii[ a - z ]. There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in the collection.

Given a list of minerals embedded in each of the rocks, display the number of types of gemstones in the collection.

Function Description

Complete the gemstones function in the editor below.

gemstones has the following parameter(s):

string arr[n]: an array of strings

Returns

int: the number of gemstones found

Input Format

The first line consists of an integer n, the size of arr.
Each of the next n lines contains a string arr[ i ] where each letter represents an occurence of a mineral in the current rock.

Constraints

1  <=   n  <=  100
1  <=   | arr [ i ] |   <=  100
Each composition arr[ i ] consists of only lower-case Latin letters ('a'-'z').

Solution:-
*/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String... args) {
        

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<HashSet<Character>> distinctSets = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < N; ++i) {
            HashSet<Character> set = new HashSet<>();
            distinctSets.add(set);
            char[] array = scanner.nextLine().toCharArray();
            for (char c : array)
                set.add(c);
        }
        
        boolean isCurrentCharGem = false;
        int count = 0;
        for(char c : distinctSets.get(0)) {
            isCurrentCharGem = true;
            for (HashSet<Character> set : distinctSets) {
                if (!set.contains(c)) {
                    isCurrentCharGem = false;
                    break;
                }
            }
            if (isCurrentCharGem)
                count++;
        }
        
        scanner.close();
        System.out.println(count);

    }
}
