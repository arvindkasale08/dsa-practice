class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def rotateRight(head, k):
    if not head or not head.next:
        return head
    l = 1
    fast = curr = head
    while fast and fast.next is not None:
        fast = fast.next
        l += 1
    k = k % l
    for _ in range(l - k - 1):
        curr = curr.next
    fast.next = head
    head = curr.next
    curr.next = None
    return head

if __name__=='__main__':
    head = Node(10)
    head.next = Node(20)
    head.next.next = Node(30)
    head.next.next.next = Node(40)
    head.next.next.next.next = Node(50)
    head = rotateRight(head, 2)
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')