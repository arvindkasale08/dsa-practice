# Time: O(n)
# Space: O(1)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def display(head):
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')

def removeNthFromEnd(head, n):
    ptr = post = head
    while n:
        post = post.next
        n -= 1
    if not post:    return head.next
    while post.next:
        ptr = ptr.next
        post = post.next
    ptr.next = ptr.next.next
    return head

if __name__=='__main__':
    node1 = Node(2)
    node1.next = Node(4)
    node1.next.next = Node(5)
    node1.next.next.next = Node(8)
    
    node2 = Node(1)
    node2.next = Node(3)
    node2.next.next = Node(6)
    node2.next.next.next = Node(7)
    
    display(removeNthFromEnd(node1, 4))
    display(removeNthFromEnd(node2, 2))