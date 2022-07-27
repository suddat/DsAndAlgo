package com.ds.algo.twopointers.easy;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class DuplicateZeros {
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
        int[] nums = {1,0,2,3,0,4,5,0};
        //withResArray(nums);
        withOutArray(nums);
        for(int x : nums){
            System.out.print(x + " ");
        }
    }

    private static void withOutArray(int[] nums) {
        int zeroCount = 0;
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            if(nums[i] == 0) zeroCount++;
        }
        int i = n-1;
        int j = n+zeroCount-1;

        while(i!=j){
            insert(i,j--, nums);
            if(nums[i] == 0){
                insert(i,j--,nums);
            }
            i--;
        }
    }
    private static void insert(int i , int j, int[] arr){
        if(j < arr.length){
            arr[j] = arr[i];
        }
    }

    private static void withResArray(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if(nums[i]==0){
                j++;
            }else{
                res[j] = nums[i];
            }
            j++;
            i++;
        }

        for(int k = 0; k< res.length; k++){
            nums[k] = res[k];
        }
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

