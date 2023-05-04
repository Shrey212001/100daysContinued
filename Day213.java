/*

Topic:- Gridland Metro

Link:- https://www.hackerrank.com/challenges/gridland-metro/problem?isFullScreen=true

Problem:-

The city of Gridland is represented as an n x m matrix where the rows are numbered from 1 to n and the columns are numbered from 1 to m.

Gridland has a network of train tracks that always run in straight horizontal lines along a row. In other words, the start and end points of a train track are  and , where  represents the row number,  represents the starting column, and  represents the ending column of the train track.

The mayor of Gridland is surveying the city to determine the number of locations where lampposts can be placed. A lamppost can be placed in any cell that is not occupied by a train track.

Given a map of Gridland and its  train tracks, find and print the number of cells where the mayor can place lampposts.

Note: A train track may overlap other train tracks within the same row.

In this case, there are five open cells (red) where lampposts can be placed.

Function Description

Complete the gridlandMetro function in the editor below.

gridlandMetro has the following parameter(s):

int n:: the number of rows in Gridland
int m:: the number of columns in Gridland
int k:: the number of tracks
track[k][3]: each element contains  integers that represent , all 1-indexed
Returns

int: the number of cells where lampposts can be installed
Input Format

The first line contains three space-separated integers  and , the number of rows, columns and tracks to be mapped.

Each of the next  lines contains three space-separated integers,  and , the row number and the track column start and end.




Solution:-
*/

import java.util.*;
import java.awt.*;

public class Solution {
    ArrayList<Point> locs;
    
    public Solution(){
        locs = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long rows = in.nextInt(), cols = in.nextInt();
        int tracks = in.nextInt();
        ArrayList<Integer> check = new ArrayList<>();
        HashMap<Integer, Solution> found = new HashMap<>();
        
        for(int i = 0; i<tracks; i++){
            int curRow = in.nextInt(), start = in.nextInt(), end = in.nextInt();
            if(!found.containsKey(curRow)){
                Solution sol = new Solution();
                sol.locs.add(new Point(start,end));
                check.add(curRow);
                found.put(curRow,sol);
            }else{
                Solution sol = found.get(curRow);
                sol.locs.add(new Point(start, end));
            }
        }
      
        long total = rows * cols;
        for(int r : check){
            Solution sol = found.get(r);
            ArrayList<Point> myPoints = sol.locs;
            Collections.sort(myPoints, new myComparator());
            Point first = myPoints.get(0);
            total -= (first.y - first.x+1);
            int lastEnd = first.y+1;
            for(int i = 1; i<myPoints.size(); i++){
                Point curPoint = myPoints.get(i);
                if(curPoint.y< lastEnd) continue;
                int begin = Math.max(curPoint.x, lastEnd);
                total -=(curPoint.y - begin + 1);
                lastEnd = curPoint.y+1;
            }
        }
        
        System.out.println(total);        
    }
}
class myComparator implements Comparator<Point>{
    public int compare(Point p1, Point p2){
        return p1.x - p2.x;
    }
}
