# Time: O(n^2)
# Space: O(n)
# Note: If recruiter asks to do this in linear time, just use a hashMap to store the indexes

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def traverse(root):
    if not root:    return root
    traverse(root.left)
    print(root.val, end = ' ')
    traverse(root.right)

def postorder_to_bt(postorder, inorder, low, high, i):
    if low > high:    return None
    node = Node(postorder[i[0]])
    i[0] -= 1
    if low == high:    return node
    idx = inorder.index(node.val)
    node.right = postorder_to_bt(postorder, inorder, idx + 1, high, i)
    node.left = postorder_to_bt(postorder, inorder, low, idx - 1, i)
    return node

if __name__=='__main__':
    tc = [[[8, 4, 5, 2, 6, 7, 3, 1],[4, 8, 2, 5, 1, 6, 3, 7]],
          [[4, 2, 7, 8, 5, 6, 3, 1],[4, 2, 1, 7, 5, 8, 3, 6]],
          [[9,3,15,20,7],[9,3,15,20,7]]]
    for post_order, in_order in tc:
        root = postorder_to_bt(post_order, in_order, 0, len(post_order) - 1, [len(postorder) - 1])
        traverse(root)
        print()