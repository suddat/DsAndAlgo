package com.ds.algo.list150;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class RomanToInteger13 {
    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
        while (t-- > 0) {
            solve(sc, romanToInt);
        }
        out.close();
    }

    public static void solve(FastReader rc, Map<Character, Integer> romanToInt) {
        String s = "MCMXCIV";
        int n = s.length();
        int total = 0;

        if(s.length() == 1)
            System.out.println(romanToInt.get(s.charAt(0)));

        for(int i = 0 ; i < n;i++){
            if(i < n-1 && romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i+1))){
                total -= romanToInt.get(s.charAt(i));
            }else{
                total += romanToInt.get(s.charAt(i));
            }
        }

        System.out.println(total);

        /*for(int i = 0; i<n; i++){
            if(s.charAt(i) == 'I'){
                if(i+1 < n && s.charAt(i+1) == 'V'){
                    total += 4;
                    i++;
                }
                if(i+1 < n && s.charAt(i+1) == 'X'){
                    total += 9;
                    i++;
                }
            }else if(s.charAt(i) == 'X') {
                if (i + 1 < n && s.charAt(i + 1) == 'L'){
                    total += 40;
                    i++;
                }
                if (i + 1 < n && s.charAt(i + 1) == 'C'){
                    total += 90;
                    i++;
                }
            }else if(s.charAt(i) == 'C'){
                if (i + 1 < n && s.charAt(i + 1) == 'D'){
                    total += 400;
                    i++;
                }
                if (i + 1 < n && s.charAt(i + 1) == 'M'){
                    total += 900;
                    i++;
                }
            }else {
                total += romanToInt.get(s.charAt(i));
            }
        }*/
    }

    private static void reverse(int[] nums, int k, int n) {
        while(k < n){
            swap(k , n, nums);
            k++;
            n--;
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
