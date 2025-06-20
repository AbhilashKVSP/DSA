package com.myjava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {

    // Undirected and Unweighted
    static class Edge {
        int src;
        int dest;
//      int weight;  -> if its weighted

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
//          this.weight = 0;  -> if its weighted
        }
    }

// Create Graph

    public void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
//      graph[0].add(new Edge(0,2,1);
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public void createCyclicGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }

    public void CreateGraph3(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public void CreateGraph4(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
//        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
//        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
    }

// Breadth first Algorithm

    public void bfs(ArrayList<Edge> graph[], int v, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

// Depth first Algorithm

    public void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph,e.dest,vis);
            }
        }
    }

// To print all paths from Source to Destination -  O(V^V)

    public void printAllPaths(ArrayList<Edge> graph[],boolean vis[], int curr, String path, int tar){
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAllPaths(graph,vis,e.dest,path+e.dest,tar);
                vis[curr] = false;
            }
        }
    }

// Cycle Detection for Directed Graph

    public boolean isCyclic(ArrayList<Edge> graph[],boolean vis[],int curr, boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest]) {
                if(isCyclic(graph, vis, e.dest, rec)){
                    return true;
                };
            }
        }
        rec[curr] = false;
        return false;
    }

// Cycle Detection for Undirected Graph

    public boolean isUndirectedCyclic(ArrayList<Edge> graph[],boolean vis[],int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] && parent!=e.dest) {
                return true;
            } else if (!vis[e.dest]) {
                if(isUndirectedCyclic(graph, vis, e.dest, curr)){
                    return true;
                };
            }
        }
        return false;
    }

// Topological Sort

    public void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[],Stack<Integer> stack){
        vis[curr] = true;

        for(int i=0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph,e.dest,vis,stack);
            }
        }
        stack.push(curr);
    }

    public void topSort(ArrayList<Edge> graph[],int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,stack);
            }
        }
        System.out.println("Topological Order is : ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " -> ");
        }
    }

}
