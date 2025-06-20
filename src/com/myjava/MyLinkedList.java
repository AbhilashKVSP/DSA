package com.myjava;

public class MyLinkedList {
    public int size;
    private class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    private Node head;
    MyLinkedList(){
        head = null;
    }

    // add the element - first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add the element last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next !=null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    // Print List
    public void printList(){
        if(head == null){
            System.out.println("The lIst is null");
            return;
        }
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    // Delete First
    public void deleteFirst(){
        if(head == null){
            System.out.println("The lIst is null");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete Last
    public void deleteLast(){
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        size--;
        // If there is only one node in the list
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        Node last = head.next;
        while(last.next != null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
    }
    public void getSize(){
        System.out.println("Size of List is " + size);
    }

    // Reverse a list
    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            // Update the next call
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next =null;
        head = prevNode;
    }

    public Node reverseListRecursive(Node head) {
        //empty node || last node or only one node
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void deleteNnode(int num) {
        int iter = this.size - num;
        Node prevNode = this.head;
        Node currNode = prevNode.next;
        for(int i=1; i<iter;i++){
            prevNode =currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
    }

    public boolean isPlaindrome(){
        if(head == null || head.next == null) {
            return true;
        }
        Node middle = getMiddle();
        Node newHead = reverseListRecursive(middle.next);
        Node currNode =head;
        while(newHead != null){
            if(newHead.data != currNode.data) return false;
            currNode = currNode.next;
            newHead = newHead.next;
        }
        return true;
    }
    public Node getMiddle(){
        Node currNode = head;
        for (int i= 1; i< size/2 ; i++){
            currNode =currNode.next;
        }
        return currNode;
    }

    public void getCycleList(){ // Hardcoding 3 elements in a list for a cycle
        head.next.next.next.next = head.next;
    }
    public boolean isCycle(){
        if(head == null || head.next == null) {
            return false;
        }
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle){
                getCycleNode();
                return true;
            }
        }
        return false;
    }

    public void getCycleNode() {
        if (head == null || head.next == null) {
            return;
        }
        Node hare = head;
        Node turtle = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                turtle = head;
                while (turtle != hare) {
                    hare = hare.next;
                    turtle = turtle.next;
                }
                System.out.println("Cycle is at node whose value is " + hare.data);
                break;
            }
        }
    }

        public void repairCycle() {
            if (head == null || head.next == null) {
                return;
            }
            Node hare = head;
            Node turtle = head;
            while (hare != null && hare.next != null) {
                hare = hare.next.next;
                turtle = turtle.next;
                if (hare == turtle) {
                    turtle = head;
                    while (turtle != hare) {
                        hare = hare.next;
                        turtle = turtle.next;
                    }
                // node = hare - > calculate loop length
                    int loopLength =1;
                    hare = turtle.next;
                    while(hare!= turtle){
                        hare = hare.next;
                        loopLength++;
                    }
                // break the loop
                    for (int i= 1; i< loopLength; i++){
                        turtle = turtle.next;
                    }
                    turtle.next= null;
                }
            }
        }
}
