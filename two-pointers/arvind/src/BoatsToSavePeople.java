import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int nooFBoats = 0;
        while (l <= r) {
            if(people[l] + people[r] <= limit) {
                l += 1;
                r -= 1;
            } else {
                r -= 1;
            }
            nooFBoats += 1;
        }
        return nooFBoats;
    }

    public static void main(String[] args) {
        BoatsToSavePeople solution = new BoatsToSavePeople();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int boats = solution.numRescueBoats(people, limit);
        System.out.println(boats);
    }
}
