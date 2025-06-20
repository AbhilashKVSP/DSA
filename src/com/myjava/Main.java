package com.myjava;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=======================Linked List =============================");

// Linked List - MyLinkedList.JAVA
        MyLinkedList myList = new MyLinkedList();
        myList.addLast("6");
        myList.addFirst("1");
        myList.addFirst("2");
        myList.addFirst("2");
        myList.addFirst("*");
        myList.addFirst("1");
        myList.addFirst("0");
        myList.printList();
        System.out.println("Reversing a List");
        myList.reverseList();
        myList.printList();
        myList.getSize();
        myList.deleteFirst();
        myList.deleteLast();
        myList.printList();

// Get nth node from last and delete => n from last = size-n+1 from first say n=3
        int num = 2;
        myList.deleteNnode(num);
        System.out.println("Deleting " + num + " number from the end");
        myList.printList();

        // To check if the list is palindrome
        boolean palindrome = myList.isPlaindrome();
        if (palindrome == true) {
            System.out.println("LinkedList is a Palindrome");
        } else {
            System.out.println("LinkedList is not a Palindrome");
        }

// To check if a linked list has cycle

        MyLinkedList myCycleList = new MyLinkedList();
        myCycleList.addFirst("4");
        myCycleList.addFirst("3");
        myCycleList.addFirst("2");
        myCycleList.addFirst("1");
        myCycleList.getCycleList();
        System.out.println("Created List: 1-> 2 -> 3 -> 4 -->2 ");
        boolean cycle = myCycleList.isCycle();
        if (cycle == true) {
            System.out.println("Created List is Cyclic");
            myCycleList.repairCycle();
            System.out.println("After Repair...");
            myCycleList.printList();
        } else {
            System.out.println("Created List is not Cyclic");
        }

// Linked List - Collection Framework
        System.out.println("==========Using Collection Framework==========");
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("Harry");
        list.add("Potter");
        for (String s : list) {
            System.out.print(s + " -> ");
        }
        System.out.println("NULL");
        System.out.println("Size of List is " + list.size());
        list.removeFirst();
        list.removeLast();

// Linked List Questions
        LinkedList<String> qstnList = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            qstnList.add(i + "_Word");
        }
        for (int i = 3; i >= 1; i--) {
            qstnList.add(i + "_Word");
        }
        System.out.println(qstnList);

// Get nth node from last and delete => n from last = size-n+1 from first say n=3
        qstnList.remove(qstnList.size() - 3);
        System.out.println("After Removing 3rd element from last");
        System.out.println(qstnList);

// Check if List is Palindrome
        int size = qstnList.size();
        palindrome = true;
        for (int i = 0; i < size / 2; i++) {
            if (!qstnList.get(i).equals(qstnList.get(size - i - 1))) palindrome = false;
        }
        if (palindrome == true) {
            System.out.println("LinkedList is a Palindrome");
        } else {
            System.out.println("LinkedList is not a Palindrome");
        }
        System.out.println("=======================Using Linked List for Stack=============================");
// Invoke MyStack. JAVA
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        System.out.println("Popping an element");
        stack.pop();
        stack.printStack();
        int peek = stack.peek();
        System.out.println("Peek is " + peek);
        System.out.println("Adding element 0 at the bottom");
        stack.addBottom(0);
        stack.printStack();
        System.out.println("Reversing a Stack");
        stack.reverse();
        stack.printStack();

        System.out.println("==========Using Collection Framework==========");

// Using collection Framework
        Stack<Integer> colStack = new Stack<>();
        colStack.push(1);
        colStack.push(2);
        colStack.push(3);
        System.out.println(colStack);
        System.out.println("Popping an element");
        colStack.pop();
        int peek2 = colStack.peek();
        System.out.println("Peek is " + peek2);
        System.out.println("Adding element 0 at the bottom");
        colStack.insertElementAt(0, 0);
        System.out.println(colStack);
        System.out.println("Reversing a Stack");
        Collections.reverse(colStack);
        System.out.println(colStack);

        System.out.println("==========Using Array List for Stack==========");

// Invoke MyStackAl
        MyStackAl stack2 = new MyStackAl();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.printStack();
        System.out.println("Popping an element");
        stack2.pop();
        stack2.printStack();
        int peek3 = stack2.peek();
        System.out.println("Peek is " + peek3);

        System.out.println("======================= Queues =============================");
        System.out.println("Using Arr[5] for Queue");
//Queue implementation using MyQueue
        MyQueue que = new MyQueue(5);
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println("Created Queue is : ");
        while (!que.isEmpty()) {
            System.out.println(que.peek());
            que.remove();
        }
//Queue implementation using LinkedList MyQueue
        LLQueue LLque = new LLQueue();
        LLque.add(1);
        LLque.add(2);
        LLque.add(3);
        System.out.println("Created Linked list Queue is : ");
        while (!LLque.isEmpty()) {
            System.out.println(LLque.peek());
            LLque.remove();
        }
//Queue implementation using Stacks MyQueue
        StQueue StQ = new StQueue();
        StQ.add(1);
        StQ.add(2);
        StQ.add(3);
        System.out.println("Created Queue using Stacks is : ");
        while (!StQ.isEmpty()) {
            System.out.println(StQ.peek());
            StQ.remove();
        }
        System.out.println("==========Using collection Framework==========");
// Queue using collection framework
//        Queue<Integer> ColQ = new ArrayDeque<>();
        Queue<Integer> ColQ = new LinkedList<>();
        ColQ.add(1);
        ColQ.add(2);
        ColQ.add(3);
        System.out.println("Created Linked list Queue is : ");
        while (!ColQ.isEmpty()) {
            System.out.println(ColQ.peek());
            ColQ.remove();
        }
        System.out.println("==========Circular Queue ==========");

//Queue implementation using MyQueue
        circularQueue cQueue = new circularQueue(4);
        cQueue.add(1);
        cQueue.add(2);
        cQueue.add(3);
        cQueue.remove();
        cQueue.add(4);
        cQueue.add(0);
        System.out.println("Created Circular Queue is : ");
        while (!cQueue.isEmpty()) {
            System.out.println(cQueue.peek());
            cQueue.remove();
        }
        System.out.println("==========Binary Tree for given preorder ==========");

// Binary Tree Implementations
        int[] preOrderNodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        MyTrees myTree = new MyTrees();
        MyTrees.Node rootNode;
        rootNode = myTree.arrangeNodes(preOrderNodes);
        System.out.println("Root Node data for the preorder given is " + rootNode.data);
        System.out.print("Printing Preorder : ");
        myTree.getPreOrder(rootNode);
        System.out.print("\nPrinting inOrder : ");
        myTree.getInOrder(rootNode);
        System.out.print("\nPrinting Postorder : ");
        myTree.getPostOrder(rootNode);
        System.out.println("\nPrinting levelOrder :  ");
        myTree.getlevelOrder(rootNode);
        System.out.println("Total No. of nodes in the tree is : " + myTree.getNodesCount(rootNode));
        System.out.println("Sum of nodes in the tree is : " + myTree.getSum(rootNode));
        System.out.println("Height of nodes in the tree is : " + myTree.getHeight(rootNode));
        System.out.println("Diameter of nodes in the tree is : " + myTree.diameter(rootNode));
        MyTrees.treeInfo heightTreeInfo;
        heightTreeInfo = myTree.diameterOpt(rootNode);
        System.out.println("Via O(N) the height and diameter of tree is : " + heightTreeInfo.height + " and " + heightTreeInfo.diameter);
        boolean IsSubTree = myTree.IsSubTree(rootNode, rootNode);
        if (IsSubTree) System.out.println("Given subtree and tree relation exists");
        else System.out.println("Given subtree and tree relation does not exists");
        System.out.println("Sum of nodes at level 3 is " + myTree.levelNodeSum(rootNode, 3));
// Binary Search Tree Implementations
        System.out.println("===================== BINARY SEARCH TREE ==================");
        int[] BSTNodes = {5, 1, 3, 4, 2, 7};
        BinaryTree Bst = new BinaryTree();
        BinaryTree.Node root = null;
        for (int i = 0; i < BSTNodes.length; i++) {
            root = Bst.insert(root, BSTNodes[i]);
        }
        System.out.println("In Order Traversal of BST is : ");
        Bst.inOrder(root);
        System.out.println();
        boolean searchKey = Bst.searchKey(root, 6);
        if (searchKey == true) System.out.println("Key found");
        else System.out.println("Key Not found");
        Bst.getPaths(root, new ArrayList<>());
        System.out.println("Deleting the two node value 3");
        Bst.deleteNode(root, 3);
        Bst.inOrder(root);
        System.out.println();
        System.out.println("Printing in range of 2 and 6");
        Bst.printInRange(root, 2, 6);
        System.out.println();
// Hash set using collection Framework
        System.out.println("===================== HASH SET USING COLLECTION FRAMEWORK ==================");
        //Create
        HashSet<Integer> set = new HashSet<>();
        //Insert -> add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        // Search - contains
        if (set.contains(2)) System.out.println("Set contains 2");
        if (!set.contains(6)) System.out.println("Set does not contains 6");
        // Delete -> remove
        set.remove(2);
        if (!set.contains(2)) System.out.println("Set does not contains 2. We deleted 2");
        System.out.println("Size of set is " + set.size());
        System.out.println("Set is : " + set);
        //Iterator => java.utils.iterator
        Iterator It = set.iterator();
        // hasNext and Next
        while (It.hasNext()) {
            System.out.print(It.next());
        }
        System.out.println();
// Hash Map using collection Framework
        System.out.println("===================== HASH MAP USING COLLECTION FRAMEWORK ==================");
        //Create
        // Country (key) and Population (Int)
        HashMap<String, Integer> map = new HashMap<>();
        //Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);
        //print
        System.out.println(map);
        map.put("India", 160); // This updates the value
        System.out.println(map);
        // Search
        if (map.containsKey("China")) System.out.println("We have data of China");
        else System.out.println("We do not have data of China");
        System.out.println("Value for China is " + map.get("China"));
        // Iterate
        System.out.println("Using Iteration : ");
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        System.out.println("Other Iteration ");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        // Remove pair
        map.remove("China");
        System.out.println("Deleting China" + map);

        System.out.println("Using Enum");
        enum days {
            SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
        }
        Set<days> set1 = EnumSet.allOf(days.class);
        System.out.println("Week Days:"+set1);
        Set<days> set2 = EnumSet.noneOf(days.class);
        System.out.println("Week Days:"+set2);

// HashMap from implementation
        System.out.println("===================== HASH MAP USING Implementation ==================");
        MyHashMap Hm = new MyHashMap();
        MyHashMap.HashMap<String, Integer> myMap = new MyHashMap.HashMap<>();
        System.out.println("Adding key value pairs under MyHashMap ");
        myMap.put("India", 190);
        myMap.put("China", 220);
        myMap.put("USA", 50);
        System.out.println("value of China is : " + myMap.get("China"));
        ArrayList<String> Allkeys = myMap.Allkeyset();
        for (int i = 0; i < Allkeys.size(); i++) {
            System.out.println(Allkeys.get(i) + " " + myMap.get(Allkeys.get(i)));
        }
        myMap.remove("India");
        System.out.println("After Removing key its value is: " + myMap.get("India"));

// Questions on Hashset and Hashmap
        // Map for list of numbers and frequency
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                int exFreq = numMap.get(nums[i]);
                numMap.put(nums[i], ++exFreq);
            } else {
                numMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : numMap.entrySet()) {
            if (e.getValue() > (nums.length / 3)) {
                System.out.println(e.getKey());
            }
        }
        // union of 2 arrays
        System.out.println("Union of two arrays");
        int arr1[] = {7, 3, 9, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> numSet = new HashSet<>();
        for (int i : arr1) {
            numSet.add(i);
        }
        for (int i : arr2) {
            numSet.add(i);
        }
        System.out.println(numSet);
        //Intersection of 2 Arrays
        System.out.println("Intersection of two arrays");
        HashSet<Integer> uniqArr1 = new HashSet<>();
        for (int i : arr1) {
            uniqArr1.add(i);
        }
        for (int i : arr2) {
            if (uniqArr1.size() == 0) break;
            else if (uniqArr1.contains(i)) {
                System.out.print(i + " ");
                uniqArr1.remove(i); // To not repeat
            }
        }
        System.out.println();
        // Find Itinerary from Tickets
        HashMap<String, String> routes = new HashMap<>();
        routes.put("Chennai", "Bengaluru");
        routes.put("Mumbai", "Delhi");
        routes.put("Goa", "Chennai");
        routes.put("Delhi", "Goa");
        String routeStart = null;
        for (String start : routes.keySet()) {
            if (!routes.values().contains(start)) {
                routeStart = start;
                break;
            }
        }
        while (routeStart != null) {
            System.out.print(routeStart + " -> ");
            routeStart = routes.get(routeStart);
        }
        System.out.println();

        // Find no.of  SubArrays whose sum = 10
        int arr[] = {10, 2, -2, -20, 10};
        int k = 10; // given
        HashMap<Integer, Integer> mapfreq = new HashMap<>();// Map to store Sum and freq
        mapfreq.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (mapfreq.containsKey(sum - k)) {
                count += mapfreq.get(sum - k);
            }
            if (mapfreq.containsKey(sum)) {
                mapfreq.put(sum, mapfreq.get(sum) + 1);
            } else {
                mapfreq.put(sum, 1);
            }
        }
        System.out.println(count);

        System.out.println("===================== TRIE USING Implementation ==================");
// MyTrie Implementation
        MyTrie tri = new MyTrie();
        String words[] = {"the","a","there","their","any"};
        for(String i : words){
            tri.insert(i);
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Search for there : " + tri.search("there"));
        System.out.println("Search for thor : " + tri.search("thor"));
        System.out.println("Search for an : " + tri.search("an"));

// Trie Questions
        MyTrie qtri1 = new MyTrie();
        String Qwords[] = {"i","like","sam","samsung","mobile"};
        String Key = "ilikesamsung";
        for(String i : Qwords){
            qtri1.insert(i);
            System.out.print(i + " ");
        }
        System.out.println();
        boolean canSplit = qtri1.wordBreak(Key);
        System.out.println("Array if it can have words to split key : " + canSplit);
        boolean swExists = qtri1.startsWith("sams");
        System.out.println("Array to contain sams as a starts with : " + swExists);

        MyTrie qtri2 = new MyTrie();
        String qstr = "ababa";
        for(int i=0; i<qstr.length();i++){
            String suffix = qstr.substring(i);
            qtri2.insert(suffix);
        }
        System.out.println("Unique Substrings of the words are of count : " +qtri2.countUniqSubstrings());

        MyTrie qtri3 = new MyTrie();
        String q3words[] ={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<q3words.length;i++){
            qtri3.insert(q3words[i]);
        }
        System.out.print("Longest word where all prefix exists for the words is : ");
        qtri3.getLongestWord();

        System.out.println("===================== GRAPH USING Implementation ==================");

// Graph - Implementation
        int V = 7; // nodes Count
        MyGraph newGraph = new MyGraph();
        ArrayList<MyGraph.Edge> graph[] = new ArrayList[V];

        newGraph.createGraph(graph);

        System.out.print("Printing Neighbours of source 2 : ");
        //Print 2's Neighbours
        for(int i=0; i<graph[2].size();i++){
            MyGraph.Edge e = graph[2].get(i);
            System.out.print (e.dest + " ");
        }
        System.out.println();

// BFS Traversal

        System.out.print("BFS Traversal output : "); // O(V+E)

        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++){ // To check for any disconnected nodes as well.
            if(vis[i] == false){
                newGraph.bfs(graph,V,vis,i);
            }
        }
        System.out.println();
// DFS Traversal
        System.out.print("DFS Traversal output : "); // O(V+E)
        boolean vis2[] = new boolean[V];
        for(int i=0; i<V; i++){ // To check for any disconnected nodes as well.
            if(vis2[i] == false){
                newGraph.dfs(graph,i,vis2);
            }
        }
        System.out.println();

// Printing all paths from one source to destination

        System.out.println("Printing all paths from 0 to 5 : ");
        int src = 0, tar= 5;
        newGraph.printAllPaths(graph,new boolean[V],src,"0",tar);

        int v2 = 4;
        MyGraph newGraph2 = new MyGraph();
        ArrayList<MyGraph.Edge> cyclicGraph[] = new ArrayList[v2];

        newGraph2.createCyclicGraph(cyclicGraph);
        System.out.println("Testing for a cycle Detection : " + newGraph2.isCyclic(cyclicGraph,new boolean [v2],0,new boolean[v2]));

// Topological Sort

        int v3 = 6;
        MyGraph newGraph3 = new MyGraph();
        ArrayList<MyGraph.Edge> SortGraph[] = new ArrayList[v3];

        newGraph3.CreateGraph3(SortGraph);
        newGraph3.topSort(SortGraph,v3);
        System.out.println();

// Undirected Graph - Cyclic
        int v4 = 6;
        MyGraph newGraph4 = new MyGraph();
        ArrayList<MyGraph.Edge> cyclilcUndirGraph[] = new ArrayList[v3];

        newGraph4.CreateGraph4(cyclilcUndirGraph);
        System.out.println("Checking if Undirected Graph is cyclic : " + newGraph4.isUndirectedCyclic(cyclilcUndirGraph, new boolean [v4],0, -1));

    }
}
