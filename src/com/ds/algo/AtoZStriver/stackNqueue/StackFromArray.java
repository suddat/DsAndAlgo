package com.ds.algo.AtoZStriver.stackNqueue;

public class StackFromArray{
    static class Stack {
        int[] stackArray;
        int capacity;
        int topElement;
        Stack(int capacity) {
            this.stackArray = new int[1000];
            this.capacity = capacity;
            this.topElement = -1;
        }
        public void push(int num) {
            /*if(this.topElement < this.capacity){
                this.topElement++;
                this.stackArray[this.topElement] = num;
            }*/
            this.stackArray[++this.topElement] = num;
        }
        public int pop() {
            int pop = -1;
            if(this.topElement >= 0){
                pop = this.stackArray[this.topElement];
                this.topElement--;
            }
            return pop;
        }
        public int top() {
            if(this.topElement >= 0){
                return this.stackArray[this.topElement];
            }
            return -1;
        }
        public int isEmpty() {
            if(this.topElement < 0)
                return 1;

            return 0;
        }
        public int isFull() {
            if(this.topElement == this.capacity)
                return 1;

            return 0;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);

        /*System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());*/

        /*
        5 10
        1 12
        1 40
        1 63
        1 74
        1 84
        1 10
        1 91
        1 87
        1 14
        1 10
        */

    }
}
