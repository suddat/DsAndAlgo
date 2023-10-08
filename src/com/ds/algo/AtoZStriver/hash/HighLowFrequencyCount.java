package com.ds.algo.AtoZStriver.hash;

import java.io.*;
import java.sql.Array;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class HighLowFrequencyCount {
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

        printArray(solution(n, arr));
    }

    private static int[] solution(int n, int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (Integer num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>(hash.keySet());

        Collections.sort(list);

        int[] ans = new int[2];
        for (int i : list) {
            if(max < hash.get(i)){
                max = hash.get(i);
                ans[0] = i;
            }
            if(min > hash.get(i)){
                min = hash.get(i);
                ans[1] = i;
            }
        }

        System.out.println(ans[0] + " <->" + ans[1]);

        return ans;
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
        /*HashMap<Integer, Integer> map = new HashMap<>();


        // Iterate over the input array and update the frequency of each element in the HashMap.

        for (int i = 0; i < v.length; i++) {
            if (map.containsKey(v[i])) {
                map.put(v[i], map.get(v[i]) + 1);
            } else {
                map.put(v[i], 1);
            }
        }

        // Sort the keys in the HashMap.

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);


        // Create a new integer array to store the two elements with the highest and lowest frequencies in the input array.

        int[] res = new int[2];


        // Initialize two variables, `minFreq` and `maxFreq`, to the maximum and minimum values of an integer, respectively.

        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;


        // Iterate over the sorted keys in the HashMap and update the variables `minFreq` and `maxFreq` with the frequencies of the elements with the lowest and highest frequencies, respectively.

        for (int key : keys) {
            if (maxFreq < map.get(key)) {
                maxFreq = map.get(key);
                res[0] = key;
            }
            if (minFreq > map.get(key)) {
                minFreq = map.get(key);
                res[1] = key;
            }
        }
*/

        // Return the array `res`.        return res;


        /*TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < v.length; i++) {
            hm.put(v[i], hm.getOrDefault(v[i], 0) + 1);
        }
        int[] ans = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : hm.keySet()) {
            if (max < hm.get(i)) {
                max = hm.get(i);
                ans[0] = i;
            }
            if (min > hm.get(i)) {
                min = hm.get(i);
                ans[1] = i;
            }
        }
        return ans;
    */
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

