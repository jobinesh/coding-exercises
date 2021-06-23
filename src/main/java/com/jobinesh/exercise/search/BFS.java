package com.jobinesh.exercise.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class BFS<T> {

    public Optional<T> search(Node<T> graph, T value) {
        Set<Node<T>> visited = new HashSet<>();
        Queue<Node<T>> q = new LinkedList<>();
        q.add(graph);
        while(!q.isEmpty()){
            Node<T> node = q.poll();
            if(node.getValue().equals(value)){
                print(node.getValue().toString());
                print("Found value");
                return Optional.of(node.getValue());
            }
            print(node.getValue().toString());
            /*
            node.getNeighbours().forEach( (n)->{
                if(!q.contains(n)){
                    q.add(n);
                }
            });*/
            visited.add(node);
            q.addAll(node.getNeighbours());
            q.removeAll(visited);
        }
        return Optional.empty();
    }

    public Optional<T> search(Tree<T> tree, T value) {
        Queue<Tree<T>> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            Tree<T> t = q.poll();
            if (t.getValue().equals(value)) {
                print(t.getValue().toString());
                print("Found value");
                return Optional.of(t.getValue());
            }
            List<Tree<T>> children = t.getChildren();
            children.forEach(child -> q.add(child));
            print(t.getValue().toString());
        }
        return Optional.empty();
    }

    private void print(String msg) {
        System.out.println(msg);
    }

    public static void testTree() {
        Tree<Integer> root = new Tree<>(10);
        Tree<Integer> rootFirstChild = new Tree<>(2);
        root.addChild(rootFirstChild);
        Tree<Integer> depthMostChild = new Tree<>(3);
        rootFirstChild.addChild(depthMostChild);
        Tree<Integer> rootSecondChild = new Tree<>(4);
        root.addChild(rootSecondChild);
        BFS<Integer> bfs = new BFS<>();
        bfs.search(root, 3);
    }

    public static void testGraph() {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(start);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        BFS<Integer> bfs = new BFS<>();
        bfs.search(firstNeighborNeighbor, 4);
    }

    public static void main(String[] arg) {

        testGraph();
    }
}
