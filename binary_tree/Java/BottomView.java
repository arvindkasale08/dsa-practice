// Java program to print Bottom View of Binary Tree
import java.lang.*;
import java.util.*;

class Main{
    static class Node
    {
        //hd - horizontal distance
        int data;
        int hd;
        Node left, right;
        public Node(int key)
        {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    static void printBottomView(Node root, int curr, int hd, TreeMap<Integer, int[]> mapp)
    {
        if (root == null)
            return;
        if (!mapp.containsKey(hd))
        {
            mapp.put(hd, new int[]{ root.data, curr });
        }
        else
        {
            int[] p = mapp.get(hd);
            if (p[1] <= curr)
            {
                p[1] = curr;
                p[0] = root.data;
            }
            mapp.put(hd, p);
        }

        // Recur for left subtree
        printBottomView(root.left, curr + 1, hd - 1, mapp);

        // Recur for right subtree
        printBottomView(root.right, curr + 1, hd + 1, mapp);
    }

    static void printBottomView(Node root)
    {
        TreeMap<Integer, int[]> mapp = new TreeMap<>();

        printBottomView(root, 0, 0, mapp);

        for(int val[] : mapp.values())
        {
            System.out.print(val[0] + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the given binary tree:");

        printBottomView(root);
    }
}

