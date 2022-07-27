package com.ds.algo;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class PascalTriangle {
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
        generate(rc.nextInt());
    }

    public static List<List<Integer>> generate(int numRows) {
//    System.out.println("numRows : "+numRows);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        //setting 1st list value to 1
        List<Integer> row , pre=null;
        for(int i=0; i< numRows; ++i){
            row = new ArrayList<>();
            System.out.println("pre :"+ pre);
            for(int j =0;j<=i;++j){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add((pre.get(j-1)+pre.get(j)));
                }
            }
            pre = row;
            res.add(row);
        }

        for(List<Integer> rows : res){
//            out.println("rows :"+ rows.size());
            for(Integer val: rows){
                out.print(val+" ");
            }
            out.println();
        }
        return res;
    }
    private static List<List<Integer>> getInitiatedValues(int numRows){
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(numRows);
        for(int i =0; i< numRows; i++){
            listOfLists.add(new ArrayList<>(numRows));
        }
        return listOfLists;
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
