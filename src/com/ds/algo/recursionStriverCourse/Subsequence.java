package com.ds.algo.recursionStriverCourse;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Subsequence {
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
        System.out.println(rc.nextInt());
        int[] arr = {3,1,2,4};
        String str = "eat";
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> listChar = new ArrayList<>();
        //printSequence(0, list, arr, n);
        printSequence(0, listChar, str.toCharArray(), str.length());
    }

    private static void printSequence(int i, ArrayList<Integer> list, int[] arr, int n) {
        if(i == n){
            System.out.println(list);
            return;
        }

        //not pick , where the element is not pick in the sequence
        //System.out.println("Not pick list value at iteration i:"+i+" :"+list);
        printSequence(i+1, list, arr,n);
        //pick the particular index into subsequence
        list.add(arr[i]);
        //System.out.println("pick list value at iteration i:"+i+" :"+list);
        printSequence(i+1, list, arr,n);
        list.remove(list.size()-1);
    }

    private static void printSequence(int i, ArrayList<Character> list, char[] arr, int n) {
        if(i == n){
            System.out.println(list);
            return;
        }
        //not pick , where the element is not pick in the sequence
        //System.out.println("Not pick list value at iteration i:"+i+" :"+list);
        printSequence(i+1, list, arr,n);
        //pick the particular index into subsequence
        list.add(arr[i]);
        //System.out.println("pick list value at iteration i:"+i+" :"+list);
        printSequence(i+1, list, arr,n);
        list.remove(list.size()-1);
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
