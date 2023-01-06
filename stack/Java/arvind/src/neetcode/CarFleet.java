package neetcode;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    class Car {
        int position;
        int speed;
        double time;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n= position.length;
        Car[] cars = new Car[n];

        for (int i=0; i<n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> o2.position - o1.position);
        Stack<Car> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            Car car = cars[i];
            car.time = (double) (target - car.position) / car.speed;
            if (stack.isEmpty()) {
                stack.push(car);
                continue;
            }

            Car popped = stack.peek();
            if (car.time > popped.time) {
                stack.push(car);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet solution = new CarFleet();
        int target = 10;
        int[] position = {6, 8};
        int[] speed = {3, 2};
        int fleets = solution.carFleet(target, position, speed);
        System.out.println(fleets);
    }
}
