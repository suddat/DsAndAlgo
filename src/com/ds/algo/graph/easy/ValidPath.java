package com.ds.algo.graph.easy;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.*;

public class ValidPath {
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
     * 6
     * [[0,1],[0,2],[3,5],[5,4],[4,3]]
     * 0
     * 5
     * @param rc
     */

    public static void solve(FastReader rc) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0, destination = 5;
        ArrayList<Integer>[] graph = createGraph(n, edges);

        for(int i = 0 ; i< graph.length;i++){
            System.out.println(i + " -> " +graph[i]);
        }

        System.out.println(connectedPathOfGraph(graph,source, destination));
    }

    private static ArrayList<Integer>[] createGraph(int n , int[][] edges){
        ArrayList<Integer>[] list = new ArrayList[n];

        for(int i = 0;i <n;i++){
            list[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
            //System.out.println(list[0]);
        }
        return list;
    }

    private static boolean connectedPathOfGraph(ArrayList<Integer>[] graph, int source, int destination){
        //boolean[] visitedNode = new boolean[n+1];
        HashSet<Integer> visitedNode = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()){
            Integer node = q.poll();
            visitedNode.add(node);

            for(Integer nextNode : graph[node]){
                if(!visitedNode.contains(nextNode)){
                    if(nextNode.equals(destination)){
                        return true;
                    }
                    q.add(nextNode);
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

