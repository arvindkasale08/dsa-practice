class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def level_order(root, level = 1, last_level = 0):
    if not root:
        return last_level
    if last_level < level:
        print(root.val, end = ' ')
        last_level = level
    last_level = level_order(root.left, level + 1, last_level)
    last_level = level_order(root.right, level + 1, last_level)
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
    level_order(root)