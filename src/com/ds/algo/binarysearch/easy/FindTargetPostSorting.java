package com.ds.algo.binarysearch.easy;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class FindTargetPostSorting {
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
        int[] nums = {1,2,5,2,3};
        int target = rc.nextInt();

        System.out.println(targetIndices(nums, target));
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> ansList = new ArrayList<>();
        int leftPointIndex = findTargets(nums, target, n, true);
        if(leftPointIndex!=-1){
            for(int i = leftPointIndex; i< nums.length; i++){
                if(nums[i] == target)
                    ansList.add(i);
                else
                    break;
            }
        }
        return ansList;
    }

    private static int findTargets(int[] nums, int target, int n, boolean flag) {
        int l = 0, r= n -1;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(target > nums[mid]){
                l = mid+1;
            }else if (target < nums[mid]){
                r = mid-1;
            }else{
                ans = mid;
                if(flag)
                    r = mid-1;
                else
                    l = mid+1;
            }
        }
        return ans;
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

