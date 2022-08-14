class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

def display(head):
    while head:
        print(head.val, end = ' -> ')
        head = head.right
    print('X')

head = tail = None
def bt_to_dll(root):
    if not root:
        return root
    global head
    global tail
    bt_to_dll(root.left)
    if not head:
        head = tail = root
    else:
        tail.right = root
        root.left = tail
        tail = root
    bt_to_dll(root.right)

if __name__=='__main__':
#     TC - 1
#     root = Node(1)
#     root.left = Node(2)
#     root.right = Node(3)
#     root.left.left = Node(4)
#     root.left.right = Node(5)
#     root.right.left = Node(6)
#     root.right.right = Node(7)

#     TC - 2

#     root = Node(1)
#     root.left = Node(2)
#     root.right = Node(3)

#     TC - 3
    
    root =  Node(10)
    root.left =  Node(12)
    root.right =  Node(15)
    root.left.left =  Node(25)
    root.left.right =  Node(30)
    root.right.left =  Node(36)
    bt_to_dll(root)
    display(head)