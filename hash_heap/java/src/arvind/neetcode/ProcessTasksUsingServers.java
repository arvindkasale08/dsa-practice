package arvind.neetcode;

import java.util.*;

public class ProcessTasksUsingServers {

    class Server {
        int weight;
        int index;

        int activationTime;

        public Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getIndex() {
            return this.index;
        }

        public int getActivationTime() {
            return this.activationTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> serverHeap = new PriorityQueue<>(Comparator.comparingInt(Server::getWeight).thenComparing(Server::getIndex));
        PriorityQueue<Server> waitingHeap = new PriorityQueue<>(Comparator.comparingInt(Server::getActivationTime));
        int s = servers.length;
        int t = tasks.length;
        int[] ans = new int[t];
        Arrays.fill(ans, -1);
        for (int i=0; i< s; i++) {
            // put all in serverheap;
            serverHeap.offer(new Server(servers[i], i));
        }

        Queue<int[]> taskQueue = new LinkedList<>();
        for (int i=0; i< t; i++) {
            taskQueue.offer(new int[] {i, tasks[i]});
        }

        int currentTime = 0;
        while (ans[t-1] == -1) {
            // at the start of iteration always check if any waiting servers are elligible if yes put in server heap
            while (!waitingHeap.isEmpty()) {
                if (waitingHeap.peek().activationTime > currentTime) {
                    break;
                }
                serverHeap.offer(waitingHeap.poll());
            }

            // find all elligible tasks
            while (!taskQueue.isEmpty() && taskQueue.peek()[0] <= currentTime) {
                // get elligible server
                if (serverHeap.isEmpty()) {
                    break;
                }
                //remove the server
                Server server = serverHeap.poll();
                int[] task = taskQueue.poll();
                ans[task[0]] = server.index;
                server.activationTime = currentTime + task[1];
                waitingHeap.offer(server);
            }
            currentTime++;
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        ProcessTasksUsingServers solution = new ProcessTasksUsingServers();
        int[] result = solution.assignTasks(servers, tasks);
        System.out.println(Arrays.toString(result));
    }
}
