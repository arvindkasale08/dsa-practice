class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def max_sum_path(root, path_sum = 0, max_sum = 0):
    if not root:
        max_sum = max(max_sum, path_sum)
        return max_sum
    path_sum += root.val
    max_sum = max_sum_path(root.left, path_sum, max_sum)
    max_sum = max_sum_path(root.right, path_sum, max_sum)
    return max_sum

if __name__=='__main__':
#     TC: 1
#     root = Node(9)
#     root.left = Node(-3)
#     root.right = Node(6)
#     root.left.left = Node(7)
#     root.left.right = Node(-5)
    
#     TC: 2
    root = Node(1)
    root.left = Node(2)
    root.right = Node(1)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.right = Node(7)
    print(max_sum_path(root))