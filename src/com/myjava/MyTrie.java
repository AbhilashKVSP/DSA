package com.myjava;

public class MyTrie {

    class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26]; //a to z
            for(int i=0 ; i< 26; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    Node root  = new Node();

// Inserting words
    public void insert (String word){
        Node curr = root;
        for(int i=0; i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
// Search in a trie
    public boolean search(String word){
        Node curr = root;
        for(int i =0; i<word.length();i++){
            int idx = word.charAt(i)- 'a';
            Node node = curr.children[idx];

            if(node == null) return false;

            if(i == word.length()-1 && node.eow == false) return false;

            curr = curr.children[idx];

            }
        return true;
    }
// wordBreak in Trie
    public boolean wordBreak(String Key){
        if(Key.length() == 0) return true;
        for(int i=1; i<=Key.length(); i++){
            String firstPart = Key.substring(0,i);
            String secondPart = Key.substring(i);
            if(search(firstPart) && wordBreak(secondPart)) return true;
        }
        return false;
    }
// Starts with
    public boolean startsWith(String key){
        Node curr = root;
        for(int i =0; i<key.length();i++){
            int idx = key.charAt(i)- 'a';
            Node node = curr.children[idx];

            if(node == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
// Count Nodes
    public int countNodes(Node root){
        if(root == null) return 0;
        int count =0;
        for(int i=0; i<26; i++){
            if(root.children[i] !=null) {
                count+=countNodes(root.children[i]);
            }
        }
        return 1+count;
    }

    public int countUniqSubstrings(){
        Node curr = root;
        return countNodes(curr);
    }
// longest Word
    public String ans = "";
    public void longestWord(Node root, StringBuilder temp){

        for(int i=0; i<26 ; i++){
            if(root.children[i] !=null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
    public void getLongestWord(){
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}
