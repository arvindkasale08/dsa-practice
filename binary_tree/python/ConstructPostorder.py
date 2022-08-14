class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def inorder(root):
    if root:
        inorder(root.left)
        print(root.val, end = " ")
        inorder(root.right)

def postorder_to_bt(post_order, in_order, start, end, n):
    if start > end:
        return None
    n[0] -= 1
    node = Node(post_order[n[0]])
    if start == end:
        return node
    if node.val in in_order[start:end + 1]:
        idx = in_order.index(node.val)
    else:
        idx = end
    node.right = postorder_to_bt(post_order, in_order, idx + 1, end, n)
    node.left = postorder_to_bt(post_order, in_order, start, idx - 1, n)
    return node

if __name__=='__main__':
    post_order = [8, 4, 5, 2, 6, 7, 3, 1]
    in_order = [4, 8, 2, 5, 1, 6, 3, 7]
    n = [len(post_order)]
    root = postorder_to_bt(post_order, in_order, 0, len(post_order) - 1, n)
    inorder(root)