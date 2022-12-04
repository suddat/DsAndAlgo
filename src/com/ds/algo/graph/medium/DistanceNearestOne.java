package com.ds.algo.graph.medium;
import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;


class PairDistance extends Pair{

    int distance;
    public PairDistance(int first, int second, int distance) {
        super(first, second);
        this.distance = distance;
    }
}

public class DistanceNearestOne {
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
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        //int[][] grid = {{1,0,1},{1,1,0},{1,0,0}};

        print2DArray(nearest(grid));
    }

    public static int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        Queue<PairDistance> q = new LinkedList<>();

        for(int i = 0 ; i< n ;i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = 1;
                    q.add(new PairDistance(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int aprDist = q.peek().distance;
            q.remove();
            dist[row][col] = aprDist;

            for(int i = 0; i< 4 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n &&
                   ncol >= 0 && ncol < m &&
                   vis[nrow][ncol] == 0 &&
                   grid[nrow][ncol] == 0
                ){
                    vis[nrow][ncol] = 1;
                    q.add(new PairDistance(nrow, ncol, aprDist+1));
                }
            }
        }

        return dist;
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
