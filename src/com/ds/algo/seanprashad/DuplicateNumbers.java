package com.ds.algo.seanprashad;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class DuplicateNumbers {
  static PrintWriter out = new PrintWriter((System.out));

  public static void main(String[] args) throws IOException {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    out.close();
  }

  public static final String LOAN_CLOSE_NARRATION = "Principal Outstanding Payment for Loan <loan_id> closure";
  public static void solve(FastReader rc) {
      System.out.println(rc.nextInt());
      int[] arr = {1,2,3,4};
    System.out.println("ans is : "+ findDuplicate(arr));
  }

    private static boolean findDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();

      for(int i=0;i<nums.length;i++){
        if(!set.add(nums[i]))
          return true;
      }
      return false;
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
