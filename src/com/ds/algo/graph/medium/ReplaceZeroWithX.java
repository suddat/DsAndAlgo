package com.ds.algo.graph.medium;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class ReplaceZeroWithX {
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
        /*char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};*/
        char[][] mat = {
                {'X','X','X','X','X'},
                {'O','X','X','X','O'},
                {'O','X','X','O','X'},
                {'X','X','X','O','O'}};
        int n = mat.length;
        int m = mat[0].length;

        print2DChar(fill(n, m, mat));
    }

    private static char[][] fill(int n, int m, char mat[][])
    {
        int[][] vis = new int[n][m];

        for(int j = 0; j < m ; j++){
            if(mat[0][j] == 'O' && vis[0][j] == 0){
                dfs(0, j, vis, mat, n, m);
            }
            if(mat[n-1][j] == 'O' && vis[n-1][j] == 0){
                dfs(n-1, j, vis, mat, n, m);
            }
        }


        for(int i = 0; i < n ;i++){
            if(mat[i][0] == 'O' && vis[i][0] == 0){
                dfs(i, 0, vis, mat, n, m);
            }
            if(mat[i][m-1] == 'O' && vis[i][m-1] == 0){
                dfs(i, m-1, vis, mat, n, m);
            }
        }

        for(int i =0 ; i< n ;i++){
            for(int j = 0; j < m ;j++){
                if(mat[i][j] == 'O' && vis[i][j] == 0){
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private static void dfs(int row, int col, int[][] vis, char[][] mat, int n, int m) {
        vis[row][col] = 1;

        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {-1, 0, 1, 0};

        for(int i = 0 ; i < 4; i++){
            int nrow = delRow[i]+ row;
            int ncol = delCol[i]+ col;

            if(nrow>=0 && nrow <n &&
               ncol>=0 && ncol <m &&
               mat[nrow][ncol] == 'O' &&
               vis[nrow][ncol] != 1
            ){
                dfs(nrow, ncol, vis, mat, n, m);
            }
        }
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

    private static void print2DChar(char[][] arr){
        for (char[] a : arr){
            for (char i : a){
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

