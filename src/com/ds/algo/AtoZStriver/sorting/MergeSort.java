package com.ds.algo.AtoZStriver.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class MergeSort {
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
        int n = rc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rc.nextInt();
        }

        solution(n, arr);
        printArray(arr);
    }

    private static void solution(int n, int[] nums) {
        mergeSort(nums, 0, n-1);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if(low == high) return;
        int mid = (low + high)/2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        merge(nums, low, mid, high);

    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] leftArray = new int [leftSize];
        int[] rightArray = new int [rightSize];

        for(int i = 0 ; i < leftSize; i++){
            leftArray[i] = nums[low+i];
        }

        for(int i = 0 ; i < rightSize; i++){
            rightArray[i] = nums[mid+1+i];
        }

        int i = 0, j =0, k = low;

        while(i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                nums[k] = leftArray[i];
                i++;
            }else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < leftSize){
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightSize){
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void swap(int p1, int p2, int[] arr) {
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void print2DArray(int[][] arr) {

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

