package com.ds.algo.twopointers.easy;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class BackSpaceString {
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
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        System.out.println(backspaceCompare(s,t));

        /*Stack<Character> tStack = new Stack<>();
        Stack<Character> sStack = new Stack<>();

        int j = 0;
        int i = 0;

        while(i < t.length()){
            if(t.charAt(i)!= '#'){
                tStack.push(t.charAt(i));
            }else{
                if(!tStack.empty())tStack.pop();
            }
            i++;
        }
        while(j < s.length()){
            if(s.charAt(j)!= '#'){
                sStack.push(s.charAt(j));
            }else{
                if(!sStack.empty())sStack.pop();
            }
            j++;
        }
        System.out.println(sStack.equals(tStack));*/
    }

    private static boolean backspaceCompare(String s, String t) {
        int sPointer = s.length()-1, tPointer = t.length()-1;
        int sSkips = 0, tSkips = 0;

        while(sPointer >= 0 || tPointer >= 0){
            while(sPointer >= 0){
                if(s.charAt(sPointer) == '#'){
                    sSkips++;
                    sPointer--;
                }else if(sSkips > 0){
                    sSkips--;
                    sPointer--;
                }else{
                    break;
                }
            }
            while(tPointer >= 0){
                if(t.charAt(tPointer) == '#'){
                    tSkips++;
                    tPointer--;
                }else if(tSkips > 0){
                    tSkips--;
                    tPointer--;
                }else{
                    break;
                }
            }
            if(sPointer >=0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)){
                return false;
            }
            if(sPointer >=0 != tPointer >= 0){
                return false;
            }
            sPointer--;
            tPointer--;
        }
        return true;
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
