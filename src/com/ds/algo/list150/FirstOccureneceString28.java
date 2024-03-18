package com.ds.algo.list150;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class FirstOccureneceString28 {
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
        System.out.println(mySolution());
    }

    private static int mySolution() {
        String haystack = "mississippi", needle = "issipi";
        int hPointer = 0, nPointer = 0, index = 0;

        while(hPointer < haystack.length()){
            if(haystack.charAt(hPointer) == needle.charAt(nPointer)){
                if(nPointer == needle.length()-1)
                    return index;
                hPointer++;
                nPointer++;
            }else{
                hPointer = index+1;
                index = hPointer;
                nPointer = 0;
            }
        }
        return -1;
    }

    private static void reverseArray(String[] strArray) {
        int l =0, r  = strArray.length-1;

        while(l < r){
            swap(l, r, strArray);
            l++;
            r--;
        }
    }

    private static void swap(int l, int r, String[] strArray) {
        String temp = strArray[l];
        strArray[l] = strArray[r];
        strArray[r] = temp;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void printArray(String[] arr) {
        System.out.println("Printing String Array");
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int p1, int p2, char[] arr) {
        char t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
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
