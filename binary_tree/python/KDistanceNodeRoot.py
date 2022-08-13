# Time Complexity: O(n)
# Space Complexity: O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def print_nodes(root, k, count = 0):
    if root:
        print_nodes(root.left, k, count + 1)
        if count == k:
            print(root.val)
        print_nodes(root.right, k, count + 1)

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.left.left = Node(4)
    root.left.left.left = Node(9)
    root.left.right = Node(5)
    root.left.right.left = Node(6)
    root.left.right.left.left = Node(12)
    root.left.right.left.left.right = Node(19)
    root.left.right.right = Node(7)
    root.left.right.right.right = Node(10)
    root.left.right.right.right.right = Node(11)
    root.right = Node(23)
    root.right.right = Node(32)
    print_nodes(root, 3)