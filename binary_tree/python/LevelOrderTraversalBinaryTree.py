from collections import deque

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def rev_level_order(root):
    if not root: return root
    queue = deque([root])
    traverse = []
    while queue:
        arr = []
        for i in range(len(queue)):
            node = queue.popleft()
            arr.append(node.val)
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)
        traverse.append(arr)
    return traverse

if __name__=='__main__':
    root = Node(15)
    root.left = Node(10)
    root.right = Node(20)
    root.left.left = Node(8)
    root.left.right = Node(12)
    root.right.left = Node(16)
    root.right.right = Node(25)
    print(rev_level_order(root))