package com.myjava;

import java.util.ArrayList;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data = data;
        }
    }

    public static Node insert( Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data> val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public boolean searchKey (Node root, int key){
        if(root == null) return false;
        if(root.data < key){
            return searchKey(root.right,key);
        }
        else if(root.data == key) {
            return true;
        }
        else {
            return searchKey(root.left, key);
        }
    }
    public Node inorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public Node deleteNode(Node root, int val){
        if(root.data > val){
            root.left = deleteNode(root.left,val);
        }
        else if(root.data < val){
            root.right = deleteNode(root.right,val);
        }
        else{ // root.data == val
            //Case 1 - single leaf Node
            if(root.right == null && root.left == null){
                return null;
            }
            // Case 2 -> single node
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            // Case 3 two nodes exists for it
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right,IS.data);
        }
        return root;
    }

    public void printInRange(Node root, int x, int y){
        if(root == null) return;
        if(root.data >= x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data + " ");
            printInRange(root.right,x,y);
        }
        else if(root.data > y){
            printInRange(root.left,x,y);
        }
        else{
            printInRange(root.right,x,y);
        }
    }
    public void printPath(ArrayList<Integer> path){
        for(int i=0; i< path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public void getPaths(Node root, ArrayList<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            getPaths(root.left,path);
            getPaths(root.right,path);
        }
        path.remove(path.size()-1);
    }

}
