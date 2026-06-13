package com.arvind.revision.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {


    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Node> stack = new Stack<>();

        for (String s: logs) {
            Node currentNode = new Node(s);
            if (!stack.isEmpty()) {
                Node lastNode = stack.peek();
                if (currentNode.type.equals("start")) {
                    res[lastNode.taskId] += currentNode.index - lastNode.index;
                    stack.push(currentNode);
                } else if (currentNode.type.equals("end")) {
                    res[currentNode.taskId] += currentNode.index - lastNode.index + 1;
                    stack.pop(); // popped the last coresponding start node
                    if (!stack.isEmpty()) {
                        Node previousStartNode = stack.pop();
                        previousStartNode.index = currentNode.index + 1;
                        stack.push(previousStartNode);
                    }
                }
            } else {
                stack.push(currentNode);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] logs1 = new String[] {"0:start:0","1:start:2","1:end:5","0:end:6"};
        String[] logs2 = new String[] {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        String[] logs3 = new String[] {"0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"};
        String[] logs4 = new String[] {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
        ExclusiveTimeOfFunctions solution = new ExclusiveTimeOfFunctions();
        int[] res = solution.exclusiveTime(2, Arrays.asList(logs1));
        int[] res2 = solution.exclusiveTime(1, Arrays.asList(logs2));
        int[] res3 = solution.exclusiveTime(2, Arrays.asList(logs3));
        int[] res4 = solution.exclusiveTime(2, Arrays.asList(logs4));
        print(res);
        print(res2);
        print(res3);
        print(res4);
    }

    private static void print(int[] arr) {
        for (int i: arr) {
            System.out.print(i+ ", ");
        }
        System.out.println("\n###################");
    }

    class Node {
        int taskId;
        int index;
        String type;

        public Node(String log) {
            String[] s = log.split(":");
            taskId = Integer.parseInt(s[0]);
            index = Integer.parseInt(s[2]);
            type = s[1];
        }
    }
}
