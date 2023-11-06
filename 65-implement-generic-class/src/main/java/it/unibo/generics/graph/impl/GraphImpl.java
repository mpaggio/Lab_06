package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;
import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraphImpl<N> implements Graph<N>{
    private final Map<N,Set<N>> edgesMap = new LinkedHashMap<>();

    /* Adds a node: nothing happens if node is null or already there. */
    public void addNode(N node){
        if(node != null && !this.edgesMap.containsKey(node)){
            this.edgesMap.put(node, new HashSet<>());
        }
    }

    /* Adds an edge: nothing happens if source or target are null. */
    public void addEdge(N source, N target){
        if(source != null && target != null){
            if(this.edgesMap.containsKey(source) && this.edgesMap.containsKey(target)){
                this.edgesMap.get(source).add(target);
            }
        }
    }

    /* Return all the nodes */
    public Set<N> nodeSet(){
        return new HashSet<>(this.edgesMap.keySet());
    }

    /* Returns all the nodes directly targeted from a node. */
    public Set<N> linkedNodes(N node){
        return null;
    }

    /* Gets one sequence of nodes connecting source to target. */
    public List<N> getPath(N source, N target){
        return null;
    }

}