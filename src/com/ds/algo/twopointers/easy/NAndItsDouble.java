package com.ds.algo.twopointers.easy;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class NAndItsDouble {
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
        //int[] arr = {0,0};
        int[] arr = {-20,8,-6,-14,0,-19,14,4};

        //System.out.println(nAndDouble(arr));
        System.out.println(nAndDoubleWithSpace(arr));
    }

    private static boolean nAndDoubleWithSpace(int[] arr){
        Set<Integer> list = new HashSet<>();
        int zeroCount = 0;
        for (int z : arr) {
            if(z !=0)
                list.add(z*2);
            else if(zeroCount>0){
                list.add(z);
            }else{
                 zeroCount++;
            }
        }
        for (int x : arr) {
            if(list.contains(x))
                return true;
        }
        return false;
    }
    private static boolean nAndDouble(int[] arr) {
        Arrays.sort(arr);
        int i =0, j = arr.length-1;

        while(arr[i] < arr[j]){
            int n = arr[i]*2;
            if(n == arr[j]){
                return true;
            }else if(n < arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    private static void swap(int p1, int p2, int[] arr) {
        int t = arr[p1];
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

