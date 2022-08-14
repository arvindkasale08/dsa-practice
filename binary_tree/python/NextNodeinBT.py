from collections import deque

desired_level = 0

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def find_right_node(root, key, level = 0):
    global desired_level
    if not root:    return
    if root.val == key:
        desired_level = level
        return
    if desired_level and desired_level == level:    return root
    left = find_right_node(root.left, key, level + 1)
    if left:    return left
    return find_right_node(root.right, key, level + 1)

if __name__=='__main__':
#     Inputs
#     TC: 1
#     root = Node(1)
#     root.left = Node(2)
#     root.right = Node(3)
#     root.left.left = Node(4)
#     root.left.right = Node(5)
#     root.right.left = Node(6)
#     root.right.left.left = Node(7)
#     root.right.left.right = Node(8)
#     print(find_right_node(root, 5).val)
    
#     TC: 2
#     root = Node(1)
#     root.left = Node(2)
#     root.right = Node(3)
#     root.left.left = Node(4)
#     root.left.right = Node(5)
#     root.right.left = Node(6)
#     root.right.left.left = Node(7)
#     root.right.left.right = Node(8)
#     print(find_right_node(root, 2).val)
    
#     TC: 3
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    
    print(find_right_node(root, 2).val)