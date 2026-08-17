package com.arvind.revision.graphs;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        int nodesSeen = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.put(ch, new ArrayList<>());
                indegree.put(ch, 0);
            }
        }
        // form the graph
        for (int i=1; i<words.length; i++) {
            // find first diff character;
            int j = 0;
            String w1 = words[i-1];
            String w2 = words[i];
            boolean allSame = true;
            while (j < w1.length() && j < w2.length()) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    allSame = false;
                    break;
                }
                j++;
            }
            if(allSame && j < w1.length()) return "";
        }

        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {
            Character node = queue.poll();
            sb.append(node);
            nodesSeen++;

            for(Character c : graph.get(node)) {
                indegree.put(c, indegree.get(c) -1);
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }

        return graph.size() == nodesSeen ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = new String[] {"xza", "xzb", "yba", "ybc", "zca"};
        AlienDictionary solution = new AlienDictionary();
        System.out.println(solution.alienOrder(words));
    }
}
