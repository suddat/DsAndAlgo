package com.ds.algo.misc;

public class Main {

    public static void main(String[] args){

        String a = "abgefjjjdk"; //abejk // abdefgjjjjk

        String b = "abceetjkp"; //abejk  // abceejkpt

        findSubsequence(b, a);
    }

    private static int findSubsequence(String a, String b) {

        if(a == null || b == null){
            return 0;
        }
        int  p1 = 0, p2 = 0;
        int len1 = a.length();
        int len2 = b.length();
        String result = new String();
        while(p1 < len1 && p2 < len2){
            if(a.charAt(p1) == b.charAt(p2)){ // result  = abejk
                result = result.concat(String.valueOf(a.charAt(p1)));
                p1++; // 9
                p2++; // 8
            }else if (p2 == len2-1){
                p2 = p1;
                p1++;
            }else{
                p2++;
            }
        }
        return result.length();
    }

}

