package com.ds.algo.dp;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class Stairs {
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
        int target = rc.nextInt();
        int[] dp = new int[45+1];
        System.out.println(countStairs(0, target, dp));
    }

    private static int countStairs(int sum, int target, int[] dp){
        if(sum > target)
            return 0;
        if(sum == target){
            return 1;
        }

        if(dp[sum] != 0) return dp[sum];

        dp[sum] = countStairs(sum+1, target, dp) + countStairs(sum+2, target, dp);
        return dp[sum];
    }

    private static void countStairs(int sum, int target, List<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        if(sum > target) return;
        if(target == sum){
            ans.add(new ArrayList<>(ds));
            return;
        }
        countStairs(sum+1, target, ans, ds);
        ds.add(sum);
        countStairs(sum+2, target, ans, ds);
//        ds.remove(ds.size()-1);
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
