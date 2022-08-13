# Time: O(n)
# Space: O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def diameter(root, dia):
    if not root:    return 0, dia
    left, dia = diameter(root.left, dia)
    right, dia = diameter(root.right, dia)
    dia = max(dia, left + right)
    return 1 + max(left, right), dia

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    _, dia = diameter(root, 0)
    print(dia)