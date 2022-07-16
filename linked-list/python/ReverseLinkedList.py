class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def reverseList(head):
    prev, curr = None, head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    head = prev
    return head

if __name__=='__main__':
    head = Node(10)
    head.next = Node(20)
    head.next.next = Node(30)
    head.next.next.next = Node(40)
    head.next.next.next.next = Node(50)
    head = reverseList(head)
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')