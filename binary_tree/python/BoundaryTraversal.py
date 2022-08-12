class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def print_boundary_nodes(root):
    def print_left_boundary(root):
        if not root:    return root
        if not root.left and not root.right:
            return
        res.append(root.val)
        if root.left:
            print_left_boundary(root.left)
        elif root.right:
            print_left_boundary(root.right)
    
    def print_leaf_nodes(root):
        if not root:    return root
        if not root.left and not root.right:
            res.append(root.val)
            return
        print_leaf_nodes(root.left)
        print_leaf_nodes(root.right)
    
    def print_right_boundary(root):
        if not root:    return root
        if not root.left and not root.right:
            return
        if root.right:
            print_right_boundary(root.right)
        elif root.left:
            print_right_boundary(root.left)
        res.append(root.val)
    
    res = []
    print_left_boundary(root)
    print_leaf_nodes(root)
    print_right_boundary(root.right)
    return res

if __name__=='__main__':
#     root = Node(1)
#     root.left = Node(2)
#     root.right = Node(3)
    
#     root = Node(1)
#     root.left = Node(2)
#     root.left.right = Node(5)
#     root.left.right.left = Node(8)
#     root.left.right.right = Node(4)
#     root.right = Node(3)
#     root.right.right = Node(7)
#     root.right.right.left = Node(17)
#     root.right.left = Node(6)
#     root.right.left.right = Node(16)
    
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    root.left.left.left = Node(8)
    root.left.left.right = Node(9)
    root.left.right.right = Node(10)
    root.right.right.left = Node(11)
    root.left.left.right.left = Node(12)
    root.left.left.right.right = Node(13)
    root.right.right.left.left = Node(14)
    
    print(print_boundary_nodes(root))