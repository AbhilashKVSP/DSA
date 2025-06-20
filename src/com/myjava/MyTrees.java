package com.myjava;

import java.util.LinkedList;
import java.util.Queue;

public class MyTrees {

    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    int idx = -1;
    public Node arrangeNodes(int[] nodes){
        idx++;
        if(nodes[idx] == -1) return null;

        Node newNode = new Node(nodes[idx]);
        newNode.left = arrangeNodes(nodes);
        newNode.right = arrangeNodes(nodes);

        return newNode;
    }
    public void getPreOrder(Node rootNode) {
        if(rootNode == null){
//            System.out.print("-1 ");
            return;
        }
        System.out.print( rootNode.data + " ");
        getPreOrder(rootNode.left);
        getPreOrder(rootNode.right);
    }
    public void getInOrder(Node rootNode) {
        if(rootNode == null){
//            System.out.print("-1 ");
            return;
        }
        getInOrder(rootNode.left);
        System.out.print( rootNode.data + " ");
        getInOrder(rootNode.right);
    }
    public void getPostOrder(Node rootNode) {
        if(rootNode == null){
//            System.out.print("-1 ");
            return;
        }
        getPostOrder(rootNode.left);
        getPostOrder(rootNode.right);
        System.out.print( rootNode.data + " ");
    }

    public void getlevelOrder(Node rootNode) {
        Queue<Node> que = new LinkedList<>();
        if(rootNode == null) return;
        que.add(rootNode);
        que.add(null);
        while(!que.isEmpty()){
            Node currNode = que.remove();
            if(currNode == null){
                System.out.println();
                if(que.isEmpty()){
                    break;
                }
                else{
                    que.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null) que.add(currNode.left);
                if(currNode.right != null) que.add(currNode.right);
            }
        }
    }
    public int getNodesCount(Node root){
        if(root == null) return 0;
        int subLeftTreecount = getNodesCount(root.left);
        int subRightTreecount = getNodesCount(root.right);
        return subLeftTreecount+subRightTreecount+1;
    }
    public int getSum(Node root) {
        if (root == null) return 0;
        int subLeftTreeSum = getSum(root.left);
        int subRightTreeSum = getSum(root.right);
        return subLeftTreeSum + subRightTreeSum + root.data;
    }
    public int getHeight(Node root) {
        if (root == null) return 0;
        int subLeftTreeHeight = getHeight(root.left);
        int subRightTreeHeight = getHeight(root.right);
        return Math.max(subLeftTreeHeight,subRightTreeHeight)+1;
    }

    public int diameter(Node root){
        if(root == null) return 0;
        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);
        int diaRoot = getHeight(root.left) + getHeight(root.right) + 1;
        return Math.max(diaRoot,Math.max(diameterRight,diameterLeft));
    }

    class treeInfo{
        int height;
        int diameter;
        treeInfo(int ht, int diameter){
            this.height = ht;
            this.diameter = diameter;
        }
    }
    public treeInfo diameterOpt(Node root){
        if(root == null) return new treeInfo(0,0);
        treeInfo leftTree = diameterOpt(root.left);
        treeInfo righTree = diameterOpt(root.right);
        int currHeight = Math.max(leftTree.height,righTree.height)+1;

        int leftDia = leftTree.diameter;
        int rightDia = righTree.diameter;
        int rootDia = leftTree.height + righTree.height +1;

        int currDia = Math.max(Math.max(leftDia,rightDia),rootDia);
        return new treeInfo(currHeight,currDia);
    }

    public boolean IsIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.data == subRoot.data) {
            return IsIdentical(root.left, subRoot.left) && IsIdentical(root.right, subRoot.right);
        }
        else return false;
    }
    public boolean IsSubTree(Node root, Node subRoot){
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.data == subRoot.data){
            if(IsIdentical(root,subRoot)) return true;
        }
        return IsSubTree(root.left,subRoot) || IsSubTree(root.right,subRoot);
    }

    public int levelNodeSum(Node rootNode, int i) {
        Queue<Node> qu = new LinkedList<>();
        int idx = 1;
        int sum =0;
        qu.add(rootNode);
        qu.add(null);
        while(!qu.isEmpty()){
            if(idx == i){
                Node levelNode =  qu.peek();
                while(qu.peek()!=null){
                    sum+= qu.remove().data;
                }
                return sum;
            }
            Node currNode = qu.remove();
            if(currNode == null){
                idx++;
                if(qu.isEmpty()){
                    break;
                }
                else{
                    qu.add(null);
                }
            }
            else{
                if(currNode.left != null) qu.add(currNode.left);
                if(currNode.right != null) qu.add(currNode.right);
            }

        }
        return sum;
    }
}
