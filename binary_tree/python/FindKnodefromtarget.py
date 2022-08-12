class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def print_down(node, k, res):
    if not node:    return
    if not k:
        res.append(node.val)
        return
    print_down(node.left, k - 1, res)
    print_down(node.right, k - 1, res)

def find_nodes_k_dist(node, target, k, res):
    if not node:    return -1
    if node == target:
        print_down(target, k, res)
        return 1
    dleft = find_nodes_k_dist(node.left, target, k, res)
    if dleft != -1:
        if dleft == k:
            res.append(node.val)
        else:
            print_down(node.right, k - dleft - 1, res)
        return 1 + dleft
    dright = find_nodes_k_dist(node.right, target, k, res)
    if dright != -1:
        if dright == k:
            res.append(node.val)
        else:
            print_down(node.left, k - dright - 1, res)
        return 1 + dright
    return -1

if __name__=='__main__':
#     root = Node(20)
#     root.left = Node(8)
#     root.right = Node(22)
#     root.left.left = Node(4)
#     root.left.right = Node(12)
#     root.left.right.left = Node(10)
#     root.left.right.right = Node(14)
#     target = root.left.right
    
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
    target = root.left.right
    
    res = []
    find_nodes_k_dist(root, target, 3, res)
    print(res)