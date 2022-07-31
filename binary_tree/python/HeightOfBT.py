# Time: O(n)
# Space: O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def height(root):
    if not root:
        return 0
    return 1 + max(height(root.left), height(root.right))

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    tree_height = height(root)
    print(tree_height)