package com.ds.algo.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuickSort {
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
    int [] arr = new int[rc.nextInt()];
    for(int i = 0; i < arr.length; i++){
      arr[i] = rc.nextInt();
    }

    quickSort(arr, 0, arr.length);

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static void quickSort(int[] arr, int low, int high) {
    if(low < high){
      int piv = partition(arr, low , high);

      quickSort(arr, low, piv-1);
      quickSort(arr, piv+1, high);
    }

  }

  private static int partition(int[] arr, int low, int high) {

    //set i to previous index
    int i = low-1;
    //set last index as pivot
    int piv = arr[high-1];

    //loop through current low to current high
    for(int j = low; j <= high-1; j++){
      //if curr val in loop is less than pivot than increment i and swap.
      if(arr[j] < piv){
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i+1, high-1);
    return (i+1);
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
