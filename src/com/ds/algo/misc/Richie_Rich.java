package com.ds.algo.misc;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

class Richie_Rich {
  static FastWriter out = new FastWriter();

  public static void main(String[] args) throws IOException {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    out.close();
  }

  public static void solve(FastReader rc) throws IOException {
    /*int A = rc.nextInt();
    int B = rc.nextInt();
    int X = rc.nextInt();*/

    out.println(Math.abs((rc.nextInt() - rc.nextInt()) / rc.nextInt()));
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
