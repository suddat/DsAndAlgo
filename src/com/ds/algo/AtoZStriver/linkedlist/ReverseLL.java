package com.ds.algo.AtoZStriver.linkedlist;

import java.util.Stack;

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = createLL(arr);
        printLL(head);
        System.out.println();
        reverse(head);
        printLL(head);
        System.out.println();
    }

    private static void reverse(Node head){
        Stack<Node> stack = new Stack<>();
        Node iterator = head;

        while(iterator.next != null){
            stack.add(iterator);
            iterator = iterator.next;
        }

        head = iterator;
        while(!stack.isEmpty()){
            iterator.next = stack.peek();
            stack.pop();
            iterator = iterator.next;
        }
        iterator.next =  null;
    }

    public static Node createLL(int []arr) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node iterator = head;
        for(int i = 1 ; i< n; i++){
            Node node = new Node(arr[i]);
            iterator.next = node;
            iterator = node;
        }
        return head;
    }

    private static int median(Node head) {
        Node mid = head;
        Node iterator = head;
        int counter = 1;
        while(iterator!=null){
            if(counter%2 == 0){
                mid = mid.next;
            }
            iterator = iterator.next;
            counter++;
        }
        return mid.data;
    }

    private static void printLL(Node head) {
        Node iterator = head;

        while(iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
    }
}
