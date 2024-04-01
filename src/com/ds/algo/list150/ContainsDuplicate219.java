package com.ds.algo.list150;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class ContainsDuplicate219 {
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
//        printArray(duplicate());
        System.out.println(duplicate());
    }

    private static boolean duplicate() {
        int[] nums = {1,2,3,1,4,1};
        int k = 2;
        System.out.println(Math.abs(-1));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            List<Integer> integers;
            integers = map.getOrDefault(nums[i], new ArrayList<>());
            integers.add(i);
            map.put(nums[i], integers);
        }

        boolean result = false;
        for(Map.Entry<Integer, List<Integer>> val : map.entrySet()){
            if(val.getValue().size() >= 2){
                List<Integer> list = val.getValue();
                Collections.sort(list);
                for(int i = 1; i < list.size(); i++){
                    if(list.get(i)- list.get(i-1) <= k){
                        return true;
                    }else{
                        result = false;
                    }
                }
            }
        }
        System.out.println(map);

        return result;
    }

    private static void hashOperation(String str, int[] hash, boolean operation){
        for(int i = 0 ; i < str.length(); i++){
            int c = str.charAt(i) - 97;
            if(operation)
                hash[c]++;
            else
                hash[c]--;
        }
    }

    private static boolean isPalindrom(String onlyAlphabets) {
        int l = 0, r = onlyAlphabets.length()-1;
        while(l <= r){
            if(onlyAlphabets.charAt(l) != onlyAlphabets.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static String removeSpecialCharachter(String s) {
        StringBuffer str = new StringBuffer();

        for(int i = 0 ;i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
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
