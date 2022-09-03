import java.util.*;
public class FindFirstNonRepeatingCharacter {
    public static ArrayList<Character> firstNonRepeating(String stream) {
        ArrayList<Character> DLL = new ArrayList<Character>();
        boolean[] isCharRepeated = new boolean[256];
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < stream.length(); i++) {
            char x = stream.charAt(i);

            if (!isCharRepeated[x]) {

                if (!(DLL.contains(x))) {
                    DLL.add(x);
                }
                else {
                    DLL.remove((Character) x);
                    isCharRepeated[x] = true;
                }
            }
            if (DLL.size() != 0) {
                result.add(DLL.get(0));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String stream = "bab";
        List<Character> res = firstNonRepeating(stream);
        System.out.println(res);

    }
}
