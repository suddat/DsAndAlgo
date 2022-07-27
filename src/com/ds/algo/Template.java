package com.ds.algo;

import java.io.*;
import java.util.*;

public class Template {
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
    String str1 = new String("hello");
    String str4 = new String("hello");
    String str = "hello";
    String str2 = "hello";
    char[] strNew = str.toCharArray();
    strNew[0] = 'a';

    System.out.println(str.hashCode());
    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode());
    System.out.println(str4.hashCode());
    System.out.println(strNew.toString().hashCode());
    System.out.println(str == str2);
    System.out.println(str4 == str1);
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
