package com.ds.algo.graph.medium;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class DetectCycleBFS {
    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        out.close();
    }

    /***
     * 4 2
     * 1 2
     * 2 3
     * @param rc
     */
    public static void solve(FastReader rc) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        /*adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));*/

        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(1,3)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        boolean cycle = isCycle(4, adj);
        System.out.println(cycle);
    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i =0 ; i< V ;i++){
            vis[i] = false;
        }
        for(int i =0 ; i < V ;i++){
            if(!vis[i]){
                if(checkForCycle(i, adj, vis)) return true;
            }
        }
        return false;
    }

    private static boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(Integer adjNode: adj.get(src)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                }else if(parent != adjNode){
                    return true;
                }
            }
        }
        return false;
    }

    private static void swap(int p1, int p2, int[] arr) {
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
    }

    private static void print2DArray(int[][] arr){
        for (int[] a : arr){
            for (int i : a){
                System.out.print(i + " ");
            }
            System.out.println();
        }
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

