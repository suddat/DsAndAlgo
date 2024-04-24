package com.ds.algo.dailyPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class RotateArray {
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
        List<Integer> arr = Arrays.asList(1,2);
        int k = 1;
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.size()-1);
        reverse(arr, 0, arr.size()-1);
        printList(arr);
    }

    private static void reverse(List<Integer> arr, int l, int r){
        while(l < r){
            Integer temp = arr.get(l);
            arr.set(l, arr.get(r));
            arr.set(r, temp);
            l++;
            r--;
        }
    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void printList(List<Integer> arr) {

        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void swap(int p1, int p2, char[] arr) {
        char t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
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
