package com.ds.algo.list150;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class ThreeSum15 {
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
        System.out.println(TwoPointerSolution());
    }

    private static int[] mySolution() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,25,75};
        int target = 3;
        int n = numbers.length;
        int l =0, r = n-1;

        while(l <= r){
            int mid = (l+r)/2;
            if(numbers[l] + numbers[mid] > target){
                r = mid;
            }else if(numbers[mid] + numbers[r] < target){
                l = mid;
            }else{
                return new int[]{mid+1,r+1};
            }
        }
        return new int[]{-1,-1};
    }

    private static List<List<Integer>> TwoPointerSolution() {
        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0; i< n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int t = -nums[i];
            int l = i+1;
            int r = n-1;

            while(l < r){
                if(nums[l] + nums[r] == t){
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(nums[i]);
                    sublist.add(nums[l]);
                    sublist.add(nums[r]);
                    ans.add(sublist);
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(r > 0 && nums[r] == nums[r-1]) r--;
                    r--;
                    l++;
                }else if(nums[l] + nums[r] > t){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return new ArrayList<>(ans);
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
