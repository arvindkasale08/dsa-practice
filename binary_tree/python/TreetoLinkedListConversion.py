class Node:
    def __init__(self, val):
        self.val = val
        self.left = self.right = None

class BT_DLL:
    def __init__(self):
        self.head = self.tail = None
    
    def display(self):
        print('From front: ')
        ptr = self.head
        while ptr:
            print(ptr.val, end = ' -> ')
            ptr = ptr.right
        print('X')
        print('From end: ')
        ptr = self.tail
        while ptr:
            print(ptr.val, end = ' -> ')
            ptr = ptr.left
        print('X')
    
    def bt_to_dll(self, root):
        if not root:
            return root
        self.bt_to_dll(root.left)
        if not self.head:
            self.head = self.tail = root
        else:
            self.tail.right = root
            root.left = self.tail
            self.tail = root
        self.bt_to_dll(root.right)
    
if __name__=='__main__':
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    BT = BT_DLL()
    BT.bt_to_dll(root)
    BT.display()