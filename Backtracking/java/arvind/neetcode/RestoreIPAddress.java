package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public List<String> find(String str) {
        List<String> result = new ArrayList<>();
        char[] ch = str.toCharArray();
        if (ch.length < 4)
            return new ArrayList();
        find(0, Math.min(ch.length, 2), new StringBuilder(), ch, 3, result);
        return result;
    }

    private void find(int i, int j, StringBuilder res, char[] ch, int dot, List<String> result) {

        String[] dotsep = res.toString().split("\\.");
        String curr = "";
        if (dotsep.length > 0 && !dotsep[0].equals("")) {
            curr = dotsep[dotsep.length - 1];
            if (curr.length() > 1 && curr.charAt(0) == '0') {
                return;
            }
            if (curr.length() >= 3 && Integer.parseInt(curr) > 256) {
                return;
            }
        }

        if (dot == -1) {
            if (res.length() == ch.length + 4) {
                res.setLength(res.length()-1);
                result.add(res.toString());
                res.append(".");
            }
            return;
        }


        for (int ind = i; ind <=j; ind++) {
            int k = i;
            while (k <= ind) {
                res.append(ch[k]);
                k++;
            }
            res.append(".");
            find(Math.min(ind+1, ch.length-1), Math.min(ind+1+2, ch.length-1), res, ch, dot-1, result);
            int trimLength = 2 + ind - i;
            res.setLength(res.length() - Math.min(res.length(), trimLength));
        }



    }

    public static void main(String[] args) {
        RestoreIPAddress solution = new RestoreIPAddress();
        String str = "0";
        List<String> validResults = solution.find(str);
        System.out.println(validResults);
    }
}
