package com.ds.algo.graph.medium;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;


public class FloodFillAlgo {
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
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1;
        int newColor = 2;

        floodfill(image, sr, sc, newColor);
    }

    private static void floodfill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        //dfs(sr, sc, ans, image, newColor, delRow, delCol,iniColor);
        bfs(image, ans, delRow, delCol,sr,sc, newColor,iniColor);
        print2DArray(ans);
    }

    private static void bfs(int[][] image, int[][] ans, int[] delRow, int[] delCol, int sr, int sc, int newColor, int initColor){
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc] = newColor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = delRow[i] + row;
                int ncol = delCol[i] + col;
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m &&
                   image[nrow][ncol] == initColor &&
                   ans[nrow][ncol] != newColor
                ){
                    ans[nrow][ncol] = newColor;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        //print2DArray(ans);
    }

    private static void dfs(int row,
                            int col,
                            int[][]ans,
                            int[][] image,
                            int newColor,
                            int[] delRow,
                            int[] delCol,
                            int iniColor
    ){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i< 4; i++){
            int nrow = delRow[i] + row;
            int ncol = delCol[i] + col;
            if(nrow >= 0 && nrow < n &&
               ncol >= 0 && ncol < m &&
               image[nrow][ncol] == iniColor &&
               ans[nrow][ncol] != newColor
            ){
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }

    private static void print2DArray(int[][] arr){
        for (int[] a : arr){
            for (int i : a){
                System.out.print(i + " ");
            }
            System.out.println();
        }
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

