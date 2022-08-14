class Node(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def preorder(root, res):
    if not root:    return root
    res.append(root.val)
    preorder(root.left, res)
    preorder(root.right, res)

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: Node
        :rtype: str
        """
        def preorder(root, traverse):
            if not root:
                traverse.append(-1001)
                return
            traverse.append(root.val)
            preorder(root.left, traverse)
            preorder(root.right, traverse)
        traverse = []
        preorder(root, traverse)
        return traverse

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: Node
        """
        def preorder_to_bt(traverse, i):
            if traverse[i] == -1001:    return None, i + 1
            root = Node(traverse[i])
            i += 1
            root.left, i = preorder_to_bt(traverse, i)
            root.right, i = preorder_to_bt(traverse, i)
            return root, i
        return preorder_to_bt(data, 0)[0]
    

if __name__=='__main__':
    root = Node(4)
    root.left = Node(-7)
    root.right = Node(-3)
    root.right.left = Node(-9)
    root.right.right = Node(-3)
    root.right.left.left = Node(9)
    root.right.left.right = Node(-7)
    root.right.right = Node(-4)
    root.right.left.left.left = Node(6)
    root.right.left.left.left.left = Node(0)
    root.right.left.left.left.right = Node(6)
    root.right.left.right.left = Node(-6)
    root.right.left.right.left.left = Node(-6)
    root.right.left.right.right = Node(-6)
    root.right.left.right.right.left = Node(-6)
    
    # Your Codec object will be instantiated and called as such:
    
    ser = Codec()
    deser = Codec()
    ans = deser.deserialize(ser.serialize(root))
    res = []
    preorder(ans, res)
    print(res)