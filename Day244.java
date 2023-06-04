/*

Topic:- Cloudy Day

Link:- https://www.hackerrank.com/challenges/cloudy-day/problem?isFullScreen=true

Problem:-

Quibdó in Colombia is one among the cities that receive maximum rainfall in the world.

All year round, the city is covered in clouds. The city has many towns, located on a one-dimensional line. The positions and populations of each town on the number line are known to you. Every cloud covers all towns located at a certain distance from it. A town is said to be in darkness if there exists at least one cloud such that the town is within the cloud's range. Otherwise, it is said to be sunny.

The city council has determined that they have enough money to remove exactly one cloud using their latest technology. Thus they want to remove the cloud such that the fewest number of people are left in darkness after the cloud is removed. What is the maximum number of people that will be in a sunny town after removing exactly one cloud?

Note: If a town is not covered by any clouds, then it is already considered to be sunny, and the population of this town must also be included in the final answer.

Complete the function maximumPeople which takes four arrays representing the populations of each town, locations of the towns, locations of the clouds, and the extents of coverage of the clouds respectively, and returns the maximum number of people that will be in a sunny town after removing exactly one cloud.

Input Format

The first line of input contains a single integer , the number of towns.

The next line contains  space-separated integers . The  integer in this line denotes the population of the  town.

The next line contains  space-separated integers  denoting the location of the  town on the one-dimensional line.

The next line consists of a single integer  denoting the number of clouds covering the city.

The next line contains  space-separated integers  the  of which denotes the location of the  cloud on the coordinate axis.

The next line consists of  space-separated integers  denoting the range of the  cloud.

Note: The range of each cloud is computed according to its location, i.e., the  cloud is located at position  and it covers every town within a distance of  from it. In other words, the  cloud covers every town with location in the range

Output Format

Print a single integer denoting the maximum number of people that will be in a sunny town by removing exactly one cloud.




Solution:-
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
        long free = 0;
        long[] sum = new long[y.length];
        ArrayList<Event> al = new ArrayList<>();
        HashSet<Integer> clouds = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            al.add(new Event(1, x[i], p[i], i));
        }

        for (int i = 0; i < y.length; i++) {
            al.add(new Event(0, y[i] - r[i], -1, i));
            al.add(new Event(2, y[i] + r[i], -1, i));
        }

        Collections.sort(al);

        for (Event e : al) {
            if (e.type == 0) {
                clouds.add(e.index);
            } else if (e.type == 1) {
                if (clouds.isEmpty()) {
                    free += e.pr;
                } else {
                    if (clouds.size() == 1) {
                        for (int q : clouds) {
                            sum[q] += e.pr;
                        }
                    }
                }
            } else {
                clouds.remove(e.index);
            }
        }

        long mx = 0;
        for (long i : sum) {
            mx = Math.max(mx, i);
        }
        return free + mx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] p = new long[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextLong();
        }
        long[] x = new long[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextLong();
        }
        int m = in.nextInt();
        long[] y = new long[m];
        for (int y_i = 0; y_i < m; y_i++) {
            y[y_i] = in.nextLong();
        }
        long[] r = new long[m];
        for (int r_i = 0; r_i < m; r_i++) {
            r[r_i] = in.nextLong();
        }
        long result = maximumPeople(p, x, y, r);
        System.out.println(result);
        in.close();
    }
}

class Event implements Comparable<Event> {
    int type;
    long x;
    long pr;
    int index;

    public Event(int type, long x, long pr, int index) {
        super();
        this.type = type;
        this.x = x;
        this.pr = pr;
        this.index = index;
    }

    @Override
    public int compareTo(Event e) {
        if (x != e.x) {
            return Long.compare(x, e.x);
        }
        return Integer.compare(type, e.type);
    }

}
