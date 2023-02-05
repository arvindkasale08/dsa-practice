import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> valueMap = new HashMap<>() {
            {
                put('~', 0);
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int total = 0;
        int i =0;
        while (i<s.length()) {
            char now = s.charAt(i);
            char next = i == s.length() - 1 ? '~': s.charAt(i+1);

            if (valueMap.get(now) < valueMap.get(next)) {
                // something like CM is present
                total -= valueMap.get(now);
                total += valueMap.get(next);
                i += 2;
            } else {
                total += valueMap.get(now);
                i += 1;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger solution = new RomanToInteger();
        int result = solution.romanToInt(s);
        System.out.println(result);
    }
}
