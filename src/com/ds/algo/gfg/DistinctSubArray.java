package com.ds.algo.gfg;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

/***
 * distinct sub-array from gfg daily problem
 * level : medium
 */
public class DistinctSubArray {
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
        int[]arr = {2,1,3,2,3};
//        int[]arr = {2,4,4,2,4};
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        System.out.println(findSubArray(0, arr, set, new ArrayList<Integer>()));
    }

    private static int findSubArray(int index, int[] nums, Set<Integer> set, List<Integer> ds) {
        if(new HashSet<Integer>(ds).equals(set)){            
            return 1;
        }
        if(index >= nums.length)
            return 0;
        int t=0;
        for(int i = index; i < nums.length; i++){
            ds.add(nums[i]);
            t += findSubArray(i+1,nums,set,ds);
            ds.remove(ds.size()-1);
        }
        t += findSubArray(index+1,nums,set,ds);
        return t;
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
