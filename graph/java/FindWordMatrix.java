import java.util.*;
class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}
public class FindWordMatrix {
    static TrieNode root;
    static int row, col;
    private static void insertInTrie(String word){
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                continue;
            }
            curr.children.put(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public static boolean exist(char[][] board, String word) {

        //Approach - Trie Approach
        root = new TrieNode();
        insertInTrie(word);
        TrieNode curr = root;
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                char ch = board[i][j];
                if(curr.children.containsKey(ch) && dfs(curr, board, i, j))
                    return true;
            }
        }
        return false;

    }
    private static boolean dfs(TrieNode curr, char[][] board, int i, int j){

        if (curr.isEnd) return curr.isEnd;
        if(i < 0 || j <0 || i>= row || j >= col || !curr.children.containsKey(board[i][j])) return false;
        char ch = board[i][j];
        char temp = board[i][j];
        board[i][j] = ' ';

        if (dfs(curr.children.get(ch), board, i+1, j) || dfs(curr.children.get(ch), board, i-1, j)
                || dfs(curr.children.get(ch), board, i, j+1) || dfs(curr.children.get(ch), board, i, j-1))
            return true;

        board[i][j] = temp;
        return false;

    }

    public static void main(String[] args) {

        char[][] grid = { {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'} };
        if (exist(grid, "ABCB")){
            System.out.println("Yep Present!");
        }
        else {
            System.out.println("Not Present");
        }
    }
}

