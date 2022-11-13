package com.ds.algo.graph.medium;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

class PairTime extends Pair{
    int time;

    public PairTime(int first, int second, int time) {
        super(first, second);
        this.time = time;
    }
}

public class RottenOranges {
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
        int[][] grid = {{0,1,2},{0,1,2},{2,1,1}};

        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        System.out.println(rottenOranges(grid, n, m, delRow, delCol));
    }

    private static int rottenOranges(int[][] grid, int n, int m, int[] delRow, int[] delCol) {
        int[][] vis = new int[n][m];
        int cntFresh=0;
        Queue<PairTime> q = new LinkedList<>();
        for(int i = 0 ; i< n; i++){
            for(int j = 0; j< m ; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new PairTime(i,j,0));
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().time;
            tm = Math.max(tm, time);
            q.remove();
            for(int i = 0 ; i< 4 ; i++){
                int nrow = delRow[i] + row;
                int ncol = delCol[i] + col;
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < n &&
                    vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1
                ){
                    q.add(new PairTime(nrow, ncol, time+1));
                    vis[nrow][ncol] = 1;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;
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

