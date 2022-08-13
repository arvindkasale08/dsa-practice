class LNode:
    def __init__(self, val, prev = None, nnext = None):
        self.val = val
        self.prev = prev
        self.next = nnext

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def vertical_sum(root, node):
    if not root:    return root
    node.val += root.val
    if root.left and not node.prev:    node.prev = LNode(0, None, node)
    vertical_sum(root.left, node.prev)
    if root.right and not node.next:    node.next = LNode(0, node, None)
    vertical_sum(root.right, node.next)

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    head = LNode(0)
    vertical_sum(root, head)
    while head.prev:
        head = head.prev
    while head:
        print(head.val, end = ' ')
        head = head.next