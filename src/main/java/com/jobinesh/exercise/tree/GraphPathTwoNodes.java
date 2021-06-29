package com.jobinesh.exercise.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Find if there is a path between two vertices in a directed graph
 */
public class GraphPathTwoNodes<T> {
    public boolean search(GraphNode<T> graph, GraphNode<T> s, GraphNode<T> e) {
        Queue<GraphNode<T>> queue = new LinkedList<>();
        HashSet<GraphNode<T>> visited = new HashSet<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            GraphNode<T> current = queue.poll();
            visited.add(current);
            if (current.equals(e)) {
                return true;
            }
            Set<GraphNode<T>> neighbours = current.getNeighbours();
            //neighbours.stream().filter(item->!visited.contains(item)).collect(queue::add)
            neighbours.forEach(item -> {
                if (!visited.contains(item)) {
                    queue.add(item);
                }
            });
        }
        return false;
    }


    public static void main(String args[]) {
        GraphNode<Integer> start = new GraphNode<>(10);
        GraphNode<Integer> firstNeighbor = new GraphNode<>(2);
        start.connect(firstNeighbor);

        GraphNode<Integer> firstNeighborNeighbor = new GraphNode<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        GraphNode<Integer> secondNeighbor = new GraphNode<>(4);
        start.connect(secondNeighbor);

        GraphPathTwoNodes<Integer> bfs = new GraphPathTwoNodes<>();
        boolean result =bfs.search(start,start,  new GraphNode<>(4));
        System.out.println(result);
    }
}
