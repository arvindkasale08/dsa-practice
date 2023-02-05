import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> valueMap = new HashMap<>() {
            {
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");
            }
        };
        int[] indexes = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder res = new StringBuilder();
        for (int i=0; i<indexes.length; i++) {
            if (num < indexes[i]) {
                continue;
            }
            while (num >= indexes[i]) {
                res.append(valueMap.get(indexes[i]));
                num -= indexes[i];
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 1994;
        String res = solution.intToRoman(num);
        System.out.println(res);
    }
}
