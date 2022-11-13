package com.ds.algo.graph.medium;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NoOfIsland {
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
        char[][] grid = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        //char[][] grid = {{'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'}};
        System.out.println(noOfIsland(grid));
    }

    private static int noOfIsland(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row =0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == '1' && vis[row][col] == 0){
                    count++;
                    //bfs(vis, grid, row, col);
                    dfs(vis, grid, row, col);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] vis, char[][] grid, int ro, int co) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int delrow = -1 ; delrow <=1 ; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = delrow+row;
                    int ncol = delcol+col;
                    if(nrow >= 0 && nrow < n &&
                       ncol >= 0 && ncol <m &&
                       grid[nrow][ncol] == '1' &&
                       vis[nrow][ncol] == 0
                    ){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    private static void dfs(int[][] vis, char[][]grid, int ro, int co){
        vis[ro][co] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for(int delrow = -1 ; delrow <=1 ; delrow++){
            for(int delcol = -1; delcol <= 1; delcol++){
                int nrow = delrow+ro;
                int ncol = delcol+co;
                if(nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol <m &&
                        grid[nrow][ncol] == '1' &&
                        vis[nrow][ncol] == 0
                ){
                    dfs(vis, grid, nrow, ncol);
                }
            }
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

