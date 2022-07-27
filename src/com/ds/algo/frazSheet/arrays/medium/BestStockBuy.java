package com.ds.algo.frazSheet.arrays.medium;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class BestStockBuy {
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
        int[] prices = {7,6,4,3,1};
        //withSpaceComplexity();
        int maxProfit = 0;
        for(int i = 1; i < prices.length ; i++){
            int diff = prices[i] - prices[i - 1];
            if(diff > 0)
                maxProfit += diff;
        }
        System.out.println(maxProfit);
    }
    public static void withSpaceComplexity(){
        int[] prices = {7,6,4,3,1};
        int[] temp = new int[prices.length];
        int maxProfit=0;
        for(int i = 1; i< prices.length; i++){
            temp[i-1] = prices[i] - prices[i-1];
        }
        for(int i = 0; i< temp.length;i++){
            if(temp[i] >0)
                maxProfit += temp[i];
        }
        System.out.println(maxProfit);
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
