package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int orderCounter = 0;
        int coursesSeen = 0;
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            indegree[p[0]]+=1;
            graph.get(p[1]).add(p[0]);
        }

        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            coursesSeen++;
            order[orderCounter] = node;
            orderCounter++;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return coursesSeen == numCourses ? order : new int[]{};
    }

    public static void main(String[] args) {
        int[][] prereq = new int[][] {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int numCourses = 4;
        CourseScheduleII solution = new CourseScheduleII();
        CommonUtils.print(solution.findOrder(numCourses, prereq));
    }
}
