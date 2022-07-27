package com.ds.algo;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class SetMatrixZero {
  static PrintWriter out = new PrintWriter((System.out));

  public static void main(String[] args) throws IOException {
      int[][] arr = new int[1][1];
      arr[0][0] = 2147483647;
    System.out.println("arr 0 index value : "+arr[0][0]);
    /*FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      solve(sc);
    }
    out.close();*/
  }

  public static void solve(FastReader rc) {
    FastWriter out = new FastWriter();
    try {
      out.println(rc.next());
      int[][] arr = new int[3][3];
      setZeroes(arr);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void setZeroes(int[][] matrix) {
    int col0 = 1, rows = matrix.length, columns = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) col0 = 0;
      for (int j = 1; j < columns; j++) if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
    }
    for (int i = rows - 1; i >= 0; i--) {
      for (int j = columns - 1; j >= 1; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
      }
      if (col0 == 0) matrix[i][0] = 0;
    }
  }

  public static class FastReader {
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
