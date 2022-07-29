# Time: O(n)
# Space: O(n)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def find_lca(root, node1, node2):
    def dfs(root, node1, node2, first = False, second = False, lca = None):
        if not root or lca:    return first, second, lca
        fl, sl, lca = dfs(root.left, node1, node2, first, second, lca)
        fr, sr, lca = dfs(root.right, node1, node2, first, second, lca)
        if root.val == node1:    first = True
        if root.val == node2:    second = True
        first = first or fl or fr
        second = second or sl or sr
        if first and second:
            if not lca:    lca = root
            return first, second, lca
        return first, second, lca
    lca = dfs(root, node1, node2)
    return lca[2] if lca else None

if __name__=='__main__':
    root = Node(3)
    root.left = Node(4)
    root.right = Node(5)
    root.left.left = Node(6)
    root.left.right = Node(7)
    root.right.left = Node(8)
    root.right.right = Node(9)
    lca = find_lca(root, 4, 9)
    if lca:    print(lca.val)
    else:    print(lca)