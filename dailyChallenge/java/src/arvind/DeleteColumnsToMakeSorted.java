package arvind;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int numColumns = strs[0].length();
        int numColumnsToDelete = 0;
        for (int i = 0; i < numColumns; i++) {
            char currChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < currChar) {
                    numColumnsToDelete++;
                    break;
                }
                currChar = strs[j].charAt(i);
            }
        }
        return numColumnsToDelete;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted solution = new DeleteColumnsToMakeSorted();
        String[] strs = new String[] {"abc", "bce", "cae"};
        int count = solution.minDeletionSize(strs);
        System.out.println(count);
    }
}
