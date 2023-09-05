/*

Topic:- Super Functional Strings

Link:- https://www.hackerrank.com/challenges/super-functional-strings/problem?isFullScreen=true

Problem:-

We define a function, F, on a string, P , as follows:

where:

length(P) denotes the number of characters in string P.
distinct(P) denotes the number of distinct characters in string P.
Consuela loves creating string challenges and she needs your help testing her newest one! Given a string, S, consisting of N lowercase letters, compute the summation of function F (provided above) over all possible distinct substrings of S. As the result is quite large, print it modulo 10^9 + 7.

Input Format

The first line contains a single integer, T, denoting the number of test cases.
Each of the T subsequent lines contains a string, S.

Constraints

1  <=     T   <=   100
1   <=   N   <=   10^5
The sum of N over all test cases does not exceed .

Output Format

For each test case, print the answer modulo 10^9 + 7.




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

public class Result {

  static final int MOD = 1_000_000_007;
  static final int MAX = 100000;

  static class Suffix {
    int index;
    int[] rank = new int[2];
  }

  static Comparator<Suffix> cmp =
      (a, b) -> {
        return (a.rank[0] == b.rank[0]) ? a.rank[1] - b.rank[1] : a.rank[0] - b.rank[0];
      };
  
  static int[] invSuff = new int[MAX];
  static int[] suffixArr = new int[MAX];
  static int[] lcp = new int[MAX];
  
  static void buildSuffixArray(char[] txt) {
    int n = txt.length;
    Suffix[] suffixes = new Suffix[n];

    for (int i = 0; i< n; i++) {
      suffixes[i] = new Suffix();
      suffixes[i].index = i;
      suffixes[i].rank[0] = txt[i] - 'a';
      suffixes[i].rank[1] = ((i + 1) < n) ? (txt[i + 1] - 'a') : -1;
    }

    Arrays.sort(suffixes, cmp);

    int[] ind = new int[n];

    for (int k = 4; k < 2 * n; k = k * 2) {
      int rank = 0;
      int prev_rank = suffixes[0].rank[0];
      suffixes[0].rank[0] = rank;
      ind[suffixes[0].index] = 0;

      for (int i = 1; i <n; i++) {
        if (suffixes[i].rank[0] == prev_rank && suffixes[i].rank[1] == suffixes[i - 1].rank[1]) {
          prev_rank = suffixes[i].rank[0];
          suffixes[i].rank[0] = rank;
        } else {
          prev_rank = suffixes[i].rank[0];
          suffixes[i].rank[0] = ++rank;
        }
        ind[suffixes[i].index] = i;
      }

      for (int i = 0; i < n; i++) {
        int nextindex = suffixes[i].index + k / 2;
        suffixes[i].rank[1] = (nextindex < n) ? suffixes[ind[nextindex]].rank[0] : -1;
      }

      Arrays.sort(suffixes, cmp);
    }

    for (int i = 0; i< n; i++) {
      suffixArr[i] = suffixes[i].index;
      invSuff[suffixArr[i]] = i;
    }
  }

  static void kasai(char[] txt) {
    int n = txt.length;
    int k = 0;

    for (int i = 0; i < n; i++) {
      if (invSuff[i] == n - 1) {
        k = 0;
        continue;
      }
      int j = suffixArr[invSuff[i] + 1];
      while (i + k < n && j + k < n &&txt[i + k] == txt[j + k]) {
        k++;
      }

      lcp[invSuff[i]] = k;

      if (k > 0) {
        k--;
      }
    }
  }
  
  static long superFunctionalStrings(char[] s, int[][] map) {
    buildSuffixArray(s);
    kasai(s);

    int len = s.length;

    @SuppressWarnings("unchecked")
    Map<Integer, Integer>[] letterPlaceArr = new Map[len];
    letterPlaceArr[len - 1] = new HashMap<>();
    letterPlaceArr[len - 1].put((s[len - 1]) - 'a', len - 1);
    for (int i = len - 2; i >= 0; i--) {
      letterPlaceArr[i] = new HashMap<>(letterPlaceArr[i + 1]);
      letterPlaceArr[i].put(s[i] - 'a', i);
    }

    long result = 0;
    for (int i = 0; i < len; i++) {
      int nowLen = i == 0 ? 0 : lcp[i - 1];

      int startIndex = suffixArr[i];
      
      List<Integer> tempArr = new ArrayList<Integer>(letterPlaceArr[startIndex].values());
      tempArr.add(len);
      Collections.sort(tempArr);

      for (int j = 1, tempLen = tempArr.size(); j < tempLen; j++) {
        if (tempArr.get(j) - startIndex <= nowLen) {
          continue;
        }

        int diff =
            map[tempArr.get(j) - startIndex][j] - map[Math.max(tempArr.get(j-1) - startIndex, nowLen)][j];
        if (diff < 0) {
          diff += MOD;
        }
        result = (result + diff) % MOD;
      }
    }

    return result;
  }

  static int[][] init() {
    int[][] map = new int[100001][28];
    for (int i = 1; i<= 100000; i++) {
      long temp = 1;
      for (int j = 1; j <= 26; j++) {
        temp = (temp * i) % MOD;
        map[i][j] = (int)temp;
      }
    }

    for (int j = 1; j <= 26; j++) {
      map[0][j] = 0;
      int temp = map[1][j];
      for (int i = 2; i <= 100000; i++) {
        map[i][j] = (temp + map[i][j]) % MOD;
        temp = map[i][j];
      }
    }

    return map;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    int[][] map = init();

    for (int i = 0; i < t; i++) {
      char[] s = br.readLine().toCharArray();
      long result = superFunctionalStrings(s, map);

      bw.write(String.valueOf(result));
      bw.newLine();
    }
    
    bw.close();
    br.close();
  }
}
