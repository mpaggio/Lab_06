package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{

    public void addNode(N node);

    public void addEdge(N source, N target);

    public Set<N> nodeSet();

    public Set<N> linkedNodes(N node);

    public List<N> getPath(N source, N target);

}