package com.ds.algo.recursionStriverCourse;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class RecursionPractice {
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
    //System.out.println(sum(rc.nextInt()));
//    int[] arr = {1,2,3,4,5,6};
    //System.out.println(factorial(rc.nextInt()));
//    reverseArray(arr,0,arr.length);

//    String str = "MADAM";
//    System.out.println("is Palindrom :"+palindrom(str.toCharArray(),0, str.length()));

    System.out.println("fibonacci no : "+fibonacci(rc.nextInt()));

//    for(int a: arr){
//      System.out.print(a+" ");
//    }
  }

  private static int fibonacci(int n) {
    if(n <= 1)
      return n;

    return fibonacci(n-1)+fibonacci(n-2);
  }

  private static boolean palindrom(char[] arr, int i, int length) {
    if(i>=length/2) return true;

    System.out.println("value is "+ arr[i]+ " "+ (int)arr[i]);
    if(arr[i]!=arr[length-i-1])
      return false;

    return palindrom(arr, i+1, length);
  }

  private static void reverseArray(int[] arr, int l, int r) {
    if(l>=r/2)
      return;
    swap(arr, l, r-l-1);
    reverseArray(arr,l+1, r);
  }

  private static void swap(int[] arr, int l, int r) {
    int t = arr[l];
    arr[l] = arr[r];
    arr[r] = t;
  }

  private static int sum(int nextInt) {
    if(nextInt==0) return 0;
    return nextInt+sum(nextInt-1);
  }

  private static int factorial(int nextInt) {
    if(nextInt==1) return 1;
    return nextInt*factorial(nextInt-1);
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
