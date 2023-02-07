public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int offset = 2*(numRows - 1);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            int idx = i;
            while (idx < s.length()) {
                sb.append(s.charAt(idx));
                idx += offset;
                // non corner rows
                if (i > 0 && i < numRows - 1) {
                    if (idx - (2 * i) < s.length()) {
                        sb.append(s.charAt(idx - (2 * i)));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion solution = new ZigZagConversion();
        String s = "A";
        int numRows = 4;
        String res = solution.convert(s, numRows);
        System.out.println(res);
    }
}
