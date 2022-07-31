import java.util.*;

class Node {
    int data;
    Node  left,  right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
public class MirrorImageBT {
    static boolean isMirror(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        return (node1.data == node2.data) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(8);
        boolean res = isMirror(a, b);
        if(res){
            System.out.println("Both are Symmetric");
        }
        else{
            System.out.println("Not Symmetric");
        }
    }
}
