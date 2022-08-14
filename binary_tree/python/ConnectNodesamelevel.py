class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.next = None

def inorder(root):
    if not root:
        return root
    inorder(root.left)
    print(root.val, end=" -> ")
    if root.next:
        print(root.next.val)
    else:
        print("None")
    inorder(root.right)

def find_next_available_node(root):
    if not root or not root.next:
        return None
    if root.next.left:
        return root.next.left
    if root.next.right:
        return root.next.right
    return find_next_available_node(root.next)

def connect_nodes(root):
    if not root:
        return root
    if not root.right and not root.left:
        return root
    if root.right and root.left:
        root.left.next = root.right
        if root.next:
            root.right.next = find_next_available_node(root)
    if (not root.right or not root.left) and root.next:
        if root.left:
            root.left.next = find_next_available_node(root)
        if root.right:
            root.right.next = find_next_available_node(root)
    connect_nodes(root.right)
    connect_nodes(root.left)

if __name__=='__main__':
    root = Node(6)
    root.left = Node(4)
    root.left.left = Node(12)
    root.left.left.left = Node(9)
    root.right = Node(10)
    root.right.left = Node(8)
    root.right.right = Node(12)
    root.right.right.right = Node(14)
    inorder(root)
    print()
    connect_nodes(root)
    inorder(root)