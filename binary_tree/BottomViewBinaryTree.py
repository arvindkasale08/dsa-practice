class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def bottom_view(root, dist_val, level = 0, dist = 0):
    if root:
        bottom_view(root.left, dist_val, level + 1, dist - 1)
        if dist not in dist_val or level >= dist_val[dist][1]:
                dist_val[dist] = [root.val, level]
        bottom_view(root.right, dist_val, level + 1, dist + 1)

if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(5)
    root.right.right = Node(6)
    root.right.left.left = Node(7)
    root.right.left.right = Node(8)
    dist_val = {}
    bottom_view(root, dist_val)
    for dist in dist_val:
        print(dist_val[dist][0])