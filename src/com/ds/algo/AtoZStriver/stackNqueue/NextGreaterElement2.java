package com.ds.algo.AtoZStriver.stackNqueue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class NextGreaterElement2 {
    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        out.close();
    }

    public static void solve(FastReader rc) throws IOException {
        int[] arr = {1, 5, 3, 4, 2};
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i = 2*n-1 ; i >= 0 ; i--){

            while(!stack.isEmpty() && arr[i%n] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i%n] = -1;
            }else{
                ans[i%n] = stack.peek();
            }
            stack.push(arr[i%n]);
        }
        printArray(ans);
    }

    private static void print2DArray(int[][] arr) {
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void print2DArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int l, int r, String[] strArray) {
        String temp = strArray[l];
        strArray[l] = strArray[r];
        strArray[r] = temp;
    }

    private static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void printArray(String[] arr) {
        System.out.println("Printing String Array");
        for (String i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int p1, int p2, char[] arr) {
        char t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
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
            System.out.println("object print : " + object);
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    /*import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = scanner.nextInt();
                }
                int start = -1, end = -1;
                for (int i = 0; i < n; i++) {
                    if (a[i] != b[i]) {
                        if (start == -1) {
                            start = i;
                        } else {
                            end = i;
                        }
                    }
                }
                System.out.println((end - start + 1));
            }
            scanner.close();
        }
    }*/
}
