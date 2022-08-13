# Time: O(n)
# Space: O(h)

class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def is_mirror(node1, node2):
    if(node1 is None and node2 is None):
        return True

    if(node1 is None or node2 is None):
        return False

    return (node1.val == node2.val) and is_mirror(node1.left, node2.right) and is_mirror(node1.right, node2.left)

if __name__=='__main__':
    node1 = Node(1)
    node2 = Node(1)
    node1.left = Node(2)
    node1.right = Node(3)
    node1.left.left = Node(4)
    node1.left.right = Node(5)

    node2.left = Node(3)
    node2.right = Node(2)
    node2.right.left = Node(5)
    node2.right.right = Node(8)

    print(is_mirror(node1, node2))