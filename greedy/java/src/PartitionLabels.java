import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> lastIdx = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            lastIdx.put(s.charAt(i), i);
        }

        int i=0;
        int j=-1;
        int farthestIndex = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int charLastIdx = lastIdx.get(ch);
            farthestIndex = Math.max(farthestIndex, charLastIdx);

            if (i == charLastIdx && i == farthestIndex) {
                result.add(i-j);
                j = i;
            }
            i++;
        }


        return result;
    }

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        String s = "eccbbbbdec";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result);
    }
}
