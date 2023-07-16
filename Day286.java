/*

Topic:- Travel around the world

Link:- https://www.hackerrank.com/challenges/travel-around-the-world/problem?isFullScreen=true

Problem:-

There are N cities and N directed roads in Steven's world. The cities are numbered from 0 to N - 1. Steven can travel from city i to city (i + 1) % N, ( 0-> 1 -> 2 -> .... -> N - 1 -> 0).

Steven wants to travel around the world by car. The capacity of his car's fuel tank is C gallons. There are a[i] gallons he can use at the beginning of city i and the car takes b[i] gallons to travel from city i to (i + 1) % N.

How many cities can Steven start his car from so that he can travel around the world and reach the same city he started?

Note

The fuel tank is initially empty.

Input Format

The first line contains two integers (separated by a space): city number N and capacity C.
The second line contains N space-separated integers: a[0], a[1], … , a[N - 1].
The third line contains N space-separated integers: b[0], b[1], … , b[N - 1].

Constraints

2 ≤ N ≤ 105
1 ≤ C ≤ 1018
0 ≤ a[i], b[i] ≤ 109

Output Format

The number of cities which can be chosen as the start city.

Sample Input

3 3
3 1 2
2 2 2
Sample Output

2
Explanation

Steven starts from city 0, fills his car with 3 gallons of fuel, and use 2 gallons of fuel to travel to city 1. His fuel tank now has 1 gallon of fuel.
On refueling 1 gallon of fuel at city 1, he then travels to city 2 by using 2 gallons of fuel. His fuel tank is now empty.
On refueling 2 gallon of fuel at city 2, he then travels back to city 0 by using 2 gallons of fuel.

Here is the second possible solution.
Steven starts from city 2, fill his car with 2 gallons, and travels to city 0.
On refueling 3 gallons of fuel from city 0, he then travels to city 1, and exhausts 2 gallons of fuel. His fuel tank contains 1 gallon of fuel now. He can then refuel 1 gallon of fuel at City 1, and increase his car's fuel to 2 gallons and travel to city 2.

However, Steven cannot start from city 1, because he is given only 1 gallon of fuel, but travelling to city 2 requires 2 gallons.

Hence the answer 2.




Solution:-
*/
import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = scanner.nextLong();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n; i++)
            b[i] = scanner.nextInt();
        int currInd = 0;
        long fuel = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n) {
                fuel += a[i % n];
                fuel = Math.min(fuel, c);
                if (fuel >= b[i % n])
                    fuel -= b[i % n];
                else {
                    fuel = 0;
                    break;
                }
                i++;
                j++;
            }
            if (j == n)
                currInd = i % n;
            else currInd = -1;
        }
        int res = 0;
        if (currInd >= 0) {
            res = 1;
            long ans[] = new long[n];
            ans[currInd] = 0;
            for (int j = 0; j < n - 1; j++) {
                int i = (currInd - j - 1 + n) % n;
                if (Math.min(a[i], c) - b[i] >= ans[(i + 1) % n]) {
                    ans[i] = 0;
                    res++;
                } else {
                    ans[i] = ans[(i + 1) % n] - (Math.min(a[i], c) - b[i]);
                }
            }
        }
        System.out.println(res);
    }
}
