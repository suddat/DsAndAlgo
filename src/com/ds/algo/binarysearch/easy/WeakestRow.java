package com.ds.algo.binarysearch.easy;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class WeakestRow {
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
        /*int[][] mat = {{1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}};*/
        int[][] mat = {{1,0},{0,0},{1,0}};
        int k = rc.nextInt();

        for (int val : kWeakestRows(mat, k)){
            System.out.print(val + " ");
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int i =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] arr : mat){
            map.put(i++, soldierPosition(arr));
            //ans[i++] = soldierPosition(arr);
        }
        List<Map.Entry<Integer, Integer> > list
                = new LinkedList<>(
                map.entrySet());

        Collections.sort(
                list,
                Map.Entry.comparingByValue());
        System.out.println(list);
        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            if(k-- == 0)
                break;
            ansList.add(aa.getKey());
            //k--;
        }
        return ansList.stream().mapToInt(Integer::new).toArray();
    }

    private static int soldierPosition(int[] arr){
        int l =0, r = arr.length-1;
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] == 0){
                r = mid-1;
            }else{
                l = mid+1;
                ans = l;
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

