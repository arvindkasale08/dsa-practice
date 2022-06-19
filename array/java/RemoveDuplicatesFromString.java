import java.util.*;

public class RemoveDuplicatesFromString {
    char[] removeDuplicate(char str[]){
        int index = 0;
        for (int i = 0; i < str.length; i++){
            int j;
            for (j = 0; j < i; j++){
                if (str[i] == str[j]){
                    break;
                }
            }

            if (j == i){
                str[index++] = str[i];
            }
        }


        return Arrays.copyOf(str, index);
    }

    char[] removeDuplicateUsingHashSet(char str[])
    {
        HashSet<Character> set = new LinkedHashSet<>(str.length - 1);
        for (char x : str){
            set.add(x);
        }
        char arr[] = new char[set.size()];
        int idx = 0;
        for (char c : set){
            arr[idx] = c;
            idx++;
        }
        return arr; 
    }

    public static void main(String[] args)
    {
        char str[] = "logicmojo".toCharArray();
        RemoveDuplicatesFromString hdfs = new RemoveDuplicatesFromString();

        char result[] = hdfs.removeDuplicate(str);
        for (char c : result){
            System.out.print(c);
        }
        System.out.println();
        result = hdfs.removeDuplicateUsingHashSet(str);
        for (char c : result){
            System.out.print(c);
        }
    }
}
