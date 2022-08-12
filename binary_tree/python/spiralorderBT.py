from collections import deque

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def spiral_order(root):
    front = True
    s1 = [root]
    s2 = []
    traverse = []
    while s1 or s2:
        while s1:
            node = s1.pop()
            traverse.append(node.val)
            if node.right:    s2.append(node.right)
            if node.left:    s2.append(node.left)
        while s2:
            node = s2.pop()
            traverse.append(node.val)
            if node.left:    s1.append(node.left)
            if node.right:    s1.append(node.right)
    return traverse

if __name__=='__main__':
#     TC: 1
#     root = Node(1)  
#     root.left = Node(2)  
#     root.right = Node(3)  
#     root.left.left = Node(7)  
#     root.left.right = Node(6)  
#     root.right.left = Node(5)  
#     root.right.right = Node(4)
    
#     TC: 2
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    print(spiral_order(root))