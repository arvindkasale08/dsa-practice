package arvind.p1;

public class FrogJump {

    public int findDays(int h) {
        int frog = 0;
        int day = 0;

        while (true) {
            day+=1;
            frog+=3;

            if (frog >= h)
                break;

            frog-=1;
        }
        return day;
    }

    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int h = 10;
        int days = solution.findDays(h);
        System.out.println(days);
    }
}
