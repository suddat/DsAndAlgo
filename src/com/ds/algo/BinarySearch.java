package com.ds.algo;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {4,5,6,7,0,1,2};
    int start =0;
    int end = arr.length;
    int piv = 0;
    int target = 6;

//    System.out.println(end);
    while(start <= end){
        piv = (start+end)/2;

        if(piv >= end){
            System.out.println("not found");
            break;
        }
        if(arr[piv] > arr[piv+1]){
          break;
        }
        /*if(arr[piv] == target){
            System.out.println(piv);
            break;
        }*/

        if(arr[piv] < arr[piv+1]){
            end = piv-1;
        }

        if(arr[piv]> arr[piv+1]){
            start = piv+1;
        }
    }
    /*System.out.println(piv);
      if(target < piv){

      }*/
    int m;
    start = piv+1;
    end = arr.length;
    while(start <= end){
        m = (start+end)/2;

        if(arr[m] == target){
            System.out.println(m);
            break;
        }

        if(start == end){
            start = 0;
            end = piv;
        }
        if(arr[m] > target){
            end = m-1;
        }
        if(arr[m] < target){
            start = m+1;
        }
    }
  }
}
