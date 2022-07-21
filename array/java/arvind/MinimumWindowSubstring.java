package arvind;

public class MinimumWindowSubstring {

    public String findMinimumSubstring(String ip, String ptr) {
        int[] ipAsciiArr = new int[256];
        int[] ptrAsciiArr = new int[256];
        char[] ipChrArr = ip.toCharArray();
        char[] ptrChrArr = ptr.toCharArray();
        int n = 0;

        for (char c : ptrChrArr) {
            if (ptrAsciiArr[c] == 0)
                n++;
            ptrAsciiArr[c] += 1;
        }

        int start = 0;
        int count = 0;
        String res = "";
        for (int i=0; i<ipChrArr.length; i++) {
            char c = ipChrArr[i];
            ipAsciiArr[c] += 1;
            if (count < n) {
                if (ptrAsciiArr[c] == ipAsciiArr[c]) {
                    count++;
                }
            }
            if (count == n) {
                while (ipAsciiArr[ipChrArr[start]] > ptrAsciiArr[ipChrArr[start]]) {
                    ipAsciiArr[ipChrArr[start]]-= 1;
                    start++;
                }
                System.out.println(start+ "-"+ i);
                String tempRes = getString(ipChrArr, start, i);
                res = tempRes.length() < res.length() || res.equals("") ? tempRes : res;
            }
        }


        return res;
    }

    private String getString(char[] arr, int start, int end) {
        char[] res = new char[(end - start) + 1];
        for (int i= start; i <= end; i++) {
            res[i-start] = arr[i];
        }
        return new String(res);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring window = new MinimumWindowSubstring();
        String ip = "aa";
        String ptr = "aa";
        /*
        "ADOBECODEBANC"
        "ABC"
         */
        String op = window.findMinimumSubstring(ip, ptr);
        System.out.println(op);
    }
}
