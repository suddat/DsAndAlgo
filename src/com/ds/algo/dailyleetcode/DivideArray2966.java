package com.ds.algo.dailyleetcode;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class DivideArray2966 {
    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        out.close();
    }

    public static int[][] divideArray(int[] nums, int k) {
        // first sort the array as the difference of k value will come nearer to elements which are nearer
        Arrays.sort(nums);
        // find diff between max and min of sub arr of size 3 if difference is <= k add the arr or else return empty array
        int i = 0;
        int n = nums.length;
        int[][] ans = new int[0][0];
        while(i < n){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }else{
                int[] triplet = {nums[i], nums[i+1], nums[i+2]};
                ans = Arrays.copyOf(ans, ans.length+1);
                ans[ans.length-1] = triplet;
            }
            i = i+3;
        }
        //
        return ans;
    }

    private static int[] addArray(int[] nums, int i){
        int[] ans = new int[3];
        ans[0] = nums[i];
        ans[1] = nums[i+1];
        ans[2] = nums[i+2];
        return ans;
    }


    public static void solve(FastReader rc) {

    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
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
