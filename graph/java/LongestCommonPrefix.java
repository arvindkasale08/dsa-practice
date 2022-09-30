import java.util.*;
class PrefixTrieNode
{
    boolean isLeaf = false;
    Map<Character, PrefixTrieNode> character = new HashMap<>();
}

class TrieMain {
    private static void insert(PrefixTrieNode head, String str){
        PrefixTrieNode curr = head;

        for (char c: str.toCharArray()){
            curr.character.putIfAbsent(c, new PrefixTrieNode());
            curr = curr.character.get(c);
        }

        curr.isLeaf = true;
    }

    public static String findLCP(List<String> dict) {
        PrefixTrieNode head = new PrefixTrieNode();
        for (String s: dict) {
            insert(head, s);
        }


        StringBuilder lcp = new StringBuilder();
        PrefixTrieNode curr = head;
        while (curr != null && !curr.isLeaf && (curr.character.size() == 1))
        {
            for (var entry: curr.character.entrySet())
            {
                lcp.append(entry.getKey());
                curr = entry.getValue();
            }
        }

        return lcp.toString();
    }

    public static void main (String[] args)
    {
        List<String> dict = Arrays.asList(
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codependence", "codependency", "codependent",
                "codependents", "codes", "codesign", "codesigned", "codeveloped",
                "codeveloper", "codex", "codify", "codiscovered", "codrive"
        );

        System.out.println("The longest common prefix is " + findLCP(dict));
    }
}