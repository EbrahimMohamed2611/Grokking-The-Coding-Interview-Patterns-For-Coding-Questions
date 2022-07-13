package io.educative.topologicalSort;

import java.util.*;

public class TopologicalSort {

    public List<Integer> topologicalSort(int vertices, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        if (vertices == 0)
            return sorted;
        // (1) first we need to build Graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            // all vertices numbered from 0 to n
            inDegree.put(i, 0); // initialize all vertices with 0 degree
            graph.put(i, new ArrayList<>());
        }

        // (2) build Graph (connect each vertex with edges
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
        }

        // (3) Get All Sources Only To Iterate over them only
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        while (!sources.isEmpty()) {
            Integer currentSource = sources.poll();
            sorted.add(currentSource);
            List<Integer> currentChildren = graph.get(currentSource);
            for (int child : currentChildren) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sorted.add(child);
            }
        }
        if (sorted.size() != vertices)
            return new ArrayList<>();

        return sorted;
    }
}
