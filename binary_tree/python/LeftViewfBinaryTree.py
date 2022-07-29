# Time: O(n)
# Space: O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def left_view(root, res, level = 0, last_level = -1):
    if not root:    return last_level
    if last_level < level:
        res.append(root.val)
        last_level = level
    last_level = left_view(root.left, res, level + 1, last_level)
    last_level = left_view(root.right, res, level + 1, last_level)
    return last_level

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    res = []
    left_view(root, res)
    for val in res:
        print(val, end = ' ')