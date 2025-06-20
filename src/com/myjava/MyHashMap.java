package com.myjava;
import java.util.*;

public class MyHashMap {
    static class HashMap<k,v>{
        private class Node{
            k key;
            v value;
            public Node(k key, v value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // nodes
        private int N; // Array length
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0; i< N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(k Key){
            int bi = Key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchInLL(k key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di= 0;
            for(int i=0; i< ll.size(); i++){
                if(ll.get(i).key == key) return i;
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0 ; i< N*2; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public void put(k key, v value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); // data index
            if(di == -1){ // data does not exist
                buckets[bi].add(new Node(key,value));
                n++;
            } else{ // key exists
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda = (double) n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public v get(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); // data index
            if(di == -1){ // data does not exist
                return null;
            }
            else{ // key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
// Check if a node exists
        public boolean containsKey(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); // data index
            if(di == -1){ // data does not exist
                return false;
            }
            else{ // key exists
                return true;
            }
        }
// Removing a node
        public v remove(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi); // data index
            if(di == -1){ // data does not exist
                return null ;
            }
            else{ // key exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n==0;
        }
        public ArrayList<k> Allkeyset(){
            ArrayList<k> keys = new ArrayList<>();
            for(int i=0; i<buckets.length ; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

    }
}
