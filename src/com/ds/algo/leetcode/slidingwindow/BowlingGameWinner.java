package com.ds.algo.leetcode.slidingwindow;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class BowlingGameWinner {
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
        /*int[] player1 = {4,10,7,9};
        int[] player2 = {6,5,2,3};*/
        int[] player1 = {10,2,2,3};
        int[] player2 = {3,8,4,5};
        /*int[] player1 = {3,5,7,6};
        int[] player2 = {8,10,10,2};*/
        int n = player1.length;
        int player1Total = calculatePlayersTotal(n, player1);
        int player2Total = calculatePlayersTotal(n, player2);
        if(player1Total > player2Total)

        System.out.println(player1Total + " " + player2Total);
    }

    private static int calculatePlayersTotal(int n, int[] player1) {
        int indexOf10=-1;
        int i = 0;
        int ans = 0;
        for(int j = 0; j < n; j++){
            if(indexOf10 >= 0 && indexOf10 >= i && indexOf10 <j) ans += 2* player1[j];
            else ans+= player1[j];
            if(player1[j] == 10){
                indexOf10 = j;
            }
            int diffInd = j-i;
            if(diffInd == 2) i++;
        }
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

    private static void print2DArray(String[][] arr) {
        for(int i=0;i< arr.length; i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
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
