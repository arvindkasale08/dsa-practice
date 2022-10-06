import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, List<String> dict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] dictionary = { "apple", "pen" };

        List<String> dict = new ArrayList<>();
        for(String s : dictionary){
            dict.add(s);
        }

        if (wordBreak("applepenapple", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}


