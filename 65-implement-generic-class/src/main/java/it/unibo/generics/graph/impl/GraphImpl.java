package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class GraphImpl<N> implements Graph<N>{
    private static String WHITE = "WHITE";
    private static String GRAY = "GRAY";
    private static String BLACK = "BLACK";
    private final Map<N,Set<N>> edgesMap = new LinkedHashMap<>();

    private boolean nodeExist(N node){
        if(node != null && this.edgesMap.containsKey(node)){
            return true;
        }
        return false;
    }
    
    /* Adds a node: nothing happens if node is null or already there. */
    public void addNode(N node){
        if(node != null && !this.edgesMap.containsKey(node)){
            this.edgesMap.put(node, new HashSet<>());
        }
    }

    /* Adds an edge: nothing happens if source or target are null. */
    public void addEdge(N source, N target){
        if(nodeExist(source) && nodeExist(target)){
            this.edgesMap.get(source).add(target);
        }
    }

    /* Return all the nodes */
    public Set<N> nodeSet(){
        return new HashSet<>(this.edgesMap.keySet());
    }

    /* Returns all the nodes directly targeted from a node. */
    public Set<N> linkedNodes(N node){
        return this.edgesMap.get(node);
    }

    private void bfs(N source, N target){
        Map<N,String> nodeColor = new HashSet<>();
        Map<N, N> parent = new HashMap<>();
        Queue<N> queue = new LinkedList<>();
        for (N node : this.edgesMap.keySet()){
            nodeColor.put(node, WHITE);
               parent.put(node, null);
        }
        nodeColor.replace(source, WHITE, GRAY);
        queue.add(source);
        while (!queue.isEmpty()) {
            N currentNode = queue.poll();
            for (N elem : this.edgesMap.get(currentNode)) {
                if (nodeColor.get(elem) == WHITE) {
                    nodeColor.replace(elem, WHITE, GRAY);
                    parent.put(elem, currentNode);
                    queue.add(elem);
                }
            }
            nodeColor.replace(currentNode, GRAY, BLACK)
        }
    }

    /* Gets one sequence of nodes connecting source to target. 
       Using BFS method. */

    public List<N> getPathWithBFS(N source, N target){
        if(nodeExist(source) && nodeExist(target)){
            List<N> path = new LinkedList<>();
            N node = target;
            bfs(source, target);
            while(node != source){

            }
        }
        return new ArrayList<>();
    }
}