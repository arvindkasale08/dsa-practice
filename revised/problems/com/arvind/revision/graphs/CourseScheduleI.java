package com.arvind.revision.graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (visited[i] == 0) {
                if(!dfs(i, graph, visited, pathVisited)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, List<List<Integer>> graph, int[] visited, int[] pathVisited) {
        if (pathVisited[i] == 1) return false; // path visited has to be checked first

        if (visited[i] == 1) return true;
        visited[i] = 1;
        pathVisited[i] = 1;
        for (int neighbor : graph.get(i)) {
            if (!dfs(neighbor, graph, visited, pathVisited)) return false;
        }
        pathVisited[i] = 0;
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {{1, 0},};
        int numCourses = 2;
        CourseScheduleI solution = new CourseScheduleI();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}
