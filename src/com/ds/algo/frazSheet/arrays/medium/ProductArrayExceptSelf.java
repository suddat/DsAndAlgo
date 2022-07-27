package com.ds.algo.frazSheet.arrays.medium;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class ProductArrayExceptSelf {
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
        int[] nums = {1,2,3,4};
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(5);
        set.add(10);
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(set.size()+1);
            if(rand !=0) break;
        }
        System.out.println(rand);
        System.out.println(set.contains(rand));
        //productArray(nums);
    }

    private static void productArray(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        int p1 = 1, p2 =1;
        int n = nums.length;
        res[0] = 1;
        for(int i = 0; i< nums.length ; i++){
            res[i] *= p1;
            p1 = p1* nums[i];
            int j = n-i-1;
            res[j] *= p2;
            p2 = p2* nums[j];
        }
        /*p1=1;
        for(int i = nums.length-1; i>=0;i--){
            res[i] *= p1;
            p1 = p1*nums[i];
        }*/
        for(int x : res){
            System.out.print(x+" ");
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
