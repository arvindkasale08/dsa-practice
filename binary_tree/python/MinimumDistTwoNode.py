class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def find_lca(root, node1, node2, found1 = False, found2 = False, lca = None):
    if not root or lca:    return found1, found2, lca
    fl, sl, lca = find_lca(root.left, node1, node2, found1, found2, lca)
    fr, sr, lca = find_lca(root.right, node1, node2, found1, found2, lca)
    if root.val == node1:    found1 = True
    if root.val == node2:    found2 = True
    found1 = found1 or fl or fr
    found2 = found2 or sl or sr
    if (found1 and found2) and not lca:
        lca = root
    return found1, found2, lca

def find_dist(root, node):
    if not root:
        return -99999
    if root.val == node:    return 0
    return 1 + max(find_dist(root.left, node), find_dist(root.right, node))

def min_distance(root, node1, node2):
    _, _, lca = find_lca(root, node1, node2)
    d1 = find_dist(lca, node1)
    d2 = find_dist(lca, node2)
    return d1 + d2

if __name__=='__main__':
#     root = Node(3) 
#     root.left = Node(4) 
#     root.right = Node(5) 
#     root.left.left = Node(6) 
#     root.left.right = Node(7) 
#     root.right.left = Node(8) 
#     root.right.right = Node(9) 
#     root.right.left.right = Node(10)
#     print(min_distance(root, 6, 7))
    
    root = Node(5) 
    root.left = Node(3) 
    root.right = Node(6) 
    root.left.left = Node(2) 
    root.left.right = Node(4) 
    root.left.left.left = Node(1) 
    root.right.right = Node(7) 
    root.left.right.right = Node(8)
    print(min_distance(root, 1, 8))