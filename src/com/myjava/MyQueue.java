package com.myjava;
//Implementing Queue via Array

import java.util.Stack;

public class MyQueue {
    int arr[];
    int size;
    private int rear = -1;

    MyQueue(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    // Add => Enqueue
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    // Dequeue => Remove
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return arr[0];
    }
}

// Queue implementation using Stacks

class StQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // Add => Enqueue
    public void add(int data) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    // Dequeue => Remove
    public int remove() {
        if (s1.isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return s1.pop();
    }

    // peek
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return s1.peek();
    }
}

// Queue implementation using linked list

class LLQueue {
    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return head == null && tail ==null;
    }

    // Add => Enqueue
    public void add(int data) {
        Node newNode = new Node(data);
        if(tail == null){
            tail = head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Dequeue => Remove
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int front = head.data;
        if(head == tail){
            tail = null;
        }
        head = head.next;
        return front;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return head.data;
    }
}

class circularQueue {
    int arr[];
    int size;
    private int rear = -1;
    private int front = -1;

    circularQueue(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return rear == -1 && front ==-1;
    }
    public boolean isFull(){
        return (rear+1)%size == front;
    }

    // Add => Enqueue
    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(front == -1) front = 0;
        rear = (rear+1)%size;
        arr[rear] = data;
    }

    // Dequeue => Remove
    public int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int result = arr[front];
        if(rear == front){
            rear = front = -1;
        }
        else{
            front = (front+1)%size;
        }
        return result;
    }

    // peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        return arr[front];
    }
}