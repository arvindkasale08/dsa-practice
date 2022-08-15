class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def inorder(root):
    if root:
        inorder(root.left)
        print(root.val, end = ' ')
        inorder(root.right)

def bt_to_sum_tree(root):
    if not root:    return 0
    left = bt_to_sum_tree(root.left)
    right = bt_to_sum_tree(root.right)
    subtree_sum = root.val + left + right
    root.val = left + right
    return subtree_sum

if __name__=='__main__':
#     Inputs
#     TC: 1
#     root = Node(10)
#     root.left = Node(-3)
#     root.right = Node(4)
#     root.left.left = Node(9)
#     root.left.right = Node(-4)
#     root.right.left = Node(6)
#     root.right.right = Node(5)
    
#     TC: 2
    root = Node(10)
    root.left = Node(-2)
    root.right = Node(6)
    root.left.left = Node(8)
    root.left.right = Node(-4)
    root.right.left = Node(7)
    root.right.right = Node(5)
    bt_to_sum_tree(root)
    inorder(root)