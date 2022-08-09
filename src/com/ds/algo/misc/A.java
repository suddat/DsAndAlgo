package com.ds.algo.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {
  static PrintWriter out = new PrintWriter((System.out));

  public static void main(String[] args) throws IOException {
    Reader sc = new Reader();
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    out.close();
  }

  public static void solve(Reader rc) {

    HashSet<Long> set = new HashSet<>();

    set.add(1l);
    set.add(2l);
    set.add(3l);
    set.add(4l);
    set.add(5l);

    if (set.contains(6l)) System.out.println("is it true?");
  }

  static class Reader {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
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
}
