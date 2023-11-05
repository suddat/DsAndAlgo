package com.ds.algo.leetcode.slidingwindow;

import java.io.*;
import java.sql.Array;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class TicTacToe {
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

        /*int[][] moves = { // A winner
                {0,0},
                {2,0},
                {1,1},
                {2,1},
                {2,2}
        };*/

        //int[][] moves = {{0,0}, {1,1}, {0,1}, {0,2}, {1,0}, {2,0}}; //B Winner
        int[][] moves = {
                {0,0},
                {1,1},
                {2,0},
                {1,0},
                {1,2},
                {2,1},
                {0,1},
                {0,2}
        };
        System.out.println(tictactoe(moves));
        //printArray(arr);
    }

    private static void solution(int k,List<Integer> list) {
        int noOfOperations = 0;
        Set<Integer> kSet = new HashSet<>();
        for(int i = 1 ; i <= k ; i++){
            kSet.add(i);
        }

        int n = list.size();

        for(int i = n-1; i >= 0 && kSet.size() != 0 ; i--){
            Integer val = list.get(i);
            if(kSet.contains(val)){
                kSet.remove(val);
            }
            noOfOperations++;
        }
        System.out.println(noOfOperations);
    }

    private static String tictactoe(int[][] moves) {
        String[][] board = new String[3][3];

        for(int i =0 ;i < 3;i++){
            for(int j = 0 ;j< 3; j++){
                board[i][j] = ".";
            }
        }


        for(int i = 0; i< moves.length; i++){
            if(i%2 == 0)
                board[moves[i][0]][moves[i][1]] = "X";
            else{
                board[moves[i][0]][moves[i][1]] = "O";
            }
        }
        print2DArray(board);

        return checkBoard(board);
    }

    private static String checkBoard(String[][] board) {
        //check row wise
        for(int i =0 ;i < 3; i++){
            int countA=0, countB=0;

            for(int j =0; j< 3; j++){
                if(board[i][j].equalsIgnoreCase("X")) countA++;
                if(board[i][j].equalsIgnoreCase("O")) countB++;
            }
            if(countA == 3) return "A";
            if(countB == 3) return "B";
        }

        //check colum wise
        for(int i =0 ;i < 3; i++){
            int countA=0, countB=0;

            for(int j =0; j< 3; j++){
                if(board[j][i].equalsIgnoreCase("X")) countA++;
                if(board[j][i].equalsIgnoreCase("O")) countB++;
            }
            if(countA == 3) return "A";
            if(countB == 3) return "B";
        }
        //check diagonally
        if(board[0][0].equalsIgnoreCase("X") &&
                board[1][1].equalsIgnoreCase("X") &&
                board[2][2].equalsIgnoreCase("X")
        ) return "A";
        if(board[0][0].equalsIgnoreCase("O") &&
                board[1][1].equalsIgnoreCase("O") &&
                board[2][2].equalsIgnoreCase("O")
        ) return "B";

        if(board[0][2].equalsIgnoreCase("X") &&
                board[1][1].equalsIgnoreCase("X") &&
                board[2][0].equalsIgnoreCase("X")
        ) return "A";
        if(board[0][2].equalsIgnoreCase("O") &&
                board[1][1].equalsIgnoreCase("O") &&
                board[2][0].equalsIgnoreCase("O")
        ) return "B";

        int c = 0;
        for(int i = 0; i<3 ; i++){
            for(int j = 0; j< 3; j++){
                if(board[i][j].equalsIgnoreCase("X") || board[i][j].equalsIgnoreCase("O"))
                    c++;
            }
        }
        if(c == 9)
            return "Draw";

        return "Pending";

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

