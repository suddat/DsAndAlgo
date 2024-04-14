package com.ds.algo.AtoZStriver.linkedlist;

import java.util.Stack;

public class InsertNodeInMiddleLL {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = createLL(arr);
        printLL(head);
        System.out.println();
        insertNode(head, 11, 10);
        printLL(head);
        System.out.println();
    }

    private static void insertNode(Node head, int data, int position){
        Node newNode = new Node(data);
        if(head == null || position == 0){
            newNode.next = head;
            head = newNode;
        }

        int count = 0;
        Node iterator = head;
        // SinglyLinkedListNode prev;
        while(iterator.next != null && count < position){
            count++;
            iterator = iterator.next;
        }
        newNode.next = iterator.next;
        iterator.next = newNode;
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
