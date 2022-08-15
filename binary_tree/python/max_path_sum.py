max_sum = 0

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def max_path_sum(root):
    global max_sum
    if not root:    return 0
    left_sum = max_path_sum(root.left)
    right_sum = max_path_sum(root.right)
    max_single_sum = max(root.val, root.val + left_sum, root.val + right_sum)
    max_top = max(max_single_sum, root.val + left_sum + right_sum)
    max_sum = max(max_sum, max_top)
    return max_single_sum

if __name__=='__main__':
    root = Node(10) 
    root.left = Node(2)
    root.right = Node(15)
    root.left.left = Node(-4)
    root.left.right = Node(-6) 
    root.left.left.left = Node(28)
    root.left.left.right = Node(-22)
    root.right.right = Node(-25)
    root.right.right.left = Node(3)
    root.right.right.right = Node(4)
    max_path_sum(root)
    print(max_sum)