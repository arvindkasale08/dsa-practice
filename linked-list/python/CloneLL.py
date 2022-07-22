# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = self.random = None

def display(head):
    while head:
        if head.random:
            print(head.val, f"({head.random.val})", end=' -> ')
        else:
            print(head.val, "(X)", end=' -> ')
        head = head.next
    print("X")

def clone_ll(head):
    if not head:    return head
    ptr = head
    while ptr:
        c_ptr = Node(ptr.val)
        c_ptr.next = ptr.next
        ptr.next = c_ptr
        ptr = c_ptr.next
    c_head = head.next
    ptr = head
    while ptr:
        if ptr.random:    ptr.next.random = ptr.random.next
        else:    ptr.next.random = None
        ptr = ptr.next.next
    ptr, front = head, head.next.next
    while front:
        ptr.next.next = front.next
        ptr.next = front
        ptr = front
        front = front.next.next
    ptr.next.next = None
    ptr.next = None
    return c_head

if __name__=='__main__':
    head = Node(3)
    head.next = Node(4)
    head.next.next = Node(5)
    head.next.next.next = Node(6)
    head.next.next.next.next = Node(7)

    head.random = head.next.next
    head.next.random = head
    head.next.next.random = head.next.next.next.next
    head.next.next.next.random = head.next.next.next.next
    head.next.next.next.next.random = head.next
    
    display(head)
    head1 = clone_ll(head)
    display(head1)