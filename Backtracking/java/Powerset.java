import java.util.*;
public class Powerset {
    public static void findPowerSet(char []s, Deque<Character> res,int n){
        if (n == 0){
            for (Character element : res)
                System.out.print(element);
            System.out.println();
            return;
        }
        res.addLast(s[n - 1]);
        findPowerSet(s, res, n - 1);
        res.removeLast();
        findPowerSet(s, res, n - 1);
    }

    public static void main(String[] args)
    {
        char []set = {'a', 'b', 'c'};
        Deque<Character> res = new ArrayDeque<>();
        findPowerSet(set, res, 3);
    }
    }

