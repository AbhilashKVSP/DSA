package com.myjava;
import java.util.*;

// Creating Stack class via Linked List
public class MyStack {
    private Node head;

    private class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        head = head.next;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }
    public void addBottom(int data) {
        if(head == null){
            this.push(data);
            return;
        }
        int peek = this.peek();
        this.pop();
        this.addBottom(data);
        this.push(peek);
    }
    public void reverse(){
        if(head == null){
            return;
        }
        int peek = this.peek();
        this.pop();
        reverse();
        this.addBottom(peek);
    }
}

// Creating Stack class via Array List
class MyStackAl {
    ArrayList<Integer> stack = new ArrayList<>();
    public boolean isEmpty(){
        return stack.size() == 0;
    }
    public void push(int data){
        stack.add(data);
    }
    public void pop(){
        if(isEmpty()){
            return;
        }
        stack.remove(stack.size()-1);
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return stack.get(stack.size()-1);
    }
    public void printStack(){
        System.out.println(stack);
    }
}

