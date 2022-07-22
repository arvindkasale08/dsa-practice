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

def reverse(head):
    pre, ptr = None, head
    while ptr:
        post = ptr.next
        ptr.next = pre
        pre = ptr
        ptr = post
    return pre

def rearrange_ll(head):
    slow = fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    first, second = head, slow.next
    slow.next = None
    second = reverse(second)
    while second:
        ptr1, ptr2 = first.next, second.next
        first.next, second.next = second, ptr1
        first, second = ptr1, ptr2
    return head

if __name__=='__main__':
    head = Node(1)
    head.next = Node(2)
    head.next.next = Node(3)
    head.next.next.next = Node(4)
    head.next.next.next.next = Node(5)
    head.next.next.next.next.next = Node(6)
    head.next.next.next.next.next.next = Node(7)
    head1 = rearrange_ll(head)
    display(head1)