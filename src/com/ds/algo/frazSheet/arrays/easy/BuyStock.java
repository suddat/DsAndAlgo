package com.ds.algo.frazSheet.arrays.easy;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class BuyStock {
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
        int[] arr = {2, 4, 1};
        System.out.println(twoPointerTechnique(arr));

        /*int buy = Integer.MAX_VALUE;
        int op = 0;
        int soldToday = 0;
        for(int i =0; i< arr.length; i++){
            if(arr[i] < buy){
                buy = arr[i];
            }
            soldToday = arr[i] - buy;
            if(op < soldToday){
                op = soldToday;
            }
        }*/
    }

    private static int twoPointerTechnique(int[] arr) {
        int l = 0;
        int r = 1;
        int profit = 0, maxProfit=0;
        while(r < arr.length){
            if(arr[l] < arr[r]){
                profit = arr[r] - arr[l];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                l = r;
            }
            r++;
        }
        return maxProfit;
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

