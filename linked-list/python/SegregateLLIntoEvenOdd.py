# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def display(node):
    while node:
        print(node.val, end = ' -> ')
        node = node.next
    print('X')

def segregate_ll(head):
    even = None
    pre = ptr = head
    while ptr:
        if ptr.val % 2 == 0:
            if not even:
                if pre == ptr:
                    even = ptr
                else:
                    node = ptr
                    pre.next = ptr.next
                    node.next = head
                    head = node
                    even = head
            else:
                node = ptr
                pre.next = ptr.next
                node.next = even.next
                even.next = node
                even = node
        pre = ptr
        ptr = ptr.next
    return head

if __name__=='__main__':
    head = Node(4)
    head.next = Node(2)
    head.next.next = Node(7)
    head.next.next.next = Node(3)
    head.next.next.next.next = Node(6)
    head.next.next.next.next.next = Node(5)
    head.next.next.next.next.next.next = Node(1)
    head.next.next.next.next.next.next.next = Node(8)
    
#     node2 = Node(1)
#     node2.next = Node(3)
#     node2.next.next = Node(6)
#     node2.next.next.next = Node(7)
    
    node = segregate_ll(head)
    display(node)