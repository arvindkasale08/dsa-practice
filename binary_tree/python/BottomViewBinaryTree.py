# Time: O(n)
# Space: O(n)

from collections import defaultdict

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def bottom_view(root):
    def dfs(root, level = 0, dist = 0):
        if not root:    return root
        dfs(root.left, level + 1, dist - 1)
        if not view[dist] or view[dist][0] <= level:    view[dist] = [level, root.val]
        dfs(root.right, level + 1, dist + 1)
    view = defaultdict(list)
    dfs(root)
    res = []
    for dist, (level, val) in view.items():
        res.append(val)
    return res

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    
#     root = Node(20)
#     root.left = Node(8)
#     root.right = Node(22)
#     root.left.left = Node(5)
#     root.left.right = Node(3)
#     root.right.left = Node(4)
#     root.right.right = Node(25)
#     root.left.right.left = Node(10)
#     root.left.right.right = Node(14)
    
    print(bottom_view(root))