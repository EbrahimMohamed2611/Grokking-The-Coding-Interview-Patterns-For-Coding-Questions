package io.educative.topologicalSort;

import java.util.*;

public class TasksScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        if (tasks <= 0)
            return false;
        List<Integer> sorted = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        buildGraphAndInDegree(graph, tasks, inDegree);
        buildEdgeAndCalcNodeInDegree(inDegree, prerequisites, graph);

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                queue.add(entry.getKey());

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            sorted.add(currentNode);
            List<Integer> neighbours = graph.get(currentNode);
            for (int child : neighbours) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    queue.add(child);
            }
        }

        return sorted.size() == tasks;
    }

    private static void buildEdgeAndCalcNodeInDegree(Map<Integer, Integer> inDegree, int[][] prerequisites, Map<Integer, List<Integer>> graph) {
        for (int[] edge : prerequisites) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
    }

    private static void buildGraphAndInDegree(Map<Integer, List<Integer>> graph, int tasks, Map<Integer, Integer> inDegree) {
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        System.out.println(isSchedulingPossible(6, new int[][]{ {2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}));
        System.out.println(isSchedulingPossible(3, new int[][]{{0,1}, {1,2}, {2,0}}));
    }
}
