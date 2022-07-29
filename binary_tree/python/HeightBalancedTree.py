# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def height(root):
    if not root:
        return 0
    left, right = height(root.left), height(root.right)
    if abs(left - right) > 1:
        return -99999
    return 1 + max(left, right)

if __name__=='__main__':
#     root = Node(2)
#     root.left = Node(3)
#     root.right = Node(4)
#     root.left.left = Node(5)
#     root.left.right = Node(6)
#     root.left.left.left = Node(9)
    
#     root = Node(2)
#     root.left = Node(3)
#     root.right = Node(4)
#     root.left.left = Node(5)
#     root.left.left.left = Node(6)
#     root.left.left.left.left = Node(9)
    
    root = Node(3)
    root.left = Node(9)
    root.right = Node(20)
    root.right.left = Node(15)
    root.right.right = Node(7)
    print(height(root) >= 0)