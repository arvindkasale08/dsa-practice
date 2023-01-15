package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length() + "#"); // add the size of the string and the chosen delimiter
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int num = -1;
        String numStr = "";
        int i =0;
        while (i<s.length()) {
            // get the size information
            char c = s.charAt(i);
            if (num == -1 && Character.isDigit(c)) {
                numStr += c;
                i++;
                continue;
            }
            if (num == -1 && c == '#') {
                num = Integer.parseInt(numStr);
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                sb.append(s.charAt(i));
                i++;
                num--;
            }
            numStr = "";
            num = -1;
            result.add(sb.toString());
        }
        if (numStr.equals("0")) {
            result.add("");
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeDecodeString solution = new EncodeDecodeString();
        String encoded = solution.encode(Arrays.asList("0"));
        System.out.println(encoded);
        List<String> decoded = solution.decode(encoded);
        System.out.println(decoded);
    }
}
