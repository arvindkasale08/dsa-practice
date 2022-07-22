# Time: O(n)
# Space: O(n)

class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def display(head):
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')

def reverse_kll(head, k):
    if not head:
        return head
    pre = None
    ptr = head
    count = 0
    while count < k and ptr:
        post = ptr.next
        ptr.next = pre
        pre = ptr
        ptr = post
        count += 1
    head.next = reverse_kll(post, k)
    return pre

if __name__=='__main__':
    head = Node(4)
    head.next = Node(2)
    head.next.next = Node(8)
    head.next.next.next = Node(5)
    head.next.next.next.next = Node(1)
    head.next.next.next.next.next = Node(6)
    head.next.next.next.next.next.next = Node(3)
    head.next.next.next.next.next.next.next = Node(7)
    print('Original List: ', end = '')
    display(head)
    head1 = reverse_kll(head, 3)
    print('Reversed List: ', end = '')
    display(head1)