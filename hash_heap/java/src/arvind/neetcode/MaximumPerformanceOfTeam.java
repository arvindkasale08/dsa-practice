package arvind.neetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumPerformanceOfTeam {

    int mod = 1000000007;

    class Employee {
        int speed;
        int efficiency;

        public Employee(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }
    public int maxPerformance(int n, int k, int[] speed, int[] efficiency) {
        Employee[] employees = new Employee[n];
        for (int i=0; i<n; i++) {
            employees[i] = new Employee(speed[i], efficiency[i]);
        }
        Arrays.sort(employees, (o1, o2) -> o2.efficiency - o1.efficiency);
        PriorityQueue<Employee> pq = new PriorityQueue<>((o1, o2) -> o2.speed - o1.speed);
        Queue<Employee> q = new LinkedList<>();
        int mp = 0;
        for (int i=0; i<n; i++) {
            Employee current = employees[i];
            int ts = current.speed;
            int j =0;
            while (!pq.isEmpty() && j < k-1) {
                Employee prev = pq.poll();
                ts += prev.speed;
                q.offer(prev);
                j++;
            }
            while (!q.isEmpty()) {
                pq.offer(q.poll());
            }
            int tp = ts * current.efficiency % mod;
            mp = Math.max(tp, mp);
            pq.offer(current);
        }
        return mp;
    }

    public static void main(String[] args) {
        MaximumPerformanceOfTeam solution = new MaximumPerformanceOfTeam();
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 4;
        int result = solution.maxPerformance(n, k, speed, efficiency);
        System.out.println(result);
    }
}
