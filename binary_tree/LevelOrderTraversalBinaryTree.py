class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def rev_level_order(root):
    if not root:
        return root
    queue = [root]
    height = {}
    level = 0
    while len(queue) > 0:
        node = queue.pop(0)
        height[level] = [node]
        level += 1
        if node.right:
            queue.append(node.right)
        if node.left:
            queue.append(node.left)
    for i in range(0, len(height)):
        for j in height[i]:
            print(j.val, end = ' ')
        print()

if __name__=='__main__':
    root = Node(15)
    root.left = Node(10)
    root.right = Node(20)
    root.left.left = Node(8)
    root.left.right = Node(12)
    root.right.left = Node(16)
    root.right.right = Node(25)
    rev_level_order(root)