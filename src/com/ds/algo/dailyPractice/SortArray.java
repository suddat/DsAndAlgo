package com.ds.algo.dailyPractice;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 0, -1, 1};

        sortInAsc(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for(int i : arr){
            System.out.print(" "+i);
        }
    }

    private static void sortInAsc(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            if(arr[end] == 1){
                end--;
            }
            if(arr[start] == -1){
                start ++;
            }

            if(arr[end] < arr[start]){
                swap(arr, start, end);
                if(arr[end] == 1)
                    end--;
            }
        }
    }

    private static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
