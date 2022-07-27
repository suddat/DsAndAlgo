package com.ds.algo.twopointers.easy;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class ArrayByParity2 {
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
        for(int x : sortArrayByParityIIOptimised(nums)){
            System.out.print(x + " ");
        }
    }
    private static int[] sortArrayByParityIIOptimised(int[] nums) {
        int p1 =0, p2 =1;

        int n = nums.length;
        while(p1 < n && p2 < n){
            if(nums[p1]%2 == 1){
                swap(p1,p2, nums);
                p2=p2+2;
            }else{
                p1 = p1+2;
            }
        }
        return nums;
    }
    private static int[] sortArrayByParityII(int[] nums) {
        int p1 = 0;

        for(int i = 0; i< nums.length; i++){
            if(i%2 == 0 && nums[i]%2!=0){
                p1 = i+1;
                while(p1 < nums.length){
                    if(nums[p1]%2 == 0){
                        swap(i,p1,nums);
                        break;
                    }
                    p1++;
                }
            }else if (i%2 != 0 && nums[i]%2==0){
                p1 = i+1;
                while(p1 < nums.length){
                    if(nums[p1]%2 != 0){
                        swap(i,p1,nums);
                        break;
                    }
                    p1++;
                }
            }
        }
        return nums;
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
