class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def print_k_leaf(node, k, res):
    def dfs(root, i = -1, arr = [], seen = []):
        if not root:    return root
        arr.append(root.val)
        seen.append(False)
        i += 1
        if not root.left and not root.right and i >= k:
            if not seen[i - k]:
                res.append(arr[i - k])
                seen[i - k] = True
        dfs(root.left, i, arr, seen)
        dfs(root.right, i, arr, seen)
        arr.pop()
        seen.pop()
    dfs(root)

if __name__=='__main__':
    root = Node(3)
    root.left = Node(8)
    root.right = Node(9)
    root.left.left = Node(11)
    root.left.right = Node(7)
    root.left.right.left = Node(6)
    root.left.right.right = Node(12)
    root.right.left = Node(8)
    root.right.right = Node(3)
    
    res = []
    print_k_leaf(root, 2, res)
    print(res)