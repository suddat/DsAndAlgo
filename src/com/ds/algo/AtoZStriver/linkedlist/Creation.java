package com.ds.algo.AtoZStriver.linkedlist;


class Node {
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

public class Creation {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        Node head = createLL(arr);
        printLL(head);
    }

    private static void printLL(Node head) {
        Node iterator = head;

        while(iterator.next.next != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        iterator.next = null;
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
}
