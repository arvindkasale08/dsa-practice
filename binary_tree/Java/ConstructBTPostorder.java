import java.util.*;

class Node {
   int data;
   Node left, right;

   public Node(int item)
   {
       data = item;
       left = right = null;
   }
}

public class ConstructBTPostorder {
    public static void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length !=
                postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,hm);
    }
    
    private static Node buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
                                     int ps, int pe, HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        Node root = new Node(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        Node leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        Node rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

        public static void main(String[] args)
        {

            int in[] = new int[] { 9,3,15,20,7 };
            int post[] = new int[] { 9,15,7,20,3 };
            int n = in.length;
            Node root = buildTree(in, post);
            System.out.println("Preorder of the constructed tree : "); preOrder(root);
        }
    }


