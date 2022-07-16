class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def addTwoNumbers(head1, head2):
    head = ptr = Node(-1)
    carry = 0
    while head1 or head2:
        if not head1:
            ptr.next = Node((head2.val + carry) % 10)
            carry = (head2.val + carry) // 10
            ptr = ptr.next
            head2 = head2.next
            continue
        if not head2:
            ptr.next = Node((head1.val + carry) % 10)
            carry = (head1.val + carry) // 10
            ptr = ptr.next
            head1 = head1.next
            continue
        node = Node((head1.val + head2.val + carry) % 10)
        carry = (head1.val + head2.val + carry) // 10
        head1 = head1.next
        head2 = head2.next
        ptr.next = node
        ptr = node
    if carry:   ptr.next = Node(carry)
    return head.next

if __name__=='__main__':
    head1 = Node(2)
    head1.next = Node(4)
    head1.next.next = Node(3)

    head2 = Node(5)
    head2.next = Node(6)
    head2.next.next = Node(4)
    head = addTwoNumbers(head1, head2)
    while head:
        print(head.val, end = ' -> ')
        head = head.next
    print('X')