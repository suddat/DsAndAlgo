package com.ds.algo.list150;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class MergeSortArray {

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
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3, n = 3;

        int pointerNum1End = m+n-1;
        int pointerNum1M = m-1;
        int pointerNum2N = n-1;

        mergeArrays(pointerNum1M, pointerNum2N, nums1, nums2, pointerNum1End);

        printArray(nums1);
    }

    private static void mergeArrays(int pointerNum1M, int pointerNum2N, int[] nums1, int[] nums2, int pointerNum1End) {
        while(pointerNum2N >= 0){
            if(pointerNum1M >= 0 && nums1[pointerNum1M] > nums2[pointerNum2N]){
                nums1[pointerNum1End] = nums1[pointerNum1M];
                pointerNum1M--;
            }else/* if(nums1[m] < nums2[n])*/{
                nums1[pointerNum1End] = nums2[pointerNum2N];
                pointerNum2N--;
            }
            pointerNum1End--;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

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
