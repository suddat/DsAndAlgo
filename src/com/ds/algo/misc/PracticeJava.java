package com.ds.algo.misc;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class PracticeJava {
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
        //LocalDate dob = LocalDate.of(1967, 11, 23);
        LocalDate dob = LocalDate.of(2001, 11, 24);
        Period p = Period.between(dob, LocalDate.now());
        System.out.println("p -> " +p.toString());
        System.out.println("years -> " +p.getYears());
        System.out.println("months -> " + p.getMonths());
        System.out.println("days -> " + p.getDays());
        int age = p.getYears();
        if(age < 21 || age > 55){
            System.out.println("not valid age");
        }
        if(age == 55 && (p.getMonths() > 0 || p.getDays() > 0)) {
            System.out.println("not valid");
        }
    }

    public static boolean isDoubleEqual(Double first, Double second){
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;

        DecimalFormat df = new DecimalFormat("#.##");
        first = Double.valueOf(df.format(Double.valueOf(first)));
        second = Double.valueOf(df.format(Double.valueOf(second)));
        return first.compareTo(second)==0? true : false;
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

