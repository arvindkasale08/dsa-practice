# Time: O(n)
# Space: O(n)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def largest_BST(root):
    if not root:
        return [0, float('-inf'), float('inf'), True]
    nums1 = largest_BST(root.left)
    nums2 = largest_BST(root.right)
    if not nums1[-1] or not nums2[-1] or nums1[1] >= root.val or nums2[2] <= root.val:
        return [max(nums1[0], nums2[0]), 0, 0, False]
    return [1 + nums1[0] + nums2[0], max(nums1[1], root.val, nums2[1]), min(nums1[2], root.val, nums2[2]), True]

if __name__=='__main__':
#     TC: 1
#     root = Node(60)
#     root.left = Node(65)
#     root.right = Node(70)
#     root.left.left = Node(50)
    
#     TC: 2
#     root = Node(5)
#     root.left = Node(2)
#     root.right = Node(4)
#     root.left.left = Node(1)
#     root.left.right = Node(3)
    
#     TC: 3
    root = Node(1)
    root.left = Node(4)
    root.right = Node(4)
    root.left.left = Node(6)
    root.left.right = Node(8)
    
    print(largest_BST(root)[0])