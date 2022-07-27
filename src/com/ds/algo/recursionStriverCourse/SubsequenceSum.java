package com.ds.algo.recursionStriverCourse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class SubsequenceSum {
  static PrintWriter out = new PrintWriter((System.out));

  public static void main(String[] args) throws IOException {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    out.close();
  }

  public static void solve(FastReader rc) {
    int[] arr = {1, 2, 1};
    int sum = 2;
    printOneSubsequence(0, new ArrayList<>(), 0, sum, arr, arr.length);
    System.out.println(
        "the count of subsequence which satisfies the sum k : "
            + printCountOfSubsequence(0, 0, sum, arr, arr.length));
  }

  private static void printAllSubsequence(
      int index, List<Integer> ds, int s, int sum, int[] arr, int n) {

    if (index == n) {
      if (s == sum) {
        System.out.println(ds);
      }
      return;
    }
    ds.add(arr[index]);
    s += arr[index];
    printAllSubsequence(index + 1, ds, s, sum, arr, arr.length);
    s -= arr[index];
    ds.remove(ds.size() - 1);
    printAllSubsequence(index + 1, ds, s, sum, arr, arr.length);
  }

  private static boolean printOneSubsequence(
      int index, List<Integer> ds, int s, int sum, int[] arr, int n) {

    if (index == n) {
      if (s == sum) {
        System.out.println(ds);
        return true;
      }
      return false;
    }
    ds.add(arr[index]);
    s += arr[index];
    if (printOneSubsequence(index + 1, ds, s, sum, arr, arr.length) == true) return true;
    s -= arr[index];
    ds.remove(ds.size() - 1);
      return printOneSubsequence(index + 1, ds, s, sum, arr, arr.length) == true;
  }

    /***
     * This is very important pattern which will be used in DP as well a lot
     * @param index
     * @param s
     * @param sum
     * @param arr
     * @param n
     * @return
     */
  private static int printCountOfSubsequence(int index, int s, int sum, int[] arr, int n) {

    if (index == n) {
      if (s == sum) {
        return 1;
      }
      return 0;
    }
    s += arr[index];
    int l = printCountOfSubsequence(index + 1, s, sum, arr, arr.length);
    s -= arr[index];
    int r = printCountOfSubsequence(index + 1, s, sum, arr, arr.length);
    return l + r;
  }

  static class FastReader {
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    StringTokenizer st = new StringTokenizer("");

    public String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return parseInt(next());
    }

    public long nextLong() {
      return parseLong(next());
    }

    public double nextDouble() {
      return parseDouble(next());
    }

    public String nextLine() {
      try {
        return br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

    public boolean hasNext() {
      String next = null;
      try {
        next = br.readLine();
      } catch (Exception e) {
      }
      if (next == null) {
        return false;
      }
      st = new StringTokenizer(next);
      return true;
    }
  }

  static class FastWriter {
    private final BufferedWriter bw;

    public FastWriter() {
      this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
      bw.append("" + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append("\n");
    }

    public void close() throws IOException {
      bw.close();
    }
  }
}
