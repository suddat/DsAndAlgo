package com.ds.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/***
 * 5
 * wow
 * tata
 * a
 * ab
 * lala
 */

public class DoubleStrings {
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
    String str = rc.next();
    int[] hash = new int[26];
    char[] ch = str.toCharArray();
    boolean flag=false;
    for (int i = 0; i < ch.length; i++) hash[ch[i] - 'a']++;

    for (int i: hash){
      if(i>=2){
        flag=true;
        break;
      }
    }
    if (flag) System.out.println("Yes");
    else System.out.println("No");
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
